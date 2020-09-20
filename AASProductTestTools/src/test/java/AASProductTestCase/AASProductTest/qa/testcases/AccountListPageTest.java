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
import AASProductTestCase.AASProductTest.qa.pages.AccountListPage;
import AASProductTestCase.AASProductTest.qa.pages.AgActivationPage;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class AccountListPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AccountListPage accountListPage;
	TestUtil testUtil;
	String menu = "1";
	String TestSMA, TestMA, TestAG;
	String adminType, password, initPassword, name, memo, invalidPassword1, invalidPassword2;
	String initStatus, initSuspend, initLock, initName, initMemo;
	String newStatus, newSuspend, newLock, newName, newMemo;
	int returnOpenResult, returnClosedResult, returnAllResult, totalAcc;
	
	public AccountListPageTest(){
		super();
	}
	
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		accountListPage = new AccountListPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickMenu(menu);
		accountListPage = homePage.clickOnAccountList();		
		//Test account declare
		TestSMA = prop.getProperty("SMA2");
		TestMA = prop.getProperty("MA2");
		TestAG = prop.getProperty("AG2");
		adminType = prop.getProperty("AdminTypeS"); 
		password = prop.getProperty("password2"); 
		name = prop.getProperty("Test_Name");
		memo = prop.getProperty("Test_Memo");
		initPassword = prop.getProperty("password");
		invalidPassword1 = prop.getProperty("invalidPassword1");
		invalidPassword2 = prop.getProperty("invalidPassword2");
	}
	
	@Test(priority=1)
	public void AccountListStatusFilterTest(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with accpunt status filter section.");
		returnOpenResult = Integer.parseInt(accountListPage.getAccountCount("Open"));
		Thread.sleep(1000);
		returnClosedResult = Integer.parseInt(accountListPage.getAccountCount("Closed"));
		Thread.sleep(1000);
		returnAllResult = Integer.parseInt(accountListPage.getAccountCount("All"));
		Thread.sleep(1000);
		totalAcc = returnOpenResult + returnClosedResult;
		Thread.sleep(1000);
		context.setAttribute("Result", "Result expected value : "+ totalAcc +" and received value : " + returnAllResult);
		Assert.assertEquals(totalAcc,returnAllResult);
	}
	
	@Test(priority=2)
	public void SMA_Filter(ITestContext context) throws InterruptedException {
		accountListPage.findTestingAccount(TestSMA);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "Filter with account : "+TestSMA);
		//Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=3)
	public void AccountListUpdateTestSMA01(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA + " with all close status.");
		Thread.sleep(1000);
		initStatus = accountListPage.getAccountStatus("SMA");
		initSuspend = accountListPage.getSuspendStatus("SMA");
		initLock = accountListPage.getLockStatus("SMA");
		initName = accountListPage.getName("SMA");
		initMemo = accountListPage.getMemo("SMA");
		context.setAttribute("Process2", "Initial Status: " + initStatus + ", Initial Suspend Status : " + initSuspend
							+ ", Initial Lock Status : " + initLock + ", Initial Name : " + initName + ", Initial Memo : " + initMemo);
		String returnResult = accountListPage.AccountUpdateTest("SMA", password, name, memo, "Close");
		Thread.sleep(2000);
		newStatus = accountListPage.getAccountStatus("SMA");
		newSuspend = accountListPage.getSuspendStatus("SMA");
		newLock = accountListPage.getLockStatus("SMA");
		newName = accountListPage.getName("SMA");
		newMemo = accountListPage.getMemo("SMA");
		context.setAttribute("Result", "Return Status: " + newStatus + ", Return Suspend Status : " + newSuspend
				+ ", Return Lock Status : " + newLock + ", Return Name : " + newName + ", Return Memo : " + newMemo);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Closed",newStatus);
		Assert.assertEquals("Yes",newSuspend);
		Assert.assertEquals("Yes",newLock);
		Assert.assertNotEquals(initName,newName);
		Assert.assertNotEquals(initMemo,newMemo);
	}
	
	@Test(priority=4)
	public void AccountListUpdateTestSMA02(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA  + " with all open status.");
		Thread.sleep(1000);
		initStatus = accountListPage.getAccountStatus("SMA");
		initSuspend = accountListPage.getSuspendStatus("SMA");
		initLock = accountListPage.getLockStatus("SMA");
		initName = accountListPage.getName("SMA");
		initMemo = accountListPage.getMemo("SMA");
		context.setAttribute("Process2", "Initial Status: " + initStatus + ", Initial Suspend Status : " + initSuspend
							+ ", Initial Lock Status : " + initLock + ", Initial Name : " + initName + ", Initial Memo : " + initMemo);
		String returnResult = accountListPage.AccountUpdateTest("SMA", initPassword, name, memo, "Open");
		Thread.sleep(2000);
		newStatus = accountListPage.getAccountStatus("SMA");
		newSuspend = accountListPage.getSuspendStatus("SMA");
		newLock = accountListPage.getLockStatus("SMA");
		newName = accountListPage.getName("SMA");
		newMemo = accountListPage.getMemo("SMA");
		context.setAttribute("Result", "Return Status: " + newStatus + ", Return Suspend Status : " + newSuspend
				+ ", Return Lock Status : " + newLock + ", Return Name : " + newName + ", Return Memo : " + newMemo);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Open",newStatus);
		Assert.assertEquals("No",newSuspend);
		Assert.assertEquals("No",newLock);
		Assert.assertNotEquals(initName,newName);
		Assert.assertNotEquals(initMemo,newMemo);
	}  
	
	@Test(priority=5)
	public void AccountListUpdateTestSMANegative01(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA  + " with Invalid Password : " + invalidPassword1);
		Thread.sleep(1000);
		String returnResult = accountListPage.AccountUpdateTest("SMA", invalidPassword1, name, memo, "Open");
		accountListPage.backBtnClick("SMA");
		Thread.sleep(2000);
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Alph_Password_error") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Alph_Password_error"),returnResult);
	}  
	
	@Test(priority=6)
	public void AccountListUpdateTestSMANegative02(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process1", "Test with SMA : " + TestSMA  + " with Invalid Password : " + invalidPassword2);
		Thread.sleep(1000);
		String returnResult = accountListPage.AccountUpdateTest("SMA", invalidPassword2, name, memo, "Open");
		accountListPage.backBtnClick("SMA");
		Thread.sleep(2000);
		context.setAttribute("Result", "Result expected value : ("+ prop.getProperty("Length_Password_error") +") and received value : (" + returnResult +")");
		Assert.assertEquals(prop.getProperty("Length_Password_error"),returnResult);
	}  
	
	///////SMA Tier Test///////
	
	@Test(priority=7)
	public void ProceedSMACheck(ITestContext context) throws InterruptedException {
		accountListPage.downLineLinkClick();
		Thread.sleep(1000);
		String AllAccountCount = accountListPage.getAccountCount("All");
		accountListPage.findTestingAccount(TestMA);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "Filter with account : ."+TestMA);
	}
	
	@Test(priority=8)
	public void AccountListUpdateTestMA01(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with MA : " + TestMA + " with all close status.");
		Thread.sleep(1000);
		initStatus = accountListPage.getAccountStatus("MA");
		initSuspend = accountListPage.getSuspendStatus("MA");
		initLock = accountListPage.getLockStatus("MA");
		initName = accountListPage.getName("MA");
		initMemo = accountListPage.getMemo("MA");
		context.setAttribute("Process2", "Initial Status: " + initStatus + ", Initial Suspend Status : " + initSuspend
							+ ", Initial Lock Status : " + initLock + ", Initial Name : " + initName + ", Initial Memo : " + initMemo);
		String returnResult = accountListPage.AccountUpdateTest("MA", initPassword, name, memo, "Close");
		Thread.sleep(2000);
		newStatus = accountListPage.getAccountStatus("MA");
		newSuspend = accountListPage.getSuspendStatus("MA");
		newLock = accountListPage.getLockStatus("MA");
		newName = accountListPage.getName("MA");
		newMemo = accountListPage.getMemo("MA");
		context.setAttribute("Result", "Return Status: " + newStatus + ", Return Suspend Status : " + newSuspend
				+ ", Return Lock Status : " + newLock + ", Return Name : " + newName + ", Return Memo : " + newMemo);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Closed",newStatus);
		Assert.assertEquals("Yes",newSuspend);
		Assert.assertEquals("Yes",newLock);
		Assert.assertNotEquals(initName,newName);
		Assert.assertNotEquals(initMemo,newMemo);
	}
	
	@Test(priority=9)
	public void AccountListUpdateTestMA02(ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		context.setAttribute("Process1", "Test with MA : " + TestMA + " with all close status.");
		Thread.sleep(1000);
		initStatus = accountListPage.getAccountStatus("MA");
		initSuspend = accountListPage.getSuspendStatus("MA");
		initLock = accountListPage.getLockStatus("MA");
		initName = accountListPage.getName("MA");
		initMemo = accountListPage.getMemo("MA");
		context.setAttribute("Process2", "Initial Status: " + initStatus + ", Initial Suspend Status : " + initSuspend
							+ ", Initial Lock Status : " + initLock + ", Initial Name : " + initName + ", Initial Memo : " + initMemo);
		String returnResult = accountListPage.AccountUpdateTest("MA", password, name, memo, "Open");
		Thread.sleep(2000);
		newStatus = accountListPage.getAccountStatus("MA");
		newSuspend = accountListPage.getSuspendStatus("MA");
		newLock = accountListPage.getLockStatus("MA");
		newName = accountListPage.getName("MA");
		newMemo = accountListPage.getMemo("MA");
		context.setAttribute("Result", "Return Status: " + newStatus + ", Return Suspend Status : " + newSuspend
				+ ", Return Lock Status : " + newLock + ", Return Name : " + newName + ", Return Memo : " + newMemo);
		Assert.assertEquals(prop.getProperty("Success_Message"),returnResult);
		Assert.assertEquals("Open",newStatus);
		Assert.assertEquals("No",newSuspend);
		Assert.assertEquals("No",newLock);
		Assert.assertNotEquals(initName,newName);
		Assert.assertNotEquals(initMemo,newMemo);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
