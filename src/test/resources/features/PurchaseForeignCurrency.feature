
Feature: Purchase Foreign Currency

  Background:
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"
    Then the user navigate to "Pay Bills" tab
    Then the user accesses the Purchase foreign currency cash tab

  @wip
  Scenario: Available currencies
    Then following currencies should be available
      |Australia (dollar) |
      |Canada (dollar) |
      |Switzerland (franc) |
      |China (yuan) |
      |Denmark (krone) |
      |Eurozone (euro) |
      |Great Britain (pound)|
      |Japan (yen) |
      |Mexico (peso) |
      |Norway (krone) |
      |New Zealand (dollar) |
      |Singapore (dollar) |

  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed