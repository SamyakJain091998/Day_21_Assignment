package com.InvoiceService.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public double returnsAggregateTotalFare(List<Rides> myRideList) {
		// TODO Auto-generated method stub
		double totalSumOfFare = 0;
		for (Rides rides : myRideList) {
			totalSumOfFare += (rides.getDistance()) * costPerKm + (rides.getTime()) * costPerMinute;
		}
		return totalSumOfFare;
	}

	public List<Rides> addDetailsOfRides() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the count of rides : ");
		int numberOfRides = sc.nextInt();
		int dummyNumberOfRides = numberOfRides;
		List<Rides> rideList = new ArrayList();
		while (dummyNumberOfRides-- > 0) {
			System.out.println("Enter time and distance for ride number " + (numberOfRides - dummyNumberOfRides));
			double time = sc.nextDouble();
			double distance = sc.nextDouble();
			Rides ride = new Rides(time, distance);
			rideList.add(ride);
		}
		return rideList;
	}
}
