package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement indistrydropdown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(id = "phone")
	private WebElement phoneEdt;

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	public WebElement getIndistrydropdown() {
		return indistrydropdown;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void CreateOrg(String orgname) {
		OrgNameEdt.sendKeys(orgname);
		savebtn.click();
	}
	public void CreateOrg(String orgname,String industry) {
		OrgNameEdt.sendKeys(orgname);
		Select sel=new Select(indistrydropdown);
		sel.selectByVisibleText(industry);
		savebtn.click();
	}
	public void CreateOrganization(String orgname,String phonenumber) {
		OrgNameEdt.sendKeys(orgname);
		phoneEdt.sendKeys(phonenumber);
		savebtn.click();
	}
	
}
