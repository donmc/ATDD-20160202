package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	
	private Map<String, Member> members = new HashMap<String, Member>();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email) throws DuplicateUsernameException {
		Member member = new Member(username, email);
		if(members.get(username)!=null)
		{
			throw new DuplicateUsernameException();
		}
		member.setStatus(Status.Red);
		member.setBalanceMiles(10000);
		member.setYtdMiles(0);
		members.put(username, member);
	}

	public Member lookupMember(String username) {
		return members.get(username);
	}
}
