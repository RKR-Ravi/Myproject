package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOutLink;
	
	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	
	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	public void NavigateToCampaignsPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		CampaignsLink.click();
	}
	public void Logout() {
		Actions act=new Actions(driver);
		act.moveToElement(AdminImg).perform();
		SignOutLink.click();
	}
	

}
