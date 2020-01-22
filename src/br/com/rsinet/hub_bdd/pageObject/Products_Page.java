package br.com.rsinet.hub_bdd.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products_Page {
	
	WebDriver driver;
	
	public Products_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "HP ElitePad 1000 G2 Tablet")
	private WebElement lnk_Tablet;

	@FindBy(how = How.LINK_TEXT, using = "HP Pavilion 15t Touch Laptop")
	private WebElement lnk_Laptop;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private WebElement txt_NoResult;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	private WebElement title_Product;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	private WebElement closebtn_Search;
	
	public void close_Search() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(closebtn_Search));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", closebtn_Search);
	}
	
	public void click_Laptop() {
		lnk_Laptop.click();
	}
	
	public String getTitleText() {
		return title_Product.getText();
	}
	
	public String getErrorText() {
		return txt_NoResult.getText();
	}
	
}
