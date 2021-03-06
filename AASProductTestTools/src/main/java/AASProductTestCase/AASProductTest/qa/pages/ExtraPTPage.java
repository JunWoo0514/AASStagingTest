package AASProductTestCase.AASProductTest.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AASProductTestCase.AASProductTest.qa.base.TestBase;

public class ExtraPTPage extends TestBase{
	
	//Page Factory
	//Function Button Element
	@FindBy(id="ag_code") 
	WebElement filterName;
	
	@FindBy(xpath="//div[contains(@class,'form-group ml-2')]/button") 
	WebElement filterBtn;

	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i") 
	WebElement editBtn;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i[1]") 
	WebElement saveBtn;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[3]/i[2]") 
	WebElement cancelBtn;
	
	//PT Display Element
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[4]") 
	WebElement EvoPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[5]") 
	WebElement BGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[6]") 
	WebElement MGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[7]") 
	WebElement ASGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[8]") 
	WebElement DGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[9]") 
	WebElement AVPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[10]") 
	WebElement PPPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[11]") 
	WebElement SXGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[12]") 
	WebElement PPSPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[13]") 
	WebElement HBSPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[14]") 
	WebElement MVSPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[15]") 
	WebElement NTSPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[16]") 
	WebElement QSPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[17]") 
	WebElement SGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[18]") 
	WebElement PNGPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[19]") 
	WebElement WMPT;
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[20]") 
	WebElement IMPT;

	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/td[21]") 
	WebElement UKPT;

	//Select (Combo Box) Element
	@FindBy(id="evo_pt") 
	WebElement EvoPTSelect;
	
	@FindBy(id="bg_pt") 
	WebElement BGPTSelect;
	
	@FindBy(id="mg_t_pt") 
	WebElement MGPTSelect;
	
	@FindBy(id="asg_pt") 
	WebElement ASGPTSelect;
	
	@FindBy(id="dg_pt") 
	WebElement DGPTSelect;
	
	@FindBy(id="av_pt") 
	WebElement AVPTSelect;
	
	@FindBy(id="pp_pt") 
	WebElement PPPTSelect;
	
	@FindBy(id="sxg_pt") 
	WebElement SXGPTSelect;
	
	@FindBy(id="pps_pt") 
	WebElement PPSPTSelect;
	
	@FindBy(id="haba_pt") 
	WebElement HBPTSelect;
	
	@FindBy(id="mv_pt") 
	WebElement MVPTSelect;
	
	@FindBy(id="nt_pt") 
	WebElement NTPTSelect;
	
	@FindBy(id="qs_pt") 
	WebElement QSPTSelect;

	@FindBy(id="sg_pt") 
	WebElement SGPTSelect;
	
	@FindBy(id="png_pt") 
	WebElement PNGPTSelect;
	
	@FindBy(id="wm_pt") 
	WebElement WMPTSelect;
	
	@FindBy(id="im_pt") 
	WebElement IMPTSelect;

	@FindBy(id="ukt_pt") 
	WebElement UKPTSelect;
	//Initializing the Page Objects:
	public ExtraPTPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public void findTestingAccount(String agCode) throws InterruptedException{
		Thread.sleep(1000);	
		filterName.clear();
		//clearText(filterName);
		//writeText(filterName,agCode);
		filterName.sendKeys(agCode);
		Thread.sleep(3000);	
		filterBtn.click();
		Thread.sleep(2000);	
		//click(filterBtn);
	}
	
	public void ExtraPTPositiveTest(String prdID, String PTValue) throws InterruptedException {
		
		//Thread.sleep(1000);	
		//filterName.clear();
		//filterName.sendKeys(agCode);
		//Thread.sleep(2000);	
		//filterBtn.click();
		//click(filterBtn);
		Thread.sleep(1000);	
		editBtn.click();
		//click(editBtn);
		this.selectPT(prdID, PTValue);
		saveBtn.click();
		//click(saveBtn);
		Thread.sleep(3000);			
		//new WebDriverWait(driver, 10)
        //.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void ExtraPTPositiveTestAll(String PTValue) throws InterruptedException {
		
		Thread.sleep(1000);	
		editBtn.click();
		this.selectPTALL(PTValue);
		saveBtn.click();
		Thread.sleep(3000);			
		driver.switchTo().alert().accept();
	}
	
