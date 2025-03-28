package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomeTest extends TestBase {
	public LoginPage lp;
	public HomePage hp;
	public ContactPage cp;
@Test
public void verifygetPagetitle()
{
	 lp=new LoginPage(driver);
	 hp=new HomePage(driver);
	 lp.login(prop.getProperty("username"),prop.getProperty("password"));
	String exptile= hp.getPagetitle();
	Assert.assertEquals("CRMPRO",exptile,"title does not match");
}

@Test
public void verifyusernamedisplayed()
{
	if(hp.verifycorrectusername()==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertFalse(true);
	}
}
@Test
public void getContact()
{
	
cp=hp.getContact();
}

}
