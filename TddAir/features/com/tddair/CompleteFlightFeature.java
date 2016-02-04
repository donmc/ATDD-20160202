package com.tddair;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompleteFlightFeature {
	
	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with (\\d+) ytd miles$")
	public void a_member_with_ytd_miles(String arg1, String arg2, int arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^they complete flight \"([^\"]*)\"$")
	public void they_complete_flight(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member \"([^\"]*)\" has \"([^\"]*)\" status$")
	public void member_has_status(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member \"([^\"]*)\" has (\\d+) ytd miles$")
	public void member_has_ytd_miles(String arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
