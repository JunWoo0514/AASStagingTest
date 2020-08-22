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
	
	public ExtraPTPageTest(){
		super();
	}
	
	
	@DataProvider
	public Object[][] getExtraPTPositiveData() {
		Object data[][] = TestUtil.getTestData(sheetName);
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
		
		if(menu.equals("2")) {
			homePage.clickMenu(menu);
			if(item.equals("4")) {
				extraPtPage = homePage.clickOnExtraPT();
			}
		}
		extraPtPage.findTestingAccount(prop.getProperty("testaccount"));
	}
	
	
	@Test(dataProvider = "getExtraPTPositiveData")
	public void ExtraPTTest(String prdID, String ptValue, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + prdID + "with PT Value : " + ptValue);
		extraPtPage.ExtraPTPositiveTest(prdID,ptValue);
		double resultPT = new Double(ptValue);
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
