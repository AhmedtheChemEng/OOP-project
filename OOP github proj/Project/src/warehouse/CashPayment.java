package warehouse;

public class CashPayment implements Payment {
    private String currency;
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

    public CashPayment(String currency, double amount) {
        this.currency = currency;
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
        return "CashPayment{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}

