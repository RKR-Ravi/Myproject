package com.comcast.crm.objectreposotoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.webDriverUtility;
/**
 * 
 * @author RaviKumar Reddy
 * 
 * containsLogin Page elements and business lib like login()
 *
 */
public class LoginPage extends webDriverUtility {   //Rule-1 create a separate java class
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Rule-2 object creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//Rule-3 object Intialization
		//Rule-4 object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * Login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void LoginToapp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
	}
	
	
	
	

	

}
