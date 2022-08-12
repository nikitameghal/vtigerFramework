package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
// Initialization
	public ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
// Declaration
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductButton;

//Utilization by using getters method
	
	
	public WebElement getCreateProductButton() 
	{
		return CreateProductButton;
	}
	
//BusinessLogic 
	/**
	 * this method is used to create product
	 * @author nikita
	 */
	
	public void ProductPage() 
	{
		CreateProductButton.click();
	}
	

	
	
}
