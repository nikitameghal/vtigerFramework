package com.Vtiger.Object_Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
// Initialization:
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
//Declaration:
	@FindBy(name="user_name")
	private WebElement UserNameTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
//Utilization by using getters method	

	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	//business logic
	/**
	 * this is used for login the application
	 * @param username
	 * @param password
	 * @author nikita
	 */
	public void login(String Username,String Password) 
	{
		UserNameTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Password);
		LoginButton.click();
	}
	
	

	
	
}
