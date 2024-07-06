package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;
import com.comcast.crm.listenerutility.ListenerImplementationClass;
import com.comcast.crm.objectreposotoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectreposotoryutility.HomePage;
import com.comcast.crm.objectreposotoryutility.LoginPage;
import com.comcast.crm.objectreposotoryutility.OrganizationInformationPage;
import com.comcast.crm.objectreposotoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrganizationTestWithPom extends BaseClass{
	@Test(groups = "ST")
	public void CreateOrganizationTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO,"read the data from Excel");
		String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
         wu.waitForPageToLoad(driver);
 	//	LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
         UtilityClassObject.getTest().log(Status.INFO,"Navigate to org page");
 		HomePage hp=new HomePage(driver);
 		hp.getOrgLink().click();
 		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create org page");
 		OrganizationsPage op=new OrganizationsPage(driver);
 		op.getCreateNewOrgbtn().click();
 		UtilityClassObject.getTest().log(Status.INFO,"Create a new Org");
 		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
 		cop.CreateOrg(orgname);
 		UtilityClassObject.getTest().log(Status.INFO,"===Create a new org");
 		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
 		String actOrgName=oip.getHeaderMsg().getText();
 		if(actOrgName.contains(orgname)) {
 			System.out.println(orgname+" name is verified===PASS===");
 		}
 		else {
 			System.out.println(orgname+" name is not verified===FAIL===");
 		}
	}
	@Test(groups = "RegressionTest")
	public void CreateOrgWithindustryTest1() throws Throwable {
		String orgname =eu.getDataFromExcel("Sample", 1, 2)+ju.getRandomNumber();
		String industry=eu.getDataFromExcel("Sample", 4, 4);
		String type=eu.getDataFromExcel("Sample", 4, 5);
			wu.waitForPageToLoad(driver);
	 		HomePage hp=new HomePage(driver);
	 		hp.getOrgLink().click();
	 		OrganizationsPage op=new OrganizationsPage(driver);
	 		op.getCreateNewOrgbtn().click();
	 		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	 		cop.CreateOrg(orgname, industry);
//		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		WebElement wbsele=   driver.findElement(By.name("industry"));
//		Select se1=new Select(wbsele);
//		se1.selectByVisibleText(industry);
		
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
		String actType=driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(type)) {
			System.out.println(type+" information is verified==PASS");
		}
		else {
			System.out.println(type+" information is not verified==FAIL");
		}
	}
	@Test(groups = "RegressionTest")
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
