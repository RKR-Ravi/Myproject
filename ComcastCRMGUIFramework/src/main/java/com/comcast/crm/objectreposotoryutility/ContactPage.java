package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLink;
	public WebElement getContactLink() {
		return contactLink;
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOrgbtn;
	public WebElement getCreateNewOrgbtn() {
		return createNewOrgbtn;
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(id = "dtlview_Last Name")
	private WebElement actNameEdt;
	public WebElement getActNameEdt() {
		return actNameEdt;
	}
	
}
