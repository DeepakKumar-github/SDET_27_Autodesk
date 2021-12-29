package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility { //Step 1: create a separate class for web page

	//Step 2 identify all WebElements and Declare them as private
	@FindBy (name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy (name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy (id = "submitButton")
	private WebElement loginBtn;
	
	//Step 3 initialize the elements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step 4 Utilization provide getter methods
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business 
    public void login(String username, String password)
    {
    	usernameEdt.sendKeys(username);
    	passwordEdt.sendKeys(password);
    	loginBtn.click();
	
	}
	
}
