package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy (xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
//	public 
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;

	
	
	//Step 3
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 4
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
		
	}
	
	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}
	
	public WebElement getSearchnowBtn() {
		return searchNowBtn;
	}
	
	//Business library
	public void clickOnCreateOrg() 
	{
		createOrgLookUpImg.click();
	}
}
	
		

		
	

