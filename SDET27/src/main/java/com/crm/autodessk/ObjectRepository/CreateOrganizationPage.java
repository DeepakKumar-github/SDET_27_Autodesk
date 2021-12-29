package com.crm.autodessk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility  {
	
	//step 1 : create separate page for homepage
	
		//step2 : identify all webelement and declare them as private

		
		@FindBy(name  ="accountname")
		private WebElement organizationNameEdt;
		
		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(name ="accounttype")
		private WebElement typeDropDown;
		
		@FindBy(xpath  ="//input[@value='T']")
		private WebElement assigntogrpclk; 
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//step 3 : initialization
		public CreateOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		//step 4 utilization
		public WebElement getOrganizationNameEdt() {
			return organizationNameEdt;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}

		public WebElement getTypeDropDown() {
			return typeDropDown;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		public WebElement getAssigntogrpclk() {
			return assigntogrpclk;
		}
		
		
		//businuss libaray for create organization
		
		public void createorg(String orgName) {
			
			organizationNameEdt.sendKeys(orgName);
			assigntogrpclk.click();
		

			saveBtn.click();
		}
			
			
			//businuss libaray for create organization with industry drop down
			
			public void createorgwithIndustry(String orgName, String industryType,String type) {
				organizationNameEdt.sendKeys(orgName);
				select(industryDropDown, industryType);
				select(typeDropDown, type);
				saveBtn.click();
								}
			public void AssignToGrpClk(String Assign) {
				
				assigntogrpclk.click();
			}
	

}
