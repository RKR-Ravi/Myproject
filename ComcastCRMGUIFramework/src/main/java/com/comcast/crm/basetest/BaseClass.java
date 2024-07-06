package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;
import com.comcast.crm.objectreposotoryutility.HomePage;
import com.comcast.crm.objectreposotoryutility.LoginPage;

import lombok.experimental.UtilityClass;

public class BaseClass {
	 public ExcelUtility eu=new ExcelUtility();
	 public javaUtility ju=new javaUtility();
	 public webDriverUtility wu=new webDriverUtility();
	 public DataBaseUtility du=new DataBaseUtility();
	 public FileUtility fu=new FileUtility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver=null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB,ReportConfig===");
		du.getConnection();	
	}
//	@Parameters("BROWSER")
//	@BeforeClass
//	public void configBC(String browser) throws Throwable {
	@BeforeClass
	public void configBC() throws Throwable{
		System.out.println("===Launch Browser===");
		//String BROWSER= browser;
		String BROWSER=fu.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		    sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===Login===");
		String URL=fu.getDataFromPropertiesFile("url");
		String USERNAME=fu.getDataFromPropertiesFile("username");
		String PASSWORD=fu.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToapp(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod
	public void configAM() {
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.Logout();
	}
	@AfterClass
	public void configAC() throws SQLException {
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close DB,Reprot BackUp====");
		du.closeDbconnection();
		
		
	}
}
