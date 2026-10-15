package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

import net.bytebuddy.asm.Advice.This;

public class institues_moderation {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public institues_moderation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//*[normalize-space()='Institutes Moderation']/ancestor::a[1]")
	public WebElement institutesmoderation;

	@FindBy(xpath = "//*[@placeholder='Search institutes or cities...']")
	public WebElement searchfield;

	@FindBy(xpath = "//*[@placeholder='Search institutes or cities...']")
	public WebElement searchbox;

	@FindBy(xpath = "//*[@placeholder='Search institutes or cities...']")
	public WebElement placefield;

	@FindBy(xpath = "//option[@value='approved']")
	public WebElement approvedoption;

	@FindBy(xpath = "//option[@value='pending']")
	public WebElement pendingoption;

	@FindBy(xpath = "//option[@value='rejected']")
	public WebElement rejectedoption;

	@FindBy(xpath = "//option[@value='suspended']")
	public WebElement suspendedoption;

	@FindBy(xpath = "//span[text()='Approve']")
	public WebElement approvebutton;

	@FindBy(xpath = "(//button[.//span[normalize-space()='Reject']][1])[1]")
	public WebElement rejectbutton;

	@FindBy(xpath = "//td[normalize-space()='No matching institutes found.']")
	public WebElement invalidmessagElement;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div/span[contains(normalize-space(),'Global Business Academy')]")
	public WebElement displayedmessagElement;

	@FindBy(xpath = "//table/tbody//tr/td[4]")
	public List<WebElement> textElement;
	
	@FindBy(xpath = " //table/tbody//tr")
	public List<WebElement> displayeddataElement;

	@FindBy(xpath = "//*[normalize-space()='Bengaluru']")
	public WebElement placeResult;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> displayedcourse;

	@FindBy(xpath = "//strong")
	public WebElement totalinstitutescount;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> totalinstitutedisplayed;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> pendingInstituteRows;
	
	@FindBy(xpath="//tr[.//span[normalize-space()='Apex Institute of Technology']]")
	public  WebElement apexinstitutElement;
	
	@FindBy(xpath="//tr[.//span[normalize-space()='My Institute']]")
	public WebElement myinstitutElement;
	
	public void clicktheinstituesmoderation() {
		elementUtils.scrollAndClick(institutesmoderation);
	}

	public void clearsearchfield() {
		elementUtils.scrollAndClick(searchbox);
	}

	public void entersearch(String institutename) {
		elementUtils.sendKeys(searchfield, institutename);
	}

	public void enterplace(String place) {
		elementUtils.sendKeys(placefield, place);
	}

	public void selecttheapproved() {

		elementUtils.clickElement(approvedoption);
	}

	public void selectthepending() {
		elementUtils.clickElement(pendingoption);
	}

	public void selectthereject() {
		elementUtils.clickElement(rejectedoption);
	}

	public void selectthesuspended() {
		elementUtils.clickElement(suspendedoption);
	}

	public void clicktheapporve() {
		elementUtils.clickElement(approvebutton);
	}

	public void clickthereject() {
		elementUtils.scrollAndClick(rejectbutton);
	}

	public String getcurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String geterrormessage() {
		return elementUtils.getText(invalidmessagElement);
	}

	public String getdisplayedmessage() {
		return elementUtils.getText(displayedmessagElement);
	}

	public String getplaceresult() {
		return elementUtils.getText(placeResult);
	}

	public List<String> getvaliddisplayedmessage() {
		List<String> statusList = new ArrayList<String>();
		for (WebElement element : textElement) {
			String valueString = elementUtils.getText(element);
			statusList.add(valueString);
		}
		return statusList;
	}

	public int gettotalcoursedetails() {
		return elementUtils.getSize(displayedcourse);
	}
	 
	public  String gettotalinstitutedetails() {
		return elementUtils.getText(totalinstitutescount).trim();
	}
	public int getDisplayedinstitutecount() {
		return elementUtils.getSize(totalinstitutedisplayed);
	}

	public String getSearchfieldValue() {
		return
	 elementUtils.getAttributeValue(searchfield );
	}
 
	public int getapprovedinstitutescount() {
		 
		 return elementUtils.getSize(displayeddataElement);
	}
	public int getPendingInstituteCount() {
		return pendingInstituteRows.size();
	}
	
	public boolean isdisplayedapexinstitute() {
		String xpath ="//tr[.//span[normalize-space()='Apex Institute of Technology']]";
		return elementUtils.getElementcount(xpath)>0;
	}
	public boolean isdisplayedmyinstitute() {
		String xpath ="//tr[.//span[normalize-space()='My Institute']]";
		return elementUtils.getElementcount(xpath)>0;
	}
	}

