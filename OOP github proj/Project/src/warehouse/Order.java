package warehouse;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.ArrayList;
import java.io.Serializable;

public class Order implements Serializable {
     
    private String id;
    private Customer customer;
    private LocalDate date;
    private ArrayList<OrderItem> items;
    private double subtotal;
    private double discountAmount;
    private double shippingFee;
    private double total;
    private Discount appliedDiscount;
    private Payment payment;


   

	public Order(String orderId, Customer customer2, LocalDate today, ArrayList<OrderItem> orderItems, double subtotal2,
			double discountAmount2, double shipping, double total2, Discount discount, Payment payment2) {
		
	}

	
	
	public Payment getPayment() {
		return payment;
	}


	public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public double getTotal() {
        return total;
    }

    public Discount getAppliedDiscount() {
        return appliedDiscount;
    }
    public String toString() {
    	return String.format("%8s| %8s| QAR %.2f", id,customer.getName(),total);
    }
}