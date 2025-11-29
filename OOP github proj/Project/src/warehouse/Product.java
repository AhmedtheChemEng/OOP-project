package warehouse;

import java.util.InputMismatchException;
import  java.io.*;

public abstract class Product implements Serializable{
	private String id;
	private String name;
	private String curency;
	private double price;
	private double weightKg;
	private int stockQty;
	

	public abstract String getCategory();
	
	public Product(String id,String name,double price,double weightKg,int stock) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.weightKg=weightKg;
		setStock(stock);
		
	}

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
		if (stock>=0) {
			this.stockQty = stock;}
		else throw new InputMismatchException("Stock must be 0 or postive integer!");

	}

	public String basicInfo() {
		return String.format("%s (%s)",name,id);
	}
	
	public String toString() {
		return String.format(" - %s: %s (ID %s), stock %d, price QAR %.2f",getClass().getSimpleName(),name,id,stockQty,price);
	}

}
