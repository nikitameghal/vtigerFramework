package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignValidation 
{
	public  CampaignValidation(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualCampaignData;

	
	public WebElement getActualCampaignData() 
	{
		return actualCampaignData;
	}

	public String actualCampaignName() 
	{
		return actualCampaignData.getText();
		
	}
	
	
	
	
	

}
