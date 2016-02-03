package com.tddair;

public class Member {

	private String username;
	private String email;
	private int ytdMiles;
	private int balanceMiles;
	private Status status;

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

	public Status getStatus() {
		return status;
	}

	public int getYTDMiles() {
		return ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

	public String getEmail() {
		return email;
	}
}
