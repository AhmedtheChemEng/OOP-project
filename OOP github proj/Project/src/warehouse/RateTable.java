/**
 * Represents the shipping rate table used in the warehouse system.
 * Calculates shipping fees based on the total shipment weight.
 * The rate table defines weight thresholds and corresponding QAR fees.
 *
 * @author Ali Al-Marri
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;
import java.io.*;
public class RateTable implements Serializable{

	
	
	double[] maxWeights = {2,5,10};
	double[] feesQar = {10,20,35,50};


	public double shippingFeeFor(double totalWeightKg) {
		
		for (int i=0;i<(maxWeights.length);i++) {
			if (totalWeightKg<maxWeights[i]) {
				return feesQar[i];
			}
		}
		return feesQar[feesQar.length-1];
	}
	
	
}
