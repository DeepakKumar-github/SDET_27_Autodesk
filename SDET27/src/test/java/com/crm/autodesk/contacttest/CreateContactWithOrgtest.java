package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericUtility.BaseClass;

public class CreateContactWithOrgtest extends BaseClass{

	public void createContactWithOrg() throws Throwable {
		// random number
		int randomNum = jLib.getRanDomNumber();
				 
		 /* read test data from Excel File*/

	    String orgName = eLib.getDataFromExcel("sheet3", 1, 3) + randomNum;
	    String conactName = eLib.getDataFromExcel("sheet3", 1, 3) + randomNum;
				
				
				
				driver.findElement(By.linkText("Organizations")).click();
				
				
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.name("industry")).click();

	}

}
