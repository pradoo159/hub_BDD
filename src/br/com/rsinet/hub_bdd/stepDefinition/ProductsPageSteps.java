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
	@When("^User click on chosen laptop$")
	public void user_click_on_chosen_laptop() throws Throwable {
		Reporter.addStepLog("Clicando no produto escolhido");
		products.close_Search();
		products.click_Laptop();
	}

	@Then("^Laptop Chosed page will be displayed$")
	public void laptop_Chosed_page_will_be_displayed() throws Throwable {
		Wait.untilJqueryIsDone(driver);
		Reporter.addStepLog("Mostrando a página do produto escolhido");
		assertEquals(products.getTitleText(), "HP PAVILION 15T TOUCH LAPTOP");
		Print_Func.captureScreenShot(driver);
	}

	// Invalid Search By Text
	@Then("^An Error message will be displayed$")
	public void an_Error_message_will_be_displayed() throws Throwable {
		Reporter.addStepLog("Mensagem de erro: produto não encontrado");
		assertTrue(products.getErrorText().contains("No results for"));
		Print_Func.captureScreenShot(driver);
	}

	// Valid Search By Image
	@When("^User click on chosen tablet$")
	public void user_click_on_chosen_tablet() throws Throwable {
		Reporter.addStepLog("Clicando no produto escolhido");
		products.click_Tablet();
	}

	@Then("^Tablet Chosed page will be displayed$")
	public void Tablet_Chosed_page_will_be_displayed() throws Throwable {
		Reporter.addStepLog("Mostrando a página do produto escolhido");
		String tituloProduto = products.getTitleText();
		assertEquals(tituloProduto.equalsIgnoreCase("HP ElitePad 1000 G2 Tablet"), true);
	}
	
	// Invalid Search By Image
	@Then("^Another laptop page will be displayed$")
    public void another_laptop_page_will_be_displayed() throws Throwable {
		Reporter.addStepLog("Mostrando a página de um produto diferente");
		String textoNotebookInvalido = home.title_NotebookInvalid();
		String textoNotebookValido = products.getTitleText();
		assertEquals(textoNotebookValido.equalsIgnoreCase(textoNotebookInvalido), false);
    }

}
