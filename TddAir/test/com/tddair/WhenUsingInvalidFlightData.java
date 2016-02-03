package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenUsingInvalidFlightData
{

	@Test
	public void shouldErrorWithNoOrigin()
	{
		try
		{
			new Flight(null, "DFW", 300);
			fail("Should throw an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Invalid origin code", e.getMessage());
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithNoDestination()
	{
		new Flight("SAT", null, 300);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithInvalidOrigin()
	{
		new Flight("SANANTONIO", "DFW", 299);
	}

	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithInvalidDestination()
	{
		new Flight("SAT", null, 300);
	}
}
