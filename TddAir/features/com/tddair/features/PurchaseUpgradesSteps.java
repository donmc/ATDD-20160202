package com.tddair.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseUpgradesSteps {

	@When("^member \"([^\"]*)\" purchases (\\d+) seat upgrades$")
	public void member_purchases_seat_upgrades(String username, int quantity)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^that member has (\\d+) upgrades$")
	public void that_member_has_upgrades(int expectedUpgrades) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
