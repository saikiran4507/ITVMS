package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='LoginUser_UserName']")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement passwor;

	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup
	WebElement loginbtn;

	@FindBy(xpath = "//ul//a[text()='Log out']")
	@CacheLookup
	WebElement logoutbtn;

	public void setUsername(String uname) throws Exception {
		username.sendKeys(uname);
		Thread.sleep(3000);
	}

	public void setPassword(String pwd) {
		passwor.sendKeys(pwd);
	}

	public void clickSubmit() {
		loginbtn.click();
	}

//	public void clickLogout() {
//		logoutbtn.click();
//	}

}
