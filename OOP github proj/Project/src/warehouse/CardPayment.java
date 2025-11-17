package warehouse;

public class CardPayment implements Payment {
    private String currency, cardHolder, maskedNumber;
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

    public CardPayment(String currency, String cardHolder, String maskedNumber, double amount) {
        this.currency = currency;
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
        return "CardPayment{" +
                "currency='" + currency + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", maskedNumber='" + maskedNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}

