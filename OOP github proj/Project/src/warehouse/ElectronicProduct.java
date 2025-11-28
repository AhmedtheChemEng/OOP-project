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
