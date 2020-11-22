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
import AASProductTestCase.AASProductTest.qa.pages.ProductSkinPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class ProductSkinPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductSkinPage productSkinPage;
	TestUtil testUtil;
	String menu = "2";
	
	public ProductSkinPageTest(){
		super();
	}
	
	
	@DataProvider(name="SkinData")
	public static Object[][] dataProviderSkinCase() {
		String vhigh = prop.getProperty("skinvhigh");
		String high = prop.getProperty("skinhigh");
		String medium = prop.getProperty("skinmedium");
		String low = prop.getProperty("skinlow");
			return new Object[][]{
			{"1",vhigh},
			{"1",high},
			{"1",medium},
			{"1",low},
			{"2",vhigh},
			{"2",high},
			{"2",medium},
			{"2",low},
			{"3",vhigh},
			{"3",high},
			{"3",medium},
			{"3",low},
			{"4",vhigh},
			{"4",high},
			{"4",medium},
			{"4",low},
		};
	}

	//before test case -- launch the browser and login
	//@test -- execute test case
		
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		productSkinPage = new ProductSkinPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		homePage.clickMenu(menu);
		productSkinPage = homePage.clickOnSkinSetting();

		productSkinPage.findTestingAccount(prop.getProperty("testaccount"));
	}
	
	
	@Test(dataProvider = "SkinData")
	public void ProductSkinTest(String prdID, String skinValue, ITestContext context) throws InterruptedException {
		context.setAttribute("Steps", "2");
		context.setAttribute("Process", "Test with Product : " + prdID + "with Skin Value : " + skinValue);
		productSkinPage.SkinPositiveTest(prdID,skinValue);
		Thread.sleep(2000);
		String result = productSkinPage.getSkinResult(prdID);
		context.setAttribute("Result", "Result expected value : " + skinValue + " and received value : " + result);
		Assert.assertEquals(skinValue,result);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
