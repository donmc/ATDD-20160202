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
		app = new TddAirApplication(new FakeFlightDao());
		
		app.registerMember(username, email);
		
		member = app.lookUpMember(username);
	}
	
	@Test
	public void shouldCreateMemberWithUsername() {
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUsername() {
		assertEquals("don", member.getUsername());
	}
	
	@Test
	public void shouldCreateTwoMembers() {
		app.registerMember("bob", "bob@improving.com");
		Member secondMember = app.lookUpMember("bob");
		assertEquals("bob", secondMember.getUsername());
		
	}
	
	@Test
	public void shouldHaveCorrectEmail() {
		assertEquals("don@improving.com", member.getEmail());
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	
	@Test
	public void shouldHave10000BalanceMiles() {
		assertEquals(10000, member.getBalanceMiles());
	}
	
	@Test(expected=DuplicateUsernameException.class)
	public void shouldNotHaveDuplicateUsername() {
		app.registerMember("don", "don@gmail.com");
	}
	
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoAt() {
		app.registerMember("bob", "gmail.com");
	}
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoDot() {
		app.registerMember("bob", "bob@gmail");
	}
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoPrefix() {
		app.registerMember("bob", "@gmail.com");
	}
}
