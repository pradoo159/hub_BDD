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


    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        home.navigateTo_HomePage();
        Reporter.addStepLog("Entrando na página inicial");
    }

 
    //Register Valid/Invalid
    @When("^User Navigate to Register Page$")
    public void user_Navigate_to_Register_Page() {
    	home.click_MyAccount();
    	login.click_CreateAccount();
    	Reporter.addStepLog("Entrando na página de cadastro");
    }
    
    // Valid/Invalid Search By Text
    @When("^User click on search button$")
    public void user_click_on_search_button() throws Throwable {
    	home.menu_Search();
    	Reporter.addStepLog("Clicando no botão pesquisar");
    }
    
    // Valid Search By Text
    @When("^User enters data to search$")
    public void user_enters_data_to_search() throws Throwable {
    	home.auto_Complete(Data.nomeLaptop());
    	Reporter.addStepLog("Procurando por um produto válido");
    }
    
    // Invalid Search By Text
    @When("^User enters invalid data to search$")
    public void user_enters_invalid_data_to_search() throws Throwable {
        home.auto_Complete(Data.pesquisaInvalida1());
        Reporter.addStepLog("Procurando por um produto inválido");
    }
    
    // Valid Search By Image
    @When("^User click on the desired category$")
    public void user_click_on_the_desired_category() throws Throwable {
    	home.click_CategoryTablet();
    	Reporter.addStepLog("Clicando em uma categoria válida");
    }

    //Invalid Search By Image
    @When("^User click on view details$")
    public void user_click_on_view_details() throws Throwable {
    	home.click_ViewDetails();
    	Reporter.addStepLog("Clicando no produto com erro");
    }

}

