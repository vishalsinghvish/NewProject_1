package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.BasePage;
import com.pack.common.pageobjects.CreateAccountPage;
import com.pack.common.pageobjects.SignInPage;

public class CreateAccountPageTest extends TestBaseSetup {
	
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	private CreateAccountPage createAccountPage;
	
	@BeforeClass
	public void setup(){
		driver = getDriver();
	}
	
	@Test
	public void verifyCreateAnAccountPage() throws InterruptedException{
		System.out.println("Create an account page test...");
		basePage = new BasePage(driver);
		signInPage = basePage.clickSignInBtn();
		Thread.sleep(5000);
		createAccountPage = signInPage.clickonCreateAnAccount();
		Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
		Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
	}
	
//	public void verifySignInFunction(){
//		
//	}

}
