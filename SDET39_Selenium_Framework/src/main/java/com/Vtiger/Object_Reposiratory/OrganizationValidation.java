package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidation 
{
	
	//initialization
	public OrganizationValidation(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(className="dvHeaderText")
	private WebElement actualOrganizationData;
	
	//utilization
	public WebElement getActualOrganizationData()
	{
		return actualOrganizationData;
	}
	
	//businesslogic
	public String actualOrganizationName() 
	{
		return actualOrganizationData.getText();
		
	}
	

	
	
	
	
	

}
