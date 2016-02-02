package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testGetFullFlightNumber() {
		// setup
		Flight flight = new Flight("SAT","DFW",300,"SW",32);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		//verify
		assertEquals("SW32", fullFlightNumber);
	}
	@Test
	public void testGetFullFlightNumber_Unknown() {
		// setup
		Flight flight = new Flight("SAT","DFW",300);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	@Test
	public void testGetFullFlightNumber_UnknownNumber() {
		// setup
		Flight flight = new Flight("SAT","DFW",300,"",0);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}	
	@Test
	public void testGetFlightInformation() {
		// setup
		Flight flight = new Flight("SAT","DFW",300,"SW",32);
				
		//exercise
		String flightInfo = flight.getInformation();
				
		//verify
		assertEquals("SW32 | SAT -> DFW | 300 miles", flightInfo);
	}

}
