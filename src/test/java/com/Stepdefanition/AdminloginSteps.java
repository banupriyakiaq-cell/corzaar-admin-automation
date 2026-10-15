package com.Stepdefanition;

import java.lang.System.Logger;

import org.apache.commons.logging.Log;
import org.testng.Assert;

import com.Pages.Adminlogin;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminloginSteps {
	 String enteredEmail;
	String enterdpassword;
	private static String title;
	private Adminlogin log;
	
	@Given("user lanuch the application")
	public void user_lanuch_the_application() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		log=new Adminlogin(DriverFactory.getDriver());
		title=log.getAdminPageTitle();
		System.out.println("Page title is:"+title);
	}
	@When("user click the admin button")
	public void user_click_the_admin_button() {
	   log.clicktheadminbutton();
	   title=log.getAdminPageTitle();
		System.out.println("Page title is:"+title);
	}
	
	@When("user enter the {string}")
	public void user_enter_the(String email) {
		enteredEmail = email;
		 log.enterEmailid(email);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
		enterdpassword =password;
	     log.enterPassword(password);
	}

	@When("click the aunthendicate button")
	public void click_the_aunthendicate_button() {
	     log.clickauthendicatebutton();
	}
	@Then("user verify the {string} and {string}")
	public void user_verify_the_and(String  status, String message) {


	    if(status.equalsIgnoreCase("failed")) {
	    	String actualMessage=log.getvalidationMessage();
	    System.out.println("Expected Message:"+message);
	    System.out.println("Actual Message:"+message);

	    Assert.assertEquals(actualMessage.trim(),message.trim(),"invalid lodin mismatch");
	    }else if
	    (status.equalsIgnoreCase("empty")) {
	    	String actualMessage;
	    	if
	    	(message.equalsIgnoreCase("Email")) {
	    	  actualMessage=log.getEmailValidationMessage();
	    }else if 
	    (message.equalsIgnoreCase("Password")) {
		actualMessage=log.getpasswordValidationMessage();
				
		}else {
			throw new
			IllegalArgumentException("Unknown field:"+message);
		}
	    System.out.println("validation Message:"+actualMessage);
	    Assert.assertNotNull(actualMessage,message+"validation message null");
			
	    	 Assert.assertFalse(actualMessage.isEmpty(),message +"valiation message is empty");
	    } 
	}
	 
    @When("admin enter the emailids {string}")
	public void admin_enter_the_emailids(String email) {
 	     log.enterEmailid(email);
	}

	@When("admin enter tha password {string}")
	public void admin_enter_tha_password(String password) {
 
	     log.enterPassword(password);
	}

	@When("click the anuthenticatebutton")
	public void click_the_anuthenticatebutton() {
	     log.clickauthendicatebutton();
	}

	@When("and admin clicks verify with empty OTP")
	public void and_admin_clicks_verify_with_empty_otp() {
	     log.clicksubmitbutton();
	}

	@Then("admin should see the otp validation messahe")
	public void admin_should_see_the_otp_validation_messahe() {
		String actualmessage  =log.getotpValidationMessage();
	     System.out.println("OTP ValidationMessage:"+actualmessage);
	     Assert.assertNotNull(actualmessage,"Otp Validation message is null");
	     Assert.assertFalse(actualmessage.isEmpty(),"Otp Validation message is empty"); 
	}

 	 @And("Admin is on the 2FA verification page")
	public void admin_is_on_the_2fa_verification_page() {
		log=new Adminlogin(DriverFactory.getDriver());
	     log.dipalyedfapage();
	     System.out.println(log.FAPagetext);
 	 }

	@When("admin enters valid {string}")
	public void admin_enters_valid(String otp) {
	      log.enterpasscode(otp);
	}
	@When("admin verifies email and password after back navigation")
	public void admin_verifies_email_and_password_after_back_navigation()  {
	     log.clickbackbutton();
	     String actualEmail = log.getemailfieldvalue();
	     String actualpassword =log.getpasswordfieldvalue();
	     Assert.assertEquals(actualEmail ,enteredEmail,"Email value changed after back navigation");
	     Assert.assertEquals(actualpassword, enterdpassword, "Password value changed after back navigation");
         System.out.println("Email value is maintained after back navication");
	     System.out.println("Password value is maintained after back navication");
	     log.clickauthendicatebutton();

	     
	}
	@When("admin click the verify button")
	public void admin_click_the_verify_button()   {
	   log.clicksubmitbutton();
	}

	@When("admin verify the {string} and {string}")
	public void admin_verify_the_and(String status, String message ) {
		System.out.println("Status:"+status);
		System.out.println("Message:"+message);

 	    if(status.equalsIgnoreCase("failed")) {
	    	String actualMessage=log.getvalidationMessageotp();
 	   System.out.println("Actual Message:"+actualMessage);
	   System.out.println("Actual Message:"+actualMessage);

	    	Assert.assertEquals(actualMessage,message );
	    }else if(status.equalsIgnoreCase("empty")) {
	    	String actualMessage=log.getotpValidationMessage();
	    	System.out.println("OTP Validation Message:"+actualMessage);
	    	Assert.assertNotNull(actualMessage,"Otp Validation Message is null");
	    	Assert.assertFalse(actualMessage.isEmpty(),"Otp validation message is empty");
	    }
	}

	@Then("admin should be logged in successfully")
	public void admin_should_be_logged_in_successfully() {
	    String actualURL=log.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("admin"));
}
}