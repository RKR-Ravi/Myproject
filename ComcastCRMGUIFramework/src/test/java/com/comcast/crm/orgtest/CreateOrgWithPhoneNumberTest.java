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
import com.comcast.crm.objectreposotoryutility.OrganizationsPage;

public class CreateOrgWithPhoneNumberTest extends BaseClass{
	
	@Test
	public void CreateOrgWithPhoneNumberTest() throws Throwable {
		
		String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
		String phoneNumber=eu.getDataFromExcel("Sample", 7, 3);
		
		HomePage hp=new HomePage(driver);
 		hp.getOrgLink().click();
 		
 		OrganizationsPage op=new OrganizationsPage(driver);
 		op.getCreateNewOrgbtn().click();
 		
		wu.waitForPageToLoad(driver);
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.CreateOrganization(orgname, phoneNumber);
		
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgname)) {
			System.out.println(orgname+" is created==PASS");
		}
		else {
			System.out.println(orgname+" is not created==FAIL");

		}

		String actphoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber+" information is verified==PASS");
		}
		else {
			System.out.println(phoneNumber+" information is not verified==FAIL");
		}
	}

}
