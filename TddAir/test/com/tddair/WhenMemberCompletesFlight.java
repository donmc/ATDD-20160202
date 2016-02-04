package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberCompletesFlight {

	private TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() {
		app = new TddAirApplication(new FakeFlightDao());
		app.registerMember("bob", "bob@improving.com");
		member = app.lookUpMember("bob");
		app.addFlight("DFW", "DFW", 25000, "TEST", 25000);
		app.addFlight("DFW", "SYD", 12000, "TEST", 12000);
	}
	
	@Test
	public void shouldAccumulateMiles() {
		app.completeFlight("bob", "TEST12000");
		assertEquals(12000, member.getYtdMiles());
		assertEquals(22000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldEarnGreenStatus() {
		app.completeFlight("bob", "TEST25000");
		assertEquals(Status.Green, member.getStatus());
	}

	@Test
	public void shouldEarnBlueStatus() {
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldEarnGoldStatus() {
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		assertEquals(Status.Gold, member.getStatus());
	}
}
