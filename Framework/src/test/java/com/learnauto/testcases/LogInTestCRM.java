package com.learnauto.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LogInPage;
import com.learnauto.utilities.BrowserFactory;
import com.learnauto.utilities.ExcelDataProvider;
import com.learnauto.utilities.Helper;

public class LogInTestCRM extends BaseClass {
	

  @Test
  public void logInApp() throws InterruptedException {
	 
	  
	 // excel.getStringData("Login", 0, 0);
	  
	  logger=report.createTest("Log in to FB");
	  
	LogInPage loginpage=  PageFactory.initElements(driver1, LogInPage.class);
	
	logger.info("Starting Application");
	loginpage.loginToCRM(excel.getStringData("Login", 0, 0) ,excel.getStringData("Login", 0, 1));
	logger.pass("Login done sucessfully");
	
  }
}
