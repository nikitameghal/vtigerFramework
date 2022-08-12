package com.crm.sdet.Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Vtiger.Generic_Utility.BaseClass;
import com.Vtiger.Generic_Utility.Excel_Utility;
import com.Vtiger.Generic_Utility.Java_Utility;
import com.Vtiger.Generic_Utility.Property_Utility;
import com.Vtiger.Generic_Utility.WebDriver_Utility;
import com.Vtiger.Object_Reposiratory.HomePage;
import com.Vtiger.Object_Reposiratory.NewProductPage;
import com.Vtiger.Object_Reposiratory.ProductPage;
import com.Vtiger.Object_Reposiratory.loginPage;

public class CreateProductANDdeleteProductTest extends BaseClass{

	
	@Test(groups= {"smokeTest"})
	public void createProductAndDeleteProduct()throws Throwable
	{
		 Property_Utility plib = new Property_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 WebDriver_Utility wlib=new WebDriver_Utility();
				
//		 String Url=plib.getPropertyKeyValue("Url");
//		 String Username=plib.getPropertyKeyValue("UN");
//		 String Password=plib.getPropertyKeyValue("PSD");
//		
//		
//		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 wlib.WebDriverPageToLoad(driver);
		 
//		 driver.get(Url);
//		 
//		 loginPage login=new loginPage(driver);//login
//		 login.login(Username,Password);//un psd
		 
		 HomePage home=new HomePage(driver);
		 home.ProductModule();
		 
		 ProductPage Product=new ProductPage(driver);
	     Product.ProductPage();
		 
		 int RanNum=jlib.getRandomNum();
		 String proName= elib.getDataFromExcel("Product", 1, 0)+RanNum;
		 
		 NewProductPage prodpage=new NewProductPage(driver);
		 prodpage.NewProductPage(proName);
		 prodpage.Savebutton();
		 
		 System.out.println(proName);
		 String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			
		if(actData.contains(proName))
		{
		   System.out.println("pass");
		}
		else
		{
		   System.out.println("Fail");
		}
			
		prodpage.deleteButton();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
			
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElement(driver, ele);
		home.SignOutButton();
		driver.close();
			}
			}







