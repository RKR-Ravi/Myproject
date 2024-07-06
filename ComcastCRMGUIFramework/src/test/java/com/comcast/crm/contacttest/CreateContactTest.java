package com.comcast.crm.contacttest;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;
import com.comcast.crm.objectreposotoryutility.ContactPage;
import com.comcast.crm.objectreposotoryutility.CreateNewContactPage;
import com.comcast.crm.objectreposotoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectreposotoryutility.HomePage;
import com.comcast.crm.objectreposotoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "ST")
	public void CreateContactTest() throws Throwable {
		
		String lastName =eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		
		wu.waitForPageToLoad(driver);
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		//cp.getContactLink().click();
		cp.getCreateNewOrgbtn().click();
	
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.CreateContact(lastName);
		
		String actHeader=cp.getHeaderMsg().getText();
		boolean status=actHeader.contains(lastName);
		Assert.assertEquals(status,true);
		String actlastName=cp.getActNameEdt().getText();
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertEquals(actlastName, lastName);
	}
	@Test(groups = "RegressionTest")
	public void createcontactwithorgtest() throws Throwable {

		String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
		String contactLastName=eu.getDataFromExcel("contact", 7, 3);
		
		HomePage hp=new HomePage(driver);
 		hp.getOrgLink().click();
 		
 		OrganizationsPage op=new OrganizationsPage(driver);
 		op.getCreateNewOrgbtn().click();
 		
 		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
 		cop.CreateOrg(orgname);
 		Thread.sleep(3000);
 		hp.getContactLink().click();
		//wu.waitForPageToLoad(driver);
		ContactPage cp=new ContactPage(driver);
		//cp.getContactLink().click();
		cp.getCreateNewOrgbtn().click();
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.CreateContactWithOrg(contactLastName, orgname);
	//switch to child window
		wu.switchToTabonURL(driver, "module=Accounts");
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();	
	//switch to parent window
		wu.switchToTabonURL(driver, "module=Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName+" is created==PASS");
		}
		else {
			System.out.println(contactLastName+" is not created==FAIL");
		}
		 String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.trim().equals(orgname)) {
			System.out.println(orgname+" is created==PASS");
		}
		else {
			System.out.println(orgname+" is not created==FAIL");
		}
	}
	@Test(groups = "RegressionTest")
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
