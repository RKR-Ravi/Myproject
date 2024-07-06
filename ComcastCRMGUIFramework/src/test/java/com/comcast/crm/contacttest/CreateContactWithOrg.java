package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.objectreposotoryutility.ContactPage;
import com.comcast.crm.objectreposotoryutility.CreateNewContactPage;
import com.comcast.crm.objectreposotoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectreposotoryutility.HomePage;
import com.comcast.crm.objectreposotoryutility.OrganizationsPage;

public class CreateContactWithOrg extends BaseClass{
	@Test
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
}
