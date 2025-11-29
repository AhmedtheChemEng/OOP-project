package warehouse;

public class RateTable {
	
	double[] maxWeights = {2,5,10};
	double[] feesQar = {10,20,35,50};

	
	/**
	 * Returns shipping fees from the total weight.
	 *
	 * <p>Returns one of the fee prices based on the totalWeight of the shipment.</p>
	 *
	 * @param totalWeightKg Total weight of shipment, to calculate fees, in double.
	 * @return Shipping fees in double.
	 */
	public double shippingFeeFor(double totalWeightKg) {
		
		for (int i=0;i<(maxWeights.length);i++) {
			if (totalWeightKg<maxWeights[i]) {
				return feesQar[i];
			}
		}
		return feesQar[feesQar.length-1];
	}
	
	
}
