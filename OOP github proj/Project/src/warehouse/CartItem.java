/**
 * Represents an item inside a customer's shopping cart.
 * Each CartItem contains a product reference, its quantity,
 * and methods to calculate subtotal price and total weight.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double lineSubTotal(){
        return product.getPrice()*getQuantity();

    }
    public double lineWeight(){
        return product.getWeightKg()*getQuantity();

    }

    
    public String info() {
        return String.format("%s x%d | QAR %.2f", product.getId(),quantity,lineSubTotal());
    }

}
