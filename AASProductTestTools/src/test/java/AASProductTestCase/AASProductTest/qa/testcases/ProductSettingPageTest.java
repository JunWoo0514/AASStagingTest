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
import AASProductTestCase.AASProductTest.qa.pages.ProductSettingPage;
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class ProductSettingPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductSettingPage productSettingPage;
	TestUtil testUtil;
	String menu = "2";
	String sheetName = "ProductList";
	
	public ProductSettingPageTest(){
		super();
	}
	
	@DataProvider
	public Object[][] getProductListeData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@DataProvider(name="ActiveData")
	public static Object[][] dataProviderStatusActiveCase() {
			return new Object[][]{
			{"1","Active"},
		};
	}
	
	@DataProvider(name="DisabledData")
	public static Object[][] dataProviderStatusDisableCase() {
			return new Object[][]{
			{"1","Disabled"},
		};
	}

	//before test case -- launch the browser and login
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		productSettingPage = new ProductSettingPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		homePage.clickMenu(menu);
		productSettingPage = homePage.clickOnProductSetting();

		productSettingPage.findTestingAccount(prop.getProperty("SMA2"));
		Thread.sleep(1000);
	}
	
	
	@Test(priority=1, dataProvider = "getProductListeData")
	public void ProductStatusPositiveTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + productName + " with Status Value : " + newStatus);
		productSettingPage.ProductStatusPositiveTest(prdID,newStatus);
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=2)
	public void ProductSettingSMAGroupUpdate(ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		productSettingPage.findTestingAccount(prop.getProperty("SMA2"));
		Thread.sleep(1000);
		
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "SMA Tier Test All Product with status Value : " + newStatus);
		productSettingPage.ProductStatusGroupTest(newStatus);
		Thread.sleep(1000);
	}
	
	@Test(priority=3, dataProvider = "getProductListeData")
	public void SMAProductStatusGroupActiveTest(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "SMA Tier Check on Product : " + productName + " with Status Value : " + newStatus);		
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=4)
	public void ProceedMACheck() throws InterruptedException {
		productSettingPage.DownlineClick();
		Thread.sleep(1000);
		productSettingPage.findTestingAccount(prop.getProperty("MA2"));
		//Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=5, dataProvider = "getProductListeData")
	public void ProductStatusDownlineCheck_MA(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Downline product status on Product : " + productName + " to check status must be : " + newStatus);
		Thread.sleep(1000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=6, dataProvider = "getProductListeData")
	public void ProductSettingMASingleUpdate(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + productName + " with Status Value : " + newStatus);
		productSettingPage.ProductStatusPositiveTest(prdID,newStatus);
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=7)
	public void ProductSettingMAGroupUpdate(ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		productSettingPage.findTestingAccount(prop.getProperty("MA2"));
		Thread.sleep(1000);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "MA Tier Test All Product with status Value : " + newStatus);
		productSettingPage.ProductStatusGroupTest(newStatus);
		Thread.sleep(1000);
	}
	
	@Test(priority=8, dataProvider = "getProductListeData")
	public void MAProductStatusGroupActiveTest(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "MA Tier Check on Product : " + productName + " with Status Value : " + newStatus);		
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=9)
	public void ProductSettingMAGroupUpdate02(ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		productSettingPage.findTestingAccount(prop.getProperty("MA2"));
		Thread.sleep(1000);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "MA Tier Test All Product with status Value : " + newStatus);
		productSettingPage.ProductStatusGroupTest(newStatus);
		Thread.sleep(1000);
	}
	
	@Test(priority=10)
	public void ProceedAGCheck() throws InterruptedException {
		productSettingPage.DownlineClick();
		Thread.sleep(1000);
		productSettingPage.findTestingAccount(prop.getProperty("AG2"));
		//Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=11, dataProvider = "getProductListeData")
	public void ProductStatusDownlineCheck_AG(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Downline product status on Product : " + productName + " to check status must be : " + newStatus);
		Thread.sleep(1000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=12, dataProvider = "getProductListeData")
	public void ProductSettingAGSingleUpdate(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + productName + " with Status Value : " + newStatus);
		productSettingPage.ProductStatusPositiveTest(prdID,newStatus);
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=13)
	public void ProductSettingAGroupUpdate(ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		productSettingPage.findTestingAccount(prop.getProperty("AG2"));
		Thread.sleep(1000);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "AG Tier Test All Product with status Value : " + newStatus);
		productSettingPage.ProductStatusGroupTest(newStatus);
		Thread.sleep(1000);
	}
	
	@Test(priority=14, dataProvider = "getProductListeData")
	public void AGProductStatusGroupActiveTest(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "AG Tier Check on Product : " + productName + " with Status Value : " + newStatus);		
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}
	
	@Test(priority=15)
	public void ProductSettingAGroupUpdate02(ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		productSettingPage.findTestingAccount(prop.getProperty("AG2"));
		Thread.sleep(1000);
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "AG Tier Test All Product with status Value : " + newStatus);
		productSettingPage.ProductStatusGroupTest(newStatus);
		Thread.sleep(1000);
	}
	
	/*@Test(priority=6)
	public void ProceedProductStatusActiveTest(ITestContext context) throws InterruptedException {
		productSettingPage.CABreadCrumbClick();
		productSettingPage.findTestingAccount(prop.getProperty("SMA2"));
		Thread.sleep(1000);
		String newStatus = prop.getProperty("active");
		context.setAttribute("Steps", "1");
		context.setAttribute("Process", "Test All Product with Status Value : " + newStatus);
		productSettingPage.ProductStatusActiveTest(newStatus);
		Thread.sleep(2000);
	}
	
	@Test(priority=7, dataProvider = "getProductListeData")
	public void ProductStatusActiveTest(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("active");
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Check on Product : " + productName + " with Status Value : " + newStatus);		
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}*/

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
