import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class PurchaseOrderWithMandatoryFiled {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
/* Object Creation for Libraries*/
		
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib =new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		
		/*Common Data From Properties*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
	
		/* Excel data*/
		String PO_Subject = eLib.getDataFromExcel("purchase order", 8, 0);
		String VendorName = eLib.getDataFromExcel("vendors", 8, 0);
		String VendorAdd = eLib.getDataFromExcel("vendors", 8, 1);
		String ProductName = eLib.getDataFromExcel("Product", 8, 0);
		String ProductQnty = eLib.getDataFromExcel("Product", 8, 1);
		String ListPrice = eLib.getDataFromExcel("Product", 8, 2);
		
		/* launch the browser*/
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		
		/* login to application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/* create vendor for Selecting in purchase order*/
		WebElement moreVendor = driver.findElement(By.xpath("//a[text()='Dashboard']/../following-sibling::td[2]/a"));
		wLib.mouseOverOnElement(driver, moreVendor);
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.cssSelector("img[title='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(VendorName);
		driver.findElement(By.name("street")).sendKeys(VendorAdd);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		
		/* Create Product for Selecting in Purchase Order*/
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.id("unit_price")).sendKeys(ListPrice);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		/* navigate to purchase order*/
		WebElement morePO = driver.findElement(By.xpath("//a[text()='Dashboard']/../following-sibling::td[2]/a"));
		wLib.mouseOverOnElement(driver, morePO);
		driver.findElement(By.linkText("Purchase Order")).click();
		
		/* create purchase order*/
		driver.findElement(By.cssSelector("img[title='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(PO_Subject);
		driver.findElement(By.xpath("//input[@name='vendor_id']/following-sibling::img")).click();
		
		/* window handle switch to child window*/
		wLib.switchToWindow(driver, "Vendors&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(VendorName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+VendorName+"']")).click();
		
		/* switch to main window*/
		wLib.switchToWindow(driver, "Purchase Order");
		
		/* click on item + image*/
		driver.findElement(By.id("searchIcon1")).click();
		
		/* window handle switch to child window*/
		wLib.switchToWindow(driver, "Products&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(ProductName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		
		wLib.switchToWindow(driver, "Purchase Order");
		/*enter quantity*/
		driver.findElement(By.id("qty1")).sendKeys(ProductQnty);
		
		//Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		String ProductActual = driver.findElement
				(By.xpath("//div[@id='tblDescriptionInformation']/following-sibling::table//tr[3]/td")).getText();
		
		/* validate*/
		if(ProductActual.contains(ProductName)) {
			System.out.println("Product Displayed");
			System.out.println("Test Case Pass");
		}else {
			System.out.println("Product Not Displayed");
			System.out.println("Test Case Fail");
		}
		
		/*logout*/
		WebElement logout = driver.findElement
				(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]/img"));
		wLib.mouseOverOnElement(driver, logout);
		driver.findElement(By.linkText("Sign Out")).click();
		
		/*close */
		driver.close();
	}


	}


