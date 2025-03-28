package com.crm.qa.testutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	WebDriver driver;
	WebDriverWait wait;
public	TestUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	public void switchtoframe(String  framename)
	{
		
		driver.switchTo().frame(framename);
	}
	public void waitforelementtobevisible(WebElement ele)
	{
	try {
			 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	catch(StaleElementReferenceException e)
	{
        ele = wait.until(ExpectedConditions.visibilityOf(ele));

	}
	}
		
}
