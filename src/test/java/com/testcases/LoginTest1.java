package com.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.LoginPage;
import com.utilities.XLUtils;

import junit.framework.Assert;

public class LoginTest1 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginDa(String user, String pwd) throws Exception

	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if (isAlertpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		
		else {
			
			Assert.assertTrue(true);
//			lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
		}
		
		

	}
	
	
	public boolean isAlertpresent()
	{
		try {
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/com/testData/LoginData (1).xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cocount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][cocount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cocount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}

		return logindata;
	}

}
