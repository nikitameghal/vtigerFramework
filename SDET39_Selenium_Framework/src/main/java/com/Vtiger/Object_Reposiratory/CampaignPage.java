package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	// Initialization:
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
	//declaration
		@FindBy(xpath="//img[@alt='Create Campaign...']")
		private WebElement CreateCampaignButton;
		
	//utilization

		public WebElement getCreateCampaignButton()
		{
			return CreateCampaignButton;
		
		}
		//business logic
		
public void CampaignPage()	
{
	CreateCampaignButton.click();	
}
		
		
		
}
