package com.learnauto.utilities;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	
	
	public static WebDriver startApp(WebDriver driver1, String browserName, String appURL)
	{
		
		if(browserName.equals("Chrome"))
		{
		//	WebDriver driver1 ;
	    	System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	    	driver1 = new FirefoxDriver();
	    	
	    	
	    	return driver1;
	    	
		} else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	    	driver1 = new FirefoxDriver();
	    	
			
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	    	driver1 = new FirefoxDriver();
	    	
			
			
		}
		else {
			System.out.print("Not supported");
		}
		
		driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	driver1.manage().window().maximize();
    	driver1.get(appURL);
    	driver1.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		return driver1;
		
		
		
		
		
	//	return null;
		
		
	}
	
	public static WebDriver quitBrowser(WebDriver driver1)
	{
		driver1.quit();
		return driver1;
		
	}
}
