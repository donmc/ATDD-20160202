Feature: Upgrade Status
As a frequent flyer program member
I want my status to be upgraded upon completing a flight
So that I can receive greater rewards

Background: Cleanup
	Given a clean system

Scenario: Red to Green
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 19000 miles flown
	When user completes flight "QF191"
	Then user now has 26490 miles flown
		And user has "Green" status
		
		
Scenario: Green to Blue
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 49500 miles flown
	When user completes flight "AA242"
	Then user now has 50424 miles flown
		And user has "Blue" status
		
		
Scenario: Blue to Golden
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 73000 miles flown
	When user completes flight "AF38"
	Then user now has 76620 miles flown
		And user has "Golden" status
		
		
Scenario: No Status Change (Green)
	Given user "donmc" exists on the list of registered members
		And user "donmc" has 28000 miles flown
	When user completes flight "QF191"
	Then user now has 35490 miles flown
		And user has "Green" status