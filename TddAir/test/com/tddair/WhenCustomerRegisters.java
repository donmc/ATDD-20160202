package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegisters {

	private Member member;

	@Before
	public void setup() {
		String username = "sdm";
		String email = "sdm@sdm.com";
		TddAirApplication app = new TddAirApplication();
		
		//execute
		app.registerMember(username, email);
		
		//verify
		member = app.lookUpMember(username);
	}
	
	@Test
	public void shouldCreateMemberWithUsername() {
		assertNotNull(member);
	}

	@Test
	public void shouldHaveCorrectUsername() {
		assertEquals("sdm", member.getUsername());
	}
	
	
	@Ignore
	@Test
	public void shouldHaveRedStatus(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YTDMiles(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave10000BalanceMiles(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotHaveDuplicateUserName(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotHaveDuplicateEmail(){
		fail("Not yet implemented");
	}
	
	
}
