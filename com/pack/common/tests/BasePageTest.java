package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.BasePage;

public class BasePageTest extends TestBaseSetup {

	private WebDriver driver;
	
	@BeforeClass
	public void setup(){
		driver = getDriver();
	}
	
	@Test
	public void verifyHomePage(){
		System.out.println("Verifying Home page.....");
		BasePage basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}
}
