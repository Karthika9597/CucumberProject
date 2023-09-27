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

Feature: Login Functionality
 
  @login
  Scenario: Login page with Credentials
    Given User Enters the URL
    When User enters the username and password and clicks login button "karthikack" "Java@123"
    Then  validate the home page title
    
  Scenario: Login page with Valid Credentials
   Given User Enters the URL
   When User enters the username "karthikack"
   And User enters the password "Java@123"
   And Clicks the login button
   Then Validate the home page title
   And Vallidate the user icon
   But Validate that sign in button is not visible 
   But Validate that sign in icon is not visible
  
  Scenario: Login page with empty Credentials
   Given User Enters the URL
   When User enters the username ""
   And User enters the password ""
   And Clicks the login button
   Then Validate the home page title
   And Vallidate the user icon
   But Validate that sign in button is not visible 
   But Validate that sign in icon is not visible
  
   Scenario: Login page with Invalid Credentials
   Given User Enters the URL
   When User enters the username ""
   And User enters the password ""
   And Clicks the login button
   Then Validate the home page title
   And Vallidate the user icon
   But Validate that sign in button is not visible 
   But Validate that sign in icon is not visible
  
  
  
  