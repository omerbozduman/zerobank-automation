
Feature:Account Activity

Background:
  Given the user is on the Home Page
  When the user navigate to Login Page
  Then the user logs in using "username" and "password"
  Then the user navigate to "Account Activity" tab


  Scenario:  Verify Account Activity Page
    And the title should be "Zero - Account Activity"


  Scenario:  Verify Account Activity tab Account dropdown default option
    Then Account drop down should have "Savings" selected


  Scenario:  Verify Account Activity tab Account dropdown options
    And the user should see following dropdown options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario:  Verify Account Activity tab Transactions options
    And user should see following options on Transactions table
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |