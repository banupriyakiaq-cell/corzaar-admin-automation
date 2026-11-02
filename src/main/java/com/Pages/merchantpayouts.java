package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.ElementUtils;

public class merchantpayouts {

	private final WebDriver driver;
	private ElementUtils elementUtils;
	String settlementamount;
	String bankReceipt;
	public merchantpayouts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//*[text()='Merchant Payouts']")
	public WebElement merchantpayoutElement;

	@FindBy(xpath = "//button[.//span[normalize-space()='Record Settlement']]")
	public WebElement recordsettlementElement;

	@FindBy(id = "merchant-/-institute-recipient")
	public WebElement institutedropdown;
	
	@FindBy(xpath = "//select[@id='merchant-/-institute-recipient']/option")
	public WebElement institutnamElement;

	@FindBy(id = "settlement-amount-(₹)")
	public WebElement amountfieldElement;

	@FindBy(id = "bank-neft-/-rtgs-reference-number")
	public WebElement bankfieldElement;

	@FindBy(id = "settlement-notes-/-memo")
	public WebElement notesfieldElement;

	@FindBy(xpath = " //*[text()='Log Settlement']")
	public WebElement logsettlementbuttonElement;

	@FindBy(xpath = " (//*[text()='Disburse Payout'])[1]")
	public WebElement disbursepayoutElement;

	@FindBy(xpath = "//*[text()='Cancel']")
	public WebElement cancelbutton;

	@FindBy(xpath = "//*[@class='lucide lucide-x w-5 h-5']")
	public WebElement cancelicon;

	@FindBy(xpath = "(//*[@class='divide-y divide-border dark:divide-dark-border text-sm'])[1]")
	public List<WebElement> activemerchanttable;

	@FindBy(xpath = "(//*[@class='divide-y divide-border dark:divide-dark-border text-sm'])[2]")
	public List<WebElement> historicalsettlementtable;

	@FindBy(xpath = " //*[contains(text(),'Payout Recorded!')]")
	public WebElement settilementsuccessmessage;

	@FindBy(xpath = " //*[contains(text(),'Settlement Failed')]")
	public WebElement settlementfailemessag;
	
	@FindBy(xpath=" ((//*[contains(text(),'Historical Settlement Disbursements')]/following::table[1])//tr[1])[2]")
	public List<WebElement>historicalSettlementrow;

	public void clickmerchantpayouts() {
		elementUtils.clickElement(merchantpayoutElement);
	}

	public void clickrecordsettlement() {
		elementUtils.scrollAndClick(recordsettlementElement);
	}

	public void selectInstitute() {
     Select select=new Select(institutedropdown);
     select.selectByIndex( 1);
			 }	

	public void enteramount(String amount) {
		settlementamount=amount;
		System.out.println("amount stored:"+settlementamount);
		elementUtils.sendKeys(amountfieldElement, amount);
	}

	public void enterbankfield(String bankreceipet) {
		this.bankReceipt=bankreceipet ;
		System.out.println("Bank receipt stored:"+this.bankReceipt);
		elementUtils.sendKeys(bankfieldElement, bankreceipet);
	}

	public void enternotesfield(String notes) {
		elementUtils.sendKeys(notesfieldElement, notes);
	}

	public void clicklogsettement() {
		elementUtils.clickElement(logsettlementbuttonElement);
	}

	public void clickdisbursepayout() {
		elementUtils.clickElement(disbursepayoutElement);
	}

	public boolean isrecordsettlementDisplayed() {
		return logsettlementbuttonElement.isDisplayed();
	}

	public String getcurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void clickclosebutton() {
		elementUtils.clickElement(cancelbutton);
	}

	public void clickcloseicon() {
		elementUtils.clickElement(cancelicon);
	}

	public int getactivemerchantdetails() {
		return elementUtils.getSize(activemerchanttable);
	}

	public int gethistoricalmerchanttabledetails() {
		return elementUtils.getSize(historicalsettlementtable);
	}

	public boolean issettlementFailedmessagedisplayed() {
WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
return wait.until(ExpectedConditions.visibilityOf(settlementfailemessag)).isDisplayed();

	}

	public boolean issettlementsuccessmessage() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(settilementsuccessmessage)).isDisplayed();

	}
	public String getsettlementamountvalidationmessage() {
		return(String)((JavascriptExecutor)driver).executeScript("return arguments[0].validationMessage;",amountfieldElement);
	}
	public boolean verifyNewSettlement() {
	if(this.settlementamount == null || 
		this.settlementamount.trim().isEmpty()||
		this.bankReceipt == null ||
		this.bankReceipt.trim().isBlank()){
		System.out.println("Amount is Bank receipt is empty");
		return false;
		
	}for(WebElement rowWebElement:historicalSettlementrow) {
		String rowData  = rowWebElement.getText();
		System.out.println("Expected Amount:"+ this.settlementamount);
		System.out.println("Expected Bank Receipt:"+this.bankReceipt);
		System.out.println("Actual Historical Row:"+rowData);
		if(rowData.contains(this.bankReceipt)&&rowData.contains(this.settlementamount)) {
		System.out.println("New Settlement Details Added ");
	return true;
}
	}
	System.out.println("New Settlement Details not found");
	return false;
	}
}
