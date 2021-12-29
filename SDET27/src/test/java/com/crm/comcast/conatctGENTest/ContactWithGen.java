package com.crm.comcast.conatctGENTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodessk.ObjectRepository.ContactPage;
import com.crm.autodessk.ObjectRepository.CreateContactPage;
import com.crm.autodessk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodessk.ObjectRepository.HomePage;
import com.crm.autodessk.ObjectRepository.LoginPage;
import com.crm.autodessk.ObjectRepository.OrganizationPage;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class ContactWithGen extends BaseClass{
	public void createContactWithGen() throws Throwable {
		
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		
		 /* read test data from Excel File*/

		    String orgName = eLib.getDataFromExcel("sheet3", 1, 3) + randomNum;
		    String conactName = eLib.getDataFromExcel("sheet3", 1, 3) + randomNum;
	
         /* step 1 : navigate to Org Page */ 
        
          
         HomePage hp = new HomePage(driver);
         hp.clickonorganizationsLinks();
           

         /* step 2 :  navigate to CREATE  Org Page*/
     
         OrganizationPage op = new OrganizationPage(driver);
         op.clickOnCreateOrg();
         
         CreateOrganizationPage co = new CreateOrganizationPage(driver);
         co.createorg(orgName);
        
         /* step 3 : create a new Org */
         
     //  driver.findElement(By.className("dvHeaderText")).click();
         
         ContactPage cp=new ContactPage(driver);
         cp.getClickOnContactsLink().click();

        // wLib.waitForElementToBeClickAble(driver, headerWb);
         
         // click on contact
         
         /* step 4 : navigate to Contact Page */
        hp.clickcontactLink();        
  
        cp.clickoncreateCon();
        		
        
        
         /* step 5 :  navigate to CREATE  Contact Page*/ 
         
         CreateContactPage ccp = new CreateContactPage(driver);
         ccp.createContact(conactName);
         
        
         
         /* step 6 : create a new contact With org Name */
         ccp.getContactLastNameEdt().sendKeys(conactName);
         ccp.getOrgNameLookUpImg().click();
       
 
          wdLib.switchToWindow(driver, "Accounts");
          op.getSearchTextEdt().sendKeys(orgName);
          op.getSearchnowBtn().click();
    
    
         driver.findElement(By.name("search_text")).sendKeys(orgName);
         driver.findElement(By.name("search")).click();
         driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
         wdLib.switchToWindow(driver, "Contacts");
         
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}


}

	
