package warehouse;
import java.time.*;
import java.util.*;
import java.io.*;

public class App {
	public LocalDate TODAY= LocalDate.of(2025,10,24);
public static void main(String[] args) {
	WarehouseSystem w1= new WarehouseSystem();
	SeedData.load(w1);
	save(w1,"testing");
	
	
	
}

private static void MainMenu(Scanner sc,WarehouseSystem system) {
		int choice;
		do {
				System.out.println("=== Single-Warehouse System (QAR) ===");
				System.out.println("1) Staff Menu\n"+
									"2) Customer Menu\n"+
									"0) Exit");
				System.out.print("Choose: > ");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1-> StaffMenu.run(sc, system);
				//case 2-> CustomerMenu.run(sc, system);
				case 0-> {System.out.println("Goodbye.");
						System.exit(0);}
				}
				
		}while (choice != 0);
	
}
private static void save(WarehouseSystem sys,String fileName) {
	ObjectOutputStream out = null;

    try {
        FileOutputStream fos = new FileOutputStream(fileName);
        out = new ObjectOutputStream(fos);

        // Put all lists in one ArrayList										private ArrayList<Customer> customers = new ArrayList<>();
    	
        ArrayList<Object> master = new ArrayList<>();
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
            if (out != null) out.close();
        } catch (IOException ignored) {}
    }
}
			
		}
	




