Feature: 

  Scenario: 
    Given User should be in the telecom page
    And click add customer button
    When user enter the datas
    And click submit button
    Then output should be displayed

  Scenario: 
    Given User should be in the telecom page
    And click add customer button
    When user enter the datas.
      | surya | perumal | surya@gmail.com | chennai | 1234567890 |
    And click submit button
    Then output should be displayed

  Scenario: 
    Given User should be in the telecom page
    And click add customer button
    When user enter the datass.
      | fname   | surya              |
      | lname   | perumal            |
      | email   | suryabca@gmail.com |
      | address | chennai            |
      | phno    |         1234567890 |
    And click submit button
    Then output should be displayed

  Scenario: 
    Given User should be in the telecom page
    And click add customer button
    When user enter the datasss.
      | surya  | perumal     | surya@gmail.com  | chennai    | 1234567890 |
      | anitha | selvaraj    | anitha@gmail.com | trichy     |   12345678 |
      | kotee  | chandru     | kotee@gmail.com  | tirupathur |    3456783 |
      | indhu  | parivarthan | indhu@gmail.com  | vellore    |   23456758 |
    And click submit button
    Then output should be displayed

  Scenario: 
    Given User should be in the telecom page.
    And click add customer button
    When user enter the datass.
      | fname   | lname     | email            | address | phno |
      | saran   | sarann    | saran@gmail.com  | 3455566 |      |
      | parkavi | selvam    | par@gmail.com    | 1254321 |      |
      | buvana  | perumall  | buvan@gmail.com  |   34526 |      |
      | chithra | perumalll | chithu@gmail.com | 0985457 |      |
    And click submit button
    Then output should be displayed
