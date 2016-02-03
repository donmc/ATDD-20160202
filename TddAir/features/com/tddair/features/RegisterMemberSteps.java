package com.tddair.features;

import com.tddair.Member;
import com.tddair.Status;
import com.tddair.TddAirApplication;
import com.tddair.exception.MemberException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class RegisterMemberSteps {

	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String errorMessage;

	@When("^a customer provides a username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_provides_a_username_and_email(String username,
			String email) throws Throwable {
		app.registerMember(username, email);
		member = app.lookUpMember(username);
	}

	@Then("^the customer is stored in the system with username \"([^\"]*)\"$")
	public void the_customer_is_stored_in_the_system_with_username(
			String username) throws Throwable {
		assertEquals(username, member.getUsername());
	}

	@Then("^a status of \"([^\"]*)\"$")
	public void a_status_of(Status status) throws Throwable {
		assertEquals(status, member.getStatus());
	}

	@Then("^customer has (\\d+) ytd miles$")
	public void customer_has_ytd_miles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^customer has (\\d+) balance miles$")
	public void customer_has_balance_miles(int balance) throws Throwable {
		assertEquals(balance, member.getBalanceMiles());
	}

	@Given("^an existing customer with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void an_existing_customer_with_username_and_email(String username, String email) throws Throwable {
		app.registerMember(username, email);
	}

	@When("^the customer provides a username  \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void the_customer_provides_a_username_and_email(String username,
			String email) throws Throwable {
		try {
			app.registerMember(username, email);
			member = app.lookUpMember(username);
			fail("should throw duplicate user exception");
		} catch (MemberException e) {
			errorMessage = e.getMessage();
		}
	}

	@Then("^the customer is not registered in the system$")
	public void the_customer_is_not_registered_in_the_system() throws Throwable {
	}

	@Then("^recieves an error message \"([^\"]*)\"$")
	public void recieves_an_error_message(String error) throws Throwable {
		assertEquals(error, errorMessage);
	}

	@When("^a customer registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_username_and_email(String username,
			String email) throws Throwable {
		try {
			app.registerMember(username, email);
			member = app.lookUpMember(username);
		} catch (MemberException e) {
			errorMessage = e.getMessage();
		}
	}

	@Then("^an error message \"([^\"]*)\" is returned$")
	public void an_error_message_is_returned(String error) throws Throwable {
		assertEquals(error, errorMessage);
	}

}
