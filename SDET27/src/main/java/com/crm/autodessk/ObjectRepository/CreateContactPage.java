package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//step 1 : create separate page for homepage
	
		//step2 : identify all webelement and declare them as private
		
		@FindBy(name="lastname")
		private WebElement contactLastNameEdt;
		
		
		@FindBy(xpath ="//input[@name='account_name']/following-sibling::img")
		private WebElement OrgNameLookUpImg;
		
		@FindBy(xpath = "//a[@href='javascript:window.close();']")
	    private WebElement OrgNameClick;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//initialization 
		
		
		
		
		//step 4 Utilization

		public WebElement getContactLastNameEdt() {
			return contactLastNameEdt;
		}

		public WebElement getOrgNameLookUpImg() {
			return OrgNameLookUpImg;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getOrgNameClick() {
			return OrgNameClick;
		}


		//business libraries for create contacts
		public void createContact(String lastName) {
			
			contactLastNameEdt.sendKeys(lastName);
			OrgNameLookUpImg.click();
			
		}
		
		public void FetchOrgInCon(String orgname) {
			
			saveBtn.click();
		}

}
