package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WhenCustomerRegisters
{

	private Member member;
	private TddAirApplication app;
	
	@Before
	public void setup()
	{
		String username = "don";
		String email = "don@improving.com";
		
		app = new TddAirApplication();
		app.registerMember(username, email);
	}
	
	@Test
	public void shouldCreateMemberWithUsername()
	{
		member = app.lookUpMember("don");
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUsername()
	{
		member = app.lookUpMember("don");
		assertEquals("don", member.getUsername());
	}
	
	@Test
	public void shouldHaveCorrectUsernameForAdditionalMember()
	{
		app.registerMember("mik", "mikmik@somewhere.com");
		member = app.lookUpMember("mik");
		assertEquals("mik", member.getUsername());
	}

	@Test
	public void shouldHaveRedStatus()
	{
		member = app.lookUpMember("don");
		assertEquals(Status.Red, member.getStatus());
	}

	@Test
	public void shouldHave0YTDMiles()
	{
		member = app.lookUpMember("don");
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void shouldHave10000BalanceMiles()
	{
		member = app.lookUpMember("don");
		assertEquals(10000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldNotHaveDuplicateUsername()
	{
		try
		{
			app.registerMember("don", "mikmik@somewhere.com");
			fail("Should throw an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Duplicate member!", e.getMessage());
		}
	}
	
	@Test
	public void shouldNotHaveNullEmail()
	{
		try
		{
			app.registerMember("mik", null);
			fail("Should throw an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Invalid e-mail address!", e.getMessage());
		}
	}

	
	@Test
	public void shouldNotHaveEmailWithoutAtSign()
	{
		try
		{
			app.registerMember("mik", "mikmiksomewhere.com");
			fail("Should throw an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Invalid e-mail address!", e.getMessage());
		}
	}
}
