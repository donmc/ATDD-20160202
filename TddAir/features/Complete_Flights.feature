Feature: Complete Flights
  As a member
  I want my miles recorded
  so that I can accumulate miles and earn status.
  
  Background: Cleanup
  Given a clean system

  Scenario: Member accumulates miles and status
    Given a registered member with username "bill" and email "bill@bill.com"
    And member has 20000 extra miles
    When member takes flight "QF191"
    Then that member has 27490 ytd miles
    And that member has 37490 balance miles
    And that member has "Green" status
