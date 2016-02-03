package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberCompletesFlight
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
		member = app.lookUpMember("don");
		member.setYtdMiles(10000);
	}

	@Test
	public void shouldAccumulateYtdMiles()
	{
		Flight flight = new Flight("SAT","DFW",3000);
		
		member.completeFlight(flight);
		
		assertEquals(13000, member.getYtdMiles());
	}

	@Test
	public void shouldAttainGreenStatus()
	{
		Flight flight = new Flight("SAT","DFW",15000);
		
		member.completeFlight(flight);
		
		assertEquals(Status.Green, member.getStatus());
	}
	
	@Test
	public void shouldAttainBlueStatus()
	{
		Flight flight = new Flight("SAT","DFW",40000);
		
		member.completeFlight(flight);
		
		assertEquals(Status.Blue, member.getStatus());
	}

	@Test
	public void shouldAttainGoldenStatus()
	{
		Flight flight = new Flight("SAT","DFW",65000);
		
		member.completeFlight(flight);
		
		assertEquals(Status.Golden, member.getStatus());
	}

}
