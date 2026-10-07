package com.Stepdefanition;

import java.util.List;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.coupon_approval;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class coupon_approvalstep {
private coupon_approval ca =new coupon_approval(DriverFactory.getDriver());
	@Given("admin is on the dashboard page")
	public void admin_is_on_the_dashboard_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	  
	}

	@When("admin click the coupon approval module")
	public void admin_click_the_coupon_approval_module() {
	     ca.clickcouponapproval();
	     String actualURL=ca.getcurrentUrl();
		    System.out.println("Actual URL:"+actualURL);
		    Assert.assertTrue(actualURL.contains("courses"));
	}

	@When("admin search the coupon code in search field {string}")
	public void admin_search_the_coupon_code_in_search_field(String Couponcode) {
	     ca.entersearchfield(Couponcode);
	}

	@When("the displayed message depends on search code")
	public void the_displayed_message_depends_on_search_code() {
	    String message =ca.displayedmessage();
	    Assert.assertTrue(message !=null && !message.isEmpty());
 	}
	@When("admin verify the details {string} and {string}")
	public void admin_verify_the_details_and(String Status, String Displayedmessage) {
	  // String actualmessage=ca.invalidmessage();
	   if(Status.equalsIgnoreCase("invalid")) {
		   String actualmessage =ca.invalidmessage();
		   Assert.assertEquals(actualmessage,  Displayedmessage);
	   }else if (Status.equalsIgnoreCase("valid")) {
		}
	   }
	@When("admin clear the couponapproval search field in")
	public void admin_clear_the_couponapproval_search_field_in() {
	     ca.clearsearchfield();
	}

    @When("admin using the filter option in search the details")
	public void admin_using_the_filter_option_in_search_the_details() {
	     Assert.assertTrue(ca.isfilterbuttonDisplayed());
	}

	@When("admin select the pending option")
	public void admin_select_the_pending_option() {
	    ca.clickpendingoption();
	}

	@When("it should be displayed correct details")
	public void it_should_be_displayed_correct_details() {
//		 List<String>actualvalue=ca.statusmessagedisplayed();
//			for(String actual:actualvalue) {
//				System.out.println("Status:"+actual);
//				Assert.assertEquals(actual.trim(),"pending");
//	}
	}

	@When("admin click the approve button the coupon approved for admin side")
	public void admin_click_the_approve_button_the_coupon_approved_for_admin_side() {
	    // ca.clickapprovebutton();
	}

	@When("admin reject the coupon")
	public void admin_reject_the_coupon() {
	    //ca.clickrejectbutton();
 	}

	@When("admin select the approved button")
	public void admin_select_the_approved_button() {
	    // ca.clickapprovedoption();
	}

	@When("the approved button displayed correct details")
	public void the_approved_button_displayed_correct_details() {
		 List<String>actualvalue=ca.statusmessagedisplayed();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"approved");
	}
	}

	@When("admin reject the discound details")
	public void admin_reject_the_discound_details() {
	    ca.clickrejectbutton();
	}

	@When("admin select the  rejected button")
	public void admin_select_the_rejected_button() {
	     ca.clickrejectedoption();
	}

	@When("the reject button should be displayed correct details")
	public void the_reject_button_should_be_displayed_correct_details() {
		List<String>actualvalue=ca.statusmessagedisplayed();
		for(String actual:actualvalue) {
			System.out.println("Status:"+actual);
			Assert.assertEquals(actual.trim(),"rejected");}
		
	}

	@Then("admin click the apporve button")
	public void admin_click_the_apporve_button() {
	    //ca.clickapprovebutton();
	}



}
