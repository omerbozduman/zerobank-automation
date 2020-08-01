Feature: Check & Control Summary table under My Money Map Page
  User compares summary tables under th My Money Map Page tab

  Background:
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"

    @xyz
  Scenario: Check the Summary Schema's Data
      Then the user navigate to "My Money Map" tab
      When table should displays summaryrows
      Then system should compare infos between "Total Inflow" and "Deposits"
      Then system should compare infos between "Total Outflow" and "Spendings"
      Then verify "What's Left" amount is correct