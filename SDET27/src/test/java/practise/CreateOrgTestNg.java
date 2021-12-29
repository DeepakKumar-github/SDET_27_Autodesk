package practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.autodessk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodessk.ObjectRepository.HomePage;
import com.crm.autodessk.ObjectRepository.OrganisationInfoPage;
import com.crm.autodessk.ObjectRepository.OrganizationPage;
import com.vtiger.comcast.genericUtility.BaseClass;

public class CreateOrgTestNg extends BaseClass{



    @Test(groups = "SmokeSuite")
    
    public void createOrgTestNG() throws Throwable {
    	
    	
    	int ranDomNum = jLib.getRanDomNumber(); 
    	
    	//read the data from excel file 
    	
    	String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNum;
    	
    
		//navigate to organization module
    	HomePage hp = new HomePage(driver);
    	hp.clickonorganizationsLinks();
    	
    	//click on create organization button
    	OrganizationPage op = new OrganizationPage(driver);
    	op.clickOnCreateOrg();
    	
    	//Enter all the details and create new organization
    	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    	cop.createorg(orgName);
    	
    	//Verify organization name in header of mgs
    	OrganisationInfoPage oip = new OrganisationInfoPage(driver);
    	String act_Msg = oip.getOrgInfo();
    	
    	if(act_Msg.contains(orgName)) {
    		System.out.println(act_Msg);
    		System.out.println("Organization Created Successfully");
    	}else {
    		System.err.println("Failed");
    	}	
    }
    
   @Test(groups = "SmokeSuite")
    public void Demo() {
    	
    	System.out.println("Demo");
    }

}
