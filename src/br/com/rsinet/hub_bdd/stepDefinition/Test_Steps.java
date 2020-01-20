package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.managers.PageObjectManager;
import br.com.rsinet.hub_bdd.pageObject.Home_Page;
import br.com.rsinet.hub_bdd.pageObject.LogIn_Page;
import br.com.rsinet.hub_bdd.pageObject.Register_Page;
import br.com.rsinet.hub_bdd.util.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	
	WebDriver driver;
	Home_Page home;
	Register_Page register;
	LogIn_Page login;
	PageObjectManager pageObjectManager;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = DriverFactory.iniciaChrome();
		DriverFactory.abrirSite(driver);
	}

	@When("^User Navigate to Register Page$")
	public void user_Navigate_to_Register_Page() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		home = pageObjectManager.getHomePage();
		login = pageObjectManager.getLoginPage();
		home.click_MyAccount();
		login.click_CreateAccount(driver);
	}
	
	// Valid Register

	@When("^User enters data to register$")
	public void user_enters_credentials_to_register() throws Throwable {
		register = pageObjectManager.getRegisterPage();
		register.completeValidRegister(driver);
	}

	@Then("^Message displayed Register Successfully and close Browser$")
	public void message_displayed_Register_Successfully() throws Throwable {
		System.out.println("sucesso");
		DriverFactory.FechaChrome(driver);
	}
	
	//Invalid Register
	
	@When("^User enters invalid data to register$")
	public void user_enters_invalid_data_to_register() throws Throwable {
	    register = pageObjectManager.getRegisterPage();
	    register.completeFailRegister(driver);
	}

	@Then("^Message displayed Register failed and close Browser$")
	public void message_displayed_Register_failed_and_close_Browser() throws Throwable {
		System.out.println("Register Fail, invalid data!");
		DriverFactory.FechaChrome(driver);
	}

}
