package AASProductTestCase.AASProductTest.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AASProductTestCase.AASProductTest.qa.base.DriverManager;
import AASProductTestCase.AASProductTest.qa.base.DriverManagerFactory;
import AASProductTestCase.AASProductTest.qa.base.DriverType;
import AASProductTestCase.AASProductTest.qa.util.TestUtil;
import AASProductTestCase.AASProductTest.qa.util.WebEventListener;

public class TestBase {
	
	public static DriverManager driverManager;
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/AASProductTestCase/AASProductTest"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
			driver = driverManager.getWebDriver();
		}
		else if(browserName.equals("FF")){
			//For Fire Fox
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		wait = new WebDriverWait(driver, TestUtil.ELEMENT_WAIT);
		
	}
	
	//Click Method
    public void click(WebElement element) {
    	//System.out.print("1:"+element.toString());
        waitVisibility(element);
        element.click();
    }
    
    //Write Text
    public void writeText(WebElement element, String text) {
        waitVisibility(element);
        element.sendKeys(text);
    }
    
    //Clear Text
    public void clearText(WebElement element) {
        waitVisibility(element);
        element.clear();
    }
 
    //Read Text
    public String readText(WebElement element) {
        waitVisibility(element);
        return element.getText();
    }
    
    public void selectItem(WebElement element, String text) {
        waitVisibility(element);
        Select select = new Select(element);	
        select.selectByVisibleText(text);	
    }
	
	//Wait
    public void waitVisibility(WebElement element){
    	//System.out.print("2:"+element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
        
       // element = new WebDriverWait(driver, TestUtil.ELEMENT_WAIT)
                //.until(ExpectedConditions.elementToBeClickable(element));
    }

}
