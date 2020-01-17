Feature: Login Action 

Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to Register Page 
	And User enters data to register 
	Then Message displayed Register Successfully and close Browser

Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When Search by Laptop 
	And Click on the first result
	Then The title of product must be correct and close Browser
