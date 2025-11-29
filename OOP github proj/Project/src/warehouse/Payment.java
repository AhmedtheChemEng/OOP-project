package warehouse;
import java.io.Serializable;

public interface Payment extends Serializable {
    public String currency();
    public double amount();
    public String summary();
}