package br.com.rsinet.hub_bdd.stepDefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;
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

 

    public ProductsPageSteps(TestContext context) {
        testContext = context;
        products = testContext.getPageObjectManager().getProductsPage();
        manager = testContext.getWebDriverManager();
        this.driver = manager.getDriver();
    }

    @When("^User click on chosen laptop$")
    public void user_click_on_chosen_laptop() throws Throwable {
    	products.close_Search();
    	
    }

    @Then("^Laptop Chosed page will be displayed$")
    public void laptop_Chosed_page_will_be_displayed() throws Throwable {
    	Wait.untilJqueryIsDone(driver);
    	assertEquals(products.getTitleText(), "HP PAVILION 15T TOUCH LAPTOP");
    	Print_Func.captureScreenShot(driver);
    }
    
    // Invalid Search
    
    @Then("^An Error message will be displayed$")
    public void an_Error_message_will_be_displayed() throws Throwable {
    	assertTrue(products.getErrorText().contains("No results for"));
    	Print_Func.captureScreenShot(driver);
    }
    
}

