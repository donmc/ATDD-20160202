Feature: Register Member
  As an airline customer
  I want to be able to register for the frequent flyer program
  so that I can receive rewards for flying frequently

Background: Cleanup
	Given a clean system

  Scenario: Valid Registration
    When a user attempts to register for the frequent flyer program with username "donmc" and e-mail address "don@improving.com"
    Then The username "donmc" is added to the list of registered members
    	And The e-mail address "don@improving.com" is associated to the newly registered member
    	And The newly registered member has "Red" status
    	And The newly registered member has 0 miles flown
    	And The newly registered member has 10000 miles redeemable for upgrades

  Scenario: Existing Username
    Given user "donmc" exists on the list of registered members
    When a user attempts to register for the frequent flyer program with username "donmc" and e-mail address "don@improving.com"
    Then Error "Duplicate member!" is displayed to the user

  Scenario Outline: Invalid e-mail
    When a user attempts to register for the frequent flyer program with username "donmc" and e-mail address <invalid-email>
    Then Error "Invalid e-mail address!" is displayed to the user

Examples:
	|invalid-email   |
#	|"don@improving" |
#	|"@improving.com"|
	|"improving.com" |