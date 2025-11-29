package warehouse;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class WarehouseSystem implements Serializable{

	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Discount> discounts = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<Shipment> shipments = new ArrayList<>();
	private RateTable rateTable = new RateTable();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ------------------------- Setters ------------------------------------
	
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}

	public void setRateTable(RateTable rateTable) {
		this.rateTable = rateTable;
	}

	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}
	
	// ------------------------- Setters end ------------------------------------
	
	
	// ------------------------- Discounts ------------------------------------
	
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	
	private void deactivateOverlaps(Discount newDiscount) {
		for (Discount d : discounts) {//deactivates overlapping discounts
			if (Discount.overlaps(newDiscount,d) && !d.equals(newDiscount)) {//checks for all discounts in the arraylist that overlap and skips its' self.
				d.setActive(false);
			}
		}
	}
	
	public void addDiscount(Discount newDiscount) {//adds a new discount to arraylist discounts
		if (!discounts.contains(newDiscount)) { //checks if it was already added
			if (newDiscount.isActive()){//if it is active deactivate overlaps
				deactivateOverlaps(newDiscount); 
			}
			discounts.add(newDiscount);}//finally add
		
	}
	
	public void setDiscountActive(Discount target) { // toggles discount activity
		if (target.isActive()){ // if active toggle off
			target.setActive(false);
		}
		else { // else toggle on and check for overlap
			target.setActive(true);
			deactivateOverlaps(target);
		}
	}
	
	public Discount findApplicableDiscount(LocalDate date) {
		
		for (Discount d:discounts) {// checks all discounts and the if statement checks if it meets the conditions specified.
			if (d.isActive() && ( d.getStartDate().isBefore(date) || d.getStartDate().equals(date) ) && ( d.getEndDate().isAfter(date) || d.getStartDate().equals(date) ) ) {
				return d;
			}
		}
		System.out.println("No Applicable Discounts.");
		return null;
	}
	
	// ------------------------- Discounts end ------------------------------------
	
	// ------------------------- Customer ------------------------------------
	
	public void addCustomer(Customer newCustomer) {
		if (!customers.contains(newCustomer)){
			customers.add(newCustomer);}
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public Customer findCustomerById(String id) {
		for (Customer c:customers) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	// ------------------------- Customer end ------------------------------------
	
	// ------------------------- Product ------------------------------------
	
	public void addProduct(Product newProduct) {
		if (!products.contains(newProduct)){
			products.add(newProduct);}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public Product findProductById(String id) {
		for (Product p:products) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	// ------------------------- Product end ------------------------------------
	
	// ------------------------- Order ------------------------------------
	
	public void addOrder(Order order) {
		if (!orders.contains(order)){
			orders.add(order);}
	}


	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	// ------------------------- Order end ------------------------------------
	
	// ------------------------- Shipment ------------------------------------
	
	public void addShipment(Shipment Shipment) {
		if (!shipments.contains(Shipment)){
			shipments.add(Shipment);}
	}

	public ArrayList<Shipment> getShipments() {
		return shipments;
	}

	
	// ------------------------- Shipment end ------------------------------------
	
	// ------------------------- RateTable ------------------------------------
	
	public RateTable getRateTable() {
		return rateTable;
	}
	
	// ------------------------- RateTable ------------------------------------

}
