package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberFeature {

	

	@Given("^a customer registers with username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_username_and_email(String username,
			String email) throws Throwable {
		try
		{
			FeatureDataSingleton.getInstance().getApp().registerMember(username, email);
			FeatureDataSingleton.getInstance().setMember(FeatureDataSingleton.getInstance().getApp().lookupMember(username));
		}
		catch(InvalidEmailException e)
		{
			FeatureDataSingleton.getInstance().setErrorMessage(e.getMessage());
		}
	}

	@When("^a customer registers with duplicate username \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void a_customer_registers_with_duplicate_username_and_email(
			String username, String email) throws Throwable {
		try
		{
			FeatureDataSingleton.getInstance().getApp().registerMember(username, email);
		}
		catch(DuplicateUsernameException e)
		{
			FeatureDataSingleton.getInstance().setErrorMessage(e.getMessage());
		}
	}

	@Then("^a member exists with username \"([^\"]*)\"$")
	public void a_member_exists_with_username(String username) throws Throwable {
		FeatureDataSingleton.getInstance().setMember(FeatureDataSingleton.getInstance().getApp().lookupMember(username));
		assertNotNull(FeatureDataSingleton.getInstance().getMember());
	}

	@Then("^that member has \"([^\"]*)\" status$")
	public void that_member_has_status(String status) throws Throwable {
		assertEquals(FeatureDataSingleton.getInstance().getMember().getStatus().name(), status);
	}

	@Then("^that member has (\\d+) ytd miles$")
	public void that_member_has_ytd_miles(int arg1) throws Throwable {
		assertEquals(FeatureDataSingleton.getInstance().getMember().getYtdMiles(), arg1);
	}

	@Then("^that member has (\\d+) balance miles$")
	public void that_member_has_balance_miles(int arg1) throws Throwable {
		assertEquals(FeatureDataSingleton.getInstance().getMember().getBalanceMiles(), arg1);
	}

	@Then("^duplicate user error message \"([^\"]*)\" is displayed$")
	public void duplicate_user_error_message_is_displayed(String arg1)
			throws Throwable {
		assertEquals(arg1, FeatureDataSingleton.getInstance().getErrorMessage());
	}

	@Then("^invalid email error message \"([^\"]*)\" is displayed$")
	public void invalid_email_error_message_is_displayed(String arg1)
			throws Throwable {
		assertEquals(FeatureDataSingleton.getInstance().getErrorMessage(), arg1);
	}

}
