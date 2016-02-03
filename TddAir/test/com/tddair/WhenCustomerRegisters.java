package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegisters {

	private Member member;
	private TddAirApplication app;

	@Before
	public void setup() {
		String username = "sdm";
		String email = "sdm@sdm.com";
		app = new TddAirApplication();
		
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


	@Test
	public void shouldCreateTwoMembers() {
		app.registerMember("abc","abc@abc.com");
		Member secondMember = app.lookUpMember("abc");
		assertEquals("abc", secondMember.getUsername());	
	}
	
	@Test
	public void shouldHaveCorrectEmail() {
		assertEquals("sdm@sdm.com", member.getEmail());
	}	
	
	
	@Test
	public void shouldHaveRedStatus(){
		assertEquals (Status.Red, member.getStatus());
	}
	

	@Test
	public void shouldHave0YTDMiles(){
		assertEquals(0,member.getYTDMiles());
	}
	

	@Test
	public void shouldHave10000BalanceMiles(){
		assertEquals(10000,member.getBalanceMiles());
	}
	
	@Test(expected=DuplicateUsernameException.class)
	public void shouldNotHaveDuplicateUserName(){
		app.registerMember("sdm","sdm@sdm.com");
	}
	
}
