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
		return String.format("Fixed(%s) QAR %.2f [%s to %s] | Active: %s", getCode(), amountQar,getStartDate(),getEndDate(),isActive());
	}
	
	public String toString() {
		return getDetails();
	}

}
