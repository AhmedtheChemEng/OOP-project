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
