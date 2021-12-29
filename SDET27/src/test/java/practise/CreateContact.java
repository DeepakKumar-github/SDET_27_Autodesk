package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodessk.ObjectRepository.LoginPage;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateContact {
public static void main(String[] args) throws Throwable {
		
        /* create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
        FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		
		/* read common data from Properties File*/

		 String BROWER = fLib.getPropertyKeyValue("browser");
		 String URL = fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
          
		// WebDriver driver;
		 
		 
		 /* read test data from Excel File*/

		    String orgName = eLib.getDataFromExcel("contact", 4, 2) + randomNum;
		    String conactName = eLib.getDataFromExcel("contact", 4, 3) + randomNum;
		    
		    /* launch the Browser */ 
	         WebDriver driver = null;
	         if(BROWER.equals("chrome")) {
	              driver = new ChromeDriver();
	         }else if(BROWER.equals("firefox")){
	        	  driver = new FirefoxDriver();
	         }else if(BROWER.equals("ie")){
	       	  driver = new InternetExplorerDriver();
	        }else {
	            driver = new ChromeDriver();
	        }

	       wLib.waitForPageToLoad(driver);
	       driver.get(URL);
	       
	       /* step 1 : login to APP  using POM class*/ 

	          LoginPage lp = new LoginPage(driver);
	          lp.login(USERNAME, PASSWORD);
	           lp.getLoginBtn().click();
	         
		 

}
}
