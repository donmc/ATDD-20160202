package com.tddair.features;

import cucumber.api.java.en.Given;

public class CleanupSteps
{
	@Given("^a clean system$")
	public void a_clean_system() throws Throwable
	{
	    TddAirApplicationSingleton.newInstance();
	}
}
