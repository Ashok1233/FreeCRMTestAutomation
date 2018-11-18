package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
    WebElement loginBTN;
	
	
	@FindBy(xpath="//font[contains(.,'Sign Up')]")
	WebElement sigupBTN;
	
	@FindBy(xpath="//img[contains(@src,'https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg')]")
	WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	
	
	public HomePage login(String un,String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginBTN.click();
		return new HomePage();
		
	}
	

}
