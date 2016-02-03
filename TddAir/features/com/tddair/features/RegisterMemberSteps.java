package com.tddair.features;

import static junit.framework.Assert.assertEquals;

import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps
{
	private TddAirApplication app = TddAirApplicationSingleton.getInstance();
	private Member member;
	private String message;
	
	@When("^a user attempts to register for the frequent flyer program with username \"([^\"]*)\" and e-mail address \"([^\"]*)\"$")
	public void a_user_attempts_to_register_for_the_frequent_flyer_program_with_username_and_e_mail_address(String username, String email) throws Throwable
	{
		try
		{
			app.registerMember(username, email);
		}
		catch(IllegalArgumentException e)
		{
			message = e.getMessage();
		}
	}

	@Then("^The username \"([^\"]*)\" is added to the list of registered members$")
	public void the_username_is_added_to_the_list_of_registered_members(String username) throws Throwable
	{
	    member = app.lookUpMember(username);
	    assertEquals(username, member.getUsername());
	}

	@Then("^The e-mail address \"([^\"]*)\" is associated to the newly registered member$")
	public void the_e_mail_address_is_associated_to_the_newly_registered_member(String email) throws Throwable
	{
	    assertEquals(email, member.getEmail());
	}

	@Then("^The newly registered member has \"([^\"]*)\" status$")
	public void the_newly_registered_member_has_status(String status) throws Throwable
	{
	    assertEquals(status, member.getStatus().toString());
	}

	@Then("^The newly registered member has (\\d+) miles flown$")
	public void the_newly_registered_member_has_miles_flown(int milesFlown) throws Throwable
	{
	    assertEquals(milesFlown, member.getYtdMiles());
	}

	@Then("^The newly registered member has (\\d+) miles redeemable for upgrades$")
	public void the_newly_registered_member_has_miles_redeemable_for_upgrades(int redeemableMiles) throws Throwable
	{
	    assertEquals(redeemableMiles, member.getBalanceMiles());
	}

	@Given("^user \"([^\"]*)\" exists on the list of registered members$")
	public void username_exists_on_the_list_of_registered_members(String username) throws Throwable
	{
		try
		{
			app.registerMember(username, "don@improving.com");
		}
		catch(IllegalArgumentException e)
		{
			message = e.getMessage();
		}
	}

	@Then("^Error \"([^\"]*)\" is displayed to the user$")
	public void error_is_displayed_to_the_user(String message) throws Throwable
	{
	    assertEquals(message, this.message);
	}
}
