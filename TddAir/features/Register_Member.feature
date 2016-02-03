Feature: Register Member
As a potential member
I want to be able to register for frequent flyer membership
so that I can recieve upgrade benefits.

Scenario: Valid Registration

Given an unregistered customer
When a customer provides a username "justinet" and email "justine.t@space.com"
Then the customer is stored in the system with username "justinet"
And a status of "Red" 
And customer has 0 ytd miles
And customer has 10000 balance miles

Scenario: Existing Username

Given a customer provides username "billiscool" and email "bill@bill.com"
When the customer provides a username  "billiscool" 
Then the customer is not registered in the system 
And recieves an error message "Duplicate Username!"

Scenario: Invalid Email

Given a customer provides username "bills" and email "bill@bill.com"
When the customer provides an email "bill@bill.com"
Then the customer is not registered in the system
And recieves an error message "Invalid Email!"
