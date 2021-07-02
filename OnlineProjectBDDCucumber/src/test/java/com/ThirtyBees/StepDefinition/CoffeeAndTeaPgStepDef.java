package com.ThirtyBees.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ThirtyBees.Pages.CoffeeAndTeaPage;
import com.ThirtyBees.Pages.LoginPage;
import com.ThirtyBees.testBase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoffeeAndTeaPgStepDef extends TestBase
{
	WebDriver driver;
	LoginPage lp = null;
	CoffeeAndTeaPage ctp = null;
	
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
	
	@Given("^user should be on \"([^\"]*)\" Page$")
	public void user_should_be_on_Page(String arg1) throws Throwable 
	{
		ctp = lp.navigateMyAccountPg().navigateToCoffeeAndTeaPg();
	}

	@When("^user select the option \"([^\"]*)\"$")
	public void user_select_the_option(String arg1) throws Throwable 
	{
		ctp.sortProductByPrice_LowestFirst();
	}

	@Then("^actual and expected sequence products should be same$")
	public void actual_and_expected_sequence_products_should_be_same() throws Throwable 
	{
		Assert.assertTrue(ctp.verifySortProductByPrice_LowestFirst());
	}
	
	@When("^user select the option 'Mean Bean Flavor'$")
	public void user_select_the_option_Mean_Bean_Flavor() throws Throwable 
	{
	   ctp.meanBeanFlavor();
	}

	@Then("^actual and expected list products having 'Mean Bean Flavor' should be same$")
	public void actual_and_expected_list_products_having_Mean_Bean_Flavor_should_be_same() throws Throwable 
	{
		Assert.assertTrue(ctp.verifyMeanBeanFlavor());
	}
	
	@When("^user enters '@#\\$' in search box$")
	public void user_enters_$_in_search_box() throws Throwable 
	{
		ctp.searchInvalidProduct();
	}

	@Then("^alert message with text 'No results were found for your search \"([^\"]*)\"' should appear$")
	public void alert_message_with_text_No_results_were_found_for_your_search_should_appear(String arg1) throws Throwable 
	{
	    Assert.assertTrue(ctp.verifySearchInvalidProduct());
	}

	@When("^user enters 'MUG' in search box$")
	public void user_enters_MUG_in_search_box() throws Throwable 
	{
	    ctp.searchMug();
	}

	@Then("^actual and expected list products with name 'MUG' should be same$")
	public void actual_and_expected_list_products_with_name_MUG_should_be_same() throws Throwable 
	{
		Assert.assertTrue(ctp.verifySearchMug());
	}
	
	@When("^user clicks on product 'Honey'$")
	public void user_clicks_on_product_Honey() throws Throwable 
	{
	    ctp.clickingOnHoney();
	}

	@When("^navigate back to \"([^\"]*)\" Page$")
	public void navigate_back_to_Page(String arg1) throws Throwable 
	{
		ctp.navigatingOnPreviousPage();
	}

	@Then("^user should be able to see product 'Honey' in viewed products$")
	public void user_should_be_able_to_see_product_Honey_in_viewed_products() throws Throwable 
	{
	    Assert.assertTrue(ctp.verifyViewedProductsOption());
	}

	@When("^user selects the price range$")
	public void user_selects_the_price_range() throws Throwable 
	{
	   ctp.selectPriceRange();
	}

	@Then("^actual and expected list products belonging to that particular price range should be same$")
	public void actual_and_expected_list_products_belonging_to_that_particular_price_range_should_be_same() throws Throwable 
	{
		 Assert.assertTrue(ctp.verifyPriceRangeFilter());
	}
}
