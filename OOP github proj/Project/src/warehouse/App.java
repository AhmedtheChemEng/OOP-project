package warehouse;

import java.time.*;
import java.util.*;
import java.io.*;

public class App {
	public LocalDate TODAY = LocalDate.of(2025, 10, 24);

	public static void main(String[] args) {
		WarehouseSystem w1 = new WarehouseSystem();
		Scanner kb = new Scanner(System.in);
		
//		SeedData.load(w1);
		loadData(w1,"WarehouseData");
		
		System.out.println(w1.getOrders());
		System.out.println(w1.getShipments());

		
		MainMenu(kb,w1);
		
	}

	private static void MainMenu(Scanner sc, WarehouseSystem system) {
		int choice;
		do {
			System.out.println("=== Single-Warehouse System (QAR) ===");
			System.out.println("1) Staff Menu\n" + "2) Customer Menu\n" + "0) Exit");
			System.out.print("Choose: > ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1 -> StaffMenu.run(sc, system);
			case 2-> CustomerMenu.run(sc, system);
			case 0 -> {
				System.out.println("Goodbye.");
				save(system,"WarehouseData");
				System.exit(0);
				
			}
			}

		} while (choice != 0);

	}

	private static void save(WarehouseSystem sys, String fileName) {
		ObjectOutputStream out = null;

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			// Put all lists in one ArrayList private ArrayList<Customer> customers = new
			// ArrayList<>();

			ArrayList<Object> master = new ArrayList<>();
			master.add(sys.getCustomers());
			master.add(sys.getProducts());
			master.add(sys.getDiscounts());
			master.add(sys.getOrders());
			master.add(sys.getShipments());

			// Add more if needed, but keep the same order when loading

			out.writeObject(master);

			System.out.println("Saved successfully to " + fileName);

		} catch (IOException e) {
			System.out.println("Error while saving: " + e.getMessage());
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ignored) {
			}
		}
	}

	public static void loadData(WarehouseSystem sys, String filename) {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new FileInputStream(filename));

			ArrayList<Object> master = (ArrayList<Object>) in.readObject();

			sys.setCustomers((ArrayList<Customer>) master.get(0));
			sys.setProducts((ArrayList<Product>) master.get(1));
			sys.setDiscounts((ArrayList<Discount>) master.get(2));
			sys.setOrders((ArrayList<Order>) master.get(3));
			sys.setShipments((ArrayList<Shipment>) master.get(4));

			System.out.println("Loaded successfully from " + filename);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error while loading: " + e.getMessage());
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ignored) {
			}
		}

	}

}
