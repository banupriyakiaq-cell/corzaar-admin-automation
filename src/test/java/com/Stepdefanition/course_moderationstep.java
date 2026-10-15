package com.Stepdefanition;

import java.util.List;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.course_moderation;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class course_moderationstep {
	private course_moderation cm = new course_moderation(DriverFactory.getDriver());
	String parentwindow;
	String selectedCourseName;
	@Given("user is on tha dashboard page")
	public void user_is_on_tha_dashboard_page() throws InterruptedException {

		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);

	}

	@When("admin click the  course moderation module")
	public void admin_click_the_course_moderation_module() {
		cm.clickcoursemoderation();
		String actualURL = cm.getcurrentUrl();
		System.out.println("Actual URL:" + actualURL);
		Assert.assertTrue(actualURL.contains("courses"));
	}

	@When("admin search the course topic in search field {string}")
	public void admin_search_the_course_topic_in_search_field(String course) {
		cm.entersearchfield(course);
	}

	@When("admin verify the {string} as {string}  with {string}")
	public void admin_verify_the_as_with(String course, String Status, String message) {
		String actualmessage = cm.getinvalidmessage();
		System.out.println("Expected:" + message);
		System.out.println("Actual:" + message);
		if (Status.equalsIgnoreCase("invalid")) {
			String actualMessage = cm.getinvalidmessage();
			Assert.assertEquals(actualMessage.trim(), message.trim());
		}
	}

	@When("admin verify the entered search value {string}")
	public void admin_verify_the_entered_search_value(String course) {
		String actualValue = cm.getSearchfieldValue();
		System.out.println("Expected Value:" + course);
		System.out.println("Actual Value:" + actualValue);
		Assert.assertEquals(actualValue, course);
	}

	@When("admin clear the search field in coursemoderation module")
	public void admin_clear_the_search_field_in_coursemoderation_module() {
		cm.clearsearchbox();
	}

	@When("admin using the filter option")
	public void admin_using_the_filter_option() {
		Assert.assertTrue(cm.isfilterbuttonDisplayed());
	}

	@When("admin select the {string} published option")
	public void admin_select_the_published_option(String published) {
		cm.clickpublishoption();
		List<String> actualvalue = cm.statusmessagedisplayed();
		for (String actual : actualvalue) {
			System.out.println("Status:" + actual);
			Assert.assertEquals(actual.trim(), "published");
		}
	}

	@When("admin click the navigation icon")
	public void admin_click_the_navigation_icon() {
		parentwindow = DriverFactory.getDriver().getWindowHandle();
		cm.clicknavigationicon();
		for (String window : DriverFactory.getDriver().getWindowHandles()) {
			if (!window.equals(parentwindow)) {
				DriverFactory.getDriver().switchTo().window(window);
				break;
			}
		}

	}
	@When("admin verify selected course details")
	public void admin_verify_selected_course_details() {
		String expectedcourse =cm.getselectedcoursename();
	   Assert.assertTrue(cm.isSelectedCourseDetailsDisplaed(expectedcourse),"Selected Course details not displayed:"+expectedcourse);
	   DriverFactory.getDriver().close();
	   DriverFactory.getDriver().switchTo().window(parentwindow);
	}
	@When("admin select the reject button in displayed details")
	public void admin_select_the_reject_button_in_displayed_details() {
	String	selectedcourseName = cm.getselectedcoursename();
		int beforeDelete = cm.getDisplayedcoursecount();
 		System.out.println("Before Delete:" + beforeDelete);

		cm.clickrejectbutton();
		int afterDelete = cm.getDisplayedcoursecount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
	}

	@When("admin verify rejected  courses is removed from the table")
	public void admin_verify_rejected_courses_is_removed_from_the_table() {
		 boolean displayed = cm.isdisplayedselectedcourse(selectedCourseName);
		    Assert.assertFalse(displayed," courses is still displayed in the table");
	}

	 

	@When("admin select the {string} underreview option")
	public void admin_select_the_underreview_option(String under_review) {
		cm.clickunderreview();
	 
		List<String> actualvalue = cm.statusmessagedisplayed();
		for (String actual : actualvalue) {
			System.out.println("Status:" + actual);
			Assert.assertEquals(actual.trim(), "under_review");
		}

	}

	@When("admin select the reject button")
	public void admin_select_the_reject_button() {

		int beforeDelete = cm.getDisplayedcoursecount();
		System.out.println("Before Delete:" + beforeDelete);
		cm.clickrejectbutton();
		int afterDelete = cm.getDisplayedcoursecount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
	}
	@When("admin verify rejected  courses is removed again from underreview the table")
	public void admin_verify_rejected_courses_is_removed_again_from_underreview_the_table() {
		 boolean displayed = cm.isdisplayedselectedcourse(selectedCourseName);
		    Assert.assertFalse(displayed,"Api courses is still displayed in the table");
	}
	@When("admin select the publish option")
	public void admin_select_the_publish_option() {
		int beforeDelete = cm.getDisplayedcoursecount();
		System.out.println("Before Delete:" + beforeDelete);
		cm.clickpublishbutton();
		int afterDelete = cm.getDisplayedcoursecount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
	}
	@When("admin verify  published  courses is removed again from underreview the table")
	public void admin_verify_published_courses_is_removed_again_from_underreview_the_table() {
		 boolean displayed = cm.isdisplayedselectedcourse(selectedCourseName);
		    Assert.assertFalse(displayed,"  courses is still displayed in the table");
	}
	@When("admin select the {string} reject option")
	public void admin_select_the_reject_option(String string) {
		cm.clickrejectoption();
		List<String> actualvalue = cm.statusmessagedisplayed();
		for (String actual : actualvalue) {
			System.out.println("Status:" + actual);
			Assert.assertEquals(actual.trim(), "rejected");
		}
	}

	@Then("admin verify total course count")
	public void admin_verify_total_course_count() {
		String title = cm.gettotalcoursetext();
		System.out.println("Total Course text:" + title);
		int totalcount = Integer.parseInt(title.replaceAll("[^0-9]", ""));
		int displayedcount = cm.getDisplayedcoursecount();
		System.out.println("TOTAL COURSE COUNT:" + totalcount);
		System.out.println("DISPLAYED COURSE COUNT :" + displayedcount);
		Assert.assertTrue(totalcount >= displayedcount, "Dispalyed courses count exceeds total course count");
	}
}
