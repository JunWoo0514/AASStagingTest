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
import AASProductTestCase.AASProductTest.qa.pages.ExtraPTPage;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class ExtraPTPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ExtraPTPage extraPtPage;
	TestUtil testUtil;
	String menu = "2";
	String item = "4";
	String sheetName = "PositiveExtra";
	String sheetNameList = "ProductList";
	String InnitialExtraPT;
	
	public ExtraPTPageTest(){
		super();
	}
	
	
	@DataProvider
	public Object[][] getExtraPTPositiveData() {
		Object data[][] = TestUtil.getTestData(sheetName);
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
		extraPtPage = new ExtraPTPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		

		homePage.clickMenu(menu);

		extraPtPage = homePage.clickOnExtraPT();

		extraPtPage.findTestingAccount(prop.getProperty("testaccount"));
		//Initial Extra PT data declare
		InnitialExtraPT = prop.getProperty("Initial_EPT");
	}
	
	
	@Test(priority=1, dataProvider = "getExtraPTPositiveData")
	public void ExtraPTTest(String prdID, String ptValue, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + prdID + "with PT Value : " + ptValue);
		extraPtPage.ExtraPTPositiveTest(prdID,ptValue);
		double resultPT = new Double(ptValue);
		DecimalFormat formatter = new DecimalFormat("#0.00");
		Thread.sleep(2500);
		String result = extraPtPage.getPTResult(prdID, formatter.format(resultPT));
		context.setAttribute("Result", "Result expected PT : " + formatter.format(resultPT) + " and received PT : " + result);
		Assert.assertEquals(formatter.format(resultPT),result);
	}
	
	@Test(priority=2)
	public void ExtraPTGroupUpdate(ITestContext context) throws InterruptedException {
		extraPtPage.findTestingAccount(prop.getProperty("AG1"));
		Thread.sleep(1000);
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "Test Set All Product with Extral PT Value : " + InnitialExtraPT);
		extraPtPage.ExtraPTPositiveTestAll(InnitialExtraPT);
		Thread.sleep(1000);
	}
	
	@Test(priority=3, dataProvider = "getProductListeData")
	public void ExtraPTTest02(String prdID, String productName, ITestContext context) throws InterruptedException {
		//String newPT = prop.getProperty("CA_Innitial_GPT");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Extra PT Test On Check on Product : " + productName + " with PT Value : " + InnitialExtraPT);		
		Thread.sleep(1000);
		double resultPT = new Double(InnitialExtraPT);
		DecimalFormat formatter = new DecimalFormat("#0.00");
		Thread.sleep(2000);
		String result = extraPtPage.getPTResult(prdID, formatter.format(resultPT));
		context.setAttribute("Result", "Result expected PT : " + formatter.format(resultPT) + " and received PT : " + result);
		Assert.assertEquals(formatter.format(resultPT),result);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
