package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://advantageonlineshopping.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.findElement(By.id("hrefUserIcon")).click();

		Thread.sleep(2000);

		WebElement botaoLogin = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		botaoLogin.click();

		driver.findElement(By.name("username")).sendKeys("emerson.prado");
		driver.findElement(By.name("password")).sendKeys("Teste@1234");

		driver.findElement(By.id("sign_in_btnundefined")).click();

		Thread.sleep(2000);

		String invalid = driver.findElement(By.id("signInResultMessage")).getText();

		if (invalid == "Incorrect user name or password.") {

			driver.findElement(By.name("usernameRegisterPage")).sendKeys("emerson.prado");
			driver.findElement(By.name("emailRegisterPage")).sendKeys("emerson.prado@rsinet.com.br");
			driver.findElement(By.name("passwordRegisterPage")).sendKeys("Teste@1234");
			driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Teste@1234");

			driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Emerson");
			driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Prado");
			driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("13997420076");

			Select country = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
			country.selectByVisibleText("Brazil");

			driver.findElement(By.name("cityRegisterPage")).sendKeys("Osasco");
			driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Sebastião Picão");
			driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
			driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("06293110");
			driver.findElement(By.name("i_agree")).click();

			driver.findElement(By.id("register_btnundefined")).click();
		}

		Thread.sleep(5000);

		driver.quit();

	}

}
