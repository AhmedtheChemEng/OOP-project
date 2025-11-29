package warehouse;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;

public class StaffMenu {

	/*
	 * Shabab this is the menu for staff where i used the different cases to call
	 * the specific method depening on the users choice, i have not finished it yet
	 */
	public static void run(Scanner sc, WarehouseSystem system) {
		int choice;
		final String menu = "\n--- Staff Menu ---\n" + "1) Add Customer (ID + Name)\n" + "2) List/Toggle Discounts\n"
				+ "3) Create Discount\n" + "4) Add Product\n" + "5) Update Shipment Status\n" + "6) Reports (~15)"
				+ "0) Back";

		do {
			System.out.println(menu);
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> addCustomer(sc, system);
			case 2 -> listToggleDiscounts(sc, system);
			case 3 -> createDiscount(sc, system);
			case 4 -> addProduct(sc, system);
			case 5 -> updateShipment(sc, system);
			case 6 -> ReportService.runAllReports(system);
			// case 0 ->
			default -> System.out.println("Invalid Choice!");
			}
		} while (choice != 0);

	}

	// This function first validates the name and id of the customer, then calls the
	// method addCustomer from warehouse to create new instance of Customer
	public static void addCustomer(Scanner sc, WarehouseSystem system) {
		System.out.println("Customer ID: > ");
		String id = sc.nextLine();
		System.out.print("Customer Name: > ");
		String name = sc.nextLine();
		if (id.trim().isEmpty() || name.trim().isEmpty()) {
			System.out.println("Error: ID and Name cannot be empty.");
		} else {
			system.addCustomer(new Customer(name, id));
			System.out.printf("Added customer %s (ID: %s).%n", name, id);
		}

	}

	public static void listToggleDiscounts(Scanner sc, WarehouseSystem system) {
		ArrayList<Discount> discounts = system.getDiscounts();
		for(int i=0; i<discounts.size();i++){
			Discount d = discounts.get(i);
			System.out.printf("%d) %s" , i, d);
		}
		System.out.print("Enter index to toggle (or blank to skip): > ");
	    String idxStr = sc.nextLine();
	    if (!idxStr.isEmpty()) 	{
	        try {
	            int idx = Integer.parseInt(idxStr);
	            if (idx >= 0 && idx < discounts.size()) {
	                Discount d = discounts.get(idx);
	                boolean newState = !d.isActive();
	                system.setDiscountActive(d);
	                System.out.printf("Now Active: %b%n", d.isActive());
	                if (newState) {
	                    System.out.println("(Any overlapping active discounts were set to Inactive.)");
	                }
	            } else {
	                System.out.println("Error: Invalid index range.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error: Invalid number format.");}}
	}

	public static void createDiscount(Scanner sc, WarehouseSystem system) {
		String type;
		while (true) {
			System.out.println("Type: 1) Fixed Amount 2) Percentage");
			System.out.print("> ");
			type =sc.nextLine();
			if(type.equals("1") || type.equals("2")) {
				break;
			}System.out.println("Error: Invalid choice. Please enter 1 or 2.");
			}
			System.out.print("Code/Name: > ");
	        String code = sc.nextLine();

	        LocalDate start = null;
	        while (start == null) {
	            System.out.print("Start date (YYYY-MM-DD): > ");
	            try {
	                start = LocalDate.parse(sc.nextLine());
	            } catch (DateTimeParseException e) {
	                System.out.println("Error: Invalid date format. Use YYYY-MM-DD.");
	            }
	        }

	        LocalDate end = null;
	        while (end == null) {
	            System.out.print("End date (YYYY-MM-DD): > ");
	            try {
	                LocalDate d = LocalDate.parse(sc.nextLine());
	            } catch (DateTimeParseException e) {
	                System.out.println("Error: Invalid date format. Use YYYY-MM-DD.");
	            }
	        }

	        System.out.print("Create as Active? (y/n): > ");
	        boolean active = sc.nextLine().equalsIgnoreCase("y");

	        Discount d = null;

	        if (type.equals("1")) {
	            double amount = -1;
	            while (amount < 0) {
	                System.out.print("Fixed amount (QAR): > ");
	                try {
	                    amount = Double.parseDouble(sc.nextLine());
	                    if (amount < 0) System.out.println("Error: Amount cannot be negative.");
	                } catch (NumberFormatException e) {
	                    System.out.println("Error: Invalid number.");
	                }
	            }
	            d = new FixedAmountDiscount(code, start.toString(), end.toString(), amount); 
	        
	        } else if (type.equals("2")) {
	            double percent = -1;
	            while (percent < 0 || percent > 100) {
	                System.out.print("Percent (e.g., 10 for 10%): > ");
	                try {
	                    percent = Double.parseDouble(sc.nextLine());
	                    if (percent < 0 || percent > 100) System.out.println("Error: Percent must be between 0 and 100.");
	                } catch (NumberFormatException e) {
	                    System.out.println("Error: Invalid number.");
	                }
	            }
	            
	            d = new PercentageDiscount(code, start.toString(), end.toString(), percent);
	        }

	        if (d != null) {
	            d.setActive(active);
	            system.addDiscount(d);
	            System.out.println("Discount created. Overlap rule applied if Active.");
	        }
		};
	

	public static void addProduct(Scanner sc, WarehouseSystem system) {
		String cat = "";
        while (true) {
            System.out.println("Category: 1) Book 2) Electronic 3) Grocery");
            System.out.print("> ");
            cat = sc.nextLine();
            if (cat.equals("1") || cat.equals("2") || cat.equals("3")) break;
            System.out.println("Error: Invalid category.");
        }

        System.out.print("ID: > ");
        String id = sc.nextLine();
        System.out.print("Name: > ");
        String name = sc.nextLine();

        double price = -1;
        while (price < 0) {
            System.out.print("Price (QAR): > ");
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price < 0) System.out.println("Error: Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number.");
            }
        }

        double weight = -1;
        while (weight <= 0) {
            System.out.print("Weight (kg): > ");
            try {
                weight = Double.parseDouble(sc.nextLine());
                if (weight <= 0) System.out.println("Error: Weight must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number.");
            }
        }

        int stock = -1;
        while (stock < 0) {
            System.out.print("Stock Qty: > ");
            try {
                stock = Integer.parseInt(sc.nextLine());
                if (stock < 0) System.out.println("Error: Stock cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid integer.");
            }
        }

        Product p = null;
        if (cat.equals("1")) p = new BookProduct(id, name, price, weight, stock);
        else if (cat.equals("2")) p = new ElectronicProduct(id, name, price, weight, stock);
        else if (cat.equals("3")) p = new GroceryProduct(id, name, price, weight, stock);

        if (p != null) {
            system.addProduct(p);
            System.out.printf("Product added: %s (%s)%n", name, p.getCategory());
        }
	}
//This method shows all the instances of shipment in the arrayList shipments, then updates the shipment status based on the statusChoice of the user
	public static void updateShipment(Scanner sc, WarehouseSystem system) {
		ArrayList<Shipment> shipments=system.getShipments();
		for(int i=0;i<shipments.size();i++) {
			System.out.printf("%d) %s%n",i,shipments.get(i).basicInfo());
			}
		System.out.println("Choose shipment index: >");
		int index= sc.nextInt();
		Shipment s= shipments.get(index);
		System.out.println(
			    "Status:\n" +
			    "0) CREATED\n" +
			    "1) PACKED\n" +
			    "2) IN_TRANSIT\n" +
			    "3) OUT_FOR_DELIVERY\n" +
			    "4) DELIVERED"
			);
        System.out.print("New status index: >");
        int statusChoice = sc.nextInt();
        s.setStatus(ShipmentStatus.values()[statusChoice]);
        System.out.printf("Updated: %s",s.basicInfo());
        
	} 
		
}
