package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegisters {

	private Member member;
	private TddAirApplication app;
	
	@Before
	public void setup() {
		String username = "don";
		String email = "don@improving.com";
		
		app = new TddAirApplication();
		app.registerMember(username, email);
	}
	
	@Test
	public void shouldCreateMemberWithUsername() {
		member = app.lookUpMember("don");
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUsername() {
		member = app.lookUpMember("don");
		assertEquals("don", member.getUsername());
	}
	
	@Test
	public void shouldHaveCorrectUsernameForAdditionalMember() {
		app.registerMember("mik", "mikmik@somewhere.com");
		member = app.lookUpMember("mik");
		assertEquals("mik", member.getUsername());
	}

	@Ignore
	@Test
	public void shouldHaveRedStatus() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void shouldHave0YTDMiles() {
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
