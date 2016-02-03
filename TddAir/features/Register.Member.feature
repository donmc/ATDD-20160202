Feature: Register Member
  As a Member
  I want to be able to register for frequent flyer program
  so that I can begin to collect miles for the flights I complete

  Scenario: Valid Registration  
    Given a customer registers with username "don" and email "don@improving.com"
    Then a member exists with username "don"
    And that member has "Red" status
    And that member has 0 ytd miles
    And that member has 10000 balance miles

  Scenario: Existing username 
    Given a customer registers with username "don" and email "don@improving.com"
    When a customer registers with duplicate username "don" and email "don@improving.com"
    Then duplicate user error message "Username already exists" is displayed

  Scenario Outline: Invalid Email
    When a customer registers with username <username> and email <email>
    Then invalid email error message "Email is Invalid!" is displayed

    Examples: 
      | email              | username |
      | "bobimproving.com" | "bob"    |
      | "bob@improving"    | "don"    |
      | "@improving.com"   | "rod"    |
