package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class makeMyTrip {

	public static void main(String[] args) throws Throwable {
		 
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	    driver.get("https://www.makemytrip.com/");
	 
	    
	    WebElement src = driver.findElement(By.id("fromCity"));
	    WebElement dest = driver.findElement(By.id("toCity"));
	   //navigate to and click
	    src.sendKeys("Mumbai");
	    driver.findElement(By.xpath("(//p[text()='Mumbai, India'])[1]")).click();
	    
	    Thread.sleep(1000);
	   //navigate to from
	    dest.sendKeys("Bengaluru");
	    driver.findElement(By.xpath("(//p[text()='Bengaluru, India'])[1]")).click();
	    Thread.sleep(1000);
	   //navigate to departure
	    driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
	    
	    //fetch the month date year
	    String requiredMonth = "December";
	    String requiredYear = "2022";
	    String requiredDate = "24";
	    
	    //for current month
	    String currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption'][1]")).getText();
	    String currentMonth = currentMonthYear.split(" ")[0];
	    String currentYear = currentMonthYear.split(" ")[1];
	    
	    //(current month != required month )and current year == required year
	    while(!(currentMonth.equalsIgnoreCase(requiredMonth) && currentYear.equals(requiredYear))) 
	    {
	    driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	     currentMonthYear= driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div[1]")).getText();
	     currentMonth = currentMonthYear.split(" ")[0];
	     currentYear = currentMonthYear.split(" ")[1];   
	     }
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//p[.='"+requiredDate+"'][1]")).click();

	}}
