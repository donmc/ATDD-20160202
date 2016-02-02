package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FlightTest {

	private Flight flight_5ArgConstructor;
	
	private Flight flight_3ArgConstructor;
	
	@Before
	public void setUp() throws Exception {					
		flight_5ArgConstructor = new Flight("SAT", "DFW", 300, "SW", 32);
		assertNotNull(flight_5ArgConstructor);
		flight_3ArgConstructor = new Flight("SAT", "DFW", 300);
		assertNotNull(flight_3ArgConstructor);
	}

	@Test
	public void ShouldErrorOnNullOrigin()
	{
		try
		{
			new Flight(null,"",0);
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Origin code invalid check", "Invalid origin code", e.getMessage());
		}	
		
	}
	
	
	@Test 
	public void shouldErrorOnOriginIsNot3Chars()
	{
		try
		{
			new Flight("SA","",0);
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Origin code invalid check", "Invalid origin code", e.getMessage());
		}	
	}
	
	@Test
	public void shouldErrorOnDestinationIsNull()
	{	
		try
		{
			new Flight("SAT",null,0);
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Destination code invalid check", "Invalid destination code", e.getMessage());
		}		
	}
	
	@Test
	public void shouldErrorOnDestinationIsNot3Chars()
	{		
		try
		{
			new Flight("SAT","DF",0);
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Destination code invalid check", "Invalid destination code", e.getMessage());
		}		
	}
	
	@Test
	public void shouldErrorOnMileageIsLessThan100()
	{			
		try
		{
			new Flight("SAT","DFW", 99);
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Mileage invalid check", "Mileage muse be greater than 100", e.getMessage());
		}		
	}
	
	@Test
	public void shouldReturnUnknownFlightNumberOnAirlineNull()
	{
		Flight flight = new Flight("SAT", "DFW", 300, null, 32);
		assertNotNull(flight);
		assertTrue("Airline is null, flight number unknown", "UNKNOWN".equals(flight.getFullFlightNumber()));
	}
	
	@Test
	public void shouldReturnUnknownFlightNumberOnNumber0()
	{
		Flight flight = new Flight("SAT", "DFW", 300, "SW", 0);
		assertNotNull(flight);
		assertTrue("Number is 0, flight number unknown", "UNKNOWN".equals(flight.getFullFlightNumber()));
	}
	
	@Test
	public void testGetFlight_5ArgConstructor_NotNull() {	
		assertNotNull("Flight instance cannot be null", flight_5ArgConstructor);	
	}
	
	@Test
	public void testGetFlight_3ArgConstructor_NotNull() {	
		assertNotNull("Flight instance cannot be null", flight_5ArgConstructor);	
	}

	@Test
	public void testGetFullFlightNumber() {	
		assertTrue("Flight Airline code is not as expected", "SW32".equals(flight_5ArgConstructor.getFullFlightNumber()));
	}

	@Test
	public void testGetOrigin() {	
		assertNotNull("Flight origin cannot be null", flight_5ArgConstructor.getOrigin());
	}
		
	
	@Test
	public void testGetDestination() {	
		assertNotNull("Flight destination cannot be null", flight_5ArgConstructor.getDestination());
	}
	
		
	@Test
	public void testGetFullFlightNumber_NotNull() {	
		assertNotNull("Flight Airline code cannot be null", flight_5ArgConstructor.getFullFlightNumber());
	}
	
	@Test
	public void testGetFullFlightNumber_Unknown() {	
		assertTrue("Flight Airline code is not as expected", "UNKNOWN".equals(flight_3ArgConstructor.getFullFlightNumber()));
	}
	
	@Test
	public void testGetMileage_NotNull() {	
		assertNotNull("Flight mileage cannot be null", flight_5ArgConstructor.getMileage());
	}
		
	
	@Test 
	public void testGetFlightInformation() {
		assertEquals("SW32 | SAT -> DFW | 300 miles", flight_5ArgConstructor.getFlightInformation());
	}

}
