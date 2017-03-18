package com.credit.calculation;

import java.util.ArrayList;
import java.util.List;

public class RatePlanGenerator {
	
	public static List<Rate> generateRatePlan(double amount, int instalmentQuantity, 
			double interestRate, double constantCharge, InstalmentType instalmentType) {
		
		if (amount < 0 || instalmentQuantity <= 0 || constantCharge < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Negative values not accepted in arguments.");
		}
		
		if (instalmentType == null) {
			throw new IllegalArgumentException("Unitialized instalmentType passed to method.");
		}
		
		List<Rate> ratePlan = new ArrayList<>();
		
		double yearRate = (double) instalmentQuantity / 6;
		
		double remainingCapitalByMonth = amount / (instalmentQuantity + 1);
		double unevenCapitalPart = remainingCapitalByMonth;
		
		double overallInterest = amount * (interestRate / 100) * yearRate;
		double overallAmountToPayPerMonth = (amount + overallInterest) / (instalmentQuantity + 1);
		double unevenInterestPart = overallAmountToPayPerMonth;
		
		if (instalmentType.equals(InstalmentType.DECREASING)) {
			double remainingCapital = remainingCapitalByMonth;
			for (int i = 0; i < instalmentQuantity; i++) {
				if(i == 0) {
					ratePlan.add(Rate.newInstance(remainingCapital, 
						(overallAmountToPayPerMonth + unevenInterestPart), 
						constantCharge));
					
					remainingCapital += remainingCapitalByMonth + unevenCapitalPart;	
				} else {
					ratePlan.add(Rate.newInstance(remainingCapital, 
						overallAmountToPayPerMonth, 
						constantCharge));
					
					remainingCapital += remainingCapitalByMonth;
				}
			}
		} else if (instalmentType.equals(InstalmentType.INCREASING)) {
			double remainingCapital = 0;
			for (int i = 0; i < instalmentQuantity; i++) {
				if(i == instalmentQuantity - 1) {
					remainingCapital += remainingCapitalByMonth + unevenCapitalPart;	

					ratePlan.add(Rate.newInstance(remainingCapital, 
						(overallAmountToPayPerMonth + unevenInterestPart), 
						constantCharge));					
				} else {
					ratePlan.add(Rate.newInstance(remainingCapital, 
						overallAmountToPayPerMonth, 
						constantCharge));
					
					remainingCapital += remainingCapitalByMonth;
				}
			}
		}
			
		return ratePlan;
	}
}
