Feature: Buy Seat Upgrades
As a frequent flyer program member
I want to be able to buy seat upgrades at reduced cost
So that I can save money

Background: Cleanup
	Given a clean system

Scenario Outline: Purchase with miles
	Given member with username "bob" exists
		And member has <status> status
		And member has <balance miles> miles redeemable for upgrades
		And member has <seat upgrades> seat upgrades
	When member attempts to purchase <qty> seat upgrades with miles
	Then member now has <new seat upgrades> seat upgrades
		And member now has <new balance miles> balance miles

Examples:
|status  |balance miles|seat upgrades|qty|new seat upgrades|new balance miles|
|"Red"   |15000        |0            |1  |1                |5000             |
|"Green" |20000        |2            |1  |3                |11000            |
|"Blue"  |50000        |0            |3  |3                |26000            |
|"Golden"|60000        |4            |2  |6                |46000            |

Scenario: Not enough miles
	Given member with username "bob" exists
		And member has "Green" status
		And member has 8000 miles redeemable for upgrades
		And member has 1 seat upgrades
	When member attempts to purchase 1 seat upgrades with miles
	Then member now has 1 seat upgrades
		And member now has 8000 balance miles
		And Error "Not enough miles!" is displayed to the user
		
Scenario: Purchase with valid credit card

Scenario: Purchase with invalid credit card