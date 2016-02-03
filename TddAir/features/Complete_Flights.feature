Feature: Complete Flights
As a Member
I want my miles recorded
so that I can accumulate miles and earn status

Scenario Outline: Member accumulates miles and status

Given a customer registers with username <username> and email "bob@improving.com"
And member <username> has <start miles> miles
When member <username> takes flight <flight no>
Then that member has <end status> status
And that member has <end ytd> ytd miles
And that member has <end balance> balance miles

Examples: 
|username|start miles|flight no|end status|end ytd|end balance|
|"bob"   |20000      |"QF191"  |"Green"   |27490  |37490      |
|"sue"   |45000      |"QF191"  |"Blue"    |52490  |62490      |
|"rob"   |20000      |"QF191"  |"Green"   |27490  |37490      |
|"cob"   |20000      |"QF191"  |"Green"   |27490  |37490      |
|"dob"   |20000      |"QF191"  |"Green"   |27490  |37490      |
