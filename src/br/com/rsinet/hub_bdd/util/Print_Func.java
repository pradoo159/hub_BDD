package br.com.rsinet.hub_bdd.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Print_Func {

	public static void captureScreenShot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\emerson.prado\\eclipse-toolsqa\\workspace-cucumber\\ProjetoLoja"
					+ "\\screenshots\\"	+ System.currentTimeMillis() + ".png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

	}

}