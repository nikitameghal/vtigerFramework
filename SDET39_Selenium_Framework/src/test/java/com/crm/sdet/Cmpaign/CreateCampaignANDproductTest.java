package com.crm.sdet.Cmpaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.Vtiger.Object_Reposiratory.NewProductPage;
import com.Vtiger.Object_Reposiratory.ProductPage;
import com.Vtiger.Object_Reposiratory.loginPage;

public class CreateCampaignANDproductTest extends BaseClass{
	
@Test(groups= {"regressionTest"})
	public void createCamaignAndProduct()throws Throwable {
		 Property_Utility plib = new Property_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		
				
//		 String Url=plib.getPropertyKeyValue("Url");
//		 String Username=plib.getPropertyKeyValue("UN");
//		 String Password=plib.getPropertyKeyValue("PSD");
//		
//		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 wlib.WebDriverPageToLoad(driver);
		
//		 driver.get(Url);
//		 loginPage login=new loginPage(driver);//login
//		 login.login(Username,Password);//un psd
		 
		HomePage home=new HomePage(driver);
        home.ProductModule();
	     
	    ProductPage Product=new ProductPage(driver);
	    Product.ProductPage();
	      
	    int RanNum=jlib.getRandomNum();
		String prodName = elib.getDataFromExcel("Product", 1, 0)+RanNum;
		System.out.println(prodName);
		
		
		NewProductPage addproduct=new NewProductPage(driver);
		addproduct.NewProductPage(prodName);
		addproduct.Savebutton();
		
        home.MoreModule();
	
        home.CampaignsModule();
        CampaignPage campaign=new CampaignPage(driver);
		campaign.CampaignPage(); 		
			
	    int ranNum = jlib.getRandomNum();
		String campaignName = elib.getDataFromExcel("Campaign", 1, 0)+RanNum;
				
		CreatingNewCampaign newcampaign=new CreatingNewCampaign(driver);
		newcampaign.CamapignName(campaignName);	
		System.out.println(campaignName);
		
		newcampaign.newprodimage();
						
		wlib.switchToWindow(driver,"Products&action");
		newcampaign.srearchBar(prodName);
    	newcampaign.SearchProductButton(driver,prodName);
	
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		wlib.switchToWindow(driver,"Campaigns&action");//need to select switchto window(driver,partialwindow)otherwise throw error
						
		newcampaign.savebutton();	
//		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//					
//					if(actData.contains(campaignName))
//					{
//						System.out.println("pass");
//					}
//					else
//					{
//						System.out.println("Fail");
//					}
					
		
		 CampaignValidation actualCampaignName=  new CampaignValidation(driver);
		 String actualCampaignData = actualCampaignName.actualCampaignName();
		 Assert.assertEquals(actualCampaignData.contains(campaignName), true);
		 
		
		
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wlib.mouseOverOnElement(driver, ele);		
				
				home.SignOutButton();
				driver.close();
				
				}
//@Test
//public void modifyContact() 
//{
//	System.out.println("contact modified");
//}
				
			
				
				



	




	}

