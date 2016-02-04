package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.Flight;
import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpgradeStatusSteps
{
	private TddAirApplication app = TddAirApplicationSingleton.getInstance();
	private Member member;
	
	@Given("^user \"([^\"]*)\" has (\\d+) miles flown$")
	public void user_has_miles_flown(String username, int milesFlown) throws Throwable
	{
	    member = app.lookUpMember(username);
	    member.setYtdMiles(milesFlown);
	}

	@When("^user completes flight \"([^\"]*)\"$")
	public void user_completes_flight(String flightNumber) throws Throwable
	{
	    Flight flight = app.getFlightByFlightNumber(flightNumber);
	    member.completeFlight(flight);
	}
	
	@Then("^user now has (\\d+) miles flown$")
	public void user_now_has_miles_flown(int milesFlown) throws Throwable
	{
		assertEquals(milesFlown, member.getYtdMiles());
	}

	@Then("^user has \"([^\"]*)\" status$")
	public void user_has_status(String status) throws Throwable
	{
	    assertEquals(status, member.getStatus().toString());
	}
	
	@Given("^user \"([^\"]*)\" has (\\d+) miles redeemable for upgrades$")
	public void user_has_miles_redeemable_for_upgrades(String username, int redeemableMiles) throws Throwable
	{
		member = app.lookUpMember(username);
	    member.setBalanceMiles(redeemableMiles);
	}

	@Then("^user now has (\\d+) miles redeemable for upgrades$")
	public void user_now_has_miles_redeemable_for_upgrades(int redeemableMiles) throws Throwable
	{
	    assertEquals(redeemableMiles, member.getBalanceMiles());
	}
}
