package warehouse;

import java.time.LocalDate;
import java.util.*;

public class ReportService {
	
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
				case 9 -> ShipmentsbyStatus(warehouse);
				case 10 -> ShipmentsnotyetDELIVERED(warehouse);
				case 11 -> TopSelling(warehouse);
				case 12 -> TotalRevenue(warehouse);
				case 13 -> PaymentsSummary(warehouse);
				case 14 -> DiscountUsage(warehouse);
				case 15 -> ActiveDiscountOverlaps(warehouse);
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
				System.out.printf(" - %s\n",d);
			}
			
		}
		
		private static void ActiveDiscounts(WarehouseSystem warehouse) {
			System.out.println("\n[2] Active Discounts:");
			boolean none = true;
			for (Discount d:warehouse.getDiscounts()) {
				if (d.isActive()) {
					none=false;
					System.out.printf(" - %s\n",d);}
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
					System.out.printf(" - %s stock %d\n",p.basicInfo(),p.getStock());
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
					System.out.printf(" - %s\n",p.basicInfo());
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
			System.out.printf("[7] Orders Today (%s):\n",warehouse.getToday());
			if (warehouse.getOrders().isEmpty()) {System.out.println(" None.");return;}
			for (Order o:warehouse.getOrders()) {
				System.out.println(o);
			}
			
		}
		
		private static void SalesbyCustomer(WarehouseSystem warehouse) {
			System.out.println("[8] Sales by Customer:");
			if (warehouse.getOrders().isEmpty()) {System.out.println(" None.");return;}
			for (Order o:warehouse.getOrders()) {
				System.out.printf(" - %-9s QAR %.2f",o.getCustomer().getName()+":",o.getTotal());
			}
		}
		
		private static void ShipmentsbyStatus(WarehouseSystem warehouse) {
			System.out.println("[9] Shipments by Status:");
			if (warehouse.getShipments().isEmpty()) {System.out.println(" None.");return;}
			
			for (Shipment s: warehouse.getShipments()) {
				System.out.println("Order "+s);
			}
			
			
		}
		
		private static void ShipmentsnotyetDELIVERED(WarehouseSystem warehouse) {
			System.out.println("[10] Shipments not yet DELIVERED:");
			if (warehouse.getShipments().isEmpty()) {System.out.println(" None.");return;}
			boolean none = true;
			for (Shipment s: warehouse.getShipments()) {
				if (s.getStatus()!=ShipmentStatus.DELIVERED) {
					none = false;
					System.out.println(s);}
			}
			if (none) {System.out.println(" None.");}
		}
		//======================================
		private static void TopSelling(WarehouseSystem warehouse) {
			System.out.println("[11] Simple Top-Selling (counts):");
			ArrayList<OrderItem> soldItems = new ArrayList<>();
			boolean found;
			for (Order o:warehouse.getOrders()) {
				for (OrderItem oi:o.getItems()) {
					found = false;
					for (OrderItem si:soldItems) {
						if (si.getProduct()==oi.getProduct()) {
							si.setQuantity(si.getQuantity()+oi.getQuantity());
							found = true;
							break;
						}
					}
					if (!found) {
						soldItems.add(oi);
					}	
				}
			}
			soldItems.sort((oi1,oi2) -> Integer.compare(oi2.getQuantity(), oi1.getQuantity()));// lambda function to sort the OrderItem ArrayList in descending quantity order
			for (OrderItem oi:soldItems) {
				System.out.printf(" - %s (%s): %d units\n",oi.getProduct().getName(),oi.getProduct().getId(),oi.getQuantity());
			}
			if (soldItems.isEmpty()) {System.out.println(" None.");return;}
		}
		//======================================
		private static void TotalRevenue(WarehouseSystem warehouse) {
			double totalRevenue = 0;
			for (Order o : warehouse.getOrders()) totalRevenue += o.getTotal();

			System.out.println("[12] Total Revenue (QAR, all time):");
			System.out.printf("Total: QAR %.2f\n",totalRevenue);

		}

		private static void PaymentsSummary(WarehouseSystem warehouse) {
			System.out.println("[13] Payments Summary (from Orders):");

			ArrayList<String> cardCustomers = new ArrayList<>();
			ArrayList<String> cashCustomers = new ArrayList<>();
			
			for (Order o : warehouse.getOrders()) {
			    Payment p = o.getPayment();
			    Customer c = o.getCustomer();

			    if (p instanceof CardPayment) {
			        cardCustomers.add(c.getName());
			        
			    } else if (p instanceof CashPayment) {
			        cashCustomers.add(c.getName());
			        
			    }
			}
			double totalRevenue = 0;
			for (Order o : warehouse.getOrders()) totalRevenue += o.getTotal();

			if (cardCustomers.isEmpty()) {
				cardCustomers.add("None");
			}
			if (cashCustomers.isEmpty()) {
				cashCustomers.add("None");
			}
			
			System.out.printf("Collected: QAR %.2f%n",totalRevenue);
			System.out.printf("(mix: card for %s; cash for %s)%n",
			        String.join(", ", cardCustomers),
			        String.join(", ", cashCustomers));
			
		}
		
		private static void DiscountUsage(WarehouseSystem warehouse) {
			System.out.println("[14] Discount Usage:");
			ArrayList<Discount> UsedDiscounts = new ArrayList<>();
			ArrayList<Integer> UDnum = new ArrayList<>();
			ArrayList<Double> DAmm = new ArrayList<>();
			
			for(Order o:warehouse.getOrders()) {
				if (UsedDiscounts.contains(o.getAppliedDiscount())){
					int index = UsedDiscounts.indexOf(o.getAppliedDiscount());
					UDnum.set(index, UDnum.get(index)+1);
					DAmm.set(index, DAmm.get(index)+o.getDiscountAmount());
				}
				else {
					UsedDiscounts.add(o.getAppliedDiscount());
					UDnum.add(1);
					DAmm.add(o.getDiscountAmount());
				}
			}
			for (int i=0;i<UsedDiscounts.size();i++) {
				System.out.printf(" - %-8s times %d, total discount QAR %.2f\n",UsedDiscounts.get(i).getCode()+":",UDnum.get(i),DAmm.get(i));
			}
			if (UsedDiscounts.isEmpty()) {System.out.println(" None.");}
		}
		
		private static void ActiveDiscountOverlaps(WarehouseSystem warehouse) {
			System.out.printf("[15] Active Discount Overlaps (today %s)\n",warehouse.getToday());
			Discount ActiveDiscount=warehouse.findApplicableDiscount(warehouse.getToday());
			
			if (ActiveDiscount!=null) {
				for(Discount d:warehouse.getDiscounts() ) {
					if(d.overlaps(ActiveDiscount, d)) {
						System.out.println(" - "+d.getDetails());
					};
					
				}
			}
			else {System.out.println(" None.");}
		}
	// ----------------------------- Helper Methods end -------------------------------------

}
