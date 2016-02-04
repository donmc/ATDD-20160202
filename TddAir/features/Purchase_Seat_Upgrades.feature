Feature: Purchase Seat Upgrades
  As a Member
  I want to purchase seat upgrades
  so that I can get to 1st class once in awhile

  Scenario Outline: Purchase with Miles (Red, Green, Blue, Gold)
    Given a customer registers with username <username> and email "bob@improving.com"
    And member <username> has <start balance> miles
    When member <username> purchases <quantity> seat upgrades
    Then that member has <end upgrades> upgrades
    And that member has <end balance> balance miles

    Examples: 
      | username | start balance | quantity | end upgrades | end balance |
      | "red1"   | 10000         | 1        | 1            | 10000       |
      | "red2"   | 30000         | 2        | 2            | 20000       |
      | "green"  | 40000         | 1        | 1            | 41000       |
      | "blue"   | 70000         | 1        | 1            | 72000       |
      | "gold1"  | 100000        | 1        | 1            | 103000      |
      | "gold2"  | 100000        | 10       | 10           | 40000       |
      | "broke"  | 10000         | 2        | 0            | 20000       |

  #Scenario: Purchase with valid Credit Card

  #Scenario: Invalid Credit Card
