package com.nopcommerce.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass
{
	
	@Test(priority=1)
	public void searchCustomerbyName() throws IOException, InterruptedException
	{		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//Goto Search Page
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
			
		//Provide FirstName and LastName in Search Page
			
		SearchCustomerPage serachcust=new SearchCustomerPage(driver);
		serachcust.setFirstName("Victoria");
		serachcust.setLastName("Terces");	
		
		serachcust.clickSearch();
		
		Thread.sleep(5000);
		
		//validation
		boolean status=serachcust.searchCustomerByName("Victoria Terces");
		//Assert.assertEquals(true, status);

	if(status==true)
	{
		logger.info("**************** Search customer by name is passed************* ");
		Assert.assertTrue(true);
	
	}
	else
	{
		logger.error("**************** Search customer by name is failed************* ");
		captureScreen(driver,"searchCustomerbyName");
		Assert.assertTrue(false);	
	}
	logger.info("**************** End of TC_SearchCustomerByName_005 ************* ");
}
	
}