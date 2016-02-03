package com.tddair.features;

import com.tddair.Member;
import com.tddair.Status;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class CompleteFlightSteps {

	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String errorMessage;

	@Given("^a registered member with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_registered_member_with_username_and_email(String username,
			String email) throws Throwable {
		app.registerMember(username, email);
		member = app.lookUpMember(username);
	}

	@Given("^member has (\\d+) extra miles$")
	public void member_has_extra_miles(int miles) throws Throwable {
		member.addMiles(miles);
	}
	
	@When("^member takes flight \"([^\"]*)\"$")
	public void member_takes_flight(String flight) throws Throwable {
		app.completeMemberFlight(member, flight);
	}

	@Then("^that member has (\\d+) ytd miles$")
	public void that_member_has_ytd_miles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^that member has (\\d+) balance miles$")
	public void that_member_has_balance_miles(int balanceMiles) throws Throwable {
		assertEquals(balanceMiles, member.getBalanceMiles());

	}

	@Then("^that member has \"([^\"]*)\" status$")
	public void that_member_has_status(Status status) throws Throwable {
		assertEquals(status, member.getStatus());
	}
}
