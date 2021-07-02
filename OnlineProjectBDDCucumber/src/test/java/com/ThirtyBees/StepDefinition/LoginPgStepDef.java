package com.ThirtyBees.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ThirtyBees.Pages.LoginPage;
import com.ThirtyBees.testBase.TestBase;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPgStepDef extends TestBase
{
	WebDriver driver;
	LoginPage lp = null;
	
	@Before
	public void setup() throws Throwable
	{
		driver = initialization();
		lp = new LoginPage(driver);
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	@Given("^user should be on Login Page$")
	public void user_should_be_on_Login_Page() throws Throwable 
	{
		Utility.click(lp.signIn);
		WaitUtility.waitForPageLoad(5 , driver);
		WaitUtility.implicitWait(5 , driver);
	}

	@When("^user enters valid data$")
	public void user_enters_valid_data() throws Throwable 
	{
		 lp.validLogin();
	}

	@Then("^user should land on 'My Account' page$")
	public void user_should_land_on_My_Account_page() throws Throwable 
	{
		Assert.assertTrue(lp.verifyValidLogin());
	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String email, String password) throws Throwable 
	{
	    Utility.sendkeys(lp.emailAddr, email);
	    Utility.sendkeys(lp.pass, password);
	    Utility.click(lp.signIn);
	}

	@Then("^user should land on Login Page$")
	public void user_should_land_on_Login_Page() throws Throwable 
	{
	    Assert.assertEquals(Utility.getTitle(driver), "Login - BEE");
	}
}
