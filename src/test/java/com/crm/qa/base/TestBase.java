package com.crm.qa.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
public  WebDriver driver;
public Properties prop;
public FileReader file;
@BeforeClass
@Parameters("browser")
public void setup(String br) throws IOException, InterruptedException
{
	  prop=new Properties();
	 file=new FileReader(".\\src\\test\\resources\\config.properties");
	prop.load(file);

	switch(br)
	{
	case "Chrome" :driver=new ChromeDriver(); break;
	case "Firefox" : driver=new FirefoxDriver(); break;
	default: System.out.println("Invalid Browser name");
	return;
	}
	driver.get(prop.getProperty("url"));
	try {
        // Some code to set up the WebDriver or other objects
        wait(5000);  // Wait for 5 seconds (for example)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	 // Timeout after 30 seconds
	int waittime=Integer.parseInt(prop.getProperty("implicitwait"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waittime));
	driver.manage().window().maximize();
	
}
@AfterClass
public void teardown()
{
	if(driver!=null)
	{
		driver.quit();	
	}

}

}
