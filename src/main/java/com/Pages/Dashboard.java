package com.Pages;

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
	
	public void clickpecdingcourse() {
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
	}




