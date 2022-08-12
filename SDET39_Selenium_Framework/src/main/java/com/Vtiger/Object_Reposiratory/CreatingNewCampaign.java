package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaign 
{
// Initialization:
	public CreatingNewCampaign(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
			
//declaration
	@FindBy(name="campaignname")
	private WebElement CamapignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement SaveButton;

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement newprodimage;
	
	@FindBy(id="search_txt")
	private WebElement Srearchbar;
	
	@FindBy(name="search")
	private WebElement SearchNow;
	
	
	
	
	//utilization
	
	
	public WebElement getSearchNow() {
		return SearchNow;
	}
	
	public WebElement getSrearchbar() {
		return Srearchbar;
	}


public WebElement getCamapignNameTextField() {
		return CamapignNameTextField;
	}

	public WebElement getNewprodimage() {
		return newprodimage;
	}


	public WebElement getSaveButton() 
	{
		return SaveButton;
	}
	
//businesslogi
	public void CamapignName(String campname)
	{
		CamapignNameTextField.sendKeys(campname);
	}
	public void savebutton()
	{
		SaveButton.click();
	}
	public void newprodimage()
	{
		newprodimage.click();
	}
	public void srearchBar(String productname) 
	{
		Srearchbar.sendKeys(productname);
	}
	
	public void SearchProductButton(WebDriver driver,String Productname)	
	{
		SearchNow.click();

	}
			
}
