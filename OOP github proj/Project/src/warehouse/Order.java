package warehouse;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private String id;
    private Customer customer;
    private LocalDate date;
    private ArrayList<OrderItem> items;
    private double subtotal, discountAmount, shippingFee, total;
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

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Discount getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(Discount appliedDiscount) {
        this.appliedDiscount = appliedDiscount;
    }
}
