package com.ThirtyBees.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ThirtyBees.ObjectRepository.TinCupObjRepo;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

public class TinCupPage extends TinCupObjRepo
{
	WebDriver driver ;
	
	public TinCupPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	//1
	public boolean selectingColour() throws Exception
	{	
		String actColour = Utility.getText(checkingColour);
		WaitUtility.sleep(2000);
		log.info("actColour = " + actColour);
		
		String expColour = "Color : Black" ;
		log.info("expColour = " + expColour);
		
		if(actColour.equals(expColour))
		{
			log.info("actcolour and expcolour matched");
			return true ;
		}
		else
		{
			log.info("actcolour and expcolour not matched");
			return false ;
		}
	}
	
	
	
	public boolean selectingQuantityByInsertVal() throws Exception
	{
		String actQuantity = Utility.getText(checkingQuantity);
		WaitUtility.sleep(2000);
		log.info("actQuantity = " + actQuantity);
		
		String expQuantity = "10" ;
		log.info("expQuantity = " + expQuantity);
		
		if(actQuantity.equals(expQuantity))
		{
			log.info("actQuantity and expQuantity matched");
			return true ;
		}
		else
		{
			log.info("actQuantity and expQuantity not matched");
			return false ;
		}
	}
	
	
	
	public boolean selectingQuantityByIncButton() throws Exception
	{	
		String actQuantity = Utility.getText(checkingQuantity);
		WaitUtility.sleep(2000);
		log.info("actQuantity = " + actQuantity);
		
		String expQuantity = "10" ;
		log.info("expQuantity = " + expQuantity);
		
		if(actQuantity.equals(expQuantity))
		{
			log.info("actQuantity and expQuantity matched");
			return true ;
		}
		else
		{
			log.info("actQuantity and expQuantity not matched");
			return false ;
		}
	}
	
}
