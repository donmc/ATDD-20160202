package com.tddair.features;

import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CompleteFlightsSteps {

	private TddAirApplication app = TddAirApplicationSingleton.getInstance();
	
	@Given("^member \"([^\"]*)\" has (\\d+) miles$")
	public void member_has_miles(String username, int miles) throws Throwable {
		app.addFlight("DFW", "SOM", miles, "TST", 200);
		app.completeFlight(username, "TST200");
	}

	@When("^member \"([^\"]*)\" takes flight \"([^\"]*)\"$")
	public void member_takes_flight(String username, String flightNumber) throws Throwable {
		app.completeFlight(username, flightNumber);
	}

}
