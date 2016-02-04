package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCustomerRegisters {

	private Member member;
	private TddAirApplication app;
	
	@Before
	public void setup(){
		String username = "don";
		String email = "don@improving.com";
		Integer ytdMiles = 0;
		Integer balanceMiles = 10000;
		app = new TddAirApplication();
		
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
	
	
	@Test
	public void shouldCreateTwoMembers() {
		app.registerMember("bob", "bob@improving.com");
		Member secondMember = app.lookupMember("bob");
		assertEquals("bob", secondMember.getUsername());
	}
	
	@Test
	public void shouldHaveCorrectEmail() {

		assertEquals("don@improving.com", member.getEmail());
	}
	
	
	
	@Test
	public void shouldHaveRedStatus(){
		assertEquals(Status.Red, member.getStatus());
	}
	

	@Test
	public void shouldHave0YtdMiless(){
		assertEquals(0, member.getYtdMiles());
	}
	
	
	@Test
	public void shouldHave10000BalanceMiles(){
		assertEquals(10000, member.getBalanceMiles());
	}
	

	@Test(expected=DuplicateUsernameException.class)
	public void shouldNotHaveDuplicateUsername(){
		app.registerMember("don", "don@gmail.com");
	}
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoAt(){
		app.registerMember("dog", "doggmail.com");
	}
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoDot(){
		app.registerMember("dan", "dan@gmailcom");
	}
	
	@Test(expected=InvalidEmailException.class)
	public void shouldNotAllowInvalidEmail_NoPrefix(){
		app.registerMember("din", "d@gmail.com");
	}

}
