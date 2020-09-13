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
import AASProductTestCase.AASProductTest.qa.pages.CreditPage;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class CreditPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CreditPage creditPage;
	TestUtil testUtil;
	String menu = "1";
	String CreditLessThanError, CreditMoreThanError;
	String SMACredit_initial, SMACredit_positive,SMACredit_negative,SMACredit_Alphabet;
	String TestSMA, TestMA, TestAG;
	
	public CreditPageTest(){
		super();
	}
	


	//before test case -- launch the browser and login
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		creditPage = new CreditPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickMenu(menu);
		creditPage = homePage.clickOnCredit();
		creditPage.findTestingAccount(prop.getProperty("SMA2"));
		//Test URL data declare
		CreditLessThanError = prop.getProperty("Credit_lessthan_used");
		CreditMoreThanError = prop.getProperty("Credit_morethan_available");
		SMACredit_initial = prop.getProperty("SMA_Initial_Credit");
		SMACredit_positive = prop.getProperty("SMA_Credit_Positive");
		SMACredit_negative = prop.getProperty("SMA_Credit_Negative");
		SMACredit_Alphabet = prop.getProperty("SMA_Credit_Alpahbet");
		TestSMA = prop.getProperty("SMA2");
	}
	
	
	@Test(priority=1)
	public void SMA_Credit_Test_Positive01(ITestContext context) throws InterruptedException {
		//creditPage.searchBtnClick();
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA + " with credit Value : " + SMACredit_positive);
		Thread.sleep(1000);
		//String Rac = creditPage.getAvalCreditValue().replaceAll(",", "").toString();
		//System.out.print("Check!!!!!!!!!!!!!" + Rac);
		Long returnAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long resultGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		Long newCredit = Long.parseLong(SMACredit_positive.toString()); 
		Long incrementPT = newCredit - resultGC;
		Long expectAC = returnAC + incrementPT;
		Thread.sleep(1000);
		context.setAttribute("Process2", "Initial Available Credit Value : " + returnAC + " and Given Credit Value : " + resultGC);
		String returnResult = creditPage.CreditUpdateTest(SMACredit_positive, "Yes");
		Thread.sleep(1000);
		String resultStatus = creditPage.getActivationStatus();
		Long newAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long newGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Success_Message") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Yes",resultStatus);	  
		Assert.assertEquals(newGC,newCredit);
		Assert.assertEquals(expectAC,newAC);
	}
	
	@Test(priority=2)
	public void SMA_Credit_Test_Positive02(ITestContext context) throws InterruptedException {
		creditPage.searchBtnClick();
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA + " with credit Value : " + SMACredit_initial);
		Thread.sleep(1500);
		Long returnAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long resultGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		Long newCredit = Long.parseLong(SMACredit_initial.toString()); 
		Long incrementPT = newCredit - resultGC;
		Long expectAC = returnAC + incrementPT;
		Thread.sleep(1500);
		context.setAttribute("Process2", "Initial Available Credit Value : " + returnAC + " and Given Credit Value : " + resultGC);
		String returnResult = creditPage.CreditUpdateTest(SMACredit_initial, "Yes");
		Thread.sleep(1000);
		String resultStatus = creditPage.getActivationStatus();
		Long newAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long newGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Success_Message") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Yes",resultStatus);
		Assert.assertEquals(newGC,newCredit);
		Assert.assertEquals(expectAC,newAC);
	}
	
	@Test(priority=3)
	public void SMA_Credit_Test_Negative01(ITestContext context) throws InterruptedException {
		creditPage.searchBtnClick();
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA + " with credit Value : " + SMACredit_negative);
		Thread.sleep(1500);
		Long returnAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long resultGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		Thread.sleep(1500);
		context.setAttribute("Process2", "Initial Available Credit Value : " + returnAC + " and Given Credit Value : " + resultGC);
		String returnResult = creditPage.CreditUpdateTest(SMACredit_negative, "Yes");
		creditPage.backBtnClick();
		Thread.sleep(1000);
		String resultStatus = creditPage.getActivationStatus();
		Long newAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long newGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Credit_lessthan_used") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Credit_lessthan_used"),returnResult);
		Assert.assertEquals("Yes",resultStatus);
		Assert.assertEquals(newGC,resultGC);
		Assert.assertEquals(newAC,returnAC);
	}
	
	@Test(priority=4)
	public void SMA_Credit_Test_Negative02(ITestContext context) throws InterruptedException {
		creditPage.searchBtnClick();
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA + " with credit Value : " + SMACredit_Alphabet);
		Thread.sleep(1500);
		Long returnAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long resultGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		Thread.sleep(1500);
		context.setAttribute("Process2", "Initial Available Credit Value : " + returnAC + " and Given Credit Value : " + resultGC);
		String returnResult = creditPage.CreditUpdateTest(SMACredit_Alphabet	, "Yes");
		creditPage.backBtnClick();
		Thread.sleep(1000);
		String resultStatus = creditPage.getActivationStatus();
		Long newAC = Long.parseLong(creditPage.getAvalCreditValue().replaceAll(",", "").toString());
		Long newGC = Long.parseLong(creditPage.getCreditValue().replaceAll(",", "").toString()); 
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Credit_lessthan_used") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Credit_lessthan_used"),returnResult);
		Assert.assertEquals("Yes",resultStatus);
		Assert.assertEquals(newGC,resultGC);
		Assert.assertEquals(newAC,returnAC);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
