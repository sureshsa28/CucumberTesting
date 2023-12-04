Feature: Implemennting the DataTable

  Scenario: Validate the Patient form
    Given Patient should be on the openMRS login page
    When User given the username and password
      | Username | Password |
      | Admin    | Admin123 |
    And Patient click location and login button
    And Patient select Register a patient details button
    And Patient enter the value in firstname and lastname
      | Firstname | Familyname | DOB           |
      | Tamil     | English    | 22,March,1996 |
