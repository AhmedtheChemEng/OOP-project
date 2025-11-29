package warehouse;

import java.util.*;

public class PercentageDiscount extends Discount{

	private double percent;
	

	public PercentageDiscount(String code, String startDate, String endDate, double percent) {
		super(code, startDate, endDate);
		setPercent(percent);
	}


	public double getPercent() {
		return percent;
	}


	public void setPercent(double percent) {
		if (0<percent && percent<=100)
			this.percent = percent;
		else {
			throw new InputMismatchException("Percentage Must be from 0 to 100.");
		}
	}


	@Override
	public double calculateDiscount(double subtotal) {
		return subtotal*(percent/100);
	}


	@Override
	public String getDetails() {
		return String.format("Percent(%s) %.2f%% [%s to %s] | Active: %s", getCode(), percent, getStartDate(), getEndDate(), isActive());
	}
	
	public String toString() {
		return getDetails();
	}
	
	
	
	
}
