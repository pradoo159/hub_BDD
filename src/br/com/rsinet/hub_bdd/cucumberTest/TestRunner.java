package br.com.rsinet.hub_bdd.cucumberTest;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.managers.FileReaderManager;
import br.com.rsinet.hub_bdd.util.LocalDate;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature", 
		glue = { "br.com.rsinet.hub_bdd" }, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, 
		monochrome = true
		)

public class TestRunner {
	
	public static String caminhoPasta = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
			+ LocalDate.horas();

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}

	/*
	 * Método que cria uma pasta por suite para armazenar screenshots dos cenários
	 */
	
	@BeforeClass
	public static void criarPastaPrint() {
		File pastaScreenshot = new File(caminhoPasta);
		pastaScreenshot.mkdir();
	}

}