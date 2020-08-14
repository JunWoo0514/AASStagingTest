package AASProductTestCase.AASProductTest.qa.testcases;

import org.testng.annotations.BeforeMethod;

import AASProductTestCase.AASProductTest.qa.base.TestBase;
import AASProductTestCase.AASProductTest.qa.pages.ExtraPTPage;
import AASProductTestCase.AASProductTest.qa.pages.HomePage;
import AASProductTestCase.AASProductTest.qa.pages.LoginPage;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ExtraPTPage extraPtPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
		
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		extraPtPage = new ExtraPTPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

}
