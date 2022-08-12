package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testOrgnization {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./CommonProperties.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		
		 String Url=pobj.getProperty("Url");
		 String UN=pobj.getProperty("UN");
		 String PW=pobj.getProperty("PSD");
		
		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		   driver.get(Url);
		   driver.findElement(By.name("user_name")).sendKeys(UN);
		   driver.findElement(By.name("user_password")).sendKeys(PW);
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		    Random ran =new Random();
		    int ranNum = ran.nextInt(1000);
		    FileInputStream fis1=new FileInputStream("./Book1.xlsx"); 
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet(" Organization");
			
			
			Row r= sh.getRow(1);
			Cell cel = r.getCell(0);
			String orgName = cel.getStringCellValue()+ranNum;
			System.out.println(orgName);
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String actData = driver.findElement(By.className("dvHeaderText")).getText();
			System.out.println(actData);
			if(actData.contains(orgName))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("Fail");
			}
			
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
				
			driver.findElement(By.linkText("Sign Out")).click();

			 
			 driver.close();
	}



	}


