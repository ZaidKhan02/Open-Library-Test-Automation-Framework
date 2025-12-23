Feature: Login Feature

  Scenario: Login Success
    #Given I open the browser
    And I am on the Login Page
    When I enter the email "zk7832456@gmail.com"
    And I enter the password "zk7832456pw"
    And I click the login button
    Then I am logged in
