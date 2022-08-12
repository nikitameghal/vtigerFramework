package com.crm.sdet.Product;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.Generic_Utility.BaseClass;
import com.Vtiger.Generic_Utility.Excel_Utility;
import com.Vtiger.Generic_Utility.Java_Utility;
import com.Vtiger.Generic_Utility.Property_Utility;
import com.Vtiger.Generic_Utility.WebDriver_Utility;
import com.Vtiger.Object_Reposiratory.HomePage;
import com.Vtiger.Object_Reposiratory.NewProductPage;
import com.Vtiger.Object_Reposiratory.ProductPage;
import com.Vtiger.Object_Reposiratory.ProductValidation;
import com.Vtiger.Object_Reposiratory.loginPage;

public class CreateProductTest extends BaseClass {
	
//@Test(groups= {"smokeTest"})

@Test(retryAnalyzer = com.Vtiger.Generic_Utility.ReTryImpClass.class)
	public void createProduct() throws Throwable 
	{
	     Property_Utility plib=new Property_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 WebDriver_Utility wlib=new WebDriver_Utility();
						 
		 wlib.WebDriverPageToLoad(driver);

	     HomePage home=new HomePage(driver);
	     home.ProductModule();
	     
	     ProductPage Product=new ProductPage(driver);
	     Product.ProductPage();
	      
		 
		 int RanNum=jlib.getRandomNum();
		 String prodName = elib.getDataFromExcel("Product",1,0)+RanNum;
		 
		 NewProductPage prodpage=new NewProductPage(driver);
		 prodpage.NewProductPage(prodName);
		 prodpage.Savebutton();
			 
//		 String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//		 System.out.println(prodName);
//			
//		 if(actData.contains(prodName))
//			{
//				System.out.println("pass");
//			}
//		 else
//			{
//				System.out.println("Fail");
//			}
			
		 ProductValidation actualProductName=  new ProductValidation(driver);
		 String actualProductData = actualProductName.actualProductName();
		 Assert.assertEquals(actualProductData.contains(prodName), true);
		 
		 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wlib.mouseOverOnElement(driver, element);
			
		 home.SignOutButton();
		 driver.close();
			 
	}






	}

