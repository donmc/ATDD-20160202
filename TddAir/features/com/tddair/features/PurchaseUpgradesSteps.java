package com.tddair.features;

import org.junit.Assert;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseUpgradesSteps {

	private TddAirApplication app = TddAirApplicationSingleton.getInstance();
	private Member member;
	
	@When("^member \"([^\"]*)\" purchases (\\d+) seat upgrades$")
	public void member_purchases_seat_upgrades(String username, int quantity)
			throws Throwable {
		app.purchaseSeatUpgradesWithMilesFor(username, quantity);
		member = app.lookUpMember(username);
	}

	@Then("^that member has (\\d+) upgrades$")
	public void that_member_has_upgrades(int expectedUpgrades) throws Throwable {
		Assert.assertEquals(expectedUpgrades, member.getSeatUpgradeBalance());
	}
}
