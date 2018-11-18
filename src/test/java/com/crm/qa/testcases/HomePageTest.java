package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Thread.sleep(2000);
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	 @Test(priority=1)
	 public void verifyHomePageTitleTest() throws InterruptedException {
		 Thread.sleep(2000);
		 String homePageTitle = homePage.verifyHomePageTitle();
		 Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not Matched");
		 Thread.sleep(1000);
		 
	 }
	 
	 @Test(priority=2)
	 public void verifyUserNameTest() throws InterruptedException {
		 testUtil.switchToFrame();
		 
		 
		Assert.assertTrue(homePage.verifyCorrectUserName());
	 } 
	 
	 @Test(priority=3)
	 public void verifyContactsLinkTest() {
		 testUtil.switchToFrame();
		 contactsPage=homePage.clickOnContactsLink();
		 
	 }
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

