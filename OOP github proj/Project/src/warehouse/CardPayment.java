/**
 * Represents a card-based payment in the warehouse system.
 * Stores details such as cardholder name, masked card number, amount, and currency.
 * Implements the Payment interface to provide standardized payment behavior.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;

public class CardPayment implements Payment {
    private String  cardHolder, maskedNumber;
    private double amount;
    private String currency= "QAR";
    


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

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getMaskedNumber() {
        return maskedNumber;
    }

    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    public CardPayment(double amount, String cardHolder, String maskedNumber) {
        
        this.cardHolder = cardHolder;
        this.maskedNumber = maskedNumber;
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
        return String.format("Card QAR %.2f (%s, %s)", amount,cardHolder,maskedNumber);
    }
}

