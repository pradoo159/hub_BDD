package br.com.rsinet.hub_bdd.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn_Page {
	
	public LogIn_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement txtbx_UserName;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtbx_Password;
	
	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement btn_SignIn;
	
	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement lnk_CreateAccount;
	
	public void click_CreateAccount(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lnk_CreateAccount));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lnk_CreateAccount);
	}
	
	
}
