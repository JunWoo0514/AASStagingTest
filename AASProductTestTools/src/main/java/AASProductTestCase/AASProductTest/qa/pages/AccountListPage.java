package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class AccountListPage extends TestBase {
	
		//Page Factory
		@FindBy(id="f_name") 
		WebElement filterName;
		
		@FindBy(id="f_status") 
		WebElement filterStatus;
		
		@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
		WebElement filterBtn;
		
		//Breadcrumb
		
		//Select (Account Status Combo Box) Element
		@FindBy(id="user_activation") 
		WebElement accountSelect;
		
		//Check Field Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[2]/a") 
		WebElement downlineClick;
		
		//SMA Check
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement checkStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement checkSuspend;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]") 
		WebElement checkLock;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[8]") 
		WebElement checkName;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]") 
		WebElement checkMemo;
		
		//MA Check
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]") 
		WebElement checkMAStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement checkMASuspend;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement checkMALock;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]") 
		WebElement checkMAName;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]") 
		WebElement checkMAMemo;
		
		//AG Check
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]") 
		WebElement checkAGStatus;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]") 
		WebElement checkAGSuspend;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement checkAGLock;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement checkAGName;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[11]") 
		WebElement checkAGMemo;
		
		//Edit Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i") 
		WebElement editBtn;
		
		//Edit Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/i") 
		WebElement editMABtn;
			
		//Save Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i[1]") 
		WebElement saveBtn;
		
		//Back Button
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i[2]") 
		WebElement backBtn;
		
		@FindBy(id="status1") 
		WebElement accStatusOpen;
		
		@FindBy(id="status2") 
		WebElement accStatusClose;
		
		@FindBy(id="status_pass") 
		WebElement passWordField;
		
		@FindBy(id="suspend1") 
		WebElement accStatusSuspend;
		
		@FindBy(id="suspend2") 
		WebElement accStatusUnsuspend;
		
		@FindBy(id="locked1") 
		WebElement accStatusLock;
		
		@FindBy(id="locked2") 
		WebElement accStatusUnlock;
		
		@FindBy(id="new_fullname") 
		WebElement accName;
		
		@FindBy(id="new_memo") 
		WebElement accMemo;
		
		//Filter record 
		@FindBy(xpath="//div[contains(@class,'col-sm-6 text-right')]") 
		WebElement recordCount;
		

		
		//Initializing the Page Objects:
		public AccountListPage(){
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
		
		public String AccountUpdateTest(String tier, String password, String name, String Memo, String mode) throws InterruptedException {
			
			Thread.sleep(1000);
			editBtnClick(tier);
			passWordField.clear();	
			accName.clear();
			accMemo.clear();
			passWordField.sendKeys(password);
			if(mode.equals("Close")) {
				accMemo.sendKeys(Memo);
				accName.sendKeys(name);
				accStatusClose.click();
				accStatusSuspend.click();
				accStatusLock.click();
			}else if (mode.equals("Open")) {
				//accMemo.sendKeys(Memo);
				//accName.sendKeys(name);
				accStatusOpen.click();
				accStatusUnsuspend.click();
				accStatusUnlock.click();
			}
			saveBtnClick(tier);
			Thread.sleep(2000);		
			String updateResult = driver.switchTo().alert().getText();
			Thread.sleep(2000);	
			driver.switchTo().alert().accept();
			return updateResult;
		}
		
		public String getAccountCount(String Stat) throws InterruptedException {
			Select status = new Select(filterStatus);	
			status.selectByVisibleText(Stat);	
			filterBtn.click();
			Thread.sleep(1500);	
			String returnCount = recordCount.getText().toString();
			int givenStart = returnCount.indexOf(':') + 2;
			System.out.println("Test Return: "+returnCount.substring(givenStart));
			return returnCount.substring(givenStart);
		}
		
		public void searchBtnClick() {
			filterBtn.click();
		}
		
		public void editBtnClick(String tier) {
			String btnXpath = "";
			
			if(tier.equals("SMA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i";
			}else if (tier.equals("MA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/i";
			}else if (tier.equals("AG")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]/i";
			}
			By editButton = By.xpath(btnXpath);
			driver.findElement(editButton).click();
		}
		
		public void saveBtnClick(String tier) {
			String btnXpath = "";
			
			if(tier.equals("SMA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i[1]";
			}else if (tier.equals("MA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/i[1]";
			}else if (tier.equals("AG")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]/i[1]";
			}
			By saveButton = By.xpath(btnXpath);
			driver.findElement(saveButton).click();
		}
		
		public void backBtnClick(String tier) {
			
			String btnXpath = "";
			
			if(tier.equals("SMA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/i[2]";
			}else if (tier.equals("MA")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/i[2]";
			}else if (tier.equals("AG")) {
				btnXpath = "//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]/i[2]";
			}
			By backButton = By.xpath(btnXpath);
			driver.findElement(backButton).click();
		}
		
		public void downLineLinkClick() {
			downlineClick.click();
		}

		
		public String getAccountStatus(String tier) {
			String returnStat = "";
			if(tier.equals("SMA")) {
				returnStat = checkStatus.getText().toString();
			}else if(tier.equals("MA")) {
				returnStat = checkMAStatus.getText().toString();
			}else if(tier.equals("AG")) {
				returnStat = checkAGStatus.getText().toString();
			}
			return returnStat;
		}
		
		public String getSuspendStatus(String tier) {		
			String creditString = "";
			if(tier.equals("SMA")) {
				creditString = checkSuspend.getText().toString();
			}else if(tier.equals("MA")) {
				creditString = checkMASuspend.getText().toString();
			}else if(tier.equals("AG")) {
				creditString = checkAGSuspend.getText().toString();
			}
			return creditString;
		}
		
		public String getLockStatus(String tier) {
			String lockString = "";
			if(tier.equals("SMA")) {
				lockString = checkLock.getText().toString();
			}else if(tier.equals("MA")) {
				lockString = checkMALock.getText().toString();
			}else if(tier.equals("AG")) {
				lockString = checkAGLock.getText().toString();
			}
			return lockString;
		}
		
		public String getName(String tier) {
			String nameString = "";
			if(tier.equals("SMA")) {
				nameString = checkName.getText().toString();
			}else if(tier.equals("MA")) {
				nameString = checkMAName.getText().toString();
			}else if(tier.equals("AG")) {
				nameString = checkAGName.getText().toString();
			}
			return nameString;
		}
		
		public String getMemo(String tier) {
			String memoString = "";
			if(tier.equals("SMA")) {
				memoString = checkMemo.getText().toString();
			}else if(tier.equals("MA")) {
				memoString = checkMAMemo.getText().toString();
			}else if(tier.equals("AG")) {
				memoString = checkAGMemo.getText().toString();
			}
			return memoString;
		}

}
