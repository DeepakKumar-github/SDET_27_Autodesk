package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContact1 {
public static void main(String [] args ) throws IOException {
		
		// random number
		 Random ran = new Random();
		 int ranDomNum = ran.nextInt(1000);
		 
		 // read data from properties file
		FileInputStream fis = new FileInputStream("F:\\TEST YANTRA DATA\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String browser = pobj.getProperty("browser");
		
		// launching of browser
		ChromeDriver driver = new ChromeDriver();
		// Maximization of browser
		driver.manage().window().maximize();
		 // implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// open application
		driver.get(url);
		
		// read data from Excel sheet
		FileInputStream fis1 = new FileInputStream("F:\\TEST YANTRA DATA\\testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String contactname = wb.getSheet("Sheet2").getRow(3).getCell(0).getStringCellValue() + ranDomNum;
		
		// login
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		// navigate to contact
		driver.findElement(By.linkText("Contacts")).click();
		
		// navigate to create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// providing lastname from excel sheet
		driver.findElement(By.name("lastname")).sendKeys(contactname);
		
		// click on save
		driver.findElement(By.className("save")).click();
		
		//validation
		String actualText =driver.findElement(By.className("dvHeaderText")).getText();
		if(actualText.contains(contactname)) {
			System.out.println("contact creation pass");
		}
			else
			{
				System.out.println("contact creation fail");
			}
		// browser close
		driver.close();
		
		
	}
}





