package com.tddair;

import java.util.ArrayList;
import java.util.List;


public class TddAirApplication {
	
	private FlightDao flights;
	private String errorMessage;
	
	private List<Member> members = new ArrayList<Member>();
	
	public TddAirApplication(FlightDao flightDao)
	{
		flights = flightDao;
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}
	
	public Flight getFlightByFlightNumber(String flightNumber)
	{
		return flights.getFlightBy(flightNumber);
	}

	public void registerMember(String username, String email)
	{
		if(lookUpMember(username) != null)
		{
			errorMessage = "Duplicate member!";
			throw new IllegalArgumentException(errorMessage);
		}

		validateEmail(email);
		
		Member member = new Member(username, email);
		members.add(member);
	}

	public Member lookUpMember(String username)
	{
		for (Member member : members)
		{
			if (member.getUsername().equalsIgnoreCase(username))
			{
				return member;
			}
		}
		return null;
		
	}
	
	private void validateEmail(String email)
	{
		if(email == null)
		{
			errorMessage = "Invalid e-mail address!";
			throw new IllegalArgumentException(errorMessage);
		}
		
		if(!email.contains("@"))
		{
			errorMessage = "Invalid e-mail address!";
			throw new IllegalArgumentException(errorMessage);
		}
	}
	
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	public void purchaseUpgradesWithMiles(String username, int qty)
	{
		Member member = lookUpMember(username);
		try
		{
			member.purchaseUpgradesWithMiles(qty);
		}
		catch(InsufficientMilesException e)
		{
			errorMessage = "Not enough miles!";
			throw e;
		}
	}
}
