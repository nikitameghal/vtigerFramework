package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation
 {
	
	//initialization
	public ProductValidation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement actualProductData;

	
	//utilizaton
	public WebElement getActualProductData()
	{
		return actualProductData;
	}
	
	//business logic
	
	public String actualProductName()
	{
		return actualProductData.getText();
	}

	
	
	
	

}
