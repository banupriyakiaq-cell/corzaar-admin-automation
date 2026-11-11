package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.refundclaim;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class refundclaimstep {
private refundclaim rc = new refundclaim(DriverFactory.getDriver());
	@Given("user is on the admin dashboard page")
	public void user_is_on_the_admin_dashboard_page()   {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	   
	}

	@When("admin click the refund claim module")
	public void admin_click_the_refund_claim_module() {
	     rc.clickrefundclaim();
	     String actualURL=rc.getcurrentUrl();
		    System.out.println("Actual URL:"+actualURL);
		    Assert.assertTrue(actualURL.contains("refunds"));
	}
	@When("Admin verify the totalrefunt count and displayed details")
	public void admin_verify_the_totalrefunt_count_and_displayed_details() {
		String title = rc.gettotalrefundtext();
		System.out.println("Total Course text:" + title);
		int totalcount = Integer.parseInt(title.replaceAll("[^0-9]", ""));
		int displayedcount = rc.getDisplayedrefundcount();
		System.out.println("TOTAL COURSE COUNT:" + totalcount);
		System.out.println("DISPLAYED COURSE COUNT :" + displayedcount);
		//Assert.assertTrue(totalcount >= displayedcount, "Dispalyed courses count exceeds total course count");

	}
	

	@When("admin click the approve button and verify the update data")
	public void admin_click_the_approve_button_and_verify_the_update_data() {
	    //rc.clickApprovebutton();
	}
	@When("the popup window open enter {string}")
	public void the_popup_window_open_enter(String Approvenotes) {
	    //rc.enterapprovenotesfield(Approvenotes);
	}
	@Then("verify the approval notes validation {string}")
	public void verify_the_approval_notes_validation(String Approvenotes) {
//		String actualValue = rc.getapproveinputfieldValue();
//		System.out.println("Expected Value:" + Approvenotes );
//		System.out.println("Actual Value:" + actualValue);
//		Assert.assertEquals(actualValue, Approvenotes);
	}

	@Then("verift the notes data {string}")
	public void verift_the_notes_data(String string) {
	    
	}

	@When("click the confirm approval")
	public void click_the_confirm_approval() {
	    
	}

	@When("again click the approval button and click the close button")
	public void again_click_the_approval_button_and_click_the_close_button() {
	    
	}

	@When("again click the approval button and click the close icon")
	public void again_click_the_approval_button_and_click_the_close_icon() {
	     
	}

	@When("admin click the reject button and verify the update data")
	public void admin_click_the_reject_button_and_verify_the_update_data() {
	     
	}
	@Then("confirmation popup open enter the reason {string}")
	public void confirmation_popup_open_enter_the_reason(String string) {
	    
	}
	@Then("verify the  reject notes validation {string}")
	public void verify_the_reject_notes_validation(String string) {
	    
	}
	@Then("verift the rejectnotes data {string}")
	public void verift_the_rejectnotes_data(String string) {
	    
	}

	@When("click the confirm reject button")
	public void click_the_confirm_reject_button() {
	     
	}

	@When("again click the reject button and click the close button")
	public void again_click_the_reject_button_and_click_the_close_button() {
	     
	}

	@When("again click the reject button and click the close icon")
	public void again_click_the_reject_button_and_click_the_close_icon() {
	    
	}


}
