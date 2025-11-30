/**
 * Defines the structure for different payment types in the warehouse system.
 * Each payment must specify its currency, amount, and a summary description.
 *
 * Implementations include classes like CashPayment and CardPayment.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;
import java.io.Serializable;

public interface Payment extends Serializable {
    public String currency();
    public double amount();
    public String summary();
}
