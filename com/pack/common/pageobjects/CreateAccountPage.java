package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	
	private WebDriver driver;
	
	private By headerPageText= By.xpath("//*[@class='signuponepage main content clearfix']/h1");

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle(){
		String PageTitle ="Sign in - Google Accounts";
		return getPageTitle().contains(PageTitle);
	}
	
	public boolean verifyCreateAccountPageText(){
		WebElement element = driver.findElement(headerPageText);
		String PageTitle = "Create your Google Account";
		return element.getText().contains(PageTitle);
	}
	
	public void createAccount(){
		
	}

}
