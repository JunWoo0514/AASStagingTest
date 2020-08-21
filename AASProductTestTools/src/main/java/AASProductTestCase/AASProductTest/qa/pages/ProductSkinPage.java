package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class ProductSkinPage extends TestBase {
	
		//Page Factory
		@FindBy(id="ag_code") 
		WebElement filterName;
		
		@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
		WebElement filterBtn;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i") 
		WebElement editBtn;	
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i[1]") 
		WebElement saveBtn;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i[2]") 
		WebElement undoBtn;
		
		//Select (Skin Combo Box) Element
		@FindBy(id="evoSkinIdList") 
		WebElement EvoSkinSelect;
		
		@FindBy(id="avSkinIdList") 
		WebElement AvSkinSelect;
		
		//PT Display Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]") 
		WebElement EvoSkin;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement AvSkin;
		
		//Initializing the Page Objects:
		public ProductSkinPage(){
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
		
		public void SkinPositiveTest(String prdID, String NewSkinValue) throws InterruptedException {
			
			Thread.sleep(1000);	
			editBtn.click();
			this.selectSkin(prdID, NewSkinValue);
			saveBtn.click();
			Thread.sleep(2000);			
			driver.switchTo().alert().accept();
		}
		
		public void selectSkin(String prdID, String NewSkinValue) {
			Select evoSkinSelect = new Select(EvoSkinSelect);	
			Select avSkinSelect = new Select(AvSkinSelect);	

			switch (prdID) {
				case "1":
					evoSkinSelect.selectByVisibleText(NewSkinValue);	
					break;
				case "2":
					avSkinSelect.selectByVisibleText(NewSkinValue);	
					break;
			}
		}
		
		public String getSkinResult(String PrdID){
			
			String newSKIN = "";
			
			switch (PrdID) {
			case "1":
				newSKIN = EvoSkin.getText();
				break;
			case "2":
				newSKIN = AvSkin.getText();
				break;
			}	
			
			/*if (PrdID.equals("2")) {
				return "SSSS";
			}else {
				return newPT;
			}*/
			return newSKIN;

		}
}
