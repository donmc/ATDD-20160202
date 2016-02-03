package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegisters {

	private Member member;

	@Before
	public void setup(){
		String username = "don";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		
		app.registerMember(username, email);
		
		member = app.lookupMember(username);
	}
	
	@Test
	public void shouldCreateMemberWithUsername() {

		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUsername() {

		assertEquals("don", member.getUsername());
	}
	
	@Ignore
	@Test
	public void shouldHaveRedStatus(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave0YtdMiless(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave10000BalanceMiles(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldNotHaveDuplicateUsername(){
		fail("Not yet implemented");
	}

}
