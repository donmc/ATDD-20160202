Feature: Upgrade Status
As a frequent flyer program member
I want my status to be upgraded upon completing a flight
So that I can receive greater rewards

Background: Cleanup
	Given a clean system

Scenario: Red to Green
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 19000 miles flown
		And user "donmc" has 20000 miles redeemable for upgrades
	When user completes flight "QF191"
	Then user now has 26490 miles flown
		And user has "Green" status
		And user now has 27490 miles redeemable for upgrades
		
		
Scenario: Green to Blue
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 49500 miles flown
		And user "donmc" has 30000 miles redeemable for upgrades
	When user completes flight "AA242"
	Then user now has 50424 miles flown
		And user has "Blue" status
		And user now has 30924 miles redeemable for upgrades
		
		
Scenario: Blue to Golden
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 73000 miles flown
		And user "donmc" has 100000 miles redeemable for upgrades
	When user completes flight "AF38"
	Then user now has 76620 miles flown
		And user has "Golden" status
		And user now has 103620 miles redeemable for upgrades
		
		
Scenario: No Status Change (Green)
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 28000 miles flown
		And user "donmc" has 0 miles redeemable for upgrades
	When user completes flight "QF191"
	Then user now has 35490 miles flown
		And user has "Green" status
		And user now has 7490 miles redeemable for upgrades