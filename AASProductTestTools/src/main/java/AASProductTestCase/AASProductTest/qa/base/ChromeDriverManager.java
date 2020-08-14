package AASProductTestCase.AASProductTest.qa.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
	
	public void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");	
		this.driver = new ChromeDriver(options);
	}

}
