Feature: Complete Flights
As a Member
I want my miles flown recorded
so that I can accumulate miles and earn status


Scenario: Valid Flight
Given Purchased a ticket, checked in 
When Plane landed at destination
Then Miles are accumulated in membership account

Scenario: Invalid Flight
Given Purchased Ticket
When Cancelled Flight or Cancelled Ticket
Then No points are accumlated in membership account

Scenario: Upgrade Account
Given Purchased Ticket, checked in
When Plane landed at destination and miles will upgrade to next tier
Then Status upgraded when plane landed