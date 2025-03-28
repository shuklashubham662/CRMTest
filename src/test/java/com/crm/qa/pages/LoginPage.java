package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	HomePage lp;
public LoginPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
@FindBy(xpath="//img[@alt='Free CRM Software for customer relationship management, sales and support']") WebElement logo;
@FindBy(xpath="//a[normalize-space()='Sign Up']") WebElement signUpbtn;

public HomePage login(String user,String pass)
{
	username.sendKeys(user);
	password.sendKeys(pass);
	loginbtn.click();
	return new HomePage();
}


public void signuplink()
{
	signUpbtn.click();
}
public boolean crmlogoimageisDisplayed()
{
	try
	{
		logo.isDisplayed();
		return true;
	}
	catch(Exception e)
	{
		System.out.println("logo not displayed");
		return false;
	}
}
	
public String loginpagetitle()
	{
		return driver.getTitle();
	}

}

