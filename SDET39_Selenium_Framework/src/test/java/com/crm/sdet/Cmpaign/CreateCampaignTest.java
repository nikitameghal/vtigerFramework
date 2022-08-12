package com.crm.sdet.Cmpaign;

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
import com.Vtiger.Object_Reposiratory.CampaignPage;
import com.Vtiger.Object_Reposiratory.CampaignValidation;
import com.Vtiger.Object_Reposiratory.CreatingNewCampaign;
import com.Vtiger.Object_Reposiratory.HomePage;
import com.Vtiger.Object_Reposiratory.loginPage;
@Listeners(com.Vtiger.Generic_Utility.ListenerImplementationClass.class)

public class CreateCampaignTest extends BaseClass{
	//create campaign
	
	@Test(groups= {"regressionTest"})
	public void createCampaign() throws Throwable {
		
		
		//object creation for generivc utility
		 Property_Utility plib = new Property_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		
		//fetching Values from proprty file		
//		 String Url=plib.getPropertyKeyValue("Url");
//		 String Username=plib.getPropertyKeyValue("UN");
//		 String Password=plib.getPropertyKeyValue("PSD");
//		
//		 WebDriver driver =new ChromeDriver();
	     driver.manage().window().maximize();
				
		 wlib.WebDriverPageToLoad(driver);
				 
		// driver.get(Url);

		 //	login to the application	 
//	     loginPage login=new loginPage(driver);
//		 login.login(Username,Password);
		 
		 //now on home page with all modules
		 HomePage home=new HomePage(driver);
	     home.MoreModule();
		 home.CampaignsModule();
		 
		 //campaign page contains create new campaign tab
		 CampaignPage campaign=new CampaignPage(driver);
		 campaign.CampaignPage();
		
		 //it take random no. to avoid duplicate
		 int RanNum=jlib.getRandomNum();
		 String campaignName = elib.getDataFromExcel("Campaign",1,0)+RanNum;
			
		 //on creating new campaign i.e, add name and save
		 CreatingNewCampaign newcampaign=new CreatingNewCampaign(driver);
		 newcampaign.CamapignName(campaignName);
		 
		 System.out.println(campaignName);
		 newcampaign.savebutton();
		 
		 //verification of page
//		 String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		 
//		 System.out.println(actData);
//		 if(actData.contains(campaignName))
//		 {
//			System.out.println("pass");
//		 }
//		 else
//		 {
//			System.out.println("Fail");
//		 }
		 
		 CampaignValidation actualCampaignName=  new CampaignValidation(driver);
		 String actualCampaignData = actualCampaignName.actualCampaignName();
		 Assert.assertEquals(actualCampaignData.contains(campaignName), true);
		 
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wlib.mouseOverOnElement(driver, ele);
		 home.SignOutButton();
  	     driver.close();
				}
//	@Test
//	public void run() 
//	{
//		System.out.println("run");
//	}
//					

	}


