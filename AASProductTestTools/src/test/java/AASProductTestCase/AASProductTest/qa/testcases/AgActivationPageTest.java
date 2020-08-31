package AASProductTestCase.AASProductTest.qa.testcases;

import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AASProductTestCase.AASProductTest.qa.base.TestBase;
import AASProductTestCase.AASProductTest.qa.pages.AgActivationPage;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class AgActivationPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AgActivationPage agActivationPage;
	TestUtil testUtil;
	String menu = "1";
	String TestURLPositive, TestURLNegative;
	
	public AgActivationPageTest(){
		super();
	}
	


	//before test case -- launch the browser and login
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		agActivationPage = new AgActivationPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickMenu(menu);
		agActivationPage = homePage.clickOnAgActivation();
		agActivationPage.findTestingAccount(prop.getProperty("testaccount"));
		//Test URL data declare
		TestURLPositive = prop.getProperty("URL_P");
		TestURLNegative = prop.getProperty("URL_N");
	}
	
	
	@Test(priority=1)
	public void AGActivationTest01(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with URL : " + TestURLPositive + " with status Value : Yes");
		String returnResult = agActivationPage.ActivationUpdateTest(TestURLPositive,"Yes");
		Thread.sleep(2000);
		String resultStatus = agActivationPage.getActivationStatus();
		context.setAttribute("Result", "Result expected value : Yes and received value : " + resultStatus);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Yes",resultStatus);
	}
	
	@Test(priority=2)
	public void AGActivationTest02(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with URL : " + TestURLPositive + " with status Value : No");
		String returnResult = agActivationPage.ActivationUpdateTest(TestURLPositive,"No");
		Thread.sleep(2000);
		String resultStatus = agActivationPage.getActivationStatus();
		context.setAttribute("Result", "Result expected value : No and received value : " + resultStatus);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("No",resultStatus);
	}
	
	@Test(priority=3)
	public void AGActivationTest03(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with URL : " + TestURLNegative + " with status Value : Yes");
		String returnResult = agActivationPage.ActivationUpdateTest(TestURLNegative,"Yes");
		Thread.sleep(2000);
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Invalid_URL") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Invalid_URL"),returnResult);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
