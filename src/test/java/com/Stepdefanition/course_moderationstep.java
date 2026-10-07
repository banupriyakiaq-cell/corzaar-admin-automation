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
private course_moderation cm =new course_moderation(DriverFactory.getDriver());
	 

	@Given("user is on tha dashboard page")
	public void user_is_on_tha_dashboard_page() {
		
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	 
	}

	@When("admin click the  course moderation module")
	public void admin_click_the_course_moderation_module() {
		  cm.clickcoursemoderation();
		  String actualURL=cm.getcurrentUrl();
		    System.out.println("Actual URL:"+actualURL);
		    Assert.assertTrue(actualURL.contains("courses"));
 	}
	@When("admin search the topic in search field {string}")
	public void admin_search_the_topic_in_search_field(String course) {
		cm.entersearchfield(course);
	}

	@When("admin verify the course {string} as {string} with {string}")
	public void admin_verify_the_course_as_with(String course, String Status, String message) {
		if(Status.equalsIgnoreCase("invalid")) {
	    	 String actualMessage=cm.getinvalidmessage();
	    	 Assert.assertEquals(actualMessage,  message);
	     }
	}
	@When("admin search the course topic in search field {string}")
	public void admin_search_the_course_topic_in_search_field(String course) {
		cm.entersearchfield(course);
	}
	@When("admin verify the {string} as {string}  as {string}")
	public void admin_verify_the_as_as(String course, String Status, String message) {
		if(Status.equalsIgnoreCase("invalid")) {
	    	 String actualMessage=cm.getinvalidmessage();
	    	 Assert.assertEquals(actualMessage,  message);
	     }
	}
	@When("admin clear the search field in coursemoderation module")
	public void admin_clear_the_search_field_in_coursemoderation_module() {
	     cm.clearsearchbox();
	}   
	
 
    @When("admin using the filter option")
	public void admin_using_the_filter_option() {
    	 Assert.assertTrue(cm.isfilterbuttonDisplayed());
 	}

	@When("admin select the published option")
	public void admin_select_the_published_option() {
		cm.clickpublishoption();
 	}

	@When("the option filter the details and should be displayed correctly")
	public void the_option_filter_the_details_and_should_be_displayed_correctly() {
		 List<String>actualvalue=cm.statusmessagedisplayed();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"published");
	}
 	}

	@When("admin select the reject button in displayed details")
	public void admin_select_the_reject_button_in_displayed_details() {
		//cm.clickrejectbutton();
 	}
	 

	@When("admin select the  underreview option")
	public void admin_select_the_underreview_option() {
		cm.clickunderreview();
 	}

	@When("admin select underreview option filter the details and should be displayed correctly")
	public void admin_select_underreview_option_filter_the_details_and_should_be_displayed_correctly() {
		List<String>actualvalue=cm.statusmessagedisplayed();
		for(String actual:actualvalue) {
			System.out.println("Status:"+actual);
			Assert.assertEquals(actual.trim(),"under_review");
}
 	}
	@When("admin select the reject button")
	public void admin_select_the_reject_button() {
		//cm.clickrejectbutton();
 	}
	@When("admin select the publish option")
	public void admin_select_the_publish_option() {
		//cm.clickpublishbutton();
 	}

	@When("admin select the rejected option")
	public void admin_select_the_rejected_option() {
		cm.clickrejectoption();
 	}

	@Then("admin select  rejected option filter the details and should be displayed correctly")
	public void admin_select_rejected_option_filter_the_details_and_should_be_displayed_correctly() {
		List<String>actualvalue=cm.statusmessagedisplayed();
		for(String actual:actualvalue) {
			System.out.println("Status:"+actual);
			Assert.assertEquals(actual.trim(),"rejected");
}
 	}


}
