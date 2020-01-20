package br.com.rsinet.hub_bdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement lnk_LogIn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement txt_Login;
	
	@FindBy(how = How.ID, using = "searchSection")
	private WebElement btn_Search;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement txtbx_Search;

	@FindBy(how = How.ID, using = "tabletsTxt")
	private WebElement btn_Tablet;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"popular_items\\\"]/div/div[2]/a")
	private WebElement lnk_NotebookInvalid;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"popular_items\\\"]/div/div[2]/p")
	private WebElement txt_NotebookInvalid;
	
	public void click_MyAccount() {
		lnk_LogIn.click();	
	}

	public void menu_Search() {
        btn_Search.click();
    }
    
	public void auto_Complete(String complete) {
        txtbx_Search.sendKeys(complete);
    }

}
