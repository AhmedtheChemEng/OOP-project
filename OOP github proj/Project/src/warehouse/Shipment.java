/**
 * Represents a shipment record in the warehouse system.
 * Contains details such as the order ID, total weight, customer, 
 * delivery address, and current shipment status.
 *
 * Provides methods to retrieve and modify shipment data,
 * as well as to generate formatted summaries of shipment information.
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

package warehouse;
import java.time.LocalDate;
import java.io.*;

public class Shipment implements Serializable{
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

	
	
	public String getOrderid() {
		return Orderid;
	}



	public void setOrderid(String orderid) {
		Orderid = orderid;
	}



	public double getTotalWeightKg() {
		return totalWeightKg;
	}



	public void setTotalWeightKg(double totalWeightKg) {
		this.totalWeightKg = totalWeightKg;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public ShipmentStatus getStatus() {
		return status;
	}



	public String basicInfo() {
		return String.format("%s | %s | %s | %.2f kg to %s",
				Orderid, 
				customer.getName(),
				status,
				totalWeightKg,
				address);
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}
	
	public String toString() {
		return basicInfo();
	}
	
	

	
	

}
