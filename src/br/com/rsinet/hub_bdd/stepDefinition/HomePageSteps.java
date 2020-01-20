//package br.com.rsinet.hub_bdd.stepDefinition;
//
//import org.openqa.selenium.WebDriver;
//
//import br.com.rsinet.hub_bdd.managers.PageObjectManager;
//import br.com.rsinet.hub_bdd.pageObject.Home_Page;
//import br.com.rsinet.hub_bdd.pageObject.LogIn_Page;
//import br.com.rsinet.hub_bdd.util.DriverFactory;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
//
//public class HomePageSteps {
//	
//	WebDriver driver;
//	Home_Page home;
//	LogIn_Page login;
//	PageObjectManager pageObjectManager;
//	
//
//	@Given("^User is on Home Page$")
//	public void user_is_on_Home_Page() throws Throwable {
//		driver = DriverFactory.iniciaChrome();
//		DriverFactory.abrirSite(driver);
//	}
//
//	@When("^User Navigate to Register Page$")
//	public void user_Navigate_to_Register_Page() throws Throwable {
//		pageObjectManager = new PageObjectManager(driver);
//		home = pageObjectManager.getHomePage();
//		login = pageObjectManager.getLoginPage();
//		home.click_MyAccount();
//		login.click_CreateAccount(driver);
//	}
//
//}
