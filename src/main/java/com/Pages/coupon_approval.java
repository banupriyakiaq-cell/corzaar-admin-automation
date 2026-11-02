package com.Pages;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class coupon_approval {


	private final WebDriver driver;
	private ElementUtils elementUtils;

	public coupon_approval(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	@FindBy(xpath ="//*[text()='Coupons Approval']")
	public WebElement couponapprovalElement;
	
	@FindBy(xpath = "//*[@placeholder='Search coupon codes...']")
	public WebElement searchfield;
	@FindBy(xpath = "//*[@placeholder='Search coupon codes...']")
	public WebElement searchbox;
	
	@FindBy(xpath = "//*[@value='pending']")
	public WebElement pendingoptionElement;
	
	@FindBy (xpath = "//*[@value='approved']")
	public WebElement approvedoptionElement;
	
	@FindBy(xpath = "//*[@value='rejected']")
	public WebElement rejectedoptiomElement;
	
	@FindBy(xpath = "(//button[normalize-space()='Approve'])[1]")
	public WebElement approvebuttonElement;
	
	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	public WebElement rejectbuttonElement;
	
	@FindBy(xpath = " //*[@class='w-full text-left border-collapse']")
	public WebElement displayedmessagElement;
	
	@FindBy(xpath = " //*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
	public WebElement invalidmessagElement;
	
	@FindBy(xpath="//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
	public WebElement filterbutton;
	
	@FindBy(xpath =  "//table//tbody//tr/td[position()=4]")
	public  List<WebElement> statusdetailed; 
	
	@FindBy (xpath="//strong")
	public WebElement totalcoupon;
	
	@FindBy(xpath = "//*[@class='transition-colors hover:bg-slate-50/80 dark:hover:bg-slate-800/40']")
	public List<WebElement> totalcoupondetails;
	
	
	 
	 
	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void clearsearchfield() {
		elementUtils.clearField(searchbox);
	}
	public void clickcouponapproval() {
		elementUtils.clickElement(couponapprovalElement);
	}
	public void entersearchfield(String course) {
		elementUtils.sendKeys(searchfield, course);
	}
	public void  clickpendingoption() {
		elementUtils.clickElement(pendingoptionElement);
		
	}
	public void  clickapprovedoption() {
		elementUtils.clickElement( approvedoptionElement);
	}
	public void  clickrejectedoption() {
		elementUtils.clickElement(rejectedoptiomElement);
	}
	public void  clickapprovebutton() {
		elementUtils.clickElement(approvebuttonElement);
	}
	public void  clickrejectbutton() {
		elementUtils.clickElement(rejectbuttonElement);
	}
	public  String  displayedmessage() {
		return	elementUtils.getText(displayedmessagElement);
		   
	}
	public  String invalidmessage() {
	return	elementUtils.getText(invalidmessagElement).trim(); 
	} 
	public boolean isfilterbuttonDisplayed() {
		return filterbutton.isDisplayed();
	}
	public List<String>statusmessagedisplayed() {
		List<String> statusList = new ArrayList<String>();
		for(WebElement element:statusdetailed) {
			String valueString = elementUtils.getText(element);
			statusList.add(valueString);
		}
		return statusList;
		}
	public String gettotalcoupontext() {
		return elementUtils.getText(totalcoupon).trim();

	}

	public int getDisplayedcouponcount() {
		return elementUtils.getSize(totalcoupondetails);
	}
	public String getSearchfieldValue() {
		return
	 elementUtils.getAttributeValue(searchfield);
	}
	public boolean isdisplayedselectedcoupon(String coupon) {
		String xpath ="//table//tbody//tr[.//*[normalize-space()='\"+ couponName + \"']]";
		return elementUtils.getElementcount(xpath)>0;
	} 
	
	
	
}
