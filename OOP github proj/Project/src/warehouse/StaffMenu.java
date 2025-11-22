package warehouse;
import java.util.*;		

public class StaffMenu{
	
	
	
	/* Shabab this is the menu for staff where i used the different cases to call the specific method depening on the users choice*/
	public static void run(Scanner sc,WareHouseSystem system) {
		int choice;
		final String menu = "--- Staff Menu ---\n"
				+ "1) Add Customer (ID + Name)\n"						
				+ "2) List/Toggle Discounts\n"
				+ "3) Create Discount\n"
				+ "4) Add Product\n"
				+ "5) Update Shipment Status\n"
				+ "6) Reports (~15)"
				+ "0) Back";
		
		do {
			System.out.println(menu);
			choice= sc.nextInt();
			switch(choice) {
			case 1 -> addCustomer(sc,system);
			case 2 -> listToggleDiscounts(sc, system);
			case 3 -> createDiscount(sc, system);
			case 4 -> addProduct(sc,system);
			case 5 -> updateShipment(sc, system);
			case 6 -> ReportService.runAllReports(system);
			//case 0 -> 
			default -> System.out.println("Invalid Choice!");
			}
		} while(choice !=0);
		
		
		
		
		
	}
	
	public static void addCustomer(Scanner sc, WareHouseSystem system) {
		System.out.println("ac");
	}
	
	public static void listToggleDiscounts(Scanner sc, WareHouseSystem system) {
		System.out.println("td");
	}
	
	public static void createDiscount(Scanner sc, WareHouseSystem system) {
		System.out.println("cD");
	}
	
	public static void addProduct(Scanner sc, WareHouseSystem system) {
		System.out.println("aP");
	}
	
	public static void updateShipment(Scanner sc, WareHouseSystem system) {
		System.out.println("uS");
	}
}
//--- Staff Menu ---
//1) Add Customer (ID + Name)
//2) List/Toggle Discounts
//3) Create Discount
//4) Add Product
//5) Update Shipment Status
//6) Reports (~15)
//0) Back
