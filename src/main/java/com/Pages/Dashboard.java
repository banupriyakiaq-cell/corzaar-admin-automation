package com.Pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class Dashboard {

	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);}
	
	@FindBy(xpath = "//a[.//span[normalize-space()='Pending Courses']]")
	public WebElement pendingcours;
	
	@FindBy(xpath = "//a[.//span[normalize-space()='Pending Coupons']]")
	public WebElement pendingcoupon;
	
	@FindBy(xpath = "//a[.//span[normalize-space()='Pending Refunds']]")
	public WebElement pendingrefunds;
	
	@FindBy(xpath = "//a[.//span[normalize-space()='Institute Approvals']]")
	public WebElement  institutrapprovel;
	
	@FindBy(xpath = "//span[normalize-space()='Accredited Institutes']/ancestor :: div[contains(@class,'rounded-2xl')][1]/span[contains(@class,'text-2xl')]")
	public WebElement accreditedinstitutes;
	
	@FindBy(xpath = "//span[normalize-space()='Published Courses']/ancestor::div[contains(@class,'rounded-2xl')]/span[contains(@class,'text-2xl')]")
	public WebElement PublishedCourses;
	
	@FindBy(xpath="(//div[contains(@class,'rounded-2xl')])[2]//span[contains(@class,'font-black')]")
	public WebElement registerlearnercount;
	
	@FindBy(xpath = "//span[contains(.,'pending onboarding')] ")
	public WebElement pendingcourse;
	
	@FindBy(xpath = "//span[contains(.,'in review queue')]")
	public WebElement reviewQueueCount;
	
	@FindBy(xpath=" //a[@href='/admin/courses']//span[contains(@class,'text-2xl')]")
	public WebElement pendingcoursecount;
	
	@FindBy(xpath=" //a[@href='/admin/refunds']//span[contains(@class,'text-2xl')]")
	public WebElement pendingrefundcount;
	
	@FindBy(xpath = " //a[@href='/admin/coupons']//span[contains(@class,'text-2xl')]")
	public WebElement pendingcouponcount;
	
	@FindBy(xpath = " //a[@href='/admin/institutes']//span[contains(@class,'text-2xl')]")
	public WebElement institutesapprovalcount;
	
	
	public void clickpedingcourse() {
		elementUtils.clickElement(pendingcours);
	}
	public void clickpecdingcoupon() {
		elementUtils.clickElement( pendingcoupon);
	}
	public void clickpecdingrefunds() {
		elementUtils.clickElement( pendingrefunds);
	}
	public void clickinstituteapprovel() {
		elementUtils.clickElement( institutrapprovel);
	}
	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public int getAccreditedInstitutescount() {
		 
		String count = elementUtils.getText(accreditedinstitutes).trim();
		return Integer.parseInt(count);
	}
	public int getpublisedcoursescount() {
		 
		String count = elementUtils.getText(PublishedCourses).trim();
		return Integer.parseInt(count);
	}
	public int getinstitutelearnercount() {
		 
		String count = elementUtils.getText(registerlearnercount).trim();
		return Integer.parseInt(count);
	}
	
	public String getpendingonboardingcount() {
		String xpath="//span[contains(.,'pending onboarding')]";
		String text = elementUtils.getTextByXpath(xpath);
		 return text.replaceAll("[^0-9]","");
	}
	 public String getReviewQueueCount() {
		 String xpath  ="//span[contains(.,'in review queue')]";
			 String text = elementUtils.getTextByXpath(xpath);
			 return text.replaceAll("[^0-9]","");
		 }
	 public String getpendingcoursecount() {
		String count = elementUtils.getText(pendingcoursecount).trim();
		 return count;
		 }
	 public String getpendingcouponcount() {
			String count = elementUtils.getText(pendingcouponcount).trim();
			 return count;
			 }
	 public String getpendingrefundcount() {
			String count = elementUtils.getText(pendingrefundcount).trim();
			 return count;
			 }
	 public String getinstitutesapprovalcount() {
			String count = elementUtils.getText(institutesapprovalcount).trim();
			 return count;
			 }
	 }
	 




