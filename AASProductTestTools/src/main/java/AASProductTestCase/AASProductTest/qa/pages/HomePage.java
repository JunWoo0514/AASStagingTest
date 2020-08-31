package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//div[contains(@class,'sidebar')]/nav/ul/li[2]/a") 
	WebElement Menu2;
	
	@FindBy(xpath="//div[contains(@class,'sidebar')]/nav/ul/li[2]/ul/li[4]/a") 
	WebElement extraPTMenu;
	
	@FindBy(xpath="//div[contains(@class,'sidebar')]/nav/ul/li[2]/ul/li[3]/a") 
	WebElement skinMenu;
	
	@FindBy(xpath="//div[contains(@class,'sidebar')]/nav/ul/li[2]/ul/li[2]/a") 
	WebElement settingMenu;
	
	@FindBy(xpath="//div[contains(@class,'sidebar')]/nav/ul/li[2]/ul/li[1]/a") 
	WebElement PTSettingMenu;
	
	//Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
				return driver.getTitle();
	}
	
	public void ModuleNav(String Section, String Item) {
		this.clickMenu(Section);

	}
	
	public void clickMenu(String section) {
		if(section.equals("2")) {
			Menu2.click();
		}
	}
	
	public ExtraPTPage clickOnExtraPT() {
		extraPTMenu.click();
		return new ExtraPTPage();
	}
	
	public ProductSkinPage clickOnSkinSetting() {
		skinMenu.click();
		return new ProductSkinPage();
	}
	
	public ProductSettingPage clickOnProductSetting() {
		settingMenu.click();
		return new ProductSettingPage();
	}

	public PTSettingPage clickOnPTSetting() {
		PTSettingMenu.click();
		return new PTSettingPage();
	}

}
