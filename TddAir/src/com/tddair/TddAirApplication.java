package com.tddair;

import java.util.HashMap;
import java.util.Map; 


public class TddAirApplication {
	
	private FlightDao flights;
	private Map<String, Member> members = new HashMap<>();  
	 
	public TddAirApplication(FlightDao flightDao) {   
		flights = flightDao;
	} 
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email) {
		validate(username, email);
		
		Member member = new Member(username, email);
		members.put(username, member);
	}

	private void validate(String username, String email) {
		if (members.containsKey(username)) {
			throw new DuplicateUsernameException(); 
		}
		if (emailNotValid(email)) {
			throw new InvalidEmailException();
		}
	}

	private boolean emailNotValid(String email) {
		return !email.contains("@") || !email.contains(".") || email.indexOf('@') == 0;
	}

	public Member lookUpMember(String username) {
		return members.get(username);
	}
	
	public void completeFlight(String username, String flightNumber) {
		Member member = members.get(username);
		Flight flight = flights.getFlightBy(flightNumber); 
		member.completeFlight(flight);
	}

	public void purchaseSeatUpgradesWithMilesFor(String username, int quantity) {
		Member member = members.get(username);
		member.purchaseSeatUpgrades(quantity);
	}
}
