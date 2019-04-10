#Author: juan@santisi.io
#Keywords Summary : SFDC Login Action
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
@loginTest
Feature: SFDC Login Action
  I want to use this template for my feature file

  @Scenario1
  Scenario: Successful Login with Valid Creds
    Given User is on Login Page
    And User enters Username and Password
    When The User click's Login Button
    Then User is taken to the Home Page
