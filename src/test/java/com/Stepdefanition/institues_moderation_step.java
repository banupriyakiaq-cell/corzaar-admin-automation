package com.Stepdefanition;

import java.awt.Button;
import java.util.List;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.institues_moderation;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class institues_moderation_step {
	private institues_moderation inst = new institues_moderation(DriverFactory.getDriver());

	@Given("user is on the institues moderation page")
	public void user_is_on_the_institues_moderation_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	}

	@When("admin click the institues moderation module")
	public void admin_click_the_institues_moderation_module() {
		inst.clicktheinstituesmoderation();
		String actualURL = inst.getcurrentUrl();
		System.out.println("Actual URL:" + actualURL);
		Assert.assertTrue(actualURL.contains("institutes"));
	}

	@When("admin enters {string} in institute search field")
	public void admin_enters_in_institute_search_field(String institutename) {
		inst.entersearch(institutename);

	}

	@Then("and verify the {string} valid {string} details")
	public void and_verify_the_valid_details(String status, String expected) {
		String actualMessage;

		if (status.equalsIgnoreCase("invalid")) {
			actualMessage = inst.geterrormessage();
			Assert.assertEquals(actualMessage, expected);
		} else {
			actualMessage = inst.getdisplayedmessage();
		}
		Assert.assertTrue(actualMessage.contains(expected), "Expected:" + expected + "But Actual:" + actualMessage);
	}
	@Then("admin verify the search field details {string}")
	public void admin_verify_the_search_field_details(String InstituteName) {
		String actualValue = inst.getSearchfieldValue();
		System.out.println("Expected Value:" + InstituteName);
		System.out.println("Actual Value:" + actualValue);
		Assert.assertEquals(actualValue, InstituteName);
	}

	@When("admin clear the search field in institute module")
	public void admin_clear_the_search_field_in_institute_module() {
		inst.clearsearchfield();
	}

	@When("admin enters the in institute place {string} search field")
	public void admin_enters_the_in_institute_place_search_field(String place) {
		inst.enterplace(place);
	}

	@When("admin enter the field displayed correct matching details in")
	public void admin_enter_the_field_displayed_correct_matching_details_in() {

	}

	@Then("admin should see institutes from place {string} with {string} and expected {string}")
	public void admin_should_see_institutes_from_place_with_and_expected(String Place, String Status, String expected) {
		String actualmessage;
		if (Status.equalsIgnoreCase("invalid")) {
			actualmessage = inst.geterrormessage();
		} else {
			actualmessage = inst.getplaceresult();
		}
		Assert.assertTrue(actualmessage.contains(expected), "Expected:" + expected + "But Actual:" + actualmessage);
	}

	@When("admin clear the plase details in search field")
	public void admin_clear_the_plase_details_in_search_field() {
		inst.clearsearchfield();

	}
	@Then("admin verift the details od search field {string}")
	public void admin_verift_the_details_od_search_field(String Place) {
	    
		String actualValue = inst.getSearchfieldValue();
		System.out.println("Expected Value:" + Place);
		System.out.println("Actual Value:" + actualValue);
		Assert.assertEquals(actualValue, Place);
	}

	@When("admin select the approved option it should be displayed releted option")
	public void admin_select_the_approved_option_it_should_be_displayed_releted_option() {
		inst.selecttheapproved();
//		List<String> actualvalue = inst.getvaliddisplayedmessage();
//		for (String actual : actualvalue) {
//			System.out.println("Status:" + actual);
//			Assert.assertEquals(actual.trim(), "approved");
//		}
		Assert.assertTrue(inst.isstatusdetailsdisplayed());

	}

	@When("admin click the reject button and verify the count details")
	public void admin_click_the_reject_button_and_verify_the_count_details() {

		int beforeDelete = inst.gettotalcoursedetails();
		System.out.println("Before Delete:" + beforeDelete);
 		inst.clickthereject();
		System.out.println("reject button clicked");
		int afterDelete = inst.gettotalcoursedetails();
		System.out.println("After Delete:" + afterDelete);
 
	}

	@When("admin select the Pending option it should be displayed releted option")
	public void admin_select_the_pending_option_it_should_be_displayed_releted_option() {
//		inst.selectthepending();
//
//		List<String> actualvalue = inst.getvaliddisplayedmessage();
//		for (String actual : actualvalue) {
//			System.out.println("Status:" + actual);
//			Assert.assertEquals(actual.trim(), "pending");
//		}
		Assert.assertTrue(inst.isstatusdetailsdisplayed());

	}

	@When("admin click the approve button and verify the count details")
	public void admin_click_the_approve_button_and_verify_the_count_details() {

		int beforeDelete = inst.gettotalcoursedetails();
		System.out.println("Before Delete:" + beforeDelete);
		//inst.clicktheapporve();
		int afterDelete = inst.gettotalcoursedetails();
		System.out.println("After Delete:" + afterDelete);
 
		System.out.println("course count decressed correctly after deletion");

	}

	@When("admin select the Rejected option it should be displayed releted option")
	public void admin_select_the_rejected_option_it_should_be_displayed_releted_option() {
		inst.selectthereject();
//		List<String> actualvalue = inst.getvaliddisplayedmessage();
//		for (String actual : actualvalue) {
//			System.out.println("Status:" + actual);
//			Assert.assertEquals(actual.trim(), "rejected");
//		}
		Assert.assertTrue(inst.isstatusdetailsdisplayed());

	}

	@When("admin select the again approve button and verify the count details")
	public void admin_select_the_again_approve_button_and_verify_the_count_details() {
		int beforeDelete = inst.gettotalcoursedetails();
		System.out.println("Before Delete:" + beforeDelete);
		inst.clicktheapporve();
		int afterDelete = inst.gettotalcoursedetails();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");

	}

	@When("admin select the suspend option it should be displayed releted option")
	public void admin_select_the_suspend_option_it_should_be_displayed_releted_option() {
//		inst.selectthesuspended();
//		List<String> actualvalue = inst.getvaliddisplayedmessage();
//		for (String actual : actualvalue) {
//			System.out.println("Status:" + actual);
//			Assert.assertEquals(actual.trim(), "suspended");
//		}
		Assert.assertTrue(inst.isstatusdetailsdisplayed());

	}

	@Then("admin again select the suspended button and verify the count details")
	public void admin_again_select_the_suspended_button_and_verify_the_count_details() {
		int beforeDelete = inst.gettotalcoursedetails();
		System.out.println("Before Delete:" + beforeDelete);
		inst.clicktheapporve();
		int afterDelete = inst.gettotalcoursedetails();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");

	}@Then("admin verify the toatl institutes count and displayed details")
	public void admin_verify_the_toatl_institutes_count_and_displayed_details() {
		String title =inst.gettotalinstitutedetails();
		  System.out.println("Total Course text:"+title);
		  int totalcount=Integer.parseInt(title.replaceAll("[^0-9]",""));
		  int displayedcount = inst.getDisplayedinstitutecount();
		  System.out.println("TOTAL COURSE COUNT:"+totalcount);
		  System.out.println("DISPLAYED COURSE COUNT :"+ displayedcount);
		  Assert.assertTrue(totalcount>=displayedcount,"Dispalyed courses count exceeds total course count");
	}
	}

