Feature: Account Summary

  Background:
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"


  Scenario: Verify Account Summary Page
    And the title should be "Zero - Account Summary"

  Scenario: Verify on Account Summary page Account types
    Then the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Scenario: Verify on Account summary page Credit Options accounts
    And user should see following options under Credit Accounts
      | Account     |
      | Credit Card |
      | Balance     |

