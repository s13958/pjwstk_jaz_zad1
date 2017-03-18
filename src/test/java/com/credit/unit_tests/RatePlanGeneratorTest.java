	package com.credit.unit_tests;

import org.junit.Test;

import com.credit.calculation.InstalmentType;
import com.credit.calculation.RatePlanGenerator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

public class RatePlanGeneratorTest {
	
	@Test
	public void generateRatePlanShouldReturnResultForValidArguments() {
		// given
		double amount= 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		
		// when
		
		// then
		assertThat(RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
				interestRate, constantCharge, instalmentType)).isInstanceOf(ArrayList.class);
	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForZeroAmount() {
		// given
		double amount = 0;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForNegativeAmount() {
		// given
		double amount = -500;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForZeroInstalmentQuantity() {
		// given
		double amount = 10000;
		int instalmentQuantity = 0; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForNegativeInstalmentQuantity() {
		// given
		double amount = 10000;
		int instalmentQuantity = -15; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

	}
	
	@Test
	public void generateRatePlanShouldReturnRatePlanForZeroInterestRate() {
		// given
		double amount = 10000;
		int instalmentQuantity = 12; 
		double interestRate = 0; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		
		// then
		assertThat(RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
			interestRate, constantCharge, instalmentType)).isInstanceOf(ArrayList.class);
	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForNegativeInterestRate() {
		// given
		double amount = 10000;
		int instalmentQuantity = 12; 
		double interestRate = -10; 
		double constantCharge = 100; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
				
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void generateRatePlanShouldReturnResultForZeroConstantCharge() {
		// given
		double amount = 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 0; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		
		// then
		assertThat(RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
				interestRate, constantCharge, instalmentType)).isInstanceOf(ArrayList.class);
	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForNegativeConstantCharge() {
		// given
		double amount = 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = -500; 
		InstalmentType instalmentType = InstalmentType.INCREASING;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
				interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
					thrown = e;
		}
				
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void generateRatePlanShouldThrowExceptionForNullInstalmentQuantity() {
		// given
		double amount = 10000;
		int instalmentQuantity = 12; 
		double interestRate = 12; 
		double constantCharge = 100; 
		InstalmentType instalmentType = null;
		Exception thrown = null;
		
		// when
		try {
			RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, 
					interestRate, constantCharge, instalmentType);
		} catch (Exception e) {
			thrown = e;
		}
		
		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

	}
	

}
