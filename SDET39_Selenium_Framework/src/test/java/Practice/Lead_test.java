package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.Generic_Utility.Excel_Utility;
import com.Vtiger.Generic_Utility.Java_Utility;
import com.Vtiger.Generic_Utility.Property_Utility;
import com.Vtiger.Generic_Utility.WebDriver_Utility;

public class Lead_test {

	public static void main(String[] args) throws Throwable 
	{
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		Property_Utility plib = new Property_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		String url = plib.getPropertyKeyValue("Url");
		String username = plib.getPropertyKeyValue("UN");
		String password = plib.getPropertyKeyValue("PSD");
		
		WebDriver driver = new ChromeDriver();
		wlib.windowMaximize(driver);
		wlib.WebDriverPageToLoad(driver);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//WebElement ele = driver.findElement(By.xpath("//select[@class='small'][2]"));
	   // wlib.select(ele,"Mr");
		//Select s=new Select(ele);
		//s.selectByValue("Mr");
        driver.findElement(By.name("firstname")).sendKeys("nikita");
        driver.findElement(By.name("lastname")).sendKeys("Meghal");
        driver.findElement(By.name("company")).sendKeys("infosys");
        
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wlib.mouseOverOnElement(driver, ele);
        driver.findElement(By.linkText("Sign Out")).click();
        
        driver.close();
        
	}

	

}
