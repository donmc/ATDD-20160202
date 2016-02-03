package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegiters {

	private Member member;
	private TddAirApplication app;

	@Before
	public void setup() {
		String username = "don";
		String email = "don@improving.com";
		app = new TddAirApplication();
		
		app.registerMember(username, email);
		
		member = app.lookupMember(username);
	}
	
	@Test
	public void shouldCreateMemberWithUsername() {
		assertNotNull(member);
	}
	
	@Test
	public void shouldCorrectUsername() {
		assertEquals("don", member.getUserName());
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(0,member.getYtdMiles());
	}
	
	@Test
	public void shouldHave10000BalanceMiles() {
		assertEquals(10000, member.getBalanceMiles());
	}
	
	@Test(expected=DuplicateUsernameException.class)
	public void shouldHaveDuplicateUsernameCheck() {
		app.registerMember("don", "don@improving.com");
	}
}
