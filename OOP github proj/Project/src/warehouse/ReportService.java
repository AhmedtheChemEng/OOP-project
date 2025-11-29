package warehouse;

import java.time.LocalDate;
import java.util.*;

public class ReportService {
	
	public static void main(String[] args) {
		WarehouseSystem w1 = new WarehouseSystem();
		//---------------
		w1.addDiscount(new FixedAmountDiscount("F10","2025-11-11","2025-11-30",10));
		w1.addDiscount(new PercentageDiscount("P10","2025-11-21","2025-12-30",10));
		w1.setDiscountActive(w1.getDiscounts().get(0));
		//---------------
		w1.addProduct(new ElectronicProduct("E1","Phone",3000,1.2,1));
		w1.addProduct(new BookProduct("B1","Math",300,3,5));
//		w1.addProduct(new GroceryProduct());
		//---------------
		Customer c1 = new Customer("A1","Ali");
		w1.addCustomer(c1);
		//---------------
//		w1.addOrder();
		//---------------
		
		runAllReports(w1);
	}
	
	public static void runAllReports(WarehouseSystem warehouse) {
		final String menu = "\n1) All Discounts\r\n"
				+ "2) Active Discounts (today)\r\n"
				+ "3) Products by Category\r\n"
				+ "4) Low Stock (≤ threshold)\r\n"
				+ "5) Out of Stock\r\n"
				+ "6) Inventory Valuation (QAR)\r\n"
				+ "7) Orders Today (YYYY-MM-DD)\r\n"
				+ "8) Sales by Customer (QAR)\r\n"
				+ "9) Shipments by Status\r\n"
				+ "10) Shipments are not yet DELIVERED\r\n"
				+ "11) Simple Top-Selling (counts)\r\n"
				+ "12) Total Revenue (QAR, all time)\r\n"
				+ "13) Payments Summary (from Orders)\r\n"
				+ "14) Discount Usage\r\n"
				+ "15) Active Discount Overlaps (today)\r\n"
				+ "0) Back\r\n\n\nChoose: > ";
		
		Scanner kb = new Scanner(System.in);
		int choice = 1;
		// -------------------------- Reports Menu Loop ---------------------------------
		
		do {
			System.out.print(menu);
			choice = kb.nextInt();// this removes the \n entered after the number so that "Enter to continue" works
			switch (choice) {
				case 1 -> AllDiscounts(warehouse);
				case 2 -> ActiveDiscounts(warehouse);
				case 3 -> ProductsbyCategory(warehouse);
				case 4 -> {System.out.print("Threshold: > ");LowStock(warehouse,kb.nextInt());}
				case 5 -> OutofStock(warehouse);
				case 6 -> InventoryValuation(warehouse);
				case 7 -> OrdersToday(warehouse);
				case 8 -> SalesbyCustomer(warehouse);
	//			case 9 -> (warehouse);
	//			case 10 -> (warehouse);
	//			case 11 -> (warehouse);
	//			case 12 -> (warehouse);
	//			case 13 -> (warehouse);
	//			case 14 -> (warehouse);
	//			case 15 -> (warehouse);
				case 0 -> System.out.println("Returning to Staff Menu...\n");
				default -> System.out.println("Invalid Choice!");
			}
			if (choice!=0){
			System.out.print("\nPress Enter to continue...");
			kb.nextLine();kb.nextLine();} // waits for users input to continue (The scanner is called twice to counter act previous '\n' input)
		} while (choice!=0);
		
		// -------------------------- Reports Menu Loop end ---------------------------------
		
	}
	
	// ----------------------------- Helper Methods -------------------------------------
		
		private static void AllDiscounts(WarehouseSystem warehouse) {
			System.out.println("\n[1] All Discounts:");
			if (warehouse.getDiscounts().isEmpty()) {System.out.println(" None.");return;}
			for (Discount d:warehouse.getDiscounts()) {
				System.out.printf("- %s\n",d);
			}
			
		}
		
		private static void ActiveDiscounts(WarehouseSystem warehouse) {
			System.out.println("\n[2] Active Discounts:");
			boolean none = true;
			for (Discount d:warehouse.getDiscounts()) {
				if (d.isActive()) {
					none=false;
					System.out.printf("- %s\n",d);}
			}
			if (none) {System.out.println(" None.");}
		}
	
		private static void ProductsbyCategory(WarehouseSystem warehouse) {
			System.out.println("\n[3] Products by Category:");
			if (warehouse.getProducts().isEmpty()) {System.out.println(" None.");return;}
			ProductListView.printCategorized(warehouse.getProducts());
		}
		
		private static void LowStock(WarehouseSystem warehouse,int threshold) {
			System.out.printf("\n[4] Low Stock (<= %d):\n",threshold);
			boolean none = true;
			for (Product p: warehouse.getProducts()) {
				if (p.getStock()<=threshold) {
					none = false;
					System.out.printf("- %s stock %d\n",p.basicInfo(),p.getStock());
				}
			}
						
			if (none) {System.out.println(" None.");}
			// incomplete <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		}
		
		private static void OutofStock(WarehouseSystem warehouse) {
			System.out.println("\n[5] Out of Stock:");
			boolean none = true;
			for (Product p: warehouse.getProducts()) {
				if (p.getStock()==0) {
					none = false;
					System.out.printf("- %s\n",p.basicInfo());
				}
			}			
			if (none) {System.out.println(" None.");}
		}
		
		private static void InventoryValuation(WarehouseSystem warehouse) {
			System.out.println("\n[6] Inventory Valuation (QAR):");
			double sum = 0;
			
			for (Product p:warehouse.getProducts()) {
				sum+= p.getPrice()*p.getStock();
			}
			System.out.printf("Total: QAR %.2f (computed by system based on current stock)\n",sum);
		}
		
		private static void OrdersToday(WarehouseSystem warehouse) {
			System.out.printf("[7] Orders Today (%s):\n",LocalDate.now());
			if (warehouse.getOrders().isEmpty()) {System.out.println(" None.");return;}
			for (Order o:warehouse.getOrders()) {
				System.out.println(o);
			}
			
		}
		
		private static void SalesbyCustomer(WarehouseSystem warehouse) {
			System.out.println("[8] Sales by Customer:");
			if (warehouse.getOrders().isEmpty()) {System.out.println(" None.");return;}
			for (Order o:warehouse.getOrders()) {
				System.out.printf("- %9s QAR %.2f",o.getCustomer().getName()+":",o.getTotal());
			}
		}
		
		private static void ShipmentsbyStatus(WarehouseSystem warehouse) {
			System.out.println("[9] Shipments by Status:");
			if (warehouse.getOrders().isEmpty()) {System.out.println(" None.");return;}
			ArrayList<Order> orders = new ArrayList<>();
			ArrayList<Shipment> shipments = new ArrayList<>();
			
			for (Order o:warehouse.getOrders()) {
				System.out.printf("- Order %s | %8s| %9s | %.2f kg to %s");
				
			}
		}
		
//		private static void (WarehouseSystem warehouse) {}
	
	// ----------------------------- Helper Methods end -------------------------------------

}
