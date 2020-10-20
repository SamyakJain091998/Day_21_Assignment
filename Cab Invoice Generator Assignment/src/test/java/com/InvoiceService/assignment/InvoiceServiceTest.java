package com.InvoiceService.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class InvoiceServiceTest {

	HashMap<Integer, Invoices> invoiceMap = null;
	InvoiceGenerator invoiceGenerator = null;
	Scanner sc;

	@Ignore
	@Test
	public void basicTest() {
		Assert.assertTrue(true);
	}

	@Before
	public void invoiceGeneratorInitializer() {
		invoiceGenerator = new InvoiceGenerator();
		sc = new Scanner(System.in);
	}

	@Ignore
	@Test
	public void givenDistanceAndTime_ShouldReturn_TotalFareOfTheJourney() {
		try {
			double totalFare = invoiceGenerator.returnsTotalFare(1, 10, 0.0);
			Assert.assertEquals(101, totalFare, 0.0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void givenLessDistanceAndTime_ShouldReturn_TotalFareOfTheJourney() {
		try {
			double totalFare = invoiceGenerator.returnsTotalFare(1, 0.3, 0.0);
			Assert.assertEquals(5, totalFare, 0.0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void givenMultipleDistanceAndTime_ShouldReturn_TotalAggregateFareOfTheJourney() {
		try {
			List<Rides> rideList = invoiceGenerator.addDetailsOfRides();
			double totalFare = invoiceGenerator.returnsAggregateTotalFare(rideList);
			Assert.assertEquals(105, totalFare, 0.0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void givenMultipleDistanceAndTime_ShouldReturn_TotalNumberOfRides_TotalFare_AverageFarePerRide()
			throws IllegalStateException {
		try {
			List<Rides> rideList = invoiceGenerator.addDetailsOfRides();

			double totalFare = invoiceGenerator.returnsAggregateTotalFare(rideList);
			Assert.assertEquals(105, totalFare, 0.0);

			int totalNumberOfRides = invoiceGenerator.returnsRideListSize();
			Assert.assertEquals(2, totalNumberOfRides);

			double AverageFarePerRide = invoiceGenerator.returnsAverageFare(totalFare, totalNumberOfRides);
			Assert.assertEquals(52.50, AverageFarePerRide, 0.0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void givenUserId_ReturnsTheInvoice() throws IllegalStateException {
		try {
			Invoices invoice = null;
			invoiceMap = new HashMap<Integer, Invoices>();

			System.out.print("Enter the number of users : ");
			int numberOfUsers = sc.nextInt();

			while (numberOfUsers-- > 0) {
				Integer userId;
				userId = invoiceGenerator.takeUserIdInput();

				List<Rides> rideList = invoiceGenerator.addDetailsOfRides();
				System.out.println("Thank you! Details added successfully for the user.......");

				double totalFare = invoiceGenerator.returnsAggregateTotalFare(rideList);
				int totalNumberOfRides = invoiceGenerator.returnsRideListSize();
				double AverageFarePerRide = invoiceGenerator.returnsAverageFare(totalFare, totalNumberOfRides);
				invoice = new Invoices(totalFare, totalNumberOfRides, AverageFarePerRide);
				invoiceMap.put(userId, invoice);
			}

//			Search according to the user Id...

			System.out.print("Enter the user Id of the user you want to search details of : ");
			Integer searchForUserId = sc.nextInt();

//			In case the if statement gets executed, The test is passed.
			if (invoiceMap.containsKey(searchForUserId)) {
				System.out.println("Invoice details for this user are : ");
				System.out.println(invoiceMap.get(searchForUserId));
				Assert.assertTrue(true);
			}
//			In case the else statement gets executed, The test is failed..
			else {
				Assert.assertTrue(false);
				System.out.println("Oops! There's no such user present.");
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Oops! It's an exception.");
			System.exit(0);
		}
	}

}
