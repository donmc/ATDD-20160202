package com.tddair.features;

import com.tddair.TddAirApplication;

public class TddAirApplicationSingleton
{
	private static TddAirApplication instance = new TddAirApplication();
	
	public static TddAirApplication getInstance()
	{
		return instance;
	}
}
