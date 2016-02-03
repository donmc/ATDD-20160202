package com.tddair;

public class Member {
	
	private String username;
	
	private String email;
	
	private Status status;
	
	private int ytdMiles;

	private int balanceMiles;

	public Member(String username2, String email2) {
		this.username = username2;
		this.email = email2;
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

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

	public void setBalanceMiles(int balanceMiles) {
		this.balanceMiles = balanceMiles;
	}

	
}
