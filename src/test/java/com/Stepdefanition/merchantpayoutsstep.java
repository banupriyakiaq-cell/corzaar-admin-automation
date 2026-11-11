package com.Stepdefanition;

import java.awt.datatransfer.MimeTypeParseException;

import org.testng.Assert;
import org.testng.asserts.IAssert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.coupon_approval;
import com.Pages.merchantpayouts;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class merchantpayoutsstep {
	private merchantpayouts mp = new merchantpayouts(DriverFactory.getDriver());
	String settlementAmount;
	String bankreceipt;
	String amount;

	@Given("admin is on tha dashboard page agin")
	public void admin_is_on_tha_dashboard_page_agin() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	}

	@When("admin click the merchant payment module")
	public void admin_click_the_merchant_payment_module() {
		mp.clickmerchantpayouts();
		String actualURL = mp.getcurrentUrl();
		System.out.println("Actual URL:" + actualURL);
		Assert.assertTrue(actualURL.contains("payouts"));
	}

	@When("admin verify the record settlement popup window")
	public void admin_verify_the_record_settlement_popup_window() {
		mp.clickrecordsettlement();
		Assert.assertTrue(mp.isrecordsettlementDisplayed());
	}

	@When("admin select the institute or merchant recipient")
	public void admin_select_the_institute_or_merchant_recipient() {
		mp.selectInstitute();
	}

	@When("admin enter the settlement amount {string}")
	public void admin_enter_the_settlement_amount(String amount) {
		settlementAmount = amount;
		mp.enteramount(amount);

	}

	@When("admin enter the bank transfer details {string}")
	public void admin_enter_the_bank_transfer_details(String bankreceipet) {
		mp.enterbankfield(bankreceipet);

	}

	@When("admin enter the notes details {string}")
	public void admin_enter_the_notes_details(String notes) {
		mp.enternotesfield(notes);

	}

	@When("admin select the log settlement button")
	public void admin_select_the_log_settlement_button() {
		mp.clicklogsettement();
//		String actualmessage=mp.getsettlementamountvalidationmessage();
//		System.out.println("Actual validation message:"+actualmessage);
//		Assert.assertFalse(actualmessage.isEmpty(),"Settlement amount validation message is empty");

	}

	@When("verify the settlement failed message is displayed")
	public void verify_the_settlement_failed_message_is_displayed() {
//		boolean status = mp.issettlementFailedmessagedisplayed();
//		System.out.println("Settlement Failed:" + status);
//		Assert.assertTrue(status, "Settlement Failde message is not displayed ");
//		 

	}

	@When("admin click the record settlement open the popup window and click the close button")
	public void admin_click_the_record_settlement_open_the_popup_window_and_click_the_close_button() {

		mp.clickrecordsettlement();
		mp.clickclosebutton();
	}

	@When("admin click the record settlement open the popup window and click the close icon")
	public void admin_click_the_record_settlement_open_the_popup_window_and_click_the_close_icon() {
		mp.clickrecordsettlement();
		mp.clickcloseicon();
	}

	@When("admin click the disburse payout option")
	public void admin_click_the_disburse_payout_option() {
		mp.clickdisbursepayout();

	}

	@When("admin again  select the merchant instittute recipient")
	public void admin_again_select_the_merchant_instittute_recipient() {
		mp.selectInstitute();
	}

	@When("admin again enter the settlement amount {string}")
	public void admin_again_enter_the_settlement_amount(String amount) {
		mp.enteramount(amount);

	}

	@When("admin again enter the bank transfer details {string}")
	public void admin_again_enter_the_bank_transfer_details(String bankreceipet) {
		mp.enterbankfield(bankreceipet);

	}

	@When("admin again enter the notes details {string}")
	public void admin_again_enter_the_notes_details(String notes) {
		mp.enternotesfield(notes);

	}

	@When("admin again select the log settlement button")
	public void admin_again_select_the_log_settlement_button() {
		mp.clicklogsettement();

	}

	@Then("verify the settlement details should be added")
	public void verify_the_settlement_details_should_be_added() {
		int historycount = mp.gethistoricalmerchanttabledetails();
		System.out.println("Historical Settlement Table Count:" + historycount);
		Assert.assertTrue(historycount > 0, "Historical Settlement table has no records");
		System.out.println("Active merchant Table count:" + mp.getactivemerchantdetails());

		boolean status = mp.verifyNewSettlement();
		Assert.assertTrue(status, "New settlement details not added");
	}

	@Then("verify the settlement failed message is display")
	public void verify_the_settlement_failed_message_is_display() {
		 
	}
}