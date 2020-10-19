package com.InvoiceService.assignment;

import java.util.List;

public class Invoices {

	private double totalFare;
	private int totalNumberOfRides;
	private double averageFarePerRide;

	public Invoices() {

	}

	public Invoices(double totalFare, int totalNumberOfRides, double averageFarePerRide) {
		// TODO Auto-generated constructor stub
		this.totalFare = totalFare;
		this.totalNumberOfRides = totalNumberOfRides;
		this.averageFarePerRide = averageFarePerRide;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public int getTotalNumberOfRides() {
		return totalNumberOfRides;
	}

	public void setTotalNumberOfRides(int totalNumberOfRides) {
		this.totalNumberOfRides = totalNumberOfRides;
	}

	public double getAverageFarePerRide() {
		return averageFarePerRide;
	}

	public void setAverageFarePerRide(double averageFarePerRide) {
		this.averageFarePerRide = averageFarePerRide;
	}

	@Override
	public String toString() {
		return "Invoice -> [totalFare=" + totalFare + ", totalNumberOfRides=" + totalNumberOfRides
				+ ", averageFarePerRide=" + averageFarePerRide + "]";
	}

}
