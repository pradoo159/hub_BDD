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

	@When("^Preencher os campos com dados válidos$")
	public void preencher_os_campos_com_dados_válidos() throws Throwable {
		Reporter.addStepLog("Fazendo o cadastro com dados válidos");
		registerPage.completeValidRegister();
	}

	@Then("^Será redirecionado para a página inicial com a conta logada$")
	public void será_redirecionado_para_a_página_inicial_com_a_conta_logada() throws Throwable {
		Reporter.addStepLog("Mensagem de sucesso");
		System.out.println("Registered!");
	}

	// Invalid Register

	@When("^Preencher os campos com dados inválidos$")
	public void preencher_os_campos_com_dados_inválidos() throws Throwable {
		Reporter.addStepLog("Fazendo cadastro de usuário já cadastrado");
		registerPage.completeFailRegister();
	}

	@Then("^O usuário receberá um erro e continuará na mesma página$")
	public void o_usuário_receberá_um_erro_e_continuará_na_mesma_página() throws Throwable {
		Reporter.addStepLog("Mensagem de falha");
		System.out.println("Register Fail, invalid data!");
	}
}
