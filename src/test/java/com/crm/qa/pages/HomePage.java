package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public	WebDriver driver;
	public ContactPage cp;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//td[contains(text(),'User: Gagan Khanna ')]") WebElement userlabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement contactlink;
	@FindBy(xpath="//a[contains(text(),'Deals')]") WebElement Deallink;
    @FindBy(xpath="//frame[@name='mainpanel']") WebElement framename;
    @FindBy(xpath="//a[normalize-space()='New Contact']") WebElement newContactPage;
 public String  getPagetitle()
 {
	 return driver.getTitle();
 }

 public ContactPage getContact()
 {
	 contactlink.click();
	 return new ContactPage();
 }
 
public void getnewContactpage()
{
	Actions act=new Actions(driver);
	act.moveToElement(contactlink).build().perform();
	newContactPage.click();
	
}
public boolean verifycorrectusername()
{
	driver.switchTo().frame(framename);
	return userlabel.isDisplayed();
}
}
