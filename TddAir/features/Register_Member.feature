Feature: Register Member
As an airline customer
I want to be able to register for the frequent flyer program
so that I can receive rewards for flying frequently

Scenario: Valid Registration

When a user attempts to register for the frequent flyer program with valid username and e-mail address
Then
	The username entered is added to the list of registered members
	The e-mail address entered is associated to the username
	The newly registered member's status is set to Red
	The newly registered member's miles flown are set to 0
	The newly registered member's miles redeemable for upgrades are set to 10,000

Scenario: Existing Username

Given a username exists on the list of registered members
When a user attempts to register for the frequent flyer program with that username
Then
	No entry is added to the list of registered members
	An error is displayed to the user

Scenario: Invalid e-mail

When a user attempts to register for the frequent flyer program with a valid username and an invalid e-mail address
Then
	No entry is added to the list of registered members
	An error is displayed to the user