package AASProductTestCase.AASProductTest.qa.testcases;

import java.text.DecimalFormat;

import org.testng.Assert;
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
	
	//static String testPT = "14.5";
	
	
	/*@DataProvider(name="ExtraPTCase")
	public static Object[][] dataProviderExtraPTCase() {
			return new Object[][]{
			{"PIKACHU","1",testPT},
			{"PIKACHU","2",testPT},
			{"PIKACHU","3",testPT},
			{"PIKACHU","4",testPT},
			{"PIKACHU","5",testPT},
			{"PIKACHU","6",testPT},
			{"PIKACHU","7",testPT},
			{"PIKACHU","8",testPT},
			{"PIKACHU","9",testPT},
			{"PIKACHU","10",testPT},
			{"PIKACHU","11",testPT},
			{"PIKACHU","12",testPT},
			{"PIKACHU","13",testPT},
			{"PIKACHU","14",testPT}
		};
	}*/
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
	public void ExtraPTTest(String prdID, String ptValue) throws InterruptedException {
		extraPtPage.ExtraPTPositiveTest(prdID,ptValue);
		double resultPT = new Double(ptValue);
		DecimalFormat formatter = new DecimalFormat("#0.00");
		Thread.sleep(2000);
		Assert.assertEquals(formatter.format(resultPT), extraPtPage.getPTResult(prdID, formatter.format(resultPT)));
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
