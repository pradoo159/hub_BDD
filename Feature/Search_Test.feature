Feature: Search Action
 
@SearchTest @Valid
Scenario: Successful Register with Valid Credentials 
	Given User is on Home Page 
	When User click on search button 
	And User enters data to search 
	And User click on chosen laptop 
	Then Laptop Chosed page will be displayed 
	
@SearchTest @Invalid
Scenario: Successful Register with Valid Credentials 
	Given User is on Home Page 
	When User click on search button 
	And User enters invalid data to search 
	Then An Error message will be displayed