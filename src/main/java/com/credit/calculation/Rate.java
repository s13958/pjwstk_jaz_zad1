package com.credit.calculation;

public class Rate {
	private double remainingCapital;
	private double amount;
	private double constantCharge;
	
	private Rate(double remainingCapital, double amount, double constantCharge) {
		this.remainingCapital = remainingCapital;
		this.amount = amount;
		this.constantCharge = constantCharge;
	}
	
	public static Rate newInstance(double remainingCapital, double amount, double constantCharge) {
		if (remainingCapital < 0 || amount <= 0 || constantCharge < 0) {
			throw new IllegalArgumentException("Rate specified with invalid values: remainingCapital=" + remainingCapital
					+ ",amount=" + amount + ",constantCharge=" + constantCharge);
		}
		return new Rate(remainingCapital, amount, constantCharge);
	}
	
	public double getRemainingCapital() {
		return remainingCapital;
	}
		
	public double getAmount() {
		return amount;
	}
		
	public double getConstantAmount() {
		return constantCharge;
	}
		
	public double getTotal() {
		return amount + constantCharge;
	}
}
