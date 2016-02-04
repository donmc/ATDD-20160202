package com.tddair;

import java.util.ArrayList;
import java.util.List;


public class TddAirApplication {
	
	private FlightDao flights;
	
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
			throw new IllegalArgumentException("Duplicate member!");
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
			throw new IllegalArgumentException("Invalid e-mail address!");
		}
		
		if(!email.contains("@"))
		{
			throw new IllegalArgumentException("Invalid e-mail address!");
		}
	}
}
