package com.tddair;

public class Member {
	
	private String userName;
	private Enum<Status> status;
	private String email;
	private int YtdMiles;
	private int balanceMiles;



	public Member(String username, String email) {
		this.userName = username;
		this.setEmail(email);
		this.status = Status.Red;
		this.balanceMiles = 10000;
	
	}

	public Member(String username2) {
		this.userName = username2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Enum<Status> getStatus() {
		return this.status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYtdMiles() {
		return YtdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

}
