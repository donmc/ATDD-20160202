Feature: Register Member
As a potential member
I want to be able to register for frequent flyer membership
so that I can recieve upgrade benefits.

Scenario: Valid Registration

When a customer provides a username "justinet" and email "justine.t@space.com"
Then the customer is stored in the system with username "justinet"
And a status of "Red" 
And customer has 0 ytd miles
And customer has 10000 balance miles

Scenario: Existing Username

Given an existing customer with username "billiscool" and email "bill@bill.com"
When the customer provides a username  "billiscool" and email "bill@bill.com" 
Then the customer is not registered in the system 
And recieves an error message "username already exists"


Scenario Outline: Invalid Email

When a customer registers with username <username> and email <email>
Then an error message "Invalid Email" is returned

Examples:
	|email				|username	|
	|"bill@billcom"		|"bill"		|
	|"billname.com"		|"bob"		|
	|"@bill.com"		|"justine"	|
