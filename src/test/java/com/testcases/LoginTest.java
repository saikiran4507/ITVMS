package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		Thread.sleep(3000);
		lp.setPassword(password);
		lp.clickSubmit();
		// logger.info("submitted button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage123")) {
			Assert.assertTrue(true);
			logger.info("Passed mama");

		}

		else {
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("failed mama");

		}

	}

}
