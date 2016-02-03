package com.tddair;

public class Member {

	private String username;
	private String email;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	
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

	public void addMiles(int miles) {
		setYtdMiles(ytdMiles + miles);
		setBalanceMiles(balanceMiles + miles);
	}

	private void setBalanceMiles(int miles) {
		this.balanceMiles = miles;
	}

	public void setYtdMiles(int miles) {
		this.ytdMiles = miles;

		if (0 > ytdMiles) {
			status = Status.Invalid;
		}
		else if (25000 > ytdMiles) {
			status = Status.Red;
		}
		else if (50000 > ytdMiles) {
			status = Status.Green;
		}
		else if (75000 > ytdMiles) {
			status = Status.Blue;
		}
		else {
			status = Status.Golden;
		}
	}
}
