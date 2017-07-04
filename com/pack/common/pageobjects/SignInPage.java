package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	private WebDriver driver;
	private By headerPageText = By.xpath("//*[@class='FgbZLd']");
	private By emailTextBox = By.id("identifierId");
	private By NextBtn = By.id("//*[@class='RveJvd snByac']"); 
	private By passwordTextBox = By.id("//*[@class='whsOnd zHQkBf']");
	private By moreOptions = By.xpath("//*[@id='view_container']/form/div[2]/div/div[2]/div[2]"); 
	private By createAccountLink = By.xpath("//*[@class='z80M1'][2]"); //*[@id="SIGNUP"]/div
	private By errorMsgTxt = By.xpath("//*[@class='dEOOab RxsGPe']");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
		}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Sign in - Google Accounts";
		return getSignInPageTitle().contains(expectedTitle);
		}
	
	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		String expectedPageText = "with your Google Account";
		return pageText.contains(expectedPageText);
		}
	
	public CreateAccountPage clickonCreateAnAccount() throws InterruptedException {
		WebElement more = driver.findElement(moreOptions);
		if(more.isDisplayed()||more.isEnabled())
			more.click();
//		driver.switchTo().alert();
		WebElement element=driver.findElement(createAccountLink);
		if(element.isDisplayed()||element.isEnabled()){
			element.submit();
			Thread.sleep(10000);
		}
		return new CreateAccountPage(driver);
		}
	
	public boolean verifySignIn() {
		enterUserName("vishalsinghvish@gmail.com");
		enterPassword("afdskjb133");
		clickOnSignIn();
		return getErrorMessage().contains("Wrong");
		}
	
	public void enterUserName(String userName) {
		WebElement emailTxtBox = driver.findElement(emailTextBox);
		if(emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(userName);
		clickOnSignIn();
		}
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordTextBox);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
		}
	
	public void clickOnSignIn() {
		WebElement signInBtn = driver.findElement(NextBtn);
		if(signInBtn.isDisplayed())
			signInBtn.click();
		}
	
	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgTxt);
		if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
		}

}