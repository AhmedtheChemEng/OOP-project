package warehouse;
import java.time.LocalDate;

public class Shipment {
	private String Orderid;
	private double totalWeightKg;
	private Customer customer;
	private Address address;
	private ShipmentStatus status;
	
	public Shipment(String orderid, double totalWeightKg, Customer customer, Address address, ShipmentStatus status) {
		super();
		this.Orderid = orderid;
		this.totalWeightKg = totalWeightKg;
		this.customer = customer;
		this.address = address;
		this.status = status;
	}

	public String basicInfo() {
		return String.format("Shipment: Order %s | %s | %s | %.2f kg to %s, %s, %s ",
				Orderid, 
				customer.getName(),
				status,
				totalWeightKg,
				address.getStreet(),
				address.getCity(),
				address.getCountry());
	}
	


	
	

}
