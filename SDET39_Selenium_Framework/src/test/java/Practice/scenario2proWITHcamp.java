package Practice;

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

public class scenario2proWITHcamp {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("./CommonProperties.Properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	
	String url = pobj.getProperty("Url");
	String username = pobj.getProperty("UN");
	String password = pobj.getProperty("PSD");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	Random ran=new Random();
	int ranNum = ran.nextInt();
	
	
	//enter product name from excel
	FileInputStream fis1=new FileInputStream("./Book1.xlsx");
	Workbook wb= WorkbookFactory.create(fis1);
	Sheet sheet = wb.getSheet("Product");
	Row row = sheet.getRow(1);
    Cell cel = row.getCell(0);
    String prodname = cel.getStringCellValue()+ranNum;
    
    System.out.println(prodname);
    
    driver.findElement(By.name("productname")).sendKeys(prodname);
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    //mousehover on more
    WebElement ele = driver.findElement(By.xpath("//a[@href='javascript:;']"));
    Actions a= new Actions(driver);
    a.moveToElement(ele).perform();
    
    Thread.sleep(1000);
    driver.findElement(By.name("Campaigns")).click();
    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
    
    //now have to fatech data from ecel to take campaign name
    FileInputStream fis2=new FileInputStream("./Book1.xlsx");
	Workbook wb2= WorkbookFactory.create(fis2);
	Sheet sheet1 = wb.getSheet("Product");
	Row row1 = sheet.getRow(1);
    Cell cel1= row.getCell(0);
    String CampaignName = cel.getStringCellValue()+ranNum;
    
    System.out.println(CampaignName);
    driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
    driver.findElement(By.xpath("//img[@alt='Select']")).click();
    
    //give control to child window
    Set<String> childwin = driver.getWindowHandles();
    Iterator<String> it = childwin.iterator();
    
    while(it.hasNext())
    {
    	String win = it.next();
    	driver.switchTo().window(win);
    	
    	if(driver.getTitle().contains("Products&action")) 
    	{
    		break;
    	}
    }
    Thread.sleep(1000);
//    driver.findElement(By.xpath("//input[@id='search_txt']")).click();
//    driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
//    driver.findElement(By.xpath("//input[@type='button']")).click();
    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(prodname);

	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
    
    //back to the parent window
    Set<String> childwin1 = driver.getWindowHandles();
    Iterator<String> it1 = childwin.iterator();
    
    while(it1.hasNext())
    {
    	String win1 = it1.next();
    	driver.switchTo().window(win1);
    	
    	if(driver.getTitle().contains("Campaigns&action")) 
    	{
    		break;
    	}
    }
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(actdata.contains(CampaignName)) 
    {
    	System.out.println("pass");
    }
    else 
    {
    	System.out.println("fail");
    }
    
    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    a.moveToElement(ele1).perform();
    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    driver.close();
    
  
	
	}

}
