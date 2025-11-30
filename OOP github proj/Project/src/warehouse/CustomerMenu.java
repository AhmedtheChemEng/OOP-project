/**
 * Handles all customer interactions within the warehouse system.
 * Provides a console-based menu for customers to browse products,
 * manage their shopping cart, checkout with payment, and create shipments.
 *
 * Features include:
 * - Listing products by category
 * - Adding/removing items from the cart
 * - Viewing cart contents
 * - Applying discounts and calculating totals
 * - Choosing between card or cash payment
 * - Generating orders and shipments automatically
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;
import java.util.Scanner;

public class CustomerMenu {
    public static void run(Scanner sc, WarehouseSystem system) {
        System.out.println("Available Customer IDs:");
        for (Customer c : system.getCustomers()) {
            System.out.printf("- %s (%s)%n", c.getId(), c.getName());
        }
        System.out.print("\nEnter Customer ID to login: > ");
        String id = sc.nextLine();
        Customer customer = system.findCustomerById(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.printf("\n--- Customer Menu (ID: %s, %s) ---%n", customer.getId(), customer.getName());
            System.out.println("1) List Products (by Category)");
            System.out.println("2) Add to Cart");
            System.out.println("3) Remove from Cart");
            System.out.println("4) View Cart");
            System.out.println("5) Checkout");
            System.out.println("0) Logout");
            System.out.print("Choose: > ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                ProductListView.printCategorized(system.getProducts());
                
                
            } else if (choice.equals("2")) {
                System.out.print("Enter Product ID: > ");
                String pid = sc.nextLine();
                Product p = system.findProductById(pid);
                if (p != null) {
                    int qty = -1;
                    while (qty <= 0) {
                        System.out.print("Quantity: > ");
                        try {
                            qty = Integer.parseInt(sc.nextLine());
                            if (qty <= 0) System.out.println("Error: Quantity must be positive or more than 0.");
                            else if (qty > p.getStock()) {
                                System.out.println("Error: Insufficient stock.");
                                qty = -1;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid integer.");
                        }
                    }
//                    p.setStock(p.getStock()-qty);
                    cart.addItem(p, qty);
                    System.out.println("Added to cart.");
                } else {
                    System.out.println("Product not found.");
                }
                
                
                
            } else if (choice.equals("3")) {
                if (cart.isEmpty()) {
                    System.out.println("Cart is empty.");
                    continue;
                }
                cart.print();
                System.out.print("Enter index to remove: > ");
                try {
                    int idx = Integer.parseInt(sc.nextLine());
                    if (idx >= 0 && idx < cart.getItems().size()) {
                        cart.removeIndex(idx);
                        System.out.println("Removed.");
                    } else {
                        System.out.println("Error: Invalid index.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid index.");
                }
                
                
            } else if (choice.equals("4")) {
                cart.print();
                
                
            } else if (choice.equals("5")) {
                if (cart.isEmpty()) {
                    System.out.println("Cart is empty.");
                    continue;
                }
                System.out.println("--- Shipping Address ---");
                String street = "";
                while (street.trim().isEmpty()) {
                    System.out.print("Street: > ");
                    street = sc.nextLine();
                    if (street.trim().isEmpty()) System.out.println("Error: Street cannot be empty.");
                }
                
                String city = "";
                while (city.trim().isEmpty()) {
                    System.out.print("City: > ");
                    city = sc.nextLine();
                    if (city.trim().isEmpty()) System.out.println("Error: City cannot be empty.");
                }

                String country = "";
                while (country.trim().isEmpty()) {
                    System.out.print("Country: > ");
                    country = sc.nextLine();
                    if (country.trim().isEmpty()) System.out.println("Error: Country cannot be empty.");
                }
                Address address = new Address(street, city, country);

                String payChoice = "";
                while (true) {
                    System.out.println("Payment method: 1) Card 2) Cash");
                    System.out.print("> ");
                    payChoice = sc.nextLine();
                    if (payChoice.equals("1") || payChoice.equals("2")) break;
                    System.out.println("Error: Invalid choice.");
                }
                
                Payment payment = null;
                
                double subtotal = cart.subtotal();
                Discount discount = system.findApplicableDiscount(system.getToday());
                double discountAmount = 0;
                if (discount != null) {
                    discountAmount = discount.calculateDiscount(subtotal);
                }
                double weight = cart.totalWeight();
                double shipping = system.getRateTable().shippingFeeFor(weight);
                double total = subtotal - discountAmount + shipping;

                if (payChoice.equals("1")) {
                    String holder = "";
                    while (holder.trim().isEmpty()) {
                        System.out.print("Card Holder Name: > ");
                        holder = sc.nextLine();
                        if (holder.trim().isEmpty()) System.out.println("Error: Name cannot be empty.");
                    }
                    
                    String number = "";
                    while (number.trim().isEmpty()) {
                        System.out.print("Card Number (masked ok): > ");
                        number = sc.nextLine();
                        if (number.trim().isEmpty()) System.out.println("Error: Number cannot be empty.");
                    }
                    payment = new CardPayment(total, holder, number);
                } else {
                    payment = new CashPayment(total);
                }

                System.out.println("\n--- Checkout Summary ---");
                cart.print();
                
                if (discount != null) {
                    System.out.printf("Discount (%s): - QAR %.2f%n", discount.getDetails(), discountAmount);
                }
                System.out.printf("Shipping (%.2f kg): QAR %.2f%n", weight, shipping);
                System.out.printf("TOTAL: QAR %.2f%n", total);
                System.out.println("Payment: " + payment.summary());

                String orderId = OrderIdGenerator.nextId();
                System.out.println("Order ID: " + orderId);

                Order order = new Order(orderId,customer,system.getToday(),cart.toOrderItems(),subtotal,discountAmount,shipping,total,discount,payment);
                system.addOrder(order);

                Shipment shipment = new Shipment(orderId, weight, customer, address, ShipmentStatus.CREATED);
                system.addShipment(shipment);
                System.out.println("Shipment: " + shipment.basicInfo());

                // Reduce stock
                for (CartItem item : cart.getItems()) {
                    item.getProduct().setStock(item.getProduct().getStock() - item.getQuantity());
                }

                cart.clear();
            } else if (choice.equals("0")) {
                break;
            }
        }
    }
}
