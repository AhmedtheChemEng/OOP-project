package warehouse;
import java.time.*;
import java.util.*;

public class App {
	public LocalDate TODAY= LocalDate.of(2025,10,24);
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Shipment s1= new Shipment("Try", 50, new Customer("A","B"), new Address("s","r","india"),ShipmentStatus.CREATED);
	WarehouseSystem w1=new WarehouseSystem();
	w1.addShipment(s1);
	StaffMenu.run(sc, w1);
}
}

