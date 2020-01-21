package br.com.rsinet.hub_bdd.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_bdd.dataProvider.ConfigFileReader;
import br.com.rsinet.hub_bdd.managers.FileReaderManager;

public class DriverFactory {
	
	static ConfigFileReader configFileReader;

	public static WebDriver iniciaChrome() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}
	
	public static void abrirSite(WebDriver driver) {
		if(driver != null)
			configFileReader = new ConfigFileReader();
			driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		
	}

	public static void FechaChrome(WebDriver driver) {
		if(driver != null)
			driver.close();

	}

}
