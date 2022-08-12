package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage
{
	//Initialization
	 
		public NewProductPage (WebDriver driver) 
		{
		PageFactory.initElements(driver, this);
			
		}
		
	//Declaration
	
		
		@FindBy(name="productname")
		private WebElement productname;
		
		@FindBy(xpath="(//input[@title='Delete [Alt+D]'])[1]")
		private WebElement deleteBt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
		private WebElement savebutton;

	//Utilization
		public WebElement getProductname() {
			return productname;
		}

		public WebElement getDeleteButton() {
			return deleteBt;
		}

		public WebElement getSavebutton() {
			return savebutton;
		}
		
 public void NewProductPage(String product) 
 {
	 productname.sendKeys(product);
 }
 public void Savebutton() 
 {
	 savebutton.click(); 
 }	
 public void deleteButton()
 {
	 deleteBt.click();
 }
	 
 }
		
		
		
		

