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
	
	@Ignore
	@Test
	public void shouldHaveRedStatus() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YtdMiles() {
		fail("Not yet implemented");
	}
	
	
	@Ignore
	@Test
	public void shouldHave10000BalanceMiles() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotHaveDuplicateUsername() {
		fail("Not yet implemented");
	}
	
	
}
