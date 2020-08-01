@omer

Feature: Users should be able to login
Background:
  Given the user is on the Home Page
  When the user navigate to Login Page

  Scenario: Login with valid credentials

    Then the user logs in using "username" and "password"
    Then the user should be able to login
    And  Account Summary page should be displayed

  Scenario: Login with invalid username credential

    Then the user enter the wrong username, valid password
    Then the user should not be able to login
    And message should be displayed "Login and/or password are wrong."


  Scenario: Login with invalid username credential

    Then the user enter the valid username, wrong password
    Then the user should not be able to login
    And message should be displayed "Login and/or password are wrong."

