package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase
{
public 	LoginPage lp;
public HomePage hp;

@Test
void test_001()
{
 lp=new LoginPage(driver);
if(lp.crmlogoimageisDisplayed()==true)
{
	Assert.assertTrue(true);
}
else
{
	System.out.println("logo is not displayed");
	Assert.assertTrue(false);
	
}
}


}