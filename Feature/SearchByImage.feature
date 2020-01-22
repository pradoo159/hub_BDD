Feature: Search By Image Action
 
@SearchByImageTest @Valid
Scenario: Successful Search By Image
	Given User is on Home Page 
	When User click on the desired category
	And User click on chosen tablet 
	Then Tablet Chosed page will be displayed 
	
@SearchByImageTest @Invalid
Scenario: Fail Search By Image
	Given User is on Home Page 
	When User click on view details
	Then Another laptop page will be displayed