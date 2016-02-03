package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

	private FlightDao flights = new FlightDao();
	private Map<String, Member> members = new HashMap<>();

	public TddAirApplication() {
	}

	public void addFlight(String origin, String destination, int mileage,
			String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email) {
		if (members.containsKey(username)) {
			throw new DuplicateUsernameException();
		}
		
		Member member = new Member(username, email);
		members.put(username, member);

	}

	public Member lookUpMember(String username) {
		// TODO Auto-generated method stub
		return members.get(username);
	}
}
