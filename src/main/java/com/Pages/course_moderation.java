package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.dom.model.NodeId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class course_moderation {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public course_moderation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "(//*[text()='Courses Moderation'])[1]")
	public WebElement coursesmoderationElement;

	@FindBy(xpath = "//*[@placeholder='Search programs by title or topic...']")
	public WebElement searchfieldElement;

	@FindBy(xpath = "//*[@placeholder='Search programs by title or topic...']")
	public WebElement searchboxElement;

	@FindBy(xpath = "//*[@value='published']")
	public WebElement publishedoptionElement;

	@FindBy(xpath = "//*[@value='under_review']")
	public WebElement underreviewoptionElement;

	@FindBy(xpath = "//*[@value='rejected']")
	public WebElement rejectElement;

	@FindBy(xpath = "//*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
	public WebElement invalidmessagElement;

	@FindBy(xpath = "//table[@class='w-full text-left border-collapse']")
	public WebElement displayedmessagElement;

	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	public WebElement rejectbuttonElement;

	@FindBy(xpath = "(//button[normalize-space()='Publish'])[1]")
	public WebElement publishbuttonElement;

	@FindBy(xpath = "//tbody//tr[.//*[normalize-space()='selenium']]")
	public WebElement searchresult;

	@FindBy(xpath = "//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
	public WebElement filterbutton;

	@FindBy(xpath = "//table//tbody//tr/td[4]")
	public List<WebElement> statusdetailed;

	@FindBy(xpath = " //strong")
	public WebElement totalCourseCount;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> displayedCourse;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> publisheddisplayedcourse;
	
	@FindBy(xpath = "(//*[@class='lucide lucide-external-link w-4 h-4'])[1]")
	public WebElement navigationicon;
	
	@FindBy(xpath = "//h1")
	public WebElement coursetitle;
	
	@FindBy(xpath="( //table//tbody//tr)[1]")
	public WebElement selectedcouse; 
	
	@FindBy(xpath = "(//tr[.//span[normalize-space()='UI UX Design Fundamentals']])[1]")
	public WebElement uIcoursElement;
	
	public String getcurrentUrl() {
		return driver.getCurrentUrl();
	}
	

	public void clearsearchbox() {
		elementUtils.clearField(searchboxElement);
	}

	public void clickcoursemoderation() {
		elementUtils.clickElement(coursesmoderationElement);
	}

	public void entersearchfield(String course) {
		elementUtils.sendKeys(searchfieldElement, course);
	}

	public void clickpublishoption() {
		elementUtils.clickElement(publishedoptionElement);
	}

	public void clickunderreview() {
		elementUtils.clickElement(underreviewoptionElement);
	}

	public void clickrejectoption() {
		elementUtils.clickElement(rejectElement);
	}

	public String getinvalidmessage() {
		return elementUtils.getText(invalidmessagElement);
	}

	public void displayedmessage() {
		elementUtils.getText(displayedmessagElement);
	}

	public void clickrejectbutton() {
 
		elementUtils.clickElement(rejectbuttonElement);
	}

	public void clickpublishbutton() {
		elementUtils.clickElement(publishbuttonElement);
	}

	public boolean isfilterbuttonDisplayed() {
		return filterbutton.isDisplayed();
	}

	public List<String> statusmessagedisplayed() {
		List<String> statusList = new ArrayList<String>();
		for (WebElement element : statusdetailed) {
			String valueString = elementUtils.getText(element);
			statusList.add(valueString);
		}
		return statusList;
	}

	public String gettotalcoursetext() {
		return elementUtils.getText(totalCourseCount).trim();

	}

	public int getDisplayedcoursecount() {
		return elementUtils.getSize(displayedCourse);
	}

	public int gettotalcoursedetails() {
		return elementUtils.getSize(publisheddisplayedcourse);
	}
	public String getSearchfieldValue() {
		return
	 elementUtils.getAttributeValue(searchfieldElement);
	}
	
	 public void clicknavigationicon() {
		 elementUtils.clickElement(navigationicon);
	 }
	 public boolean isSelectedCourseDetailsDisplaed(String course) {
		 return elementUtils.getText(coursetitle).trim().equalsIgnoreCase(course);
	 }
	 public String getselectedcoursename() {
		 return elementUtils.getText(coursetitle).trim();
	 }
	 public boolean isdisplayedselectedcourse(String course) {
			String xpath ="//table//tbody//tr[.//*[normalize-space()='\"+ courseName + \"']]";
			return elementUtils.getElementcount(xpath)>0;
		}
	 public boolean isdisplayedUIcourses() {
		 String xpath="(//tr[.//span[normalize-space()='UI UX Design Fundamentals']])[1]";
		 return elementUtils.getElementcount(xpath)>0;
	 }
	 
 }