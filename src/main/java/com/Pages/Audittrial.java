package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class Audittrial {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	public Audittrial(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
@FindBy(xpath = "//*[text()='Audit Trail']")
public WebElement audittrail;

@FindBy(xpath = "//*[@placeholder='Search action logs...']")
public WebElement searchfield;

@FindBy(xpath = "//*[@placeholder='Search action logs...']")
public WebElement searchbox;

@FindBy(xpath = "//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
public WebElement fillterbutton; 

@FindBy(xpath = "//*[@value='Payouts']")
public WebElement payoutsoption;

@FindBy(xpath = "//*[@value='Certificates']")
public WebElement certificatesoption;

@FindBy(xpath = "//*[@value='Coupons']")
public WebElement couponoptionElement;

@FindBy(xpath = "//*[@value='Batches']")
public WebElement batchesoptionElement;

@FindBy(xpath = "//*[@value='Courses']")
public WebElement CoursesoptionElement;

@FindBy(xpath = "//*[@value='Institutes']")
public WebElement InstitutesoptionElement;

@FindBy(xpath="//*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
public WebElement invalidmessag;

@FindBy(xpath = "//tbody/tr/td[3]//*[normalize-space()]")
public List<WebElement>displayedmessagElement;

@FindBy(xpath="//strong")
public WebElement totalauditcount;

@FindBy(xpath = "//table/tbody/tr")
public List<WebElement> totalauditcountdetailsdisplayed;

public String getcurrentUrl(){
	return driver.getCurrentUrl();
}
public void clickfilterbutton() {
	elementUtils.clickElement( fillterbutton);
}
public void clickaudittrail() {
	elementUtils.clickElement(audittrail);
}
public void  enterdetails(String SecurityAction ) {
	elementUtils.sendKeys(searchfield, SecurityAction);
}
public void clearsearchfield() {
	elementUtils.clearField(searchbox);
}
public boolean isdispalyedfillterbuttton() {
return	elementUtils.isDisplayed(fillterbutton);
}
public void  clickpayoutoption() {
	elementUtils.clickElement(payoutsoption);
}
public void  clickcertificatesoption() {
	elementUtils.clickElement(certificatesoption);
}
public void  clickcouponsoption() {
	elementUtils.clickElement(couponoptionElement);
}
public void  clickbatchesoption() {
	elementUtils.clickElement(batchesoptionElement);
}
public void  clickcoursseoption() {
	elementUtils.scrollAndClick(CoursesoptionElement);
}
public void  clickInstitutesoption() {
	elementUtils.clickElement(InstitutesoptionElement);
}
public String getinvalidmessage() {
	return elementUtils.getText(invalidmessag);
}
public List<String>statusmessagedisplayed() {
	List<String> statusList = new ArrayList<String>();
	for(WebElement element:displayedmessagElement) {
		String valueString = elementUtils.getText(element);
		statusList.add(valueString);
	}
	return statusList;
	}
public String getSearchfieldValue() {
	return
 elementUtils.getAttributeValue(searchfield);
}
public String gettotalaudittext() {
	return elementUtils.getText(totalauditcount).trim();

}

public int getDisplayedauditcount() {
	return elementUtils.getSize(totalauditcountdetailsdisplayed);
}

 
}
