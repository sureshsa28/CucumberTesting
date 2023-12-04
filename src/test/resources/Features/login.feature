Feature: Login functionality check for orange hrm page

  Background: 
    Given User should be on login page of orange hrm

  @datas
  Scenario: Checking the orange hrm login functionality with valid credentials
    When User give the username as "Admin" and password as "admin123"
    And User is clicking on the login button
    Then User must be on dashboard page

  Scenario Outline: Check the login functionality of orang hrm page with different parameters
    When User give the username as "<username>" and password as "<password>"
    And User is clicking on the login button
    Then User must be on dashboard page

    Examples: 
      | username | password |
      | suresh   | sures123 |
      | oranium  | tech123  |
      | Admin    | admin123 |
