Feature: Register Member
  As a Customer
  I want to register for the Frequent Flyer program
  so that I start collecting miles for perks

  Scenario: Valid Registration
    When a customer registers with username "donmc" and email "don@improving.com"
    Then a member exists with username "donmc"
    And that member has "Red" status
    And that member has 0 ytd miles
    And that member has 10000 balance miles

  Scenario: Existing Username
  	Given a customer registers with username "bob" and email "bob@improving.com"
  	When a customer registers with username "bob" and email "bob@improving.com"
  	Then an error message "Duplicate Username!" is returned

  Scenario Outline: Invalid Email
  	When a customer registers with username <username> and email <email>
  	Then an error message "Invalid Email!" is returned
  
  Examples:
  	|email             |username|
  	|"bobimproving.com"|"bob"   |
  	|"bob@improving"   |"don"   |
  	|"@improving.com"  |"rod"   |
