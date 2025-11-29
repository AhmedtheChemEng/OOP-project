package warehouse;

import java.util.*;

public class ProductListView {

	public static void printCategorized(ArrayList<Product> Product) {
		for (int i = 0; i < Product.size(); i++) {
			Product P = Product.get(i);
			if (P instanceof ElectronicProduct) {
				System.out.println(P);
			}
		}
		for (int i = 0; i < Product.size(); i++) {
			Product P = Product.get(i);
			if (P instanceof BookProduct) {
				System.out.println(P);
			}
		}

		for (int i = 0; i < Product.size(); i++) {
			Product P = Product.get(i);
			if (P instanceof GroceryProduct) {
				System.out.println(P);
			}
		}
	}
}
