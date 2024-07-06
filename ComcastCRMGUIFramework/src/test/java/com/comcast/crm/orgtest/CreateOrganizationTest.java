package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		//create object
				FileUtility fu=new FileUtility();
				ExcelUtility eu=new ExcelUtility();
				javaUtility ju=new javaUtility();
				webDriverUtility wu=new webDriverUtility();
				
				String BROWSER=fu.getDataFromPropertiesFile("browser");
				String URL=fu.getDataFromPropertiesFile("url");
				String USERNAME=fu.getDataFromPropertiesFile("username");
				String PASSWORD=fu.getDataFromPropertiesFile("password");
				
				String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
		
		WebDriver driver=null;
	//	System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\chromedriver-win32\\chromedriver.exe");
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
		
		wu.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Thread.sleep(2000);
//		WebElement wbsele=   driver.findElement(By.name("industry"));
//		Select se1=new Select(wbsele);
//		se1.selectByVisibleText(industry);
//		
//		WebElement wbse1=driver.findElement(By.name("accounttype"));
//		
//		Select sel=new Select(wbse1);
//		sel.selectByVisibleText(type);
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgname)) {
			System.out.println(orgname+" is created==PASS");
		}
		else {
			System.out.println(orgname+" is not created==PASS");

		}
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgname)) {
			System.out.println(orgname+" is created==PASS");
		}
		else {
			System.out.println(orgname+" is not created==FAIL");

		}
		
//		String actIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
//		if(actIndustry.equals(industry)) {
//			System.out.println(industry+" information is verified==PASS");
//		}
//		else {
//			System.out.println(industry+" information is not verified==FAIL");
//		}
//		String actType=driver.findElement(By.id("dtlview_Type")).getText();
//		if(actType.equals(type)) {
//			System.out.println(type+" information is verified==PASS");
//		}
//		else {
//			System.out.println(type+" information is not verified==FAIL");
//		}
		driver.close();
		

	}

}
