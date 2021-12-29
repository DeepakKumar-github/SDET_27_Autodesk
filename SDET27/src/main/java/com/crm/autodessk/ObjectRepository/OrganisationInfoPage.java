package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
	@FindBy (xpath ="//span[@class='dvHeaderText']")
	private	WebElement orgHeaderText;

	public OrganisationInfoPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
	
	public WebElement getorgHeaderText (){
	return getorgHeaderText();
	}

	//business library
	 
	public String getOrgInfo()
	{
	 return(orgHeaderText.getText());
	}


}
