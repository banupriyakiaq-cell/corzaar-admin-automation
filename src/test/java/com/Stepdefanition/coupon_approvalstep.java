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
	 String selectedcouponName;

private coupon_approval ca =new coupon_approval(DriverFactory.getDriver());
	@Given("admin is on the dashboard page")
	public void admin_is_on_the_dashboard_page()   {
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
		    Assert.assertTrue(actualURL.contains("coupons"));
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
 	   if(Status.equalsIgnoreCase("invalid")) {
		   String actualmessage =ca.invalidmessage();
		   Assert.assertEquals(actualmessage,  Displayedmessage);
	   }else if (Status.equalsIgnoreCase("valid")) {
		}
	   }
	@When("admin verify the search field date {string}")
	public void admin_verify_the_search_field_date(String Couponcode) {
		String actualValue = ca.getSearchfieldValue();
		System.out.println("Expected Value:" + Couponcode);
		System.out.println("Actual Value:" + actualValue);
		Assert.assertEquals(actualValue, Couponcode);  
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

	@When("it should be displayed correct details {string}")
	public void it_should_be_displayed_correct_details(String string) {
		 List<String>actualvalue=ca.statusmessagedisplayed();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"pending");
	}
 
	}
	@When("admin click the approve button the coupon approved for admin side and updata current data")
	public void admin_click_the_approve_button_the_coupon_approved_for_admin_side_and_updata_current_data() {
		int beforeDelete = ca.getDisplayedcouponcount();
		System.out.println("Before Delete:" + beforeDelete);
	     //ca.clickapprovebutton();
		int afterDelete = ca.getDisplayedcouponcount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
		 
	     
	}
	@When("admin verify the the correct data is approved")
	public void admin_verify_the_the_correct_data_is_approved() {
		boolean displayed = ca. isdisplayedselectedcoupon(selectedcouponName);
	    Assert.assertFalse(displayed," courses is still displayed in the table");
}
	 

	@When("admin reject the coupon")
	public void admin_reject_the_coupon() {
	   
	   int beforeDelete = ca.getDisplayedcouponcount();
		System.out.println("Before Delete:" + beforeDelete);
		 ca.clickrejectbutton();
		int afterDelete = ca.getDisplayedcouponcount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
	     
 	}

	@When("admin select the approved button")
	public void admin_select_the_approved_button() {
	    ca.clickapprovedoption();
	     
	}

	@When("the {string} button displayed correct details")
	public void the_button_displayed_correct_details(String string) {
		 List<String>actualvalue=ca.statusmessagedisplayed();
			for(String actual:actualvalue) {
				System.out.println("Status:"+actual);
				Assert.assertEquals(actual.trim(),"approved");
	} 
 
		
	}

	@When("admin reject the discound details and update current data")
	public void admin_reject_the_discound_details_and_update_current_data() {
		 int beforeDelete = ca.getDisplayedcouponcount();
			System.out.println("Before Delete:" + beforeDelete);
			 ca.clickrejectbutton();
			int afterDelete = ca.getDisplayedcouponcount();
			System.out.println("After Delete:" + afterDelete);
			Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
			System.out.println("course count decressed correctly after deletion");
		     
	    
	    
	}
	
	@When("admin verify the the correct data is reject")
	public void admin_verify_the_the_correct_data_is_reject() {
		boolean displayed = ca. isdisplayedselectedcoupon(selectedcouponName);
	    Assert.assertFalse(displayed," courses is still displayed in the table");
	}
 
	@When("admin select the  rejected button")
	public void admin_select_the_rejected_button() {
	     ca.clickrejectedoption();
	}

	@When("the {string} button should be displayed correct details")
	public void the_button_should_be_displayed_correct_details(String string) {
		List<String>actualvalue=ca.statusmessagedisplayed();
		for(String actual:actualvalue) {
			System.out.println("Status:"+actual);
			Assert.assertEquals(actual.trim(),"rejected");}
 
	}

	@Then("admin click the apporve button and update current data")
	public void admin_click_the_apporve_button_and_update_current_data() {
		int beforeDelete = ca.getDisplayedcouponcount();
		System.out.println("Before Delete:" + beforeDelete);
		ca.clickapprovebutton();
		int afterDelete = ca.getDisplayedcouponcount();
		System.out.println("After Delete:" + afterDelete);
		Assert.assertEquals(afterDelete, beforeDelete - 1, "Total course count did not decrease after deletion");
		System.out.println("course count decressed correctly after deletion");
	     }
	@Then("admin click the approve button and verify the details")
	public void admin_click_the_approve_button_and_verify_the_details() {
		boolean displayed = ca. isdisplayedselectedcoupon(selectedcouponName);
	    Assert.assertFalse(displayed," courses is still displayed in the table");
	}
	@Then("admin verify the coupon approval count and displayed details              |")
	public void admin_verify_the_coupon_approval_count_and_displayed_details() {
		String title = ca.gettotalcoupontext();
		System.out.println("Total Course text:" + title);
		int totalcount = Integer.parseInt(title.replaceAll("[^0-9]", ""));
		int displayedcount = ca.getDisplayedcouponcount();
		System.out.println("TOTAL COURSE COUNT:" + totalcount);
		System.out.println("DISPLAYED COURSE COUNT :" + displayedcount);
		Assert.assertTrue(totalcount >= displayedcount, "Dispalyed courses count exceeds total course count");
	}
	 
	 

}
