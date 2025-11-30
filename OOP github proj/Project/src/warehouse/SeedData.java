package warehouse;
import java.time.*;

public class SeedData {
	public static void load(WarehouseSystem s) {

        s.addCustomer(new Customer("Ahmad","C001"));
        s.addCustomer(new Customer( "Mohammad","C002"));
        s.addCustomer(new Customer("Nasser","C003" ));
        s.addCustomer(new Customer( "Aisha","C004"));
        s.addCustomer(new Customer( "Fatimah","C005"));

        s.addProduct(new ElectronicProduct("E1", "Electronic 1", 205.00, 2.1, 8));
        s.addProduct(new ElectronicProduct("E2", "Electronic 2", 210.00, 2.2, 10));
        s.addProduct(new ElectronicProduct("E3", "Electronic 3", 215.00, 1.8, 10));
        // ... filling in some more samples based on requirements or just generic
        s.addProduct(new ElectronicProduct("E99", "Tablet 10", 899.00, 0.8, 3));

        s.addProduct(new BookProduct("B1", "Book 1", 21.00, 0.5, 9));
        s.addProduct(new BookProduct("B2", "Book 2", 22.00, 0.6, 11));
        s.addProduct(new BookProduct("B3", "Book 3", 23.00, 0.7, 11));
        s.addProduct(new BookProduct("B4", "Book 4", 24.00, 0.8, 14));
        s.addProduct(new BookProduct("B5", "Book 5", 25.00, 0.9, 9));
        s.addProduct(new BookProduct("B99", "Algorithms Handbook", 120.00, 1.5, 5));

        s.addProduct(new GroceryProduct("G1", "Grocery 1", 6.00, 1.0, 16));
        s.addProduct(new GroceryProduct("G2", "Grocery 2", 7.00, 1.1, 20));
        s.addProduct(new GroceryProduct("G10", "Grocery 10", 15.00, 0.7, 21));
        s.addProduct(new GroceryProduct("G99", "Premium Dates Box", 49.50, 1.2, 28));

        s.addDiscount(new PercentageDiscount("P10", "2025-10-14", "2025-11-03", 10.0));
        s.addDiscount(new FixedAmountDiscount("F15", "2025-10-19", "2025-10-27", 15.0));
        s.addDiscount(new PercentageDiscount("P5", "2025-10-23", "2025-10-25", 5.0));

        Discount f25 = new FixedAmountDiscount("F25", "2025-10-29", "2025-11-26", 25.0);
        s.setDiscountActive(f25);
        s.addDiscount(f25);

        s.addDiscount(new PercentageDiscount("P20", "2025-09-24", "2025-10-04", 20.0));
        s.addDiscount(new FixedAmountDiscount("F5", "2025-10-22", "2025-11-08", 5.0));
        s.addDiscount(new PercentageDiscount("P12", "2025-10-29", "2025-12-03", 12.0));

}

}
