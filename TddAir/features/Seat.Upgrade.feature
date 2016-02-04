Feature: Complete Flights
As a Member
I want to purchase seat upgrades
so that I can travel in a more comfortable way

Scenario Outline: Purchase with Miles (Red, Green, Blue, Gold)
Given a customer registers with username <username> and email "don@improving.com"
    And member <member> has <start balance> miles
    When member purchases <quantity> seat upgrade
    Then member has <upgrades> upgrades
    And that member has <end balance> balance miles
    
    Examples:
    |username|start balance|quantity|upgrades|end balance|
    |"red1"	 |10000		   |1		|1		 |0			 |
    |"red2"	 |30000		   |2		|2		 |10000		 |
    |"green" |40000		   |1		|1		 |31000		 |
    |"blue"  |70000		   |1		|1		 |62000		 |
    |"gold1" |100000	   |1		|1		 |93000		 |
    |"gold2" |100000	   |10		|10		 |30000		 |
    |"broke" |10000		   |2		|0		 |10000		 |