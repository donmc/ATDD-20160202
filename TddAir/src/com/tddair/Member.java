package com.tddair;

public class Member
{
	private String username;
	private String email;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	private int seatUpgrades;
	private Cas cas;
	
	public Member(String username, String email)
	{
		this.username = username;
		this.email = email;
		this.status = Status.Red;
		this.ytdMiles = 0;
		this.balanceMiles = 10000;
		this.seatUpgrades = 0;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getEmail()
	{
		return email;
	}

	public Status getStatus()
	{
		return status;
	}

	public int getYtdMiles()
	{
		return ytdMiles;
	}

	public int getBalanceMiles()
	{
		return balanceMiles;
	}

	public void setYtdMiles(int ytdMiles)
	{
		this.ytdMiles = ytdMiles;
	}

	public void completeFlight(Flight flight)
	{
		ytdMiles += flight.getMileage();
		balanceMiles += flight.getMileage();
		
		if(ytdMiles >= 75000)
		{
			status = Status.Golden;
		}
		else if(ytdMiles >= 50000)
		{
			status = Status.Blue;
		}
		else if(ytdMiles >= 25000)
		{
			status = Status.Green;
		}
	}

	public void setBalanceMiles(int balanceMiles)
	{
		this.balanceMiles = balanceMiles;
		
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public void setSeatUpgrades(int seatUpgrades)
	{
		this.seatUpgrades = seatUpgrades;
	}

	public void purchaseUpgradesWithMiles(int qty)
	{
		int costOfUpgrades = qty * status.getUpgradeCostMiles();
		
		if(balanceMiles < costOfUpgrades)
		{
			throw new InsufficientMilesException();
		}
		
		balanceMiles -= costOfUpgrades;
		seatUpgrades += qty;
	}

	public int getSeatUpgrades()
	{
		return seatUpgrades;
	}

	public void purchaseUpgradesWithCC(int qty, String ccNum)
	{
		cas.purchase(ccNum, status.getUpgradeCostDollars() * qty);
		seatUpgrades += qty;
	}

	public void setCas(Cas cas)
	{
		this.cas = cas;
	}

	public Cas getCas()
	{
		return cas;
	}

	
}
