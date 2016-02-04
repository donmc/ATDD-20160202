package com.tddair.features;

import com.tddair.FakeFlightDao;
import com.tddair.TddAirApplication;

public class TddAirApplicationSingleton {
	private static TddAirApplication instance = newInstance();
	
	public static TddAirApplication getInstance() {
		return instance;
	}

	public static TddAirApplication newInstance() {
		instance = new TddAirApplication(new FakeFlightDao());
		return instance;
	}	

}
