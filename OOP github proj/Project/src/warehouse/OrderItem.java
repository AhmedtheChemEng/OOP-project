/**
 * Represents an individual item within a customer's order.
 * Contains product details, quantity purchased, and unit price in QAR.
 * Provides a method to calculate the total line cost for the item.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;
import java.io.*;
public class OrderItem implements Serializable{
    private Product product;
    private int quantity;
    private double unitPriceQar;
    

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

    public double getUnitPriceQar() {
        return unitPriceQar;
    }

    public void setUnitPriceQar(double unitPriceQar) {
        this.unitPriceQar = unitPriceQar;
    }

    public OrderItem(Product product, int quantity, double unitPriceQar) {
        this.product = product;
        this.quantity = quantity;
        this.unitPriceQar = unitPriceQar;
    }
    public double lineTotal(){
        return getUnitPriceQar()*getQuantity();

    }
    
}
