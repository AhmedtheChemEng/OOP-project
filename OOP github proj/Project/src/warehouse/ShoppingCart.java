package warehouse;
import java.util.*;

public class ShoppingCart {
	 private ArrayList<CartItem> items = new ArrayList<>();

	    public void addItem(Product product, int quantity) {
	        for (CartItem item : items) {
	            if (item.getProduct().getId().equals(product.getId())) {
	                item.setQuantity(item.getQuantity() + quantity);
	                return;
	            }
	        }
	        items.add(new CartItem(product, quantity));
	    }

	    public void removeIndex(int index) {
	        if (index >= 0 && index < items.size()) {
	            items.remove(index);
	        }
	    }

	    public boolean isEmpty() {
	        return items.isEmpty();
	    }

	    public void clear() {
	        items.clear();
	    }

	    public ArrayList<CartItem> getItems() {
	        return items;
	    }

	    public double subtotal() {
	        double sum = 0;
	        for (CartItem item : items) {
	            sum += item.lineSubTotal();
	        }
	        return sum;
	    }

	    public double totalWeight() {
	        double weight = 0;
	        for (CartItem item : items) {
	            weight += item.lineWeight();
	        }
	        return weight;
	    }

	    public void print() {
	        System.out.println("--- Cart ---");
	        for (int i = 0; i < items.size(); i++) {
	            System.out.println(i + ") " + items.get(i).info());
	        }
	        System.out.printf("Subtotal: QAR %.2f%n", subtotal());
	    }

	    public ArrayList<OrderItem> toOrderItems() {
	        ArrayList<OrderItem> orderItems = new ArrayList<>();
	        for (CartItem item : items) {
	            orderItems.add(new OrderItem(item.getProduct(), item.getQuantity(), item.getProduct().getPrice()));
	        }
	        return orderItems;
	    }
	}


