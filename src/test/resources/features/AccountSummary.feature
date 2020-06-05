Feature: Account Summary

  @wip
  Scenario: Verify Account Summary Page
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"
    And the title should be "Zero - Account Summary"
    Then the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And user should see following options under Credit Accounts
      | Account     |
      | Credit Card |
      | Balance     |

