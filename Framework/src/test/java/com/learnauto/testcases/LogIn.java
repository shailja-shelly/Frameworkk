package com.learnauto.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogIn {

	public void login() throws Exception{
		//WITHOUT FRAMEWORK

		WebDriver driver1 ;
    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
    	driver1 = new FirefoxDriver();

        
        driver1.get("https://facebook.com/");
        driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	driver1.findElement(By.name("email")).sendKeys("shellues@gmail.com");
    	driver1.findElement(By.name("pass")).sendKeys("password");
    	driver1.findElement(By.id("loginbutton")).click();
    	driver1.quit();
}}
