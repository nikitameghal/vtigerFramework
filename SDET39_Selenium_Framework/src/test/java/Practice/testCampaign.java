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

import com.Vtiger.Generic_Utility.Excel_Utility;
import com.Vtiger.Generic_Utility.Java_Utility;
import com.Vtiger.Generic_Utility.Property_Utility;

public class testCampaign {

	public static void main(String[] args) throws Throwable {
		
		//create campaign
		//FileInputStream fis = new FileInputStream("./CommonProperties.properties");
		//Properties pobj = new Properties();
		//pobj.load(fis);
		
		 Property_Utility plib = new Property_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
	
		 String Url=plib.getPropertyKeyValue("Url");
		 String Username=plib.getPropertyKeyValue("UN");
		 String Password=plib.getPropertyKeyValue("PSD");
		
		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get(Url);
		 driver.findElement(By.name("user_name")).sendKeys(Username);
		 driver.findElement(By.name("user_password")).sendKeys(Password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 WebElement element = driver.findElement(By.xpath("//a[text()='More']"));

			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
			
			driver.findElement(By.name("Campaigns")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();	
			
			//Random ran =new Random();
			//int ranNum = ran.nextInt(1000);
			int RanNum=jlib.getRandomNum();
			
			String campaignName = elib.getDataFromExcel("Campaign", 1, 0)+RanNum;
			 
			//FileInputStream fis1=new FileInputStream("./Book1.xlsx"); 
			//Workbook wb = WorkbookFactory.create(fis1);
			//Sheet sh = wb.getSheet("Campaign");
				
			//	Row r= sh.getRow(1);
				//Cell cel = r.getCell(0);
				//String campaignName = cel.getStringCellValue()+ranNum;
				System.out.println(campaignName);
				
				driver.findElement(By.name("campaignname")).sendKeys(campaignName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(actData);
				if(actData.contains(campaignName))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

				
				a.moveToElement(ele).perform();
					
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(3000);
				 
				 driver.close();
		}
			

	}

