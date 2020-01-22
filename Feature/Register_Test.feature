Feature: Register Action 

@RegisterTest @Valid
Scenario: Successful Register with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to Register Page 
	And User enters data to register 
	Then Message displayed Register Successfully and close Browser 
	
@RegisterTest @Invalid
Scenario: Fail Register with Invalid Credentials 
	Given User is on Home Page 
	When User Navigate to Register Page 
	And User enters invalid data to register 
	Then Message displayed Register failed and close Browser