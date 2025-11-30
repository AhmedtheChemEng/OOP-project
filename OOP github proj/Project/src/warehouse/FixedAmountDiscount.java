/**
 * Represents a fixed amount discount in the warehouse system.
 * This discount subtracts a constant QAR value from the subtotal.
 * Extends the abstract Discount class and provides implementation
 * for calculating and displaying discount details.
 *
 * @author Ali Al-Marri
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;

import java.time.LocalDate;

public class FixedAmountDiscount extends Discount{
	
	private double amountQar;
	
	

	public FixedAmountDiscount(String code, String startDate, String endDate, double amountQar) {
		super(code, startDate, endDate);
		setAmountQar(amountQar);
	}

	public double getAmountQar() {
		return amountQar;
	}

	public void setAmountQar(double amountQar) {
		if (amountQar>0)
			{this.amountQar = amountQar;}
		else {System.out.println("Invalid Input: Discount must be a postive number!");}
	}

	@Override
	public double calculateDiscount(double subtotal) {
		return getAmountQar();
	}

	@Override
	public String getDetails() {	
		return String.format("Fixed(%s) QAR %.2f [%s to %s]", getCode(), amountQar,getStartDate(),getEndDate());
	}
	
	public String toString() {
		return String.format("%s  | Active: %s",getDetails(),isActive());
	}

}
