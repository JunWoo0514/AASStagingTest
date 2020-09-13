package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class CreditPage extends TestBase {
	
		//Page Factory
		@FindBy(id="f_name") 
		WebElement filterName;
		
		@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
		WebElement filterBtn;
		
		//Breadcrumb
		
		//Select (Account Status Combo Box) Element
		@FindBy(id="user_activation") 
		WebElement accountSelect;
		
		//Check Field Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[2]/a") 
		WebElement MAclick;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement checkCredit;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement checkAvalCredit;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[10]") 
		WebElement checkWDStatus;
		
		//Edit Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]/i") 
		WebElement editBtn;
		
		//Save Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]/i[1]") 
		WebElement saveBtn;
		
		//Back Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]/i[2]") 
		WebElement backBtn;
		
		@FindBy(id="dw_status") 
		WebElement WDStatus;
		
		//Update Field Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]/input") 
		WebElement editCredit;
		

		
		//Initializing the Page Objects:
		public CreditPage(){
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
		
		public String CreditUpdateTest(String credit, String status) throws InterruptedException {
			
			Thread.sleep(1000);
			editBtn.click();
			editCredit.clear();
			editCredit.sendKeys(credit);
			this.selectStatus(status);
			saveBtn.click();
			Thread.sleep(1000);		
			String updateResult = driver.switchTo().alert().getText();
			Thread.sleep(1500);	
			driver.switchTo().alert().accept();
			return updateResult;
		}
		
		public void searchBtnClick() {
			filterBtn.click();
		}
		
		public void backBtnClick() {
			backBtn.click();
		}
		
		public void selectStatus(String NewStatus) {
			Select activeStat = new Select(WDStatus);	
			activeStat.selectByVisibleText(NewStatus);
		}
		
		public String getActivationStatus() {
			String returnStat = checkWDStatus.getText().toString();;
			return returnStat;
		}
		
		public String getCreditValue() {
			String creditString = checkCredit.getText().toString();
			//long returnCredit = Long.parseLong(creditString.replaceAll(",", "").toString()); 
			return creditString.replaceAll(",", "").toString();
		}
		
		public String getAvalCreditValue() {
			String creditString = checkAvalCredit.getText().toString();
			System.out.print("Check2222222!   " + creditString);
			//long returnCredit = Long.parseLong(creditString.replaceAll(",", "").toString()); 
			return creditString	;
		}

}
