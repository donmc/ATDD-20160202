package com.tddair;

public class Member {

	private String username;
	private String email;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	private int seatUpgradeBalance;

	public Member(String username, String email) {
		this.username = username;
		this.email = email;
		this.status = Status.Red;
		this.ytdMiles = 0;
		this.balanceMiles = 10000;
	}

	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}

	public Status getStatus() {
		return status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

	public void completeFlight(Flight flight) {
		ytdMiles += flight.getMileage();
		balanceMiles += flight.getMileage();
		status = Status.calculateStatusFor(ytdMiles);
		
	}

	public void purchaseSeatUpgrades(int quantity) {
		// TODO Auto-generated method stub
		
	}

	public int getSeatUpgradeBalance() {
		return seatUpgradeBalance;
	}
}
