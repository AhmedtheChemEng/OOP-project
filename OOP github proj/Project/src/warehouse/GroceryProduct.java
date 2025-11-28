package warehouse;

public class GroceryProduct extends Product{
	
	public String getCategory() {
		return "Grocery";
	}

	public GroceryProduct(String id, String name, double price, double weightKg, int stock) {
		super(id, name, price, weightKg, stock);
		// TODO Auto-generated constructor stub
	}
}
