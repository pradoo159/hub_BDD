package br.com.rsinet.hub_bdd.stepDefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;
import br.com.rsinet.hub_bdd.pageObject.Home_Page;
import br.com.rsinet.hub_bdd.pageObject.Products_Page;
import br.com.rsinet.hub_bdd.util.Print_Func;
import br.com.rsinet.hub_bdd.util.Wait;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductsPageSteps {

	WebDriver driver;
	TestContext testContext;
	Products_Page products;
	WebDriverManager manager;
	Home_Page home;

	public ProductsPageSteps(TestContext context) {
		testContext = context;
		products = testContext.getPageObjectManager().getProductsPage();
		manager = testContext.getWebDriverManager();
		home = testContext.getPageObjectManager().getHomePage();
		this.driver = manager.getDriver();
	}

	// Valid Search By Text
	@When("^Clicar no laptop escolhido$")
	public void clicar_no_laptop_escolhido() throws Throwable {
		Reporter.addStepLog("Clicando no produto escolhido");
		products.close_Search();
		products.click_Laptop();
	}

	@Then("^A página do laptop escolhido será exibida$")
	public void a_página_do_laptop_escolhido_será_exibida() throws Throwable {
		Wait.untilJqueryIsDone(driver);
		Reporter.addStepLog("Mostrando a página do produto escolhido");
		assertEquals(products.getTitleText(), "HP PAVILION 15T TOUCH LAPTOP");
		Print_Func.captureScreenShot(driver);
	}

	// Invalid Search By Text
	@Then("^Uma mensagem de erro será exibida$")
	public void uma_mensagem_de_erro_será_exibida() throws Throwable {
		Reporter.addStepLog("Mensagem de erro: produto não encontrado");
		assertTrue(products.getErrorText().contains("No results for"));
		Print_Func.captureScreenShot(driver);
	}

	// Valid Search By Image
	@When("^Clicar no tablet escolhido$")
	public void clicar_no_tablet_escolhido() throws Throwable {
		Reporter.addStepLog("Clicando no produto escolhido");
		products.click_Tablet();
	}

	@Then("^A pagina do tablet escolhido será exibida$")
	public void a_pagina_do_tablet_escolhido_será_exibida() throws Throwable {
		Reporter.addStepLog("Mostrando a página do produto escolhido");
		String tituloProduto = products.getTitleText();
		assertEquals(tituloProduto.equalsIgnoreCase("HP ElitePad 1000 G2 Tablet"), true);
	}

	// Invalid Search By Image
	@Then("^Será exibida a página de outro laptop$")
	public void será_exibida_a_página_de_outro_laptop() throws Throwable {
		Reporter.addStepLog("Mostrando a página de um produto diferente");
		String textoNotebookInvalido = home.title_NotebookInvalid();
		String textoNotebookValido = products.getTitleText();
		assertEquals(textoNotebookValido.equalsIgnoreCase(textoNotebookInvalido), false);
	}

}
