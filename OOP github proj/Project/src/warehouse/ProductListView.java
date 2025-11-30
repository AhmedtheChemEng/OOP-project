/**
 * Provides utility methods for displaying product lists in categorized form.
 * Prints all products grouped by their type: Electronics, Book, or Grocery.
 * Used in customer menus to help users browse available products easily.
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

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