	public void selectPT(String prdID, String PTValue) {
		Select evoPT = new Select(EvoPTSelect);	
		Select bgPT = new Select(BGPTSelect);	
		Select mgPT = new Select(MGPTSelect);	
		Select asgPT = new Select(ASGPTSelect);	
		Select dgPT = new Select(DGPTSelect);	
		Select avPT = new Select(AVPTSelect);	
		Select ppPT = new Select(PPPTSelect);	
		Select sxgPT = new Select(SXGPTSelect);	
		Select ppsPT = new Select(PPSPTSelect);
		Select hbPT = new Select(HBPTSelect);	
		Select mvPT = new Select(MVPTSelect);
		Select ntPT = new Select(NTPTSelect);	
		Select qsPT = new Select(QSPTSelect);
		Select sgPT = new Select(SGPTSelect);
		Select pngPT = new Select(PNGPTSelect);
		Select wmPT = new Select(WMPTSelect);
		Select imPT = new Select(IMPTSelect);
		Select ukPT = new Select(UKPTSelect);
		
		switch (prdID) {
			case "1":
				evoPT.selectByVisibleText(PTValue);	
				break;
			case "2":
				bgPT.selectByVisibleText(PTValue);	
				break;
			case "3":
				mgPT.selectByVisibleText(PTValue);	
				break;
			case "4":
				asgPT.selectByVisibleText(PTValue);	
				break;
			case "5":
				dgPT.selectByVisibleText(PTValue);	
				break;
			case "6":
				avPT.selectByVisibleText(PTValue);	
				break;
			case "7":
				ppPT.selectByVisibleText(PTValue);	
				break;
			case "8":
				sxgPT.selectByVisibleText(PTValue);	
				break;
			case "9":
				ppsPT.selectByVisibleText(PTValue);	
				break;
			case "10":
				hbPT.selectByVisibleText(PTValue);	
				break;
			case "11":
				mvPT.selectByVisibleText(PTValue);	
				break;
			case "12":
				ntPT.selectByVisibleText(PTValue);	
				break;
			case "13":
				qsPT.selectByVisibleText(PTValue);	
				break;
			case "14":
				sgPT.selectByVisibleText(PTValue);	
				break;
			case "15":
				pngPT.selectByVisibleText(PTValue);	
				break;	
			case "16":
				wmPT.selectByVisibleText(PTValue);	
				break;	
			case "17":
				imPT.selectByVisibleText(PTValue);	
				break;	
			case "18":
				ukPT.selectByVisibleText(PTValue);	
				break;	
		}
	}
	
	public void selectPTALL(String PTValue) {
		Select evoPT = new Select(EvoPTSelect);	
		Select bgPT = new Select(BGPTSelect);	
		Select mgPT = new Select(MGPTSelect);	
		Select asgPT = new Select(ASGPTSelect);	
		Select dgPT = new Select(DGPTSelect);	
		Select avPT = new Select(AVPTSelect);	
		Select ppPT = new Select(PPPTSelect);	
		Select sxgPT = new Select(SXGPTSelect);	
		Select ppsPT = new Select(PPSPTSelect);
		Select hbPT = new Select(HBPTSelect);	
		Select mvPT = new Select(MVPTSelect);
		Select ntPT = new Select(NTPTSelect);	
		Select qsPT = new Select(QSPTSelect);
		Select sgPT = new Select(SGPTSelect);
		Select pngPT = new Select(PNGPTSelect);
		Select wmPT = new Select(WMPTSelect);
		Select imPT = new Select(IMPTSelect);
		Select ukPT = new Select(UKPTSelect);

		evoPT.selectByVisibleText(PTValue);	
		bgPT.selectByVisibleText(PTValue);	
		mgPT.selectByVisibleText(PTValue);	
		asgPT.selectByVisibleText(PTValue);	
		dgPT.selectByVisibleText(PTValue);	
		avPT.selectByVisibleText(PTValue);	
		ppPT.selectByVisibleText(PTValue);	
		sxgPT.selectByVisibleText(PTValue);	
		ppsPT.selectByVisibleText(PTValue);	
		hbPT.selectByVisibleText(PTValue);	
		mvPT.selectByVisibleText(PTValue);	
		ntPT.selectByVisibleText(PTValue);	
		qsPT.selectByVisibleText(PTValue);	
		sgPT.selectByVisibleText(PTValue);	
		pngPT.selectByVisibleText(PTValue);	
		wmPT.selectByVisibleText(PTValue);	
		imPT.selectByVisibleText(PTValue);	
		ukPT.selectByVisibleText(PTValue);	
	}
	
	
	public String getPTResult(String PrdID, String PTVal){
		
		String newPT = "";
		
		switch (PrdID) {
		case "1":
			newPT = EvoPT.getText();
			break;
		case "2":
			newPT = BGPT.getText();
			break;
		case "3":
			newPT = MGPT.getText();
			break;
		case "4":
			newPT = ASGPT.getText();
			break;
		case "5":
			newPT = DGPT.getText();
			break;
		case "6":
			newPT = AVPT.getText();
			break;
		case "7":
			newPT = PPPT.getText();
			break;
		case "8":
			newPT = SXGPT.getText();
			break;
		case "9":
			newPT = PPSPT.getText();
			break;
		case "10":
			newPT = HBSPT.getText();
			break;
		case "11":
			newPT = MVSPT.getText();
			break;
		case "12":
			newPT = NTSPT.getText();
			break;
		case "13":
			newPT = QSPT.getText();
			break;
		case "14":
			newPT = SGPT.getText();
			break;	
		case "15":
			newPT = PNGPT.getText();
			break;
		case "16":
			newPT = WMPT.getText();
			break;
		case "17":
			newPT = IMPT.getText();
			break;
		case "18":
			newPT = UKPT.getText();
			break;
		}	
		
		/*if (PrdID.equals("6")) {
			return "999";
		}else {
			return newPT;
		}*/
		return newPT;

	}
}
