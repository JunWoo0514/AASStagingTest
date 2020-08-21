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
	}
	
	
	@Test(dataProvider = "getProductListeData")
	public void ProductStatusPositiveTest01(String prdID, String productName, ITestContext context) throws InterruptedException {
		String newStatus = prop.getProperty("disable");
		context.setAttribute("Product", productName);
		context.setAttribute("Status", newStatus);
		productSettingPage.ProsuctStatusPositiveTest(prdID,newStatus);
		Thread.sleep(2000);
		String result = productSettingPage.getStatusResult(prdID);
		context.setAttribute("Result", "Result expected value : " + newStatus + " and received value : " + result);
		Assert.assertEquals(newStatus,result);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
