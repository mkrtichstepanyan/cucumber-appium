Feature: Login Feature
  Description -------

  @regression @smoke @tag1
  Scenario: Login with different users
    Given App is opened
    When I select Language "Eastern Armenian"
    Then Contineue button text should be "Շարունակել"
    When I select Language "Western Armenian"
    Then Contineue button text should be "Շարունակել"
    When I select Language "English"
    Then Contineue button text should be "Continue"



    When I write username <username> and password <password>
    And I press login button
    Then I will see Home page

