package com.tddair;

public enum Status
{
	Red(10000), Green(9000), Blue(8000), Golden(7000);
	
	private int upgradeCostMiles;
	
	private Status(int upgradeCostMiles)
	{
		this.upgradeCostMiles = upgradeCostMiles;
	}
	
	public int getUpgradeCostMiles()
	{
		return upgradeCostMiles;
	}
}
