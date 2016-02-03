package com.tddair;

import com.tddair.exception.MemberException;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDao members = new MemberDao();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email) throws MemberException {
		members.register(username, email);
	}

	public Member lookUpMember(String username) {
		return members.lookup(username);
	}

	public void completeMemberFlight(Member member, String flightNumber) throws Exception {
		if (null == member) {
			throw new IllegalArgumentException("member cannot be null");
		}
		
		Flight flight = flights.lookupFlight(flightNumber);
		if (null == flight) {
			throw new Exception("Flight does not exist");
		}
		
		member.addMiles(flight.getMileage());
	}
}
