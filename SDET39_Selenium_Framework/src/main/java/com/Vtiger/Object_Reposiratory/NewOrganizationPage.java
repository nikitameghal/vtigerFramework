package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrganizationPage 
{
//Initialization
	 
	public NewOrganizationPage (WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
		
	}

//Declaration
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement SaveButton;
	
	
//Utilization By using getter method
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
//BusinessLogic
/**
 * this page is used to create new organization
 * @author Nikita
 */
	
	public void NewOrganizationPage(String Organization )
	{
		OrganizationName.sendKeys(Organization);//ask to mam
	}
	public void SaveButton()
	{
	SaveButton.click();
	}
				
	}
	
	
	
		
	

