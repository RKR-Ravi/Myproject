package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactTest {
	WebDriver driver;
	public CreateNewContactTest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void CreateContact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		savebtn.click();
	}
}
