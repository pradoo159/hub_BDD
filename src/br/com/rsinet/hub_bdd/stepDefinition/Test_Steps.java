package br.com.rsinet.hub_bdd.stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	public static WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
	}

	@When("^User Navigate to Register Page$")
	public void user_Navigate_to_Register_Page() throws Throwable {
		driver.findElement(By.id("menuUserLink")).click();
		WebElement createAcc = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createAcc));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", createAcc);
	}

	@When("^User enters data to register$")
	public void user_enters_credentials_to_register() throws Throwable {
		driver.findElement(By.name("usernameRegisterPage")).sendKeys("pradoov012");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("emersonpradoo@hotmail.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Teste@1234");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Teste@1234");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Emerson");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Prado");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("13997420076");

		Select country = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		country.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Osasco");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Avenida dos remédios");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("06293110");
		driver.findElement(By.name("i_agree")).click();

		driver.findElement(By.id("register_btnundefined")).click();
	}

	@Then("^Message displayed Register Successfully and close Browser$")
	public void message_displayed_Register_Successfully() throws Throwable {
		System.out.println("sucesso");
		driver.close();
	}
	
	@When("^Search by Laptop$")
	public void search_by_Laptop() throws Throwable {
	   WebElement search = driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a"));
	   WebElement searchField = driver.findElement(By.id("autoComplete"));
	   search.click();
	   searchField.sendKeys("Laptop", Keys.ENTER);
	   
	}

	@When("^Click on the first result$")
	public void click_on_the_first_result() throws Throwable {
	    WebElement firstResult = driver.findElement(By.linkText("HP ENVY - 17t Touch Laptop"));
	    firstResult.click();
	}

	@Then("^The title of product must be correct and close Browser$")
	public void the_title_of_product_must_be_correct() throws Throwable {
		WebElement productElement = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));
		String productTitle = productElement.getText();
	    String productName = "HP ENVY - 17t Touch Laptop".toUpperCase();
	    assertEquals(productName.equals(productTitle), true);
	    driver.close();
	}

}
