package com.crm.qa.testcases;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.ContactnameDetails;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testutils.DataProviders;
import com.crm.qa.testutils.TestUtil;

public class ContactPageTest extends TestBase{
public LoginPage lp;
public HomePage hp;
public ContactPage cp;
public ContactnameDetails cnd;
WebElement ele;
TestUtil util ;
String name;
/*
public void contacttext() throws InterruptedException
{
	 lp=new LoginPage(driver);
	 hp=new HomePage(driver);
	 cp=new ContactPage(driver);
	 lp.login(prop.getProperty("username"),prop.getProperty("password"));
	 cp.switchtoframe();
	 cp=hp.getContact();
    if(cp.verifycontactlabel()==true)
    	{
    	Assert.assertTrue(true);
    	}
    
}*/
@Test(dataProvider="testdata",dataProviderClass=DataProviders.class)
public void newContactpagecreated(String title,String firstname,String lastname,String comp)
{
	 lp=new LoginPage(driver);
	 hp=new HomePage(driver);
	 cp=new ContactPage(driver);
	 lp.login(prop.getProperty("username"),prop.getProperty("password"));
	 cp.switchtoframe();
	 hp.getnewContactpage();
	 cp.createnewContact(title,firstname,lastname,comp);
Assert.assertTrue(true);
}
	
}

	
	
	
	 
	



