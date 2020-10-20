package com.InvoiceService.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceGenerator {

	private int time;
	private double distance;
	private int costPerMinuteNormalRide = 1;
	private int costPerKmNormalRide = 10;
	private int costPerMinutePremiumRide = 2;
	private int costPerKmPremiumRide = 20;

	private List<Rides> rideList = null;
	private List<Integer> userIdList = new ArrayList<>();

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
		double totalFare = (time * costPerMinuteNormalRide + distance * costPerKmNormalRide);
		return (totalFare > 5) ? totalFare : 5;
	}

	public double returnsAggregateTotalFare(List<Rides> myRideList) {
		// TODO Auto-generated method stub
		double totalSumOfFare = 0;
		for (Rides rides : myRideList) {
			if (rides.getType().equals("Normal Ride"))
				totalSumOfFare += (rides.getDistance()) * costPerKmNormalRide
						+ (rides.getTime()) * costPerMinuteNormalRide;
			else
				totalSumOfFare += (rides.getDistance()) * costPerKmPremiumRide
						+ (rides.getTime()) * costPerMinutePremiumRide;
		}
		return totalSumOfFare;
	}

	public List<Rides> addDetailsOfRides() throws IllegalStateException {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the count of rides : ");
			int numberOfRides = sc.nextInt();
			int dummyNumberOfRides = numberOfRides;
			rideList = new ArrayList();
			String typeOfRideString = "";
			while (dummyNumberOfRides-- > 0) {
				while (true) {
					System.out.println("Which type of ride is this ? \n1. Normal Ride \n2. Premium Ride");
					System.out.println("Enter 1 or 2");
					int typeOfRide = sc.nextInt();
					if (typeOfRide == 1) {
						typeOfRideString = "Normal Ride";
						break;
					} else if (typeOfRide == 2) {
						typeOfRideString = "Premium Ride";
						break;
					} else {
						System.out.println("Enter a valid type!");
						continue;
					}
				}

				System.out.println("Enter time and distance for ride number " + (numberOfRides - dummyNumberOfRides));
				double time = sc.nextDouble();
				double distance = sc.nextDouble();
				Rides ride = new Rides(time, distance, typeOfRideString);
				rideList.add(ride);
			}
			return rideList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ooops! It's an exception");
			System.exit(0);
		}
		return null;
	}

	public double returnsAverageFare(double totalFare, int totalNumberOfRides) {
		// TODO Auto-generated method stub
		return (totalFare / totalNumberOfRides);
	}

	public int returnsRideListSize() {
		// TODO Auto-generated method stub
		return rideList.size();
	}

	public Integer takeUserIdInput() {
		// TODO Auto-generated method stub
		Integer userId;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter the user Id : ");
			userId = sc.nextInt();
			if (!(userIdList.contains(userId))) {
				userIdList.add(userId);
				return userId;
			} else {
				System.out.println("The user Id is already occupied. Please enter a valid/ new user Id : ");
				continue;
			}
		}
	}
}
