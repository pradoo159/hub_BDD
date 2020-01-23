package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.pageObject.Home_Page;
import br.com.rsinet.hub_bdd.pageObject.LogIn_Page;
import br.com.rsinet.hub_bdd.util.Constant;
import br.com.rsinet.hub_bdd.util.Data;
import br.com.rsinet.hub_bdd.util.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {

	Home_Page home;
	WebDriver driver;
	TestContext testContext;
	LogIn_Page login;

	public HomePageSteps(TestContext context) throws Exception {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		login = testContext.getPageObjectManager().getLoginPage();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}

	@Given("^Usuario esteja na página inicial$")
	public void usuario_esteja_na_página_inicial() throws Throwable {
		home.navigateTo_HomePage();
		Reporter.addStepLog("Entrando na página inicial");
	}

	// Register Valid/Invalid
	@When("^Usuario navegar até a página de cadastro$")
	public void usuario_navegar_até_a_página_de_cadastro() throws Throwable {
		home.click_MyAccount();
		login.click_CreateAccount();
		Reporter.addStepLog("Entrando na página de cadastro");
	}

	// Valid/Invalid Search By Text
	@When("^Clicar no botão pesquisar$")
	public void clicar_no_botão_pesquisar() throws Throwable {
		home.menu_Search();
		Reporter.addStepLog("Clicando no botão pesquisar");
	}

	// Valid Search By Text
	@When("^Escrever o nome de um laptop$")
	public void escrever_o_nome_de_um_laptop() throws Throwable {
		home.auto_Complete(Data.nomeLaptop());
		Reporter.addStepLog("Procurando por um produto válido");
	}

	// Invalid Search By Text
	@When("^Escrever o nome de um produto inválido ou inexistente$")
	public void escrever_o_nome_de_um_produto_inválido_ou_inexistente() throws Throwable {
		home.auto_Complete(Data.pesquisaInvalida1());
		Reporter.addStepLog("Procurando por um produto inválido");
	}

	// Valid Search By Image
	@When("^Clicar na categoria desejada$")
	public void clicar_na_categoria_desejada() throws Throwable {
		home.click_CategoryTablet();
		Reporter.addStepLog("Clicando em uma categoria válida");
	}

	// Invalid Search By Image
	@When("^Usuario clicar para ver detalhes do laptop$")
	public void usuario_clicar_para_ver_detalhes_do_laptop() throws Throwable {
		home.click_ViewDetails();
		Reporter.addStepLog("Clicando no produto com erro");
	}

}
