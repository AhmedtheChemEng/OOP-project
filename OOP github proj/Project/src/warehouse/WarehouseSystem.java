package warehouse;

import java.time.LocalDate;
import java.util.*;

public class WarehouseSystem {

	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Discount> discounts = new ArrayList<>();
//	private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<Shipment> shipments = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// ------------------------- Discounts ------------------------------------
	
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
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
	
	public void toggleDiscountActive(Discount target) { // toggles discount activity
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
	
	
	
	

}
