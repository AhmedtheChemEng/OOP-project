/**
 * Represents a grocery product in the warehouse system.
 * Extends the Product class and defines its category as "Grocery".
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

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
