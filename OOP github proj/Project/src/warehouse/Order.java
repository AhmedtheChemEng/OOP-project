package warehouse;
import java.time.LocalDate;

public class Order {
	private String id;
	private LocalDate date;
	private double subtotal;
	private double discountAmount;
	private double shippingFee;
	private double total;
	private Customer customer;
	private OrderItem items;
	private Discount appliedDiscount;
	private Payment payment;
}
