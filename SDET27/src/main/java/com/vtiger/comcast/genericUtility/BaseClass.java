package com.vtiger.comcast.genericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodessk.ObjectRepository.HomePage;
import com.crm.autodessk.ObjectRepository.LoginPage;

public class BaseClass {
	
	
	public static WebDriver sdriver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wdLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	
	public WebDriver driver;
	
	@BeforeSuite
	public void dbConnection() throws SQLException 
	{
		dLib.CreateJdbcConnection();
		System.out.println("-------DataBase Connection Sucessful");
	}
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String browser) throws Throwable
	{
	//read the data
		//String browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("Invalid Browser");
		}
		
		wdLib.waitForPageToLoad(driver);
		wdLib.windowMaximize(driver);
		driver.get(url);
		
	}
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		//read the data
		String username=fLib.getPropertyKeyValue("username");
	    String password=fLib.getPropertyKeyValue("password");
			
	    LoginPage lp=new LoginPage(driver);
	    lp.login(username, password);
	    System.out.println("-------Login Successful-------");
	}
	@AfterMethod
	public void logoutTheApp() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("------Logout is successful------");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("-------Broser is closed---------");
	}
	
	@AfterSuite
	public void closeDbConnection() throws SQLException
	{
		dLib.closeJdbcConnection(null);
	}

}
