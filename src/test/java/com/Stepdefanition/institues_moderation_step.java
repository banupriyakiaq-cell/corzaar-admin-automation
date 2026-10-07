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
		if(Status.equalsIgnoreCase("invalid")) {
			   actualmessage=inst.geterrormessage();
		}else{
			actualmessage=inst.getplaceresult();
		}
			 Assert.assertTrue(actualmessage.contains(expected),"Expected:"+expected+"But Actual:"+actualmessage);
 	}
	
	@When("admin clear the plase details in search field")
	public void admin_clear_the_plase_details_in_search_field() {
		inst.clearsearchfield();

	}


	@When("admin select the approved option it should be displayed releted option")
	public void admin_select_the_approved_option_it_should_be_displayed_releted_option() {
		inst.selecttheapproved();
		List<String>actualvalue=inst.getvaliddisplayedmessage();
		for(String actual:actualvalue) {
			System.out.println("Status:"+actual);
			Assert.assertEquals(actual.trim(),"approved");
		}
	}

	@When("admin click the reject button")
	public void admin_click_the_reject_button() {
		inst.clickthereject();
		 

	}

	@When("admin select the Pending option it should be displayed releted option")
	public void admin_select_the_pending_option_it_should_be_displayed_releted_option() {
		 inst.selectthepending();

		 List<String>actualvalue=inst.getvaliddisplayedmessage();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"pending");
	}
	}
	@When("admin click the approve button")
	public void admin_click_the_approve_button() {
		 inst.clicktheapporve();
	}

	@When("admin select the Rejected option it should be displayed releted option")
	public void admin_select_the_rejected_option_it_should_be_displayed_releted_option() {
      inst.selectthereject();

		 List<String>actualvalue=inst.getvaliddisplayedmessage();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"rejected");
	}
	}

	@When("admin select the again approve button")
	public void admin_select_the_again_approve_button() {
			inst.clicktheapporve();
	}

	@When("admin select the suspend option it should be displayed releted option")
	public void admin_select_the_suspend_option_it_should_be_displayed_releted_option() {
			inst.selectthesuspended();
			List<String>actualvalue=inst.getvaliddisplayedmessage();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"suspended");
	}
	}

	@Then("admin again select the suspended button")
	public void admin_again_select_the_suspended_button() {
			inst.clicktheapporve();
	}

}