package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class AgActivationPage extends TestBase {
	
		//Page Factory
		@FindBy(id="f_username") 
		WebElement filterName;
		
		@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
		WebElement filterBtn;
		
		//Breadcrumb
		
		//Select (Account Status Combo Box) Element
		@FindBy(id="f_status") 
		WebElement accountSelect;
		
		//Check Field Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[2]") 
		WebElement checkAG;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement checkURL;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement checkToken;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]") 
		WebElement checkSecretKey;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[9]") 
		WebElement checkStatus;
		//Edit Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[10]/i") 
		WebElement editBtn;
		
		//Update Field Element
		@FindBy(id="ag_code") 
		WebElement activationAG;
		
		@FindBy(id="siteurl") 
		WebElement activationURL;
		
		@FindBy(id="status") 
		WebElement activationStatus;

		@FindBy(id="token") 
		WebElement activationToken;
		
		@FindBy(id="secret_key") 
		WebElement activationSecretKey;
		//Save Button
		@FindBy(id="btnSubmitActivation") 
		WebElement submitBtn;
		
		//Initializing the Page Objects:
		public AgActivationPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		public void findTestingAccount(String agCode) throws InterruptedException{
			Thread.sleep(1000);	
			filterName.clear();
			filterName.sendKeys(agCode);
			Thread.sleep(2000);	
			filterBtn.click();
		}
		
		public String ActivationUpdateTest(String url, String status) throws InterruptedException {
			
			Thread.sleep(1000);	
			editBtn.click();
			activationURL.clear();
			activationURL.sendKeys(url);
			this.selectStatus(status);
			submitBtn.click();
			Thread.sleep(1000);		
			String updateResult = driver.switchTo().alert().getText();
			System.out.print("Result!!!!!" + updateResult);
			Thread.sleep(1500);	
			driver.switchTo().alert().accept();
			return updateResult;
		}
		
		public void selectStatus(String NewStatus) {
			Select activeStat = new Select(activationStatus);	
			activeStat.selectByVisibleText(NewStatus);
		}
		
		public String getActivationStatus() {
			String returnStat = checkStatus.getText().toString();
			return returnStat;
		}

}
