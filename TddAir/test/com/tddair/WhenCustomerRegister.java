package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class WhenCustomerRegister {
	
	private Member member;
	private TddAirApplication app;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before	
	public void setup() throws DuplicateUsernameException, InvalidEmailException {
		String username = "don";
		String email = "don@improving.com";
		app = new TddAirApplication();
		app.registerMember(username, email);		
		member = app.lookupMember(username);
	}
	
	@Test
	public void shouldCreateMemebrWithusername() {
		assertEquals("Member username does not match", member.getUsername(), "don");
	}
	
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals("Member should have Red Status", member.getStatus(), Status.Red);
	}
	
	@Test
	public void shouldHave0YTDMiles() {
		assertEquals("Member should have 0 YTD miles", member.getYtdMiles(), 0);
	}
		
	@Test
	public void shouldHave10000BalanceMiles() {
		assertEquals("Member should have 10000 balance miles", member.getBalanceMiles(), 10000);
	}
	
	@Test
	public void shouldNotCreateMemberWithDuplicateUsername() throws DuplicateUsernameException, InvalidEmailException {
		expectedException.expect(DuplicateUsernameException.class);
		app.registerMember("don", "any_email");
	}

}
