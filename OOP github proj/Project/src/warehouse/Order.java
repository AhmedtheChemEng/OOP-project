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

    public Order(String id, Customer customer, LocalDate date, ArrayList<OrderItem> items, double subtotal, double discountAmount, double shippingFee, double total, Discount appliedDiscount) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.items = items;
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
        this.shippingFee = shippingFee;
        this.total = total;
        this.appliedDiscount = appliedDiscount;
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
}