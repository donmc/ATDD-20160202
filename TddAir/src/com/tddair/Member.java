package com.tddair;

public class Member
{
	private String username;
	private String email;
	private String status;
	private int ytdMiles;
	private int balanceMiles;
	
	public Member(String username, String email)
	{
		this.username = username;
		this.email = email;
		this.status = "Red";
		this.ytdMiles = 0;
		this.balanceMiles = 10000;
		
	}
	

	public String getUsername()
	{
		// TODO Auto-generated method stub
		return username;
	}


	public String getStatus()
	{
		
		return status;
	}


	public int getYtdMiles()
	{
		// TODO Auto-generated method stub
		return ytdMiles;
	}


	public int getBalanceMiles()
	{
		// TODO Auto-generated method stub
		return balanceMiles;
	}

}
