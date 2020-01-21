package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.pageObject.Home_Page;
import br.com.rsinet.hub_bdd.pageObject.LogIn_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {

	Home_Page home;
    WebDriver driver;
    TestContext testContext;
    LogIn_Page login;

 

    public HomePageSteps(TestContext context) {
        testContext = context;
        home = testContext.getPageObjectManager().getHomePage();
        login = testContext.getPageObjectManager().getLoginPage();
    }

 

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        home.navigateTo_HomePage();
    }

 

    @When("^User Navigate to Register Page$")
    public void user_Navigate_to_Register_Page() {
    	home.click_MyAccount();
    	login.click_CreateAccount();
    }
    
    @When("^User click on search button$")
    public void user_click_on_search_button() throws Throwable {
    	home.menu_Search();
    }
    
    // Valid Search

    @When("^User enters data to search$")
    public void user_enters_data_to_search() throws Throwable {
    	home.auto_Complete("Laptop");
    }
    
    // Invalid Search
    
    @When("^User enters invalid data to search$")
    public void user_enters_invalid_data_to_search() throws Throwable {
        home.auto_Complete("Invalid search");
    }

}

