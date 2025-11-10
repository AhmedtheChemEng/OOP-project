package warehouse;

public abstract class Product {
	private String id;
	private String name;
	private String curency;
	private double price;
	private double weightKg;
	private int stockQty;

	public abstract String getCategory();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}

	public int getStock() {
		return stockQty;
	}

	public void setStock(int stock) {
		this.stockQty = stock;

	}

	public String basicInfo() {
		return "";
	}

}
