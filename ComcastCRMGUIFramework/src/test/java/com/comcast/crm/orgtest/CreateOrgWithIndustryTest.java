package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;
import com.comcast.crm.objectreposotoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectreposotoryutility.HomePage;
import com.comcast.crm.objectreposotoryutility.LoginPage;
import com.comcast.crm.objectreposotoryutility.OrganizationsPage;

public class CreateOrgWithIndustryTest extends BaseClass{
	@Test
	public void CreateOrgWithindustryTest() throws Throwable {
	
		String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
		String industry=eu.getDataFromExcel("Sample", 4, 4);
	//	String type=eu.getDataFromExcel("Sample", 4, 5);
		
		wu.waitForPageToLoad(driver);
	 		
	 		HomePage hp=new HomePage(driver);
	 		hp.getOrgLink().click();
	 		
	 		OrganizationsPage op=new OrganizationsPage(driver);
	 		op.getCreateNewOrgbtn().click();
	 		
	 		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	 		cop.CreateOrg(orgname, industry);
		
//		WebElement wbse1=driver.findElement(By.name("accounttype"));
//		Select sel=new Select(wbse1);
//		sel.selectByVisibleText(type);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

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
		String actIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry)) {
			System.out.println(industry+" information is verified==PASS");
		}
		else {
			System.out.println(industry+" information is not verified==FAIL");
		}
	}

}
