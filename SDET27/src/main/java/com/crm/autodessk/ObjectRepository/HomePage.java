package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{ //Step 1: create a separate class for home page
	
	//Step 2 : Declaration
	@FindBy (linkText = "Organizations")
	private WebElement OrganisationLnk;
	
	@FindBy (linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy (linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy (linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy (linkText = "Documents")
	private WebElement DocumentsLnk;
	
	@FindBy (linkText = "Email")
	private WebElement EmailLnk;
	
	@FindBy (linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLnk;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//Step 3 Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Steps 4 Utilization
	
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}

	public WebElement getEmailLnk() {
		return EmailLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public WebElement getOrganisationLnk() {
		return OrganisationLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return TroubleTicketsLnk;
	}


	//business
	public void clickonorganizationsLinks() {
	OrganisationLnk.click();
	
	}
	public void clickcontactLink() {
	ContactsLnk.click();
	}
	
	//Business Library to click on organizations
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver,administratorImg);
		signOutLnk.click();
	}
}
	