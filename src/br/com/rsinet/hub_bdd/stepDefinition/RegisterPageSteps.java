package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;
import br.com.rsinet.hub_bdd.pageObject.Register_Page;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterPageSteps {

	WebDriver driver;
	TestContext testContext;
	Register_Page registerPage;
	WebDriverManager manager;

	public RegisterPageSteps(TestContext context) {
		testContext = context;
		registerPage = testContext.getPageObjectManager().getRegisterPage();
		manager = testContext.getWebDriverManager();
	}
	
	// Valid Register

	@When("^User enters data to register$")
	public void user_enters_data_to_register() throws Throwable {
		Reporter.addStepLog("Fazendo o cadastro com dados válidos");
		registerPage.completeValidRegister();
	}

	@Then("^Message displayed Register Successfully and close Browser$")
	public void message_displayed_Register_Successfully() throws Throwable {
		Reporter.addStepLog("Mensagem de sucesso");
		System.out.println("Registered!");
	}

	// Invalid Register

	@When("^User enters invalid data to register$")
	public void user_enters_invalid_data_to_register() throws Throwable {
		Reporter.addStepLog("Fazendo cadastro de usuário já cadastrado");
		registerPage.completeFailRegister();
	}

	@Then("^Message displayed Register failed and close Browser$")
	public void message_displayed_Register_failed_and_close_Browser() throws Throwable {
		Reporter.addStepLog("Mensagem de falha");
		System.out.println("Register Fail, invalid data!");
	}
}
