package com.InvoiceService.assignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceGenerator invoiceGenerator = null;

	@Ignore
	@Test
	public void basicTest() {
		Assert.assertTrue(true);
	}

	@Before
	public void invoiceGeneratorInitializer() {
		invoiceGenerator = new InvoiceGenerator();
	}

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
}
