Feature: Register Member
  As a customer
  I want register for the frequent flyer program
  so that I can stat collecting perks

  Scenario: Valid Registration
    When a customer registers with username "sdm" and email "sdm@sdm.com"
    Then a member exists with username "sdm"
    And that member has "Red" status
    And that member has 0 ytd miles
    And that member has 10000 balance miles

  Scenario: Existing User Name
    Given a customer registers with username "sdm" and email "sdm@sdm.com"
    When a customer registers with username "sdm" and email "sdm@sdm.com"
    Then an error message saying "user name is already in use" is returned

  Scenario: Invalid Email
    Given User email has already been registered
    When User registers for an account
    Then Error message saying to email address is already in use


