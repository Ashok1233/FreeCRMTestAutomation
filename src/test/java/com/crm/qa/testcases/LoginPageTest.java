package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		log.info("chrome browser is launching");
		initialization();
		log.info("application is launched");
		log.info("loginpage is initialized");
		
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("testing loginPageTitle");
		String title = loginPage.validateLoginPageTitle();
		log.info("comparing the loginpageTitle");
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	/*@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
	homePage	=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}*/
	
	@AfterMethod
	public void tearDown() {
		log.info("closing the browser");
		driver.quit();
		
	}

}
