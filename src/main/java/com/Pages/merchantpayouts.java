package com.Pages;

import java.util.List;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class merchantpayouts {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public merchantpayouts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

}
	
	@FindBy(xpath = "//*[text()='Merchant Payouts']")
	public WebElement merchantpayoutElement; 
	
	@FindBy(xpath = "//*[text()='Record Settlement']")
	public WebElement recordsettlementElement;
	
	@FindBy(id = "merchant-/-institute-recipient")
	public WebElement institutename;
	
	@FindBy(id = "settlement-amount-(₹)")
	public WebElement amountfieldElement;
	
	@FindBy(id="bank-neft-/-rtgs-reference-number")
	public WebElement bankfieldElement;
	
	@FindBy(id = "settlement-notes-/-memo")
	public WebElement notesfieldElement;
	
	@FindBy(xpath = " //*[text()='Log Settlement']")
	public WebElement logsettlementbuttonElement;
	
	@FindBy(xpath = " (//*[text()='Disburse Payout'])[1]")
	public WebElement disbursepayoutElement;
	
	@FindBy(xpath ="//*[text()='Cancel']")
	public WebElement cancelbutton;
	
	@FindBy(xpath ="//*[@class='lucide lucide-x w-5 h-5']")
	public WebElement cancelicon;
	
	@FindBy(xpath=" (//table)[1]//tbody/tr")
	public List<WebElement> activemerchanttable;
	
	@FindBy(xpath = " (//table)[2]//tbody/tr")
	public List<WebElement> historicalsettlementtable;
	
	public void clickmerchantpayouts() {
		elementUtils.clickElement(merchantpayoutElement);
	}
	public void clickrecordsettlement()      {
		elementUtils.scrollAndClick(recordsettlementElement);
	}
	public void selecetinstitute() {
		elementUtils.dropdownValue(institutename, "c3704f77-b57c-4db7-96fa-84c7c5ffe6f2");
	}
	public void enteramount(String amount) {
		elementUtils.sendKeys(amountfieldElement,amount);
	}
	public void enterbankfield(String bankreceipet) {
		elementUtils.sendKeys(bankfieldElement, bankreceipet);
	}
	public void enternotesfield(String notes) {
		elementUtils.sendKeys(notesfieldElement, notes);
	}
	public void clicklogsettement() {
		elementUtils.clickElement(logsettlementbuttonElement);
	}
	public void  clickdisbursepayout() {
		elementUtils.clickElement(disbursepayoutElement);
	}
	public boolean isrecordsettlementDisplayed() {
		return logsettlementbuttonElement.isDisplayed();
	} 
	public String getcurrentUrl(){
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
}