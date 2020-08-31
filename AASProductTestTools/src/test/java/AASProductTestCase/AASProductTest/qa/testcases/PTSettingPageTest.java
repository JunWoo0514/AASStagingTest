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
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.pages.PTSettingPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSettingPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class PTSettingPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PTSettingPage ptSettingPage;
	TestUtil testUtil;
	String menu = "2";
	String sheetNameCA = "CAPTSetting";
	String sheetNameList = "ProductList";
	double maxCAPT = 100;
	double maxSMAPT = 70;
	double maxMAPT = 50;
	
	String CAInnitialPT,CAPositivePT,CANegativePT01,CANegativePT02;
	String SMAInnitialPT,SMAPositivePT,SMANegativePT01,SMANegativePT02;
	String MAInnitialPT,MAPositivePT,MANegativePT;
	
	public PTSettingPageTest(){
		super();
	}
	
	@DataProvider
	public Object[][] getPTSettingCAData() {
		Object data[][] = TestUtil.getTestData(sheetNameCA);
		return data;
	}
	
	@DataProvider
	public Object[][] getProductListeData() {
		Object data[][] = TestUtil.getTestData(sheetNameList);
		return data;
	}
	

	//before test case -- launch the browser and login
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		ptSettingPage = new PTSettingPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		homePage.clickMenu(menu);
		ptSettingPage = homePage.clickOnPTSetting();
		Thread.sleep(8000);
		ptSettingPage.findTestingAccount(prop.getProperty("SMA1"));
		Thread.sleep(1000);
		
		//CA Tier Test PT data declare
		CAInnitialPT = prop.getProperty("CA_Innitial_GPT");
		CAPositivePT = prop.getProperty("CA_Positive_GPT");
		CANegativePT01 = prop.getProperty("CA_Negative_GPT1");
		CANegativePT02 = prop.getProperty("CA_Negative_GPT2");
		//SMA Tier Test PT data declare
		SMAInnitialPT = prop.getProperty("SMA_Innitial_GPT");
		SMAPositivePT = prop.getProperty("SMA_Positive_GPT");
		SMANegativePT01 = prop.getProperty("SMA_Negative_GPT1");
		SMANegativePT02 = prop.getProperty("SMA_Negative_GPT2");
		//SMA Tier Test PT data declare
		MAInnitialPT = prop.getProperty("MA_Innitial_GPT");
		MAPositivePT = prop.getProperty("MA_Positive_GPT");
		MANegativePT = prop.getProperty("MA_Negative_GPT");

	}
	
	
	@Test(priority=1, dataProvider = "getProductListeData")
	public void PTSettingCAPositiveTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "CA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + CAPositivePT);
		ptSettingPage.PTSettingTestSingle(prdID,CAPositivePT);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + CAPositivePT + " and received value : " + finalGPT);
		Assert.assertEquals(maxCAPT,maxPT);
	}
	
	@Test(priority=2)
	public void PTSettingCAGroupUpdate(ITestContext context) throws InterruptedException {
		ptSettingPage.findTestingAccount(prop.getProperty("SMA1"));
		Thread.sleep(1000);
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "CA Tier Test All Product with PT Value : " + CAInnitialPT);
		ptSettingPage.PTSettingTestAll(CAInnitialPT);
		Thread.sleep(1000);
		maxSMAPT = Double.parseDouble(CAInnitialPT);
	}
	
	@Test(priority=3, dataProvider = "getProductListeData")
	public void PTSettingCAPositiveTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "CA Tier Test On Check on Product : " + productName + " with PT Value : " + CAInnitialPT);		
		Thread.sleep(1000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + CAInnitialPT + " and received value : " + finalGPT);
		Assert.assertEquals(maxCAPT,maxPT);	
	}
	
	@Test(priority=4, dataProvider = "getProductListeData")
	public void PTSettingCANegativeTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "CA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + CANegativePT01);
		ptSettingPage.PTSettingTestSingle(prdID,CANegativePT01);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value will NOT : " + CANegativePT01 + " and received value : " + finalGPT);
		Assert.assertEquals(maxCAPT,maxPT);
	}
	
	@Test(priority=5, dataProvider = "getProductListeData")
	public void PTSettingCANegativeTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "CA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + CANegativePT02);
		ptSettingPage.PTSettingTestSingle(prdID,CANegativePT02);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value will NOT : " + CANegativePT02 + " and received value : " + finalGPT);
		Assert.assertEquals(maxCAPT,maxPT);
	}
	
	///////SMA Tier Test///////
	
	@Test(priority=5)
	public void ProceedSMACheck() throws InterruptedException {
		ptSettingPage.DownlineClick();
		Thread.sleep(1000);
		ptSettingPage.findTestingAccount(prop.getProperty("MA1"));
		//Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=6, dataProvider = "getProductListeData")
	public void PTSettingSMAGivenPTCheck(String prdID, String productName, ITestContext context) throws InterruptedException {
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "SMA Tier Test On Check on Product : " + productName + " with expected PT Value : " + maxSMAPT);		
		Thread.sleep(1000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + maxSMAPT + " and received value : " + maxPT);
		Assert.assertEquals(maxSMAPT,maxPT);	
	}
	
	@Test(priority=7, dataProvider = "getProductListeData")
	public void PTSettingSMAPositiveTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "SMA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + SMAPositivePT);
		ptSettingPage.PTSettingTestSingle(prdID,SMAPositivePT);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + SMAPositivePT + " and received value : " + finalGPT);
		Assert.assertEquals(maxSMAPT,maxPT);
	}
	
	@Test(priority=8, dataProvider = "getProductListeData")
	public void PTSettingSMANegativeTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "SMA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + SMANegativePT01);
		ptSettingPage.PTSettingTestSingle(prdID,SMANegativePT01);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value will NOT : " + SMANegativePT01 + " and received value : " + finalGPT);
		Assert.assertEquals(maxSMAPT,maxPT);
		Assert.assertNotEquals(SMANegativePT01, finalGPT);
	}
	
	@Test(priority=9, dataProvider = "getProductListeData")
	public void PTSettingSMANegativeTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResult(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "SMA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + SMANegativePT02);
		ptSettingPage.PTSettingTestSingle(prdID,SMANegativePT02);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value will NOT : " + SMANegativePT02 + " and received value : " + finalGPT);
		Assert.assertEquals(maxSMAPT,maxPT);
		Assert.assertNotEquals(SMANegativePT02, finalGPT);
	}
	
	@Test(priority=10)
	public void PTSettingSMAGroupUpdate(ITestContext context) throws InterruptedException {
		ptSettingPage.findTestingAccount(prop.getProperty("MA1"));
		Thread.sleep(1000);
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "SMA Tier Test All Product with PT Value : " + SMAInnitialPT);
		ptSettingPage.PTSettingTestAll(SMAInnitialPT);
		Thread.sleep(1000);
		maxMAPT = Double.parseDouble(SMAInnitialPT);
	}
	
	@Test(priority=11, dataProvider = "getProductListeData")
	public void PTSettingSMAPositiveTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "SMA Tier Test On Check on Product : " + productName + " with PT Value : " + SMAInnitialPT);		
		Thread.sleep(1000);
		String finalGPT = ptSettingPage.getGivenPTResult(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + SMAInnitialPT + " and received value : " + finalGPT);
		Assert.assertEquals(maxSMAPT,maxPT);	
	}
	
	///////MA Tier Test///////
	
	@Test(priority=12)
	public void ProceedMACheck() throws InterruptedException {
		ptSettingPage.DownlineClick();
		Thread.sleep(1000);
		ptSettingPage.findTestingAccount(prop.getProperty("AG1"));
		//Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=13, dataProvider = "getProductListeData")
	public void PTSettingMAGivenPTCheck(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "MA Tier Test On Check on Product : " + productName + " with expected PT Value : " + maxMAPT);		
		Thread.sleep(1000);
		String finalGPT = ptSettingPage.getGivenPTResultAG(prdID);
		System.out.print("Check Return!!!! : " + finalGPT);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + maxMAPT + " and received value : " + maxPT);
		Assert.assertEquals(maxMAPT,maxPT);	
	}
	
	@Test(priority=14, dataProvider = "getProductListeData")
	public void PTSettingMAPositiveTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResultAG(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "MA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + MAPositivePT);
		ptSettingPage.PTSettingTestSingle(prdID,MAPositivePT);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResultAG(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + MAPositivePT + " and received value : " + finalGPT);
		Assert.assertEquals(maxMAPT,maxPT);
	}
	
	@Test(priority=15, dataProvider = "getProductListeData")
	public void PTSettingMANegativeTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "3");
		String initialGPT = ptSettingPage.getGivenPTResultAG(prdID);
		String initialEPT = ptSettingPage.getEffectivePTResult(prdID);
		context.setAttribute("Process1", "MA Tier Test On Product : " + productName + " initial Given PT Value : " + initialGPT 
							+ ", initial Effective PT Value : " + initialEPT);
		context.setAttribute("Process2", "Test with Product : " + productName + " with PT Value : " + MANegativePT);
		ptSettingPage.PTSettingTestSingle(prdID,MANegativePT);
		Thread.sleep(2000);
		String finalGPT = ptSettingPage.getGivenPTResultAG(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value will NOT : " + MANegativePT + " and received value : " + finalGPT);
		Assert.assertEquals(maxMAPT,maxPT);
		Assert.assertNotEquals(MANegativePT, finalGPT);
	}
	
	@Test(priority=16)
	public void PTSettingMAGroupUpdate(ITestContext context) throws InterruptedException {
		ptSettingPage.findTestingAccount(prop.getProperty("AG1"));
		Thread.sleep(1000);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "MA Tier Test All Product with PT Value : " + MAInnitialPT);
		ptSettingPage.PTSettingTestAll(MAInnitialPT);
		Thread.sleep(1000);
	}
	
	@Test(priority=17, dataProvider = "getProductListeData")
	public void PTSettingMAPositiveTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "MA Tier Test On Check on Product : " + productName + " with PT Value : " + MAInnitialPT);		
		Thread.sleep(1000);
		String finalGPT = ptSettingPage.getGivenPTResultAG(prdID);
		String finalEPT = ptSettingPage.getEffectivePTResult(prdID);
		double newGPT = Double.parseDouble(finalGPT);
		double newEPT = Double.parseDouble(finalEPT);
		double maxPT = newGPT + newEPT;
		context.setAttribute("Result", "Result expected value : " + MAInnitialPT + " and received value : " + finalGPT);
		Assert.assertEquals(maxMAPT,maxPT);	
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
