package practise;

import org.testng.annotations.Test;

import com.crm.autodessk.ObjectRepository.ContactPage;
import com.crm.autodessk.ObjectRepository.ContactainfoPage;
import com.crm.autodessk.ObjectRepository.CreateContactPage;
import com.crm.autodessk.ObjectRepository.HomePage;
import com.vtiger.comcast.genericUtility.BaseClass;

public class CreateContactTestNg extends BaseClass{
	

	
	
	@Test(groups = "SmokeSuite")
	
	public void CreateContect() throws Throwable {
		
		int ranDomnum = jLib.getRanDomNumber();
		
		//get data from excel
		String ConNAME = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomnum;	
		String lastn = eLib.getDataFromExcel("Sheet1", 10, 3);
		
		//navigate to organization module
    	HomePage hp = new HomePage(driver);
    	hp.clickonorganizationsLinks();
    	
    	//click on create Contact button
    	ContactPage cp =  new ContactPage(driver);
    	cp.clickoncreateCon();
    	
    	//Enter all the details and create new Contact
    	CreateContactPage ccp = new CreateContactPage(driver);
    	ccp.createContact(lastn);
    	
    	//Verify Contact name in header of mgs	
    	ContactainfoPage cip =  new ContactainfoPage(driver);
    	String Act_mgs = cip.getcontactinfo();
    	
    	if(Act_mgs.contains(lastn)) {
    		System.out.println(Act_mgs);
    		System.out.println("Contacts created Successfully");
    	}else {
    		System.err.println("Failed");
    	}
    	
    	
	
		
		
		
	}

}
