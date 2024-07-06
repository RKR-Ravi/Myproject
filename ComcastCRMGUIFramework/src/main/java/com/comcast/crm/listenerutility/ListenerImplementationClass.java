package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	 public static ExtentReports report;
	 public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Reprot configuration");
		//spark report config
		String time=new Date().toString().replace(" ","_").replace(":","_");

				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				//add environment and create test
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","Windows-10");
				report.setSystemInfo("BROWSER","Chrome-100");
	}
	public void onFinish(ISuite suite) {
		System.out.println("Reprot Backup");	
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("===>"+result.getMethod().getMethodName()+">====");
		test= report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===>STARTED===>");
		test= report.createTest(result.getMethod().getMethodName());

	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===>"+result.getMethod().getMethodName()+">==END==");
		test.log(Status.PASS,result.getMethod().getMethodName()+"===>COMPLETED===>");
	}
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		//step1: create an object for eventFiringwebdriver
				 TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
				//step2: use getScreenshotAs method to get file type(normal) of screenshot BASE64-ExtentReport
					String filepath=ts.getScreenshotAs(OutputType.BASE64);
				//store screen on local driver
				String time=new Date().toString().replace(" ","_").replace(":","_");
				test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
				test.log(Status.FAIL,result.getMethod().getMethodName()+"===>FAILED===>");
//				try {
//					FileUtils.copyFile(scrFile, new File("./Screenshot/"+testName+"+"+time+".png"));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
