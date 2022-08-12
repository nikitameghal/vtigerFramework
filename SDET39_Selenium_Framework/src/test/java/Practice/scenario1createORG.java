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

public class scenario1createORG {

	public static void main(String[] args, TimeUnit TimeUnit) throws Throwable
	{
		//to load the common properties
		FileInputStream fis= new FileInputStream("./CommonProperties.properties");
		Properties pobj =new Properties();
	    pobj.load(fis);
	    
	    //to get the properties from it.
	    String url = pobj.getProperty("Url");
	    String username = pobj.getProperty("UN");
	    String password = pobj.getProperty("PSD");
	    
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	    driver.get(url);//get url
	    driver.findElement(By.name("user_name")).sendKeys(url);//type username
	    driver.findElement(By.name("user_password")).sendKeys(username);//type pasd
	    driver.findElement(By.id("submitButton")).sendKeys(password);//click on login
	    
	    //driver.findElement(By.linkText("Organizations")).click();//click on org
	    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();//click on create org
	    
	    Random ran=new Random();//not get duplicate name of org
	    int RanNum=ran.nextInt(1000);
	    
	    FileInputStream fis1=new FileInputStream("./Book1.xlsx");//fetch excel sheet
	    Workbook wb= WorkbookFactory.create(fis1);
	   
	    Sheet sh = wb.getSheet("Organization");//take dat from excel
	    Row r = sh.getRow(1);//take row num
	    Cell cel = r.getCell(0);//take col num
	    String orgname = cel.getStringCellValue()+RanNum;//get cell value
	    
	    driver.findElement(By.name("accountname")).sendKeys(orgname);//type orgname
	    driver.findElement(By.name("button")).click();//click on save
	    
	    
	    String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();//verification
	    if(actdata.contains(orgname)) 
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("fail");
	    }
	    
	    
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));//mousehover
	    Actions a= new Actions(driver);
	    a.moveToElement(ele);
	    
	    driver.findElement(By.linkText("Sign Out"));
	    driver.close();
	    
	       
	}

}
