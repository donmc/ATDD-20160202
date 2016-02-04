package com.tddair.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class CleanUpSteps {
	@Given("^a clean system$")
	public void a_clean_system() throws Throwable {
	    TddAirApplicationSingleton.newInstance();
	}

}
