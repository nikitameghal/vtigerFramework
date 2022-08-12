package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	//Initialization
		public OrganizationPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
	//declaration
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement CreateOrganizationButtun;
		
	//utilization by using getters method	

		public WebElement getCreateOrganizationButtun()
		{
			return CreateOrganizationButtun;
		
		}
		
		//business logic
		/**
		 * this page is used to create organization
		 * @author nikita
		 */
		
		public void OrganizationPage()
		{
			CreateOrganizationButtun.click();
		}
		
}
