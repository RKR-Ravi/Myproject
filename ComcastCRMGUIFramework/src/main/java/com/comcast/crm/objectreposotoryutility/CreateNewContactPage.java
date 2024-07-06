package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement imglookupbtn;
	
	@FindBy(name = "search_text")
	private WebElement orgsearch;
	
	public WebElement getOrgsearch() {
		return orgsearch;
	}
	public WebElement getImglookupbtn() {
		return imglookupbtn;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getLastname() {
		return lastnameEdt;
	}
	
	public void CreateContact(String lastName) {
		lastnameEdt.sendKeys(lastName);
		savebtn.click();
	}
	public void CreateContactWithOrg(String lastname,String orgname) {
		lastnameEdt.sendKeys(lastname);
		imglookupbtn.click();
	}
	public void Createcontact(String lastName) {
		lastnameEdt.sendKeys(lastName);
		
	//	savebtn.click();
	}

}
