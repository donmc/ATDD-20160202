package com.tddair;

import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeatUpgradeFeature {
	
	


	@Given("^member <member> has (\\d+) miles$")
	public void member_member_has_miles(int arg1) throws Throwable {
	   assertEquals("start balance does not match", FeatureDataSingleton.getInstance().getMember().getBalanceMiles(), arg1);
	}


	@When("^member purchases (\\d+) seat upgrade$")
	public void member_purchases_seat_upgrade(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^member has (\\d+) upgrades$")
	public void member_has_upgrades(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}
