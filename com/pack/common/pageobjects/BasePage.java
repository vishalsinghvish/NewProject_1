package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;
	private By signInButton = By.id("gb_70");
	private By imageBtn = By.xpath("//*[@class='gb_Q gb_R'][2]/a");
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public SignInPage clickSignInBtn() throws InterruptedException{

		System.out.println("Clicking on sign in button.");
		WebElement SignInBtnElement = driver.findElement(signInButton);
		if(SignInBtnElement.isDisplayed() || SignInBtnElement.isEnabled()){
			SignInBtnElement.click();
		Thread.sleep(10000);
		}
		else
			System.out.println("Element not found");
		return new SignInPage(driver);
	}
	
	
	public void ClickImagesLink(){
		
		System.out.println("Clicking in image link");
		WebElement imageBtnElement = driver.findElement(imageBtn);
		if(imageBtnElement.isDisplayed() || imageBtnElement.isEnabled())
			imageBtnElement.click();
		else
			System.out.println("Element not found");
	}
	
		public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
		public boolean verifyBasePageTitle(){
			String expectedPageTitle = "Google";
			return getPageTitle().contains(expectedPageTitle);
			
		}
		
	}