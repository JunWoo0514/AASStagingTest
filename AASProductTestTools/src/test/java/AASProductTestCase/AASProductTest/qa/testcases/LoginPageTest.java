package AASProductTestCase.AASProductTest.qa.testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AASProductTestCase.AASProductTest.qa.base.TestBase;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("siteTitle"));
	}
	
	@Test(priority=2)
	public void loginTestNegative01(ITestContext context) {
		context.setAttribute("AdminID", prop.getProperty("username"));
		context.setAttribute("Password", prop.getProperty("wrongPassword"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("wrongPassword"));
		Assert.assertEquals(prop.getProperty("Credentials_not_match"), loginPage.getErrorMessage());
	}
	
	@Test(priority=3)
	public void loginTestNegative02(ITestContext context) {
		context.setAttribute("AdminID", prop.getProperty("wrongUserName"));
		context.setAttribute("Password", prop.getProperty("wrongPassword"));
		loginPage.login(prop.getProperty("wrongUserName"), prop.getProperty("wrongPassword"));
		Assert.assertEquals(prop.getProperty("Credentials_not_exists"), loginPage.getErrorMessage());
	}
	
	@Test(priority=4)
	public void LoginTest(ITestContext context){
		context.setAttribute("AdminID", prop.getProperty("username"));
		context.setAttribute("Password", prop.getProperty("password"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
