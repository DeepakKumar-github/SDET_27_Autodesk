package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactainfoPage {
	
	//declaration
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderlnfoText;

	//initialization
	public ContactainfoPage(WebDriver driver)
	{
	
	PageFactory.initElements(driver , this);
	}

	//utilization
	public WebElement getContactHeaderinfoText(){
		return getContactHeaderinfoText();
	}

	//business library
	public String getcontactinfo()
	{
		return (contactHeaderlnfoText.getText());
	}


}

