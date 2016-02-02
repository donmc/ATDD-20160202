Feature: Register Member
As a Member
I want to register
so that I can keep track of my membership

Scenario: Valid Registration
Given Birthdate, Email, Name
When Registering
Then Creates a new member in Red status with 10,000 miles 
	And no upgrade on bonus miles given

Scenario: Existing Username
Given Registered Member
When Birthdate, Email, Name already exists
Then Reject new member creation

Scenario: Invalid Email
Given Email
When Bad format
Then Reject