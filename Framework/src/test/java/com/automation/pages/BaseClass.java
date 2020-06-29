package com.automation.pages;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnauto.utilities.BrowserFactory;
import com.learnauto.utilities.ConfigDataProvider;
import com.learnauto.utilities.ExcelDataProvider;
import com.learnauto.utilities.Helper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
public WebDriver driver1;
public ExcelDataProvider excel;
public ConfigDataProvider config;
public Helper help;
public ExtentReports report;
public ExtentTest logger;
@BeforeSuite

public void setUp() {
	
	Reporter.log("Setting up reports and test getting ready", true);
	
	 excel= new ExcelDataProvider();
	 config= new ConfigDataProvider();
	  help = new Helper();
	  ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+ "/Reports/Facebook+"+Helper.getCurrentDateTime()+".html"));
	  report=new ExtentReports();
	  report.attachReporter(extent);
	//ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(""));
	  
	  
	  Reporter.log("Setting done test can be started", true);
}
  @BeforeClass
  public void beforeClass() {
	  
	  Reporter.log("Trying to start browser and getting application redy", true); 
	  
	 driver1= BrowserFactory.startApp(driver1,config.getBrowser(), config.getStagingUrl());
	 
	 Reporter.log("Browser and applicaionis up and running", true);
  }

  @AfterClass
  public void afterClass() {
	  
	  BrowserFactory.quitBrowser(driver1);
  } 
  
  @AfterMethod
  
  public void TearDownMetod(ITestResult result) throws IOException
  {
	  
	  Reporter.log("Test is about to end", true);
	  
	  if(result.getStatus()== ITestResult.FAILURE) {
		  //Helper.captureScreenshot(driver1);
		  
		
		  logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver1)).build());
		  
	  }
	  
	  else if(result.getStatus()== ITestResult.SUCCESS){
		  
		  logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver1)).build());
		  
	  }
	  
	  report.flush();
	  
	  Reporter.log("Test completed", true);
  }

}
