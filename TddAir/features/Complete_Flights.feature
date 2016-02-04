Feature: Complete Flights
  As a Member
  I want my miles flown tracked
  so that I can accumulate miles and earn status

  Scenario: Member accumulates miles and status
    Given a customer registers with username "bob" and email "bob@improving.com"
    And member "bob" has 20000 miles
    When member "bob" takes flight "QF191"
    Then that member has "Green" status
    And that member has 27490 ytd miles
    And that member has 37490 balance miles
