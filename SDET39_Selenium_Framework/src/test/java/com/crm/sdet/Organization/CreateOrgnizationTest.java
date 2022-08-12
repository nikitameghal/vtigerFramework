	package com.crm.sdet.Organization;

import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.Generic_Utility.BaseClass;
import com.Vtiger.Generic_Utility.Excel_Utility;
import com.Vtiger.Generic_Utility.Java_Utility;
import com.Vtiger.Generic_Utility.Property_Utility;
import com.Vtiger.Generic_Utility.WebDriver_Utility;
import com.Vtiger.Object_Reposiratory.HomePage;
import com.Vtiger.Object_Reposiratory.NewOrganizationPage;
import com.Vtiger.Object_Reposiratory.OrganizationPage;
import com.Vtiger.Object_Reposiratory.OrganizationValidation;
import com.Vtiger.Object_Reposiratory.loginPage;

@Listeners(com.Vtiger.Generic_Utility.ListenerImplementationClass.class)
public class CreateOrgnizationTest extends BaseClass{

	@Test(groups= {"smokeTest"})
	public void createOrganization() throws Throwable {
			 Property_Utility plib = new Property_Utility();
			 Java_Utility jlib = new Java_Utility();
			 Excel_Utility elib = new Excel_Utility();
			 WebDriver_Utility wlib=new WebDriver_Utility();
			 
					
//			 String Url=plib.getPropertyKeyValue("Url");
//			 String Username=plib.getPropertyKeyValue("UN");
//			 String Password=plib.getPropertyKeyValue("PSD");
//			
//			 WebDriver driver =new ChromeDriver();
			 driver.manage().window().maximize();
			 wlib.WebDriverPageToLoad(driver);
			 
			 
//			 driver.get(Url);
//		   
//		     loginPage login=new loginPage(driver);
//		     login.login(Username,Password);
		      
		     HomePage home=new HomePage(driver);
		     home.OrganizationModule();
		      
		     OrganizationPage organizationpage=new OrganizationPage(driver);
		     organizationpage.OrganizationPage();
		     
		      
			 int RanNum=jlib.getRandomNum();
			 String orgName = elib.getDataFromExcel("Organization",1,0)+RanNum;
				 
			 NewOrganizationPage orgpage=new NewOrganizationPage(driver);
		     orgpage.NewOrganizationPage(orgName);
		     orgpage.SaveButton();
				
				
				//driver.findElement(By.name("accountname")).sendKeys(orgName);
				//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
//				String actData = driver.findElement(By.className("dvHeaderText")).getText();
//				System.out.println(actData);
//				
//				if(actData.contains(orgName))
//				{
//					System.out.println("pass");
//				}
//				else
//				{
//					System.out.println("Fail");
//				}
				
		     
		     OrganizationValidation actualOrganizationName = new OrganizationValidation(driver);
		     String actualOrganizationData = actualOrganizationName.actualOrganizationName();
		     Assert.assertEquals(actualOrganizationData.contains(orgName), true);
		     
			 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
             wlib.mouseOverOnElement(driver, element);
			 home.SignOutButton();
			 driver.close();
		}






	}


