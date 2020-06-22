
Feature:Pay Bills

  Background:
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"
    Then the user navigate to "Pay Bills" tab


  Scenario:  Verify Account Activity Page
    And the title should be "Zero - Pay Bills"

  Scenario:Verify Payment Operation with valid values
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Amount
    Then the user enter the Date
    Then enter the Description
    And enter pay button for payment
    Then verify "The payment was successfully submitted." message display

@test
  Scenario:Verify Payment Operation with amount field empty
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Date
    Then enter the Description
    And enter pay button for payment
    Then verify for "amount" "Please fill out this field." alert message display

  Scenario:Verify Payment Operation with enter amount as alphabetical characters
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Amount as alphabetical characters
    Then the user enter the Date
    Then enter the Description
    And enter pay button for payment
    Then verify "The payment was not successfully submitted." message display

  Scenario:Verify Payment Operation with enter amount as special characters
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Amount as special characters
    Then the user enter the Date
    Then enter the Description
    And enter pay button for payment
    Then verify "The payment was not successfully submitted." message display


  Scenario:Verify Payment Operation without date
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Amount
    Then enter the Description
    And enter pay button for payment
    Then verify for "date" "Please fill out this field." alert message display

  Scenario:Verify Payment Operation with enter date as alphabetical characters
    Then the user select the Payee
    Then the user select the account
    Then the user enter the Amount
    Then the user enter the Date as alphabetical characters
    Then enter the Description
    And enter pay button for payment
    Then verify "The payment was not successfully submitted." message display

