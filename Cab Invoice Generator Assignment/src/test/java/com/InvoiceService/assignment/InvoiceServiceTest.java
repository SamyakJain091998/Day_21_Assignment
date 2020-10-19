package com.InvoiceService.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class InvoiceServiceTest {

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

	@Test
	public void givenMultipleDistanceAndTime_ShouldReturn_TotalNumberOfRides_TotalFare_AverageFarePerRide()
			throws IllegalStateException {
		try {
			List<Rides> rideList = invoiceGenerator.addDetailsOfRides();

			double totalFare = invoiceGenerator.returnsAggregateTotalFare(rideList);
			Assert.assertEquals(105, totalFare, 0.0);

			int totalNumberOfRides = invoiceGenerator.returnsRideListSize();
			Assert.assertEquals(3, totalNumberOfRides);

			double AverageFarePerRide = invoiceGenerator.returnsAverageFare(totalFare, totalNumberOfRides);
			Assert.assertEquals(52.50, AverageFarePerRide, 0.0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
