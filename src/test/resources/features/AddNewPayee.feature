@wip
Feature: Add new payee under pay bills


  Background:
    Given the user is on the Home Page
    When the user navigate to Login Page
    Then the user logs in using "username" and "password"
    Then the user navigate to "Pay Bills" tab


  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed