Feature: Complete Flights
  As a Member
  I want to mark a flight as completed
  so that my frequent flyer miles are updated

  Scenario Outline: Increasing Status
    Given a <start status> member <user name> with <start ytd> ytd miles
    When they complete flight <flight>
    Then member <user name> has <end status> status
    And member <user name> has <end ytd> ytd miles

    #And member <user name> has 62490 balance miles
    Examples: 
      | user name | start status | start ytd | flight  | end status | end ytd |
      | "donmc"   | "Red"        | 20000     | "QF191" | "Green"    | 27490   |
      | "bob"     | "Green"      | 45000     | "QF191" | "Blue"     | 52490   |
      | "bob2"    | "Green"      | 40000     | "QF191" | "Green"    | 47490   |
