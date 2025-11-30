/**
 * Represents an electronic product in the warehouse system.
 * Extends the Product class and defines its category as "Electronics".
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

package warehouse;

public class ElectronicProduct extends Product{

	public ElectronicProduct(String id, String name, double price, double weightKg, int stock) {
		super(id, name, price, weightKg, stock);
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return "Electronics";
	}
}
