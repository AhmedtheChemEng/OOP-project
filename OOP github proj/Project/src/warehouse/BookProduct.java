/**
 * Represents a product of type Book in the warehouse system.
 * This class extends the Product class and specifies the category as "Book".
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

package warehouse;

public class BookProduct extends Product{

	public String getCategory() {
		return "Book";
	}

	public BookProduct(String id, String name, double price, double weightKg, int stock) {
		super(id, name, price, weightKg, stock);
		// TODO Auto-generated constructor stub
	}
	
	
		
}
