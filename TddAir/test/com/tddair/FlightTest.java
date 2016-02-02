package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testGetFullFlightNumber_UnknownNumber() {
		// setup
		String airline = "SW";
		int number = 0;
		Flight flight = new Flight("SAT", "DFW", 300, airline, number);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}

	@Test
	public void testGetFullFlightNumber_Unknown() {
		// setup
		String airline = null;
		int number = 0;
		Flight flight = new Flight("SAT", "DFW", 300, airline, number);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}

	@Test
	public void testGetFullFlightNumber() {
		// setup
		String airline = "SW";
		int number = 32;
		Flight flight = new Flight("SAT", "DFW", 300, airline, number);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals("SW32", fullFlightNumber);
	}

	@Test
	public void testGetFlightInformation() {
		// setup
		String airline = "SW";
		int number = 32;
		Flight flight = new Flight("SAT", "DFW", 300, airline, number);

		// exercise
		String flightInfo = flight.getInformation();

		// verify
		assertEquals("SW32 | SAT -> DFW | 300 miles", flightInfo);
	}
	
	@Test
	public void testGetFlightInformation_2ndFlight() {
		// setup
		String airline = "AA";
		int number = 12;
		Flight flight = new Flight("ORD", "LHR", 2000, airline, number);

		// exercise
		String flightInfo = flight.getInformation();

		// verify
		assertEquals("AA12 | ORD -> LHR | 2000 miles", flightInfo);
	}

}
