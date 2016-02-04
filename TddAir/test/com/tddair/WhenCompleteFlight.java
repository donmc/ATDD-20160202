package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tddair.exception.MemberException;

public class WhenCompleteFlight {

	private TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() throws MemberException{
		app = new TddAirApplication();
		app.registerMember("bill", "bill@bill.com");
		member = app.lookUpMember("bill");
		app.addFlight("DFW", "DFW", 25000, "test", 25000);
		app.addFlight("DFW", "SYD", 12000, "test", 12000);
	}
	
	@Test
	public void shouldAddMiles() throws Exception {
		app.completeMemberFlight("bill", "test12000");
		assertEquals(12000, member.getYtdMiles());
		assertEquals(22000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}

	@Test
	public void shouldHaveGreenStatus() throws Exception {
		app.completeMemberFlight("bill", "test25000");
		assertEquals(Status.Green, member.getStatus());
	}
	
	@Test
	public void shouldHaveBlueStatus() throws Exception {
		app.completeMemberFlight("bill", "test25000");
		app.completeMemberFlight("bill", "test25000");
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldHaveGoldenStatus() throws Exception {
		app.completeMemberFlight("bill", "test25000");
		app.completeMemberFlight("bill", "test25000");
		app.completeMemberFlight("bill", "test25000");
		assertEquals(Status.Golden, member.getStatus());
	}
}
