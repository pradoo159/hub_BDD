package br.com.rsinet.hub_bdd.cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://advantageonlineshopping.com/");

		WebElement botaoLogin = driver.findElement(By.id("hrefUserIcon"));
		botaoLogin.click();

		driver.findElement(By.name("username")).sendKeys("emerson.prado");
		driver.findElement(By.name("password")).sendKeys("Teste@1234");

		Thread.sleep(2000);

		driver.findElement(By.id("sign_in_btnundefined")).click();

		System.out.println("Logado com sucesso");

		Thread.sleep(2000);

		driver.findElement(By.id("menuUserLink")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"loginMiniTitle\"]/label[3]")).click();

		System.out.println("Deslogado com sucesso");

		Thread.sleep(2000);

		driver.quit();

	}

}
