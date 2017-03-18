package com.credit.integration_test;

import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Test;

import com.credit.calculation.InstalmentType;
import com.credit.calculation.Rate;
import com.credit.calculation.RatePlanGenerator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class RateGeneratingTest {
	
	@Test
	public void rateGeneratorShouldGenerateRatePlanWithAmountOfRatesEqualsToInstalmentQuantity() {
		// given
		double amount= 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.CONSTANT;
		
		// when
		List<Rate> ratePlan = RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
				interestRate, constantCharge, instalmentType);
		
		// then
		assertThat(ratePlan.size()).isEqualTo(instalmentQuantity);
	}

	@Test
	public void rateGeneratorShouldGenerateRatePlanWithConstantChargeSpecifiedInEveryRate() {
		// given
		double amount= 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.CONSTANT;
		
		// when
		List<Rate> ratePlan = RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
				interestRate, constantCharge, instalmentType);
		
		// then
		for (Rate rate : ratePlan) {
			if (rate.getConstantCharge() != constantCharge)
				Assert.fail();
		}
	}
	
	@Test
	public void rateGeneratorShouldNotExceedTotalAmountInGeneratedRatePlan() {
		// given
		double amount = 10000;
		int instalmentQuantity = 18; 
		double interestRate = 5; 
		double constantCharge = 1000; 
		InstalmentType instalmentType = InstalmentType.CONSTANT;
				
		// when
		List<Rate> ratePlan = RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
			interestRate, constantCharge, instalmentType);
		double result = ratePlan.get(ratePlan.size()-1).getCapital();
		
		// then
		assertThat(Double.valueOf(result)).isCloseTo(Double.valueOf(amount),  Offset.offset(0.1));
	}
}
