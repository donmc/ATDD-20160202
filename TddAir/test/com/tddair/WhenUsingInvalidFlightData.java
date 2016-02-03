package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenUsingInvalidFlightData {

	//one way to write this
	@Test
	public void shouldErrorWithNoOrigin() {
		// setup
		try {
			new Flight(null, "DFW", 300);
			fail("Should throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid origin code", e.getMessage());
		}

	}
	//another way to write the same thing
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithNoDestination() {
			new Flight("SAT", null, 300);
	}

	@Ignore	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithInvalidOrigin() {
			new Flight("SAT", null, 300);
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithInvalidDestination() {
			new Flight("SAT", null, 300);
	}
}
