package com.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

public class BaseClass {

	ReadConfig read = new ReadConfig();

	public String baseUrl = read.getUrl();
	public static WebDriver driver;
	public String username = read.getUsername();
	public String password = read.getPassword();

	public static Logger logger;

	@BeforeClass
	public void setUp() {
		logger = Logger.getLogger("ITMS");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", read.getChromepath());
			driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot taken");
	}

}
