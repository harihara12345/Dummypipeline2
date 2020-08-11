#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@ParaBankTest
Feature: ParasBank
  I want to login Parasbank site open a account and do a fund transfer

  @tag1
  Scenario Outline: To do a fund transfer in ParasBank Site
    Given I Launch the parasBank Site
    And Input the User Name and password and click login "<username>" and "<password>"
    And Navigate to Open New Account section
    When I Select the Account Type "<accounttype>" and Click Open new accountButton
    Then A New account is opened
    When I Click the Transfer Funds option
    And Input the Amount <amount> to be transferred
    And Select the Account from which transfer to happen
    And Click TransferButton
    Then Fund transfer is complete
    When I Click the Accounts Overview Option
    And Select the Account from the table
    Then Details of the Account Displayed
    And Account activity details displayed is exported to excel
    When I Click Logout option
    Then Successfully logged out from parasbank Site
  
   
Examples:

| username  | password  | accounttype| amount |
| Ha2 			| 123		    | SAVINGS    | 10			|	
|	Ha2	      |	123			  | CHECKING   | 20     |
|	Ha2		    |	123			  | CHECKING   | 30     |




   
 