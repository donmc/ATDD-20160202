package com.tddair;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberFeature {

	private TddAirApplication app = new TddAirApplication();
	private Member member;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Given("^a customer registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_username_and_email(String username,
			String email) throws Throwable {
		app.registerMember(username, email);
	}

	@When("^a customer registers with duplicate username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_duplicate_username_and_email(
			String username, String email) throws Throwable {
		app.registerMember(username, email);		
	}

	@Then("^a member exists with username \"([^\"]*)\"$")
	public void a_member_exists_with_username(String username) throws Throwable {
		member = app.lookupMember(username);
		assertNotNull(member);
	}

	@Then("^that member has \"([^\"]*)\" status$")
	public void that_member_has_status(String status) throws Throwable {
		member.getStatus().name().equals(status);
	}

	@Then("^that member has (\\d+) ytd miles$")
	public void that_member_has_ytd_miles(int arg1) throws Throwable {
		assertEquals(member.getYtdMiles(), arg1);
	}

	@Then("^that member has (\\d+) balance miles$")
	public void that_member_has_balance_miles(int arg1) throws Throwable {
		assertEquals(member.getBalanceMiles(), arg1);
	}

	@Then("^DuplicateUsernameException is thrown$")
	public void duplicateusernameexception_is_thrown() throws Throwable {
		expectedException.expect(DuplicateUsernameException.class);
	}

	@Then("^InvalidEmailException is thrown$")
	public void invalidemailexception_is_thrown() throws Throwable {
		throw new InvalidEmailException();
	}

}
