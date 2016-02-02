Feature: Register Member
As an airline customer
I want to be able to register for the frequent flyer program
so that I can receive rewards for flying frequently

Scenario: Valid Registration

Given --
When a user attempts to register for the frequent flyer program with valid username and e-mail address
Then
	The username entered is added to the list of registered members
	The e-mail address entered is associated to the username
	The newly registered member's status is set to Red
	The newly registered member's miles flown are set to 0
	The newly registered member's miles redeemable for upgrades are set to 10,000

Scenario: Existing Username

Given -- 
When a user attempts to register for the frequent flyer program with a username that already exists in the list of registered members
Then
	No entry is added to the list of registered members
	An error is displayed to the user

Scenario: Invalid e-mail

Given --
When a user attempts to register for the frequent flyer program with a valid username and an invalid e-mail address
Then
	No entry is added to the list of registered members
	An error is displayed to the user