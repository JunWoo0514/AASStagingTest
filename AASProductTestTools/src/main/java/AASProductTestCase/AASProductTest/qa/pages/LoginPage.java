package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class LoginPage extends TestBase {
	
		//Page Factory
		@FindBy(id="username") 
		WebElement username;
		
		@FindBy(id="password") 
		WebElement password;
		
		@FindBy(xpath="/html/body/div[1]/div[2]/form/div[1]/div[2]/span") 
		WebElement errorMessage;
		
		@FindBy(xpath="/html/body/div/div[2]/form/div[4]/div/button") 
		WebElement loginButton;
		
		@FindBy(xpath="//div[contains(@class,'custom-dropdown')]/select") 
		WebElement languageSelect;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public HomePage login(String userName, String passWord) {
			
			this.selectLangauge();
			username.sendKeys(userName);
			password.sendKeys(passWord);
			this.clickLogin();
			
			return new HomePage();
		}
		
		public void selectLangauge() {
			Select language = new Select(languageSelect);				
			language.selectByVisibleText("English");	
		}
		
		public void clickLogin() {
			loginButton.click();
		}

}
