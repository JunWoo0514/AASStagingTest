package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class ProductSettingPage extends TestBase {
	
		//Page Factory
		@FindBy(id="f_name") 
		WebElement filterName;
		
		@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
		WebElement filterBtn;
		
		//Breadcrumb
		@FindBy(xpath="//div[contains(@class,'card-header-headerbg')]//ol/li[2]/a") 
		WebElement CAbreadcrumb;
		
		//Select (Account Status Combo Box) Element
		@FindBy(id="f_status") 
		WebElement accountSelect;
		
		//MA Account Link
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[2]/a") 
		WebElement DownlineAccountLink;
		
		//Radio Box
		@FindBy(id="check_1") 
		WebElement accountBox;
		
		//Select (Product Status Combo Box) Element
		@FindBy(xpath="//select[contains(@name,'evo_status')]") 
		WebElement evoStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'bg_status')]") 
		WebElement bgStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'titanium_status')]") 
		WebElement mgStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'asg_status')]") 
		WebElement asgStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'dg_status')]") 
		WebElement dgStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'av_status')]") 
		WebElement avStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'pp_status')]") 
		WebElement ppStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'sxg_status')]") 
		WebElement sxgStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'pps_status')]") 
		WebElement ppsStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'haba_status')]") 
		WebElement habaStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'mv_status')]") 
		WebElement mvStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'nt_status')]") 
		WebElement ntStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'qs_status')]") 
		WebElement qsStatusSelect;
		
		@FindBy(xpath="//select[contains(@name,'png_status')]") 
		WebElement pngStatusSelect;
		
		//@FindBy(xpath="//select[contains(@name,'sg_status')]") 
		//WebElement sgStatusSelect;
		//change to get Xpath 
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tfoot/tr/td[18]/select") 
		WebElement sgStatusSelect2;
	
		//Product Status Display Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]/font") 
		WebElement EvoStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]/font") 
		WebElement BgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]/font") 
		WebElement MgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[8]/font") 
		WebElement AsgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[9]/font") 
		WebElement DgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[10]/font") 
		WebElement AvStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[11]/font") 
		WebElement PpStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]/font") 
		WebElement SxgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/font") 
		WebElement PpsStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]/font") 
		WebElement HabaStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[15]/font") 
		WebElement MvStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[16]/font") 
		WebElement NtStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[17]/font") 
		WebElement QsStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[18]/font") 
		WebElement SgStatus;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[19]/font") 
		WebElement PngStatus;
		
		//Apply Button
		@FindBy(id="btnSubmit") 
		WebElement submitBtn;
		
		//Initializing the Page Objects:
		public ProductSettingPage(){
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
		
		public void ProductStatusPositiveTest(String prdID, String NewStatus) throws InterruptedException {
			
			Thread.sleep(1000);	
			accountBox.click();
			this.selectStatusSingle(prdID, NewStatus);
			submitBtn.click();
			Thread.sleep(2000);			
			driver.switchTo().alert().accept();
		}
		
		public void ProductStatusActiveTest(String NewStatus) throws InterruptedException {
			
			Thread.sleep(1000);	
			accountBox.click();
			this.selectStatusALL(NewStatus);
			submitBtn.click();
			Thread.sleep(2000);			
			driver.switchTo().alert().accept();
		}
		
		public void DownlineClick() {
			DownlineAccountLink.click();
		}
		
		public void CABreadCrumbClick() {
			CAbreadcrumb.click();
		}
		
		public void selectStatusSingle(String prdID, String NewStatus) {

			Select evoSelect = new Select(evoStatusSelect);	
			Select bgSelect = new Select(bgStatusSelect);	
			Select mgSelect = new Select(mgStatusSelect);	
			Select asgSelect = new Select(asgStatusSelect);	
			Select dgSelect = new Select(dgStatusSelect);	
			Select avSelect = new Select(avStatusSelect);	
			Select ppSelect = new Select(ppStatusSelect);	
			Select sxgSelect = new Select(sxgStatusSelect);	
			Select ppsSelect = new Select(ppsStatusSelect);
			Select hbSelect = new Select(habaStatusSelect);	
			Select mvSelect = new Select(mvStatusSelect);
			Select ntSelect = new Select(ntStatusSelect);	
			Select qsSelect = new Select(qsStatusSelect);
			Select sgSelect = new Select(sgStatusSelect2);
			Select pngSelect = new Select(pngStatusSelect);

			switch (prdID) {
				case "1":
					evoSelect.selectByVisibleText(NewStatus);	
					break;
				case "2":
					bgSelect.selectByVisibleText(NewStatus);	
					break;
				case "3":
					mgSelect.selectByVisibleText(NewStatus);	
					break;
				case "4":
					asgSelect.selectByVisibleText(NewStatus);	
					break;
				case "5":
					dgSelect.selectByVisibleText(NewStatus);	
					break;
				case "6":
					avSelect.selectByVisibleText(NewStatus);	
					break;
				case "7":
					ppSelect.selectByVisibleText(NewStatus);	
					break;
				case "8":
					sxgSelect.selectByVisibleText(NewStatus);	
					break;
				case "9":
					ppsSelect.selectByVisibleText(NewStatus);	
					break;
				case "10":
					hbSelect.selectByVisibleText(NewStatus);	
					break;
				case "11":
					mvSelect.selectByVisibleText(NewStatus);	
					break;
				case "12":
					ntSelect.selectByVisibleText(NewStatus);	
					break;
				case "13":
					qsSelect.selectByVisibleText(NewStatus);	
					break;
				case "14":
					sgSelect.selectByVisibleText(NewStatus);	
					break;
				case "15":
					pngSelect.selectByVisibleText(NewStatus);	
					break;
			}
		}
		
		
		public void selectStatusALL(String NewStatus) {
			
			Select evoSelect = new Select(evoStatusSelect);	
			Select bgSelect = new Select(bgStatusSelect);	
			Select mgSelect = new Select(mgStatusSelect);	
			Select asgSelect = new Select(asgStatusSelect);	
			Select dgSelect = new Select(dgStatusSelect);	
			Select avSelect = new Select(avStatusSelect);	
			Select ppSelect = new Select(ppStatusSelect);	
			Select sxgSelect = new Select(sxgStatusSelect);	
			Select ppsSelect = new Select(ppsStatusSelect);
			Select hbSelect = new Select(habaStatusSelect);	
			Select mvSelect = new Select(mvStatusSelect);
			Select ntSelect = new Select(ntStatusSelect);	
			Select qsSelect = new Select(qsStatusSelect);
			Select sgSelect = new Select(sgStatusSelect2);
			Select pngSelect = new Select(pngStatusSelect);
			
			evoSelect.selectByVisibleText(NewStatus);	
			bgSelect.selectByVisibleText(NewStatus);	
			mgSelect.selectByVisibleText(NewStatus);	
			asgSelect.selectByVisibleText(NewStatus);	
			dgSelect.selectByVisibleText(NewStatus);	
			avSelect.selectByVisibleText(NewStatus);	
			ppSelect.selectByVisibleText(NewStatus);	
			sxgSelect.selectByVisibleText(NewStatus);	
			ppsSelect.selectByVisibleText(NewStatus);	
			hbSelect.selectByVisibleText(NewStatus);	
			mvSelect.selectByVisibleText(NewStatus);	
			ntSelect.selectByVisibleText(NewStatus);	
			qsSelect.selectByVisibleText(NewStatus);	
			sgSelect.selectByVisibleText(NewStatus);	
			pngSelect.selectByVisibleText(NewStatus);
		}
		
		public String getStatusResult(String PrdID){
			
			String newStat = "";
			
			switch (PrdID) {
			case "1":
				newStat = EvoStatus.getText();
				break;
			case "2":
				newStat = BgStatus.getText();
				break;
			case "3":
				newStat = MgStatus.getText();
				break;
			case "4":
				newStat = AsgStatus.getText();
				break;
			case "5":
				newStat = DgStatus.getText();
				break;
			case "6":
				newStat = AvStatus.getText();
				break;
			case "7":
				newStat = PpStatus.getText();
				break;
			case "8":
				newStat = SxgStatus.getText();
				break;
			case "9":
				newStat = PpsStatus.getText();
				break;
			case "10":
				newStat = HabaStatus.getText();
				break;
			case "11":
				newStat = MvStatus.getText();
				break;
			case "12":
				newStat = NtStatus.getText();
				break;
			case "13":
				newStat = QsStatus.getText();
				break;
			case "14":
				newStat = SgStatus.getText();
				break;
			case "15":
				newStat = PngStatus.getText();
				break;
			}	
			
			/*if (PrdID.equals("2")) {
				return "SSSS";
			}else {
				return newPT;
			}*/
			return newStat;

		}
}
