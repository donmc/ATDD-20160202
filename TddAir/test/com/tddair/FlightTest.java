package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testGetFullFlightNumber() {
		//setup
		String airline = "SW";
		int milage = 32;
		Flight flight = new Flight("SAT", "DFW", 300, airline, milage);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
				
		//verify
		assertEquals("SW32", fullFlightNumber);
	}

	@Test
	public void testGetFullFlightNumber_Unknown() {
		//setup
		String airline = null;
		int milage = 0;
		Flight flight = new Flight("SAT", "DFW", 300, airline, milage);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
				
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_UnknownNumber() {
		//setup
		String airline = "SW";
		int milage = 0;
		Flight flight = new Flight("SAT", "DFW", 300, airline, milage);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
				
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	
//Test Driven Development -- creating the test first
	
	@Test
	public void testGetFlightInformation() {
		//setup
		String airline = "SW";
		int mileage = 300;
		int flightNumber = 32;
		Flight flight = new Flight("SAT", "DFW", mileage, airline, flightNumber);
		
		//exercise
		String flightInfo = flight.getInformation();
				
		//verify
		assertEquals("SW32 | SAT -> DFW | 300 miles", flightInfo);
	}
}
