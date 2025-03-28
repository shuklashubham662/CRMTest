package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	public	WebDriver driver;
	public	WebElement ele;
	public WebDriverWait wait;
	public ContactnameDetails cnd;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
        WebDriverWait wait;  
	}
	
	public ContactPage()
	{
		
	}
@FindBy(xpath="//td[contains(text(),'Contacts')]") By contacttext;
@FindBy(xpath="//frame[@name='mainpanel']") WebElement framename;
@FindBy(xpath="//select[@name='title']") WebElement title;
@FindBy(xpath="//input[@id='first_name']")WebElement firstname;
@FindBy(xpath="//input[@id='surname']") WebElement lastname;
@FindBy(xpath="//input[@name='client_lookup']") WebElement companyname;
@FindBy(xpath="//input[@value='Save']") WebElement savebtn;
@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement  logout;
@FindBy(xpath="//td[@id='all']") WebElement all;
public boolean verifycontactlabel()
{
	try
	{
	wait=new WebDriverWait(driver,Duration.ofSeconds(30));
 ele=	wait.until(ExpectedConditions.visibilityOfElementLocated(contacttext));
 return ele.isDisplayed();
}
	
catch(Exception e)
	{
	System.out.println("not visible");
	return false;
	}
}
public void createnewContact(String name,String cltname,String lstname,String compname )

{
	Select sel=new Select(title);
	sel.selectByVisibleText(name);
	firstname.sendKeys(cltname);
	lastname.sendKeys(lstname);
	companyname.sendKeys(compname);
	savebtn.click();
	logout.click();
	
}

public void switchtoframe()
{
	driver.switchTo().frame(framename);
}
public boolean allisdisplayed()
{
	all.isDisplayed();
	return true;
	
}
}
