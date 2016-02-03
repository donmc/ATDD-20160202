package com.tddair;

import java.util.ArrayList;
import java.util.List;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	
	private List<Member> members = new ArrayList<Member>();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email)
	{
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
}
