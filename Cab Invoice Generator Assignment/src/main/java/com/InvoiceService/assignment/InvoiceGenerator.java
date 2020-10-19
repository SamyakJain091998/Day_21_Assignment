package com.InvoiceService.assignment;

public class InvoiceGenerator {

	private int time;
	private double distance;
	private int costPerMinute = 1;
	private int costPerKm = 10;
	
	
	public InvoiceGenerator() {

	}

	public double returnsTotalFare(int time, double distance, double d) {
		// TODO Auto-generated method stub
		this.time = time;
		this.distance = distance;
		return fareCalculator();
	}

	private double fareCalculator() {
		// TODO Auto-generated method stub
		double totalFare = (time * costPerMinute + distance * costPerKm);
		return (totalFare > 5) ? totalFare : 5;
	}

}
