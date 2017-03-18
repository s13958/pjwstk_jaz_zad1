package com.credit.calculation;

public class Rate {
	private double capital;
	private double amount;
	private double constantCharge;
	
	private Rate(double remainingCapital, double amount, double constantCharge) {
		this.capital = remainingCapital;
		this.amount = amount;
		this.constantCharge = constantCharge;
	}
	
	public static Rate newInstance(double remainingCapital, double amount, double constantCharge) {
		if (remainingCapital < 0 || amount < 0 || constantCharge < 0) {
			throw new IllegalArgumentException("Rate specified with invalid values: remainingCapital=" + remainingCapital
					+ ",amount=" + amount + ",constantCharge=" + constantCharge);
		}
		return new Rate(remainingCapital, amount, constantCharge);
	}
	
	public double getCapital() {
		return capital;
	}
		
	public double getAmount() {
		return amount;
	}
		
	public double getConstantCharge() {
		return constantCharge;
	}
		
	public double getTotal() {
		return amount + capital + constantCharge;
	}
}
