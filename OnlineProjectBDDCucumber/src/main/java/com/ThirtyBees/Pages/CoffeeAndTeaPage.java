package com.ThirtyBees.Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ThirtyBees.ObjectRepository.CoffeeAndTeaPgObjRepo;
import com.ThirtyBees.utility.ExcelUtility;
import com.ThirtyBees.utility.RobotUtility;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

public class CoffeeAndTeaPage extends CoffeeAndTeaPgObjRepo
{
	WebDriver driver ;
	
	public CoffeeAndTeaPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	//1
	public void sortProductByPrice_LowestFirst() throws Exception 
	{
		RobotUtility.downKey();
		
		Utility.click(sortLowestPriceFirst);
		WaitUtility.sleep(6000);
	}
	
	public boolean verifySortProductByPrice_LowestFirst() throws Exception
	{	
		ArrayList<String> actData = new ArrayList<>();
		for (WebElement element : sortLowestPriceFirstNames) 
		{
			String text = element.getText();
			actData.add(text);
		}
		log.info("actData = " + actData);
		
		ArrayList<String> expData = ExcelUtility.getTableColData("TheBees.xlsx", "ascendingOrderPrices", 0 , 1);
		log.info("expData = " + expData);
		
		if (actData.equals(expData))
		{
			log.info("Actual and Expected list matched");
			return true;
		}
		else
		{
			log.info("Actual and Expected list not matched");
			return false;
		}
	}
	
	
	//2
	public void meanBeanFlavor() throws Exception
	{
		for (int i=0 ; i<3 ; i++)
		{
			RobotUtility.downKey();
		}
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(5000);
		
		log.info("Clicking on Mean Bean flavor");
		Utility.click(meanBean);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(5000);
	}
	
	public boolean verifyMeanBeanFlavor()
	{
		if(coffeeImage.isDisplayed())
		{
			log.info("coffee Image is Displayed");
			return true;
		}
		else
		{
			log.info("coffee Image is not Displayed");
			return false ;
		}	
	}
	
	
	//3
	public void searchInvalidProduct() 
	{
		String product = "@#$" ;
		Utility.sendkeys(search, product);
		Utility.click(searchButton);
	}
	
	public boolean verifySearchInvalidProduct()
	{	
		String actAlertMessage = Utility.getText(alertWarning);
		log.info("actAlertMessage = " + actAlertMessage);
		
		String expAlertMessage = "No results were found for your search \"@#$\"" ;
		log.info("expAlertMessage = " + expAlertMessage);
		
		if(actAlertMessage.equals(expAlertMessage))
		{
			log.info("actAlertMessage and expAlertMessage matched");
			return true ;
		}
		else
		{
			log.info("actAlertMessage and expAlertMessage not matched");
			return false ;
		}
	} 
	
	
	//4
	public void searchMug() throws Exception
	{
		String product = "MUG" ;
		Utility.sendkeys(search, product);
		Utility.click(searchButton);
		WaitUtility.sleep(4000);
	}
	
	public boolean verifySearchMug() throws Exception
	{	
		ArrayList<String> actData = new ArrayList<>();
		for (WebElement element : searchMug) 
		{
			String text = element.getText();
			actData.add(text);
		}
		log.info("actData = " + actData);
		
		ArrayList<String> expData = new ArrayList<>();
		expData.add("MUG");
		log.info("expData = " + expData);
		
		if (actData.equals(expData))
		{
			log.info("actdata and expdata matched");
			return true;
		}
		else
		{
			log.info("actdata and expdata not matched");
			return false;
		}
	}
	
	//5
	public void clickingOnHoney() throws Exception
	{
		for (int i=0 ; i<5 ; i++)
		{
			RobotUtility.downKey();	
		}
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(2000);
		
		log.info("Clicking on Honey");
		Utility.click(clickHoney);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(4000);	
	}
	
	public void navigatingOnPreviousPage() throws Exception
	{
		Utility.navigateBack(driver);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(4000);
		
		Utility.navigateRefresh(driver);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(4000);
	}
	
	public boolean verifyViewedProductsOption() throws Exception
	{	
		RobotUtility.downKey();	
		WaitUtility.sleep(2000);
		
		String actualProduct = Utility.getText(viewedProducts);
		log.info("actualProduct = " + actualProduct);
		
		String expectedProduct = "Honey";
		log.info("expectedProduct = " + expectedProduct);
		
		if(actualProduct.equals(expectedProduct))
		{
			log.info("actualProduct and expectedProduct matched");
			return true ;
		}
		else
		{
			log.info("actualProduct and expectedProduct not matched");
			return false ;
		}
	}
	
	//6
	public void selectPriceRange() throws Exception
	{
		for (int i=0 ; i<3 ; i++)
		{
			RobotUtility.downKey();
		}
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		WaitUtility.sleep(5000);
		
		Utility.click(priceSlider);
		WaitUtility.sleep(5000);
	}
	
	public boolean verifyPriceRangeFilter() throws Exception
	{	
		ArrayList<String> actData = new ArrayList<>();
		for (WebElement element : PriceRangeProducts) 
		{
			String text = element.getText();
			actData.add(text);
		}
		log.info("actData = " + actData);
		
		ArrayList<String> expData = new ArrayList<>();
		expData.add("COFFEE");
		expData.add("TEA");
		expData.add("HONEY");
		log.info("expData = " + expData);
		
		if (actData.equals(expData))
		{
			log.info("actdata and expdata matched");
			return true;
		}
		else
		{
			log.info("actdata and expdata not matched");
			return false;
		}
	}
	
	
	public TinCupPage navigateToTinCupPage() throws Exception
	{
		RobotUtility.downKey();
		
		Utility.click(clickTinCup);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		
		return new TinCupPage(driver);
	}
}
