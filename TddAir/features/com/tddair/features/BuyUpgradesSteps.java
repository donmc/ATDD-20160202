package com.tddair.features;

import static org.junit.Assert.assertEquals;

import com.tddair.InsufficientMilesException;
import com.tddair.Member;
import com.tddair.Status;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyUpgradesSteps
{
	private TddAirApplication app = TddAirApplicationSingleton.getInstance();
	private Member member;
	
	@Given("^member with username \"([^\"]*)\" exists$")
	public void member_with_username_exists(String username) throws Throwable
	{
	    app.registerMember(username, "@");
	    member = app.lookUpMember(username);
	}

	@Given("^member has \"([^\"]*)\" status$")
	public void member_has_status(String status) throws Throwable
	{
	    member.setStatus(Status.valueOf(status));
	}

	@Given("^member has (\\d+) miles redeemable for upgrades$")
	public void member_has_miles_redeemable_for_upgrades(int miles) throws Throwable
	{
	    member.setBalanceMiles(miles);
	}

	@Given("^member has (\\d+) seat upgrades$")
	public void member_has_seat_upgrades(int seatUpgrades) throws Throwable
	{
	    member.setSeatUpgrades(seatUpgrades);
	}

	@When("^member attempts to purchase (\\d+) seat upgrades with miles$")
	public void member_attempts_to_purchase_seat_upgrades_with_miles(int qty) throws Throwable
	{
		try
		{
			app.purchaseUpgradesWithMiles(member.getUsername(), qty);
		}
		catch(InsufficientMilesException e)
		{
			
		}
	}

	@Then("^member now has (\\d+) seat upgrades$")
	public void member_now_has_seat_upgrades(int seatUpgrades) throws Throwable
	{
	    assertEquals(seatUpgrades, member.getSeatUpgrades());
	}

	@Then("^member now has (\\d+) balance miles$")
	public void member_now_has_balance_miles(int miles) throws Throwable
	{
	    assertEquals(miles, member.getBalanceMiles());
	}
}
