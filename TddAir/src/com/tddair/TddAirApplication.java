package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {
	
	private Member member;
	private Map<String, Member> members = new HashMap<String, Member>();
	
	private FlightDao flights = new FlightDao();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Member lookupMember(String username) {
		
		return members.get(username);
	}

	public void registerMember(String username, String email) throws DuplicateUsernameException {
		
		if(members.containsKey(username)){
			
			throw new DuplicateUsernameException();
		}
		
		Member member = new Member(username, email);
		members.put(username, member);
	}

	public Object getDuplicateUsernameError() {
		// TODO Auto-generated method stub
		return null;
	}
}
