package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Generic_Utility.WebDriver_Utility;

public class HomePage 
{
//Initialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//declaration
    @FindBy(xpath="//a[text()='Organizations'][1]")	
    private WebElement OrganizationModule;
    
    @FindBy(xpath="//a[text()='Products']")
    private WebElement ProductModule;
    
    @FindBy(xpath="//a[@href='javascript:;'][1]")
    private WebElement MoreModule;
    
    @FindBy(name="Campaigns")
    private WebElement CampaignsModule;
    
    @FindBy(xpath="//a[text()='Sign Out']")
    private WebElement SignOutButton;
    
  //Utilization by using getters

	public WebElement getSignOutButton() {
		return SignOutButton;
	}

	public WebElement getOrganizationModule() {
		return OrganizationModule;
	}

	public WebElement getProductModule() {
		return ProductModule;
	}

	public WebElement getMoreModule() {
		return MoreModule;
	}

	public WebElement getCampaignsModule() {
		return CampaignsModule;
	}
//businessLogic
	/**
	 * this is the home page of the application
	 * @author Nikita
	 */


	public void OrganizationModule()
	{
		OrganizationModule.click();
	}
	
	public void ProductModule()
	{
		ProductModule.click();
	}
	
	public void MoreModule()
	{
		MoreModule.click();
	}
	
	public void CampaignsModule()
	{
		CampaignsModule.click();
	}
	
	public void SignOutButton() 
	{
		SignOutButton.click();
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

    
    
    
    

