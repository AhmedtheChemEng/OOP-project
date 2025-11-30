/**
 * Represents a cash payment transaction in the warehouse system.
 * Stores the payment amount and currency, and provides a formatted summary.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;

public class CashPayment implements Payment {
    private String currency="QAR";
    private double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CashPayment( double amount) {
        this.amount = amount;
    }

    @Override
    public String currency() {
        return getCurrency();

    }

    @Override
    public double amount() {
        return getAmount();

    }

    @Override
    public String summary() {
        return String.format("Cash QAR %.2f", amount);
    }
}

