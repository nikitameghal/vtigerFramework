package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prac_makeMyTrip {

	public static void main(String[] args) throws Throwable {
		 WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    
		    driver.get("https://www.makemytrip.com/");
		 
		    
		    WebElement src = driver.findElement(By.id("fromCity"));
		    WebElement dest = driver.findElement(By.id("toCity"));
		   //navigate to and click
		    src.sendKeys("Mumbai");
		    driver.findElement(By.xpath("//p[text()='Mumbai, India'][1]")).click();
		    
		    Thread.sleep(1000);
		   //navigate to from
		    dest.sendKeys("Bengaluru");
		    driver.findElement(By.xpath("//p[text()='Bengaluru, India'][1]")).click();
		    Thread.sleep(1000);
		   //navigate to departure
		    driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10'][1]")).click();
		    
	}}
