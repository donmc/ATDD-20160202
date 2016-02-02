package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest
{

	@Test
	public void testGetFullFlightNumber()
	{
		// Setup
		Flight flight = new Flight("SAT", "DFW", 300, "SW", 32);
		
		// Exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// Verify		
		assertEquals("SW32", fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumberUnknown()
	{
		// Setup
		Flight flight = new Flight("SAT", "DFW", 300, null, 0);
		
		// Exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// Verify		
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumberUnknownNumber()
	{
		// Setup
		Flight flight = new Flight("SAT", "DFW", 300, "SW", 0);
		
		// Exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// Verify		
		assertEquals("UNKNOWN", fullFlightNumber);
	}

	@Test
	public void testGetFlightInformation()
	{
		// Setup
		Flight flight = new Flight("SAT", "DFW", 300, "SW", 32);
		
		// Exercise
		String flightInfo = flight.getInformation();
		
		// Verify		
		assertEquals("SW32 | SAT -> DFW | 300 miles", flightInfo);
	}
}
