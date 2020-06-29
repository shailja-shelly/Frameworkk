package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage{

	WebDriver driver1;
	
	public LogInPage(WebDriver driver2)
	{
		this.driver1=driver2;
	}
	@FindBy(name="email") WebElement email;
	
	@FindBy(name="pass") WebElement pass;
	
	@FindBy(id="loginbutton") WebElement loginbutton;
	
	public void loginToCRM(String username, String password) throws InterruptedException
	{
		Thread.sleep(5000);
		email.sendKeys(username);
		pass.sendKeys(password);
		loginbutton.click();
	}
}
