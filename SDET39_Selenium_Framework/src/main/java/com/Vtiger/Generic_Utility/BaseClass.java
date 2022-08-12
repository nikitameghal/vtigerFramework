package com.Vtiger.Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Vtiger.Object_Reposiratory.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver sDriver;



	public WebDriver driver;
	
	
	
	Property_Utility plib=new Property_Utility();
	
	@BeforeSuite(groups= {"smokeTest"})
	public void BS() 
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups= {"smokeTest"})
	public void BT()
	{
		System.out.println("Execute Script in parallel mode");
	}
	
    //@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest"})
	public void BC() throws Throwable 
	{
		
		String Browser=plib.getPropertyKeyValue("browser");
		
		if(Browser.equalsIgnoreCase("chrome")) 
		{
	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		sDriver=driver;
		
	}
	@BeforeMethod(groups= {"smokeTest"})
	public void BM() throws Throwable 
	{
		System.out.println("Logging to the Application");
	    String Url=plib.getPropertyKeyValue("Url");
		String Username=plib.getPropertyKeyValue("UN");
		String Password=plib.getPropertyKeyValue("PSD");
		
		driver.get(Url);
		loginPage login=new loginPage(driver);
	    login.login(Username,Password);
	}
	@BeforeMethod(groups= {"smokeTest"})
	public void AM() 
	{
		System.out.println("Logout from the Application");
	}
	@AfterClass(groups= {"smokeTest"})
	public void AC() 
	{
		System.out.println("Logout to the Browser");
	}
	@AfterTest(groups= {"smokeTest"})
	public void AT() 
	{
		System.out.println("");
	}
	@AfterSuite(groups= {"smokeTest"})
	public void AS() 
	{
		System.out.println("");
	}

}
