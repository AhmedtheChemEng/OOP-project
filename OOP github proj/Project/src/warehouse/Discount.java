package warehouse;

import java.util.*;
import java.time.*;
import java.io.*;

abstract class Discount implements Serializable{

	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active;
	
	public Discount(String code, String startDate, String endDate) {
		this.code = code;
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		
		
	}
	
	public String getCode() {
		return code;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean a) {

		this.active = a;
	}
	public abstract double calculateDiscount(double subtotal);
	
	public abstract String getDetails();
	
	public static boolean overlaps(Discount a,Discount b) {
		
		if (a.getStartDate().isBefore( b.getStartDate() ) && a.getEndDate().isAfter( b.getStartDate() ) ||
			a.getStartDate().isBefore( b.getEndDate() ) && a.getEndDate().isAfter( b.getEndDate() ) ||
			b.getStartDate().isBefore( a.getStartDate() ) && b.getEndDate().isAfter( a.getStartDate() ) ||
			b.getStartDate().isBefore( a.getEndDate() ) && b.getEndDate().isAfter( a.getEndDate() ) ||
			a.getStartDate().isEqual( b.getStartDate() ) || a.getEndDate().isEqual( b.getEndDate() )
			) { return true;}
		
		return false;
		
	}
	
}
