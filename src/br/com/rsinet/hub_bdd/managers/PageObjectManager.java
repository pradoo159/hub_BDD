package br.com.rsinet.hub_bdd.managers;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.pageObject.Home_Page;
import br.com.rsinet.hub_bdd.pageObject.LogIn_Page;
import br.com.rsinet.hub_bdd.pageObject.Products_Page;
import br.com.rsinet.hub_bdd.pageObject.Register_Page;

public class PageObjectManager {
	
	private WebDriver driver;
	private Home_Page homePage;
	private Register_Page registerPage;
	private LogIn_Page loginPage;
	private Products_Page productsPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Home_Page getHomePage() {
		return (homePage == null) ? homePage = new Home_Page(driver) : homePage;
	}
	
	public LogIn_Page getLoginPage() {
		return (loginPage == null) ? loginPage = new LogIn_Page(driver) : loginPage;
	}
	
	public Register_Page getRegisterPage() {
		return (registerPage == null) ? registerPage = new Register_Page(driver) : registerPage;
	}
	
	public Products_Page getProductsPage() {
		return (productsPage == null) ? productsPage = new Products_Page(driver) : productsPage;
	}

}
