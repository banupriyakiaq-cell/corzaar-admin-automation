package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
			features = {"src\\test\\resources\\com.Feature\\coupon_approval.feature"},
			glue = {"com.Stepdefanition","com.hooksClass"},
			//tags=" @filter",
			plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
	 
	}
