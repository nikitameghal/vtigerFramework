package com.Vtiger.Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility 
{
	public void windowMaximize(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to match the speed of selenium with the aplication Or waits for page to load before identifying any synchronized element in DOM
 	 *@param driver
     *@author nikita
	 */
	public void WebDriverPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**After every action it will waits for next action to be perform.
	 * @param driver
	 * @author nikita
	 */
	public void scriptTimeOut(WebDriver driver) 
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for the element to be clickable in gui, and check for specific element for every 500milisecond.
	 * @param driver
	 * @param Element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds.
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime) 
	{
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20 , pollingTime));
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to switch to any window based on window title.
	 * @param driver
	 * @param PartialWindowTilte
	 */
	public void switchToWindow(	WebDriver driver,String PartialWindowTilte) 
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
			String wid =it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTilte))
			{
				break;
			}
		}
	}
	
	/**
	 * this method is used to switch to frame based on index.
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method is used to switch to frame based on id or name
     * @param id_name_attribute
     * @param driver
	 * @author nikita
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute) 
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	
	/**
	 * this method is used to switch the alert popup and accept it(i.e click on ok button.)
	 * @param driver
	 * @author nikita
	 */
	
	public void switchToAlertAndAcceptAlert(WebDriver driver) 
	{
		//Alert simpleAlert = driver.switchTo().alert();
	    //simpleAlert.accept();
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * this method is used to switch the alert popup and dissmiss(click on cancle button)
	 *@param driver
	 */
	public void switchToAlertAndDissmiss(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * this method is used to select the value from the dropdown based on index.
	 * @param Element
	 * @param index
	 * @author nikita
	 * 
	 */
	public void select(WebElement Element,int index) 
	{
		Select s=new Select(Element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * this method is used to select the value from the dropdown based on value.
	 * @param Element
	 * @param text
	 * @author nikita
	 */
	public void select(WebElement Element,String text) 
	{
		Select s=new Select(Element);
		s.selectByValue(text);
	}
	
	/**
	 * this method is used to perform the action of mouseovering.
	 * @param driver
	 * @param Element
	 * @author nikita
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement Element) 
	{
		Actions a=new Actions(driver);
		a.moveToElement(Element).perform();	
	}
	
	/**
	 * this method is used to perform the action of rightclick.
	 * @param driver
	 * @param Element
	 * @author nikita
	 */
	public void rightClickOnElement(WebDriver driver,WebElement Element)
	{
		Actions a=new Actions(driver);
		a.contextClick(Element).perform();
	}
	
	/**
	 *  this method is used to perform the action of draganddrop
	 * @param driver
	 * @param Element
	 * @author nikita;
	 */
	public void DragAndDrop(WebDriver driver,WebElement Element) 
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(Element, Element);
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

