package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class PTSettingPage extends TestBase {
	
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
		@FindBy(id="check_3") 
		WebElement accountBox;
		
		//Select (Product PT Combo Box) Element
		@FindBy(xpath="//select[contains(@name,'evo_pt')]") 
		WebElement evoPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'bg_pt')]") 
		WebElement bgPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'titanium_pt')]") 
		WebElement mgPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'asg_pt')]") 
		WebElement asgPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'dg_pt')]") 
		WebElement dgPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'av_pt')]") 
		WebElement avPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'pp_pt')]") 
		WebElement ppPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'sxg_pt')]") 
		WebElement sxgPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'pps_pt')]") 
		WebElement ppsPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'haba_pt')]") 
		WebElement habaPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'mv_pt')]") 
		WebElement mvPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'nt_pt')]") 
		WebElement ntPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'qs_pt')]") 
		WebElement qsPTSelect;
		
		@FindBy(xpath="//select[contains(@name,'png_pt')]") 
		WebElement pngPTSelect;
		
		//@FindBy(xpath="//select[contains(@name,'sg_status')]") 
		//WebElement sgStatusSelect;
		//change to get Xpath 
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tfoot/tr/td[31]/select") 
		WebElement sgPTSelect2;
	
		//Product Given PT Display Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
		WebElement EvoGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]") 
		WebElement BGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[9]") 
		WebElement MGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[11]") 
		WebElement ASGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]") 
		WebElement DGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[15]") 
		WebElement AVGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[17]") 
		WebElement PPGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[19]") 
		WebElement SXGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[21]") 
		WebElement PPSGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[23]") 
		WebElement HBGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[25]") 
		WebElement MVGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[27]") 
		WebElement NTGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[29]") 
		WebElement QSGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[31]") 
		WebElement SGGPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[33]") 
		WebElement PNGGPT;
		
		//Product Given PT Display Element (For AG Tier Use)
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]/text()") 
		WebElement AGEvoGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]/text()") 
		WebElement AGBGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[9]/text()") 
		WebElement AGMGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[11]/text()") 
		WebElement AGASGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]/text()") 
		WebElement AGDGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[15]/text()") 
		WebElement AGAVGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[17]/text()") 
		WebElement AGPPGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[19]/text()") 
		WebElement AGSXGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[21]/text()") 
		WebElement AGPPSGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[23]/text()") 
		WebElement AGHBGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[25]/text()") 
		WebElement AGMVGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[27]/text()") 
		WebElement AGNTGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[29]/text()") 
		WebElement AGQSGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[31]/text()") 
		WebElement AGSGGPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[33]/text()") 
		WebElement AGPNGGPT;
		
		//Product Eff PT Display Element
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
		WebElement EvoEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[8]") 
		WebElement BGEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[10]") 
		WebElement MGEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]") 
		WebElement ASGEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]") 
		WebElement DGEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[16]") 
		WebElement AVEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[18]") 
		WebElement PPEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[20]") 
		WebElement SXGEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[22]") 
		WebElement PPSEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[24]") 
		WebElement HBEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[26]") 
		WebElement MVEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[28]") 
		WebElement NTEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[30]") 
		WebElement QSEPT;

		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[32]") 
		WebElement SGEPT;
		
		@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[34]") 
		WebElement PNGEPT;
		
		//Apply Button
		@FindBy(id="btnSubmit") 
		WebElement submitBtn;
		
		//Initializing the Page Objects:
		public PTSettingPage(){
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
		
		public void PTSettingTestSingle(String prdID, String NewPT) throws InterruptedException {
			
			Thread.sleep(1000);	
			accountBox.click();
			this.selectPTSingle(prdID, NewPT);
			submitBtn.click();
			Thread.sleep(1000);			
			//driver.switchTo().alert().accept();
		}
		
		public void PTSettingTestAll(String NewPT) throws InterruptedException {
			
			Thread.sleep(1000);	
			accountBox.click();
			this.selectStatusALL(NewPT);
			submitBtn.click();
			Thread.sleep(1000);			
			//driver.switchTo().alert().accept();
		}
		
		public void DownlineClick() {
			DownlineAccountLink.click();
		}
		
		public void CABreadCrumbClick() {
			CAbreadcrumb.click();
		}
		
		public void selectPTSingle(String prdID, String NewPT) {

			Select evoSelect = new Select(evoPTSelect);	
			Select bgSelect = new Select(bgPTSelect);	
			Select mgSelect = new Select(mgPTSelect);	
			Select asgSelect = new Select(asgPTSelect);	
			Select dgSelect = new Select(dgPTSelect);	
			Select avSelect = new Select(avPTSelect);	
			Select ppSelect = new Select(ppPTSelect);	
			Select sxgSelect = new Select(sxgPTSelect);	
			Select ppsSelect = new Select(ppsPTSelect);
			Select hbSelect = new Select(habaPTSelect);	
			Select mvSelect = new Select(mvPTSelect);
			Select ntSelect = new Select(ntPTSelect);	
			Select qsSelect = new Select(qsPTSelect);
			Select sgSelect = new Select(sgPTSelect2);
			Select pngSelect = new Select(pngPTSelect);

			switch (prdID) {
				case "1":
					evoSelect.selectByVisibleText(NewPT);	
					break;
				case "2":
					bgSelect.selectByVisibleText(NewPT);	
					break;
				case "3":
					mgSelect.selectByVisibleText(NewPT);	
					break;
				case "4":
					asgSelect.selectByVisibleText(NewPT);	
					break;
				case "5":
					dgSelect.selectByVisibleText(NewPT);	
					break;
				case "6":
					avSelect.selectByVisibleText(NewPT);	
					break;
				case "7":
					ppSelect.selectByVisibleText(NewPT);	
					break;
				case "8":
					sxgSelect.selectByVisibleText(NewPT);	
					break;
				case "9":
					ppsSelect.selectByVisibleText(NewPT);	
					break;
				case "10":
					hbSelect.selectByVisibleText(NewPT);	
					break;
				case "11":
					mvSelect.selectByVisibleText(NewPT);	
					break;
				case "12":
					ntSelect.selectByVisibleText(NewPT);	
					break;
				case "13":
					qsSelect.selectByVisibleText(NewPT);	
					break;
				case "14":
					sgSelect.selectByVisibleText(NewPT);	
					break;
				case "15":
					pngSelect.selectByVisibleText(NewPT);	
					break;
			}
		}
		
		
		public void selectStatusALL(String NewPT) {
			
			Select evoSelect = new Select(evoPTSelect);	
			Select bgSelect = new Select(bgPTSelect);	
			Select mgSelect = new Select(mgPTSelect);	
			Select asgSelect = new Select(asgPTSelect);	
			Select dgSelect = new Select(dgPTSelect);	
			Select avSelect = new Select(avPTSelect);	
			Select ppSelect = new Select(ppPTSelect);	
			Select sxgSelect = new Select(sxgPTSelect);	
			Select ppsSelect = new Select(ppsPTSelect);
			Select hbSelect = new Select(habaPTSelect);	
			Select mvSelect = new Select(mvPTSelect);
			Select ntSelect = new Select(ntPTSelect);	
			Select qsSelect = new Select(qsPTSelect);
			Select sgSelect = new Select(sgPTSelect2);
			Select pngSelect = new Select(pngPTSelect);
			
			evoSelect.selectByVisibleText(NewPT);	
			bgSelect.selectByVisibleText(NewPT);	
			mgSelect.selectByVisibleText(NewPT);	
			asgSelect.selectByVisibleText(NewPT);	
			dgSelect.selectByVisibleText(NewPT);	
			avSelect.selectByVisibleText(NewPT);	
			ppSelect.selectByVisibleText(NewPT);	
			sxgSelect.selectByVisibleText(NewPT);	
			ppsSelect.selectByVisibleText(NewPT);	
			hbSelect.selectByVisibleText(NewPT);	
			mvSelect.selectByVisibleText(NewPT);	
			ntSelect.selectByVisibleText(NewPT);	
			qsSelect.selectByVisibleText(NewPT);	
			sgSelect.selectByVisibleText(NewPT);
			pngSelect.selectByVisibleText(NewPT);	
		}	
		
		public String getGivenPTResult(String PrdID){
			
			String givenPT = "";
			
			switch (PrdID) {
			case "1":
				givenPT = EvoGPT.getText();
				break;
			case "2":
				givenPT = BGGPT.getText();
				break;
			case "3":
				givenPT = MGGPT.getText();
				break;
			case "4":
				givenPT = ASGGPT.getText();
				break;
			case "5":
				givenPT = DGGPT.getText();
				break;
			case "6":
				givenPT = AVGPT.getText();
				break;
			case "7":
				givenPT = PPGPT.getText();
				break;
			case "8":
				givenPT = SXGGPT.getText();
				break;
			case "9":
				givenPT = PPSGPT.getText();
				break;
			case "10":
				givenPT = HBGPT.getText();
				break;
			case "11":
				givenPT = MVGPT.getText();
				break;
			case "12":
				givenPT = NTGPT.getText();
				break;
			case "13":
				givenPT = QSGPT.getText();
				break;
			case "14":
				givenPT = SGGPT.getText();
				break;
			case "15":
				givenPT = PNGGPT.getText();
				break;
			
			}	
			
			/*if (PrdID.equals("2")) {
				return "SSSS";
			}else {
				return newPT;
			}*/
			return givenPT;

		}
		
		public String getEffectivePTResult(String PrdID){
			
			String effPT = "";
			
			switch (PrdID) {
			case "1":
				effPT = EvoEPT.getText();
				break;
			case "2":
				effPT = BGEPT.getText();
				break;
			case "3":
				effPT = MGEPT.getText();
				break;
			case "4":
				effPT = ASGEPT.getText();
				break;
			case "5":
				effPT = DGEPT.getText();
				break;
			case "6":
				effPT = AVEPT.getText();
				break;
			case "7":
				effPT = PPEPT.getText();
				break;
			case "8":
				effPT = SXGEPT.getText();
				break;
			case "9":
				effPT = PPSEPT.getText();
				break;
			case "10":
				effPT = HBEPT.getText();
				break;
			case "11":
				effPT = MVEPT.getText();
				break;
			case "12":
				effPT = NTEPT.getText();
				break;
			case "13":
				effPT = QSEPT.getText();
				break;
			case "14":
				effPT = SGEPT.getText();
				break;
			case "15":
				effPT = PNGEPT.getText();
				break;
			}	
			
			/*if (PrdID.equals("2")) {
				return "SSSS";
			}else {
				return newPT;
			}*/
			return effPT;
		}
		
		public String getGivenPTResultAG(String PrdID){
			
			String givenPT = "";
			
			switch (PrdID) {
			case "1":
				givenPT = EvoGPT.getText();
				break;
			case "2":
				givenPT = BGGPT.getText();
				break;
			case "3":
				givenPT = MGGPT.getText();
				break;
			case "4":
				givenPT = ASGGPT.getText();
				break;
			case "5":
				givenPT = DGGPT.getText();
				break;
			case "6":
				givenPT = AVGPT.getText();
				break;
			case "7":
				givenPT = PPGPT.getText();
				break;
			case "8":
				givenPT = SXGGPT.getText();
				break;
			case "9":
				givenPT = PPSGPT.getText();
				break;
			case "10":
				givenPT = HBGPT.getText();
				break;
			case "11":
				givenPT = MVGPT.getText();
				break;
			case "12":
				givenPT = NTGPT.getText();
				break;
			case "13":
				givenPT = QSGPT.getText();
				break;
			case "14":
				givenPT = SGGPT.getText();
				break;
			case "15":
				givenPT = PNGGPT.getText();
				break;		
			}	
			
			int givenEnd = givenPT.indexOf('+') - 1;
			
			return givenPT.substring(0,givenEnd);

		}
		

}
