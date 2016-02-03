package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tddair.exception.MemberException;

public class WhenCustomerRegisters {

	private Member member;
	private TddAirApplication app;
	private String username = "bill";
	private String email = "bill@bill.com";
	
	@Before
	public void setup(){
		//setup
		app = new TddAirApplication();
		try {
			app.registerMember(username, email);
		} catch (MemberException e) {
			fail(e.getMessage());
		}
		member = app.lookUpMember(username);
	}
	
	
	@Test
	public void shouldLookupWithUsername() {
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUsername() {
		assertEquals("bill", member.getUsername());
	}
	
	@Test
	public void shouldHaveCorrectEmail() {
		assertEquals("bill@bill.com", member.getEmail());
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
	
	@Test
	public void shouldNotHaveDuplicateUsername() {
		try {
			app.registerMember(username, "bill@name.com");
			fail("Did not fail with duplicate username");
		} catch (MemberException e) {
			assertEquals("username already exists", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void shouldNotHaveDuplicateEmail() {
		try {
			app.registerMember("justine", email);
			fail("Did not fail with duplicate email");
		} catch (MemberException e) {
			assertEquals("email already exists", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void shouldHaveValidEmail() {
		
	}
}
