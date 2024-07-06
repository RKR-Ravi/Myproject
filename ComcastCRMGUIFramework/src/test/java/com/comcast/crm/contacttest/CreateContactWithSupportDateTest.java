package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;
import com.comcast.crm.objectreposotoryutility.ContactPage;
import com.comcast.crm.objectreposotoryutility.CreateNewContactPage;

public class CreateContactWithSupportDateTest extends BaseClass{
	@Test
	public void CreateContactWithSupportDateTest() throws Throwable {
		
		String lastName=eu.getDataFromExcel("contact", 4, 2)+ju.getRandomNumber();
		String startDate=ju.getSystemDateYYYYMMDD();
		String endDate=ju.getRequiredDateYYYYMMDD(5);
		wu.waitForPageToLoad(driver);
		ContactPage cp=new ContactPage(driver);
		cp.getContactLink().click();
		cp.getCreateNewOrgbtn().click();
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.Createcontact(lastName);
		ju.getSystemDateYYYYMMDD();
		ju.getRequiredDateYYYYMMDD(30);
		ccp.getSavebtn().click();
		
		String actlastName= driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actlastName.equals(lastName)) {
			System.out.println(lastName+" is verified==PASS");
		}
		else {
			System.out.println(lastName+" is not verified==FAIL");
		}
		
		String actstartDate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartDate.equals(startDate)) {
			System.out.println(startDate+" is verified==PASS");
		}
		else {
			System.out.println(startDate+" is not verified==FAIL");
		}
		
		String actendDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actendDate.equals(endDate)) {
			System.out.println(endDate+" is verified==PASS");
		}
		else {
			System.out.println(endDate+" is not verified==FAIL");
		}
	}

}
