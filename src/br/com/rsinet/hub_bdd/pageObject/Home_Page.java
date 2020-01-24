package br.com.rsinet.hub_bdd.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.managers.FileReaderManager;

public class Home_Page {
	WebDriver driver;
	 
	 public Home_Page(WebDriver driver){
	 this.driver = driver;
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

	@FindBy(how = How.XPATH, using = "//*[@id=\"popular_items\"]/div/div[2]/a")
	private WebElement lnk_NotebookInvalid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"popular_items\"]/div/div[2]/p")
	private WebElement txt_NotebookInvalid;
	
	@FindBy(how = How.ID, using = "searchPage")
	private WebElement container_Result;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div")
	private WebElement txt_Result;

	public void click_MyAccount() {
		lnk_LogIn.click();
	}

	public void menu_Search() {
		btn_Search.click();
	}

	public void auto_Complete(String complete) {
		txtbx_Search.sendKeys(complete);
		txtbx_Search.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(container_Result));
		wait.until(ExpectedConditions.visibilityOf(txt_Result));
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void click_CategoryTablet() {
		btn_Tablet.click();
	}
	
	public void click_ViewDetails() {
		lnk_NotebookInvalid.click();
	}
	
	public String title_NotebookInvalid() {
		return txt_NotebookInvalid.getText();
	}
	

}
