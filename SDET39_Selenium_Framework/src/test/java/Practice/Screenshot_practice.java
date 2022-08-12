package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Vtiger.Generic_Utility.BaseClass;

public class Screenshot_practice {

	//public static void main(String[] args) throws Throwable
	public class Screenshotofhome extends BaseClass{
		
	
	@Test
	public void screen() throws Throwable {
		//STEP:1 Typecasting
		
		       WebDriver driver=new ChromeDriver();
		       driver.get("http://localhost:8888/");
		       
		
				TakesScreenshot ts=(TakesScreenshot) driver;
				
				//step2: access the method and photo is stored in ram
				
				File RAM=ts.getScreenshotAs(OutputType.FILE);
				
				//step3: specify the location
				
				File dest=new File("./photo/home.png");
				
				//step4 copy paste from ram to required  location
				FileUtils.copyFile(RAM, dest);
				driver.close();
			}

	}
}

