Feature: Checking the functionalities with DataTable

  Scenario: Paasing the values as parameters at step level
    Given User should be on Automation testing page
    When User click and enter the value in the firstname
      | Naruto | Hinata |
      | Bheem  | Chutki |
    And User click and enter the value in email
      | naruto00@naruto.com |
      |          1234567890 |
      | China               |
