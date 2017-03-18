package com.credit.unit_tests;

import org.junit.Test;

import com.credit.calculation.Rate;

import static org.assertj.core.api.Assertions.*;

public class RateTest {
	
	@Test
	public void newInstanceShouldReturnNewRateForValidArguments() {
		// given
		double remainingCapital = 10000;
		double amount = 125;
		double constantCharge = 50;
		
		// when
		Rate rate = Rate.newInstance(remainingCapital, amount, constantCharge);
		
		// then
		assertThat(rate).isInstanceOf(Rate.class);
		assertThat(rate.getRemainingCapital()).isEqualTo(remainingCapital);
		assertThat(rate.getAmount()).isEqualTo(amount);
		assertThat(rate.getConstantAmount()).isEqualTo(constantCharge);
	}
	
	@Test
	public void newInstanceShouldThrowExceptionForNegativeRemainingCapital() {
		// given
		double remainingCapital = -10000;
		double amount = 125;
		double constantCharge = 50;
		Exception thrown = null;
		
		// when
		try {
			Rate.newInstance(remainingCapital, amount, constantCharge);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void newInstanceShouldThrowExceptionForNegativeAmount() {
		// given
		double remainingCapital = 10000;
		double amount = -125;
		double constantCharge = 50;
		Exception thrown = null;
		
		// when
		try {
			Rate.newInstance(remainingCapital, amount, constantCharge);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void newInstanceShouldThrowExceptionForNegativeConstantCharge() {
		// given
		double remainingCapital = 10000;
		double amount = 125;
		double constantCharge = -50;
		Exception thrown = null;
		
		// when
		try {
			Rate.newInstance(remainingCapital, amount, constantCharge);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void getTotalShouldReturnSumOfAmountAndConstantCharge() {
		// given
		double remainingCapital = 10000;
		double amount = 125;
		double constantCharge = 50;
		double expectedValue = amount + constantCharge;

		// when
		Rate sut = Rate.newInstance(remainingCapital, amount, constantCharge);

		// then
		assertThat(sut.getTotal()).isEqualTo(expectedValue);
	}
}
