package com.crm.PurchaseOrdrTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

	
public class CreatePurchaseOrderTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jLib= new JavaUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 FileUtility fLib = new FileUtility();
		 WebDriverUtility wLib = new WebDriverUtility();
		 
		// random number
		 int randomNum = jLib.getRanDomNumber();
		 
		 
		 // read data from properties file
		
		//FileInputStream fis = new FileInputStream("./data1/commondata.properties");
		//Properties pobj = new Properties();
		//pobj.load(fis);
		
		
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		String browser = fLib.getPropertyKeyValue("browser");
		
		// launching of browser
		WebDriver driver = new ChromeDriver();
		
		// Maximization of browser
		driver.manage().window().maximize();
		
		 // implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// open application
		driver.get(url);
		
		// login
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
	
  WebElement more = driver.findElement(By.xpath("//table[@class='hdrTabBg']//td[22]"));
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.cssSelector("img[alt='Create Purchase Order...']")).click();
		
		
		 String Subject = eLib.getDataFromExcel("sheet3", 1, 1);
		FileInputStream fis1 = new FileInputStream("./data1/testdata1.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		String subject = wb1.getSheet("Sheet3").getRow(1).getCell(0).getStringCellValue() + randomNum;
		//String status = wb1.getSheet("Sheet3").getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(Subject);
		
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling :: img")).click();
       String mainId = driver.getWindowHandle();
       Set<String> allId = driver.getWindowHandles();
       for(String id : allId) {
    	   if(!mainId.equals(id)) {
    		   wLib.switchToWindow(driver, id);
    		   //driver.switchTo().window(id);
    		   driver.findElement(By.linkText("Mary")).click();
    		   driver.switchTo().window(mainId);
    		   
    		WebElement status  = driver.findElement(By.name("postatus"));
    		Select s = new Select(status);
    		s.selectByIndex(1);
    		
    		driver.findElement(By.id("searchIcon1")).click();
    		String mainId1 = driver.getWindowHandle();
    	       Set<String> allId1 = driver.getWindowHandles();
    	      for(String id1 : allId1) {
    	    	  
    	       if(!mainId1.equals(id1)) {
    	    	   
    	    	   
    	    		   driver.switchTo().window(id1);
    	    		   driver.findElement(By.id("all_contacts")).click();
    	    		   driver.findElement(By.linkText("Vtiger Single User Pack")).click();
    	    		  driver.switchTo().window(mainId1);
    	    		  
    	    		  driver.findElement(By.id("qty1")).sendKeys("100");
    	    		  
    	    		  driver.findElement(By.xpath("//input[@type='submit']")).click();
    	    		  
    	    		  /**
    	    		   * verify purchase order header message
    	    		   */
    	    		   String captureSrc_img = driver.findElement(By.className("lvtHeaderText")).getText();
    	    		  if(captureSrc_img.contains(Subject)) {
    	    			  System.out.println("purchase order information created sucessfuly..PASS");
    	    		  }else{
    	    			  System.out.println("purchase order information not created sucessfuly..FAIL");
    	    			 
    	    		  } 
    	    		  
    	    		   
    	    			 act.moveToElement(driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"))).perform();
    	    			 driver.findElement(By.linkText("Sign Out")).click();
    	    			 driver.close();
    	    			 
    	    		  }
    	      }
    	   }
       }
	}}
    	    		  
    	   
       

	

       
