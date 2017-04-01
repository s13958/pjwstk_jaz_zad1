package com.credit.calculation;

import java.util.ArrayList;
import java.util.List;

public class RatePlanGenerator {

	private static double YEAR_RATE = 0.08333333333;

	public static List<Rate> generateRatePlan(double amount, int instalmentQuantity, double interestRate,
			double constantCharge, InstalmentType instalmentType) {

		if (amount < 0 || instalmentQuantity <= 0 || constantCharge < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Negative values not accepted in arguments.");
		}

		if (instalmentType == null) {
			throw new IllegalArgumentException("Unitialized instalmentType passed to method.");
		}

		List<Rate> ratePlan = new ArrayList<>();

		double capitalByMonth = amount / instalmentQuantity;

		if (instalmentType.equals(InstalmentType.DECREASING)) {
			double capitalRemained = amount;
			for (int i = 0; i < instalmentQuantity; i++) {
				if (capitalRemained > 0) {
					double rateByMonth = capitalRemained * YEAR_RATE * (interestRate / 100);
					ratePlan.add(Rate.newInstance(capitalByMonth, rateByMonth, constantCharge));
					capitalRemained -= capitalByMonth;
				} else {
					ratePlan.add(Rate.newInstance(capitalByMonth, 0, constantCharge));
				}
			}
		} else if (instalmentType.equals(InstalmentType.CONSTANT)) {
			double rateByMonth = (amount * YEAR_RATE * ((100 + interestRate) / 100)) / instalmentQuantity;
			for (int i = 0; i < instalmentQuantity; i++) {
				ratePlan.add(Rate.newInstance(capitalByMonth, rateByMonth, constantCharge));
			}
		}

		return ratePlan;
	}
}
