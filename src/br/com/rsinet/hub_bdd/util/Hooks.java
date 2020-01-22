package br.com.rsinet.hub_bdd.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub_bdd.cucumber.TestContext;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	WebDriverManager manager;
	WebDriver driver;

	public Hooks(TestContext context) {
		testContext = context;
		manager = testContext.getWebDriverManager();
		driver = manager.getDriver();
	}

	@Before
	public void BeforeSteps() {
		manager.getDriver();
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) throws IOException {
		Wait.untilPageLoadComplete(driver);
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		// This takes a screenshot from the driver at save it to the specified location
		File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
				.getScreenshotAs(OutputType.FILE);

		// Building up the destination path for the screenshot to save
		// Also make sure to create a folder 'screenshots' with in the cucumber-report
		// folder
		File destinationPath = new File(
				System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

		// Copy taken screenshot from source location to destination location
		Files.copy(sourcePath, destinationPath);

		// This attach the specified screenshot to the test
		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}

	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().quitDriver();
	}

}
