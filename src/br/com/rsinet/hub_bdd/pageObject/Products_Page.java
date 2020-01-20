package br.com.rsinet.hub_bdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.util.Constant;
import br.com.rsinet.hub_bdd.util.ExcelUtils;

public class Products_Page {
	
	public Products_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "HP ElitePad 1000 G2 Tablet")
	private WebElement lnk_Tablet;

	@FindBy(how = How.LINK_TEXT, using = "HP Pavilion 15t Touch Laptop")
	private WebElement lnk_Laptop;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"searchPage\\\"]/div[3]/div/label/span")
	private WebElement txt_NoResult;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"Description\\\"]/h1")
	private WebElement title_Product;
	
}
