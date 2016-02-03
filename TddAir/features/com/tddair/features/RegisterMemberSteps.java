package com.tddair.features;

import static org.junit.Assert.*;

import com.tddair.DuplicateUsernameException;
import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {

	private 	TddAirApplication app = new TddAirApplication();
	private Member member;
	private String errorMessage;
	
	@When("^a customer registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_username_and_email(String username, String email) throws Throwable {
		try {
			app.registerMember(username, email);
		}catch(DuplicateUsernameException e) {
			this.errorMessage = "Duplicate Username!";
		}
		member = app.lookUpMember(username);
	}

	@Then("^a member exists with username \"([^\"]*)\"$")
	public void a_member_exists_with_username(String username) throws Throwable {
		assertEquals(username, member.getUsername());
	}

	@Then("^that member has \"([^\"]*)\" status$")
	public void that_member_has_status(String status) throws Throwable {
		assertEquals(status, member.getStatus().toString());
	}

	@Then("^that member has (\\d+) ytd miles$")
	public void that_member_has_ytd_miles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^that member has (\\d+) balance miles$")
	public void that_member_has_balance_miles(int balance) throws Throwable {
		assertEquals(balance, member.getBalanceMiles());
	}

	@Then("^an error message \"([^\"]*)\" is returned$")
	public void an_error_message_is_returned(String message) throws Throwable {
		assertEquals(message, errorMessage);
	}

}
