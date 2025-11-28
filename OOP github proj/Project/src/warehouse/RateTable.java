package warehouse;

public class RateTable {
	
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
