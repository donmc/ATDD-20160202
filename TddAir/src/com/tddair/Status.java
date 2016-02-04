package com.tddair;

public enum Status
{
	Red(10000, 100), Green(9000, 90), Blue(8000, 75), Golden(7000, 60);
	
	private int upgradeCostMiles;
	private int upgradeCostCC;
	
	private Status(int upgradeCostMiles, int upgradeCostCC)
	{
		this.upgradeCostMiles = upgradeCostMiles;
		this.upgradeCostCC = upgradeCostCC;
	}
	
	public int getUpgradeCostMiles()
	{
		return upgradeCostMiles;
	}

	public int getUpgradeCostDollars()
	{
		return upgradeCostCC;
	}
}
