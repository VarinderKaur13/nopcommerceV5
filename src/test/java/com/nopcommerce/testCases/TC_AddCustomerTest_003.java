package com.nopcommerce.testCases;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;


public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(configPropObj.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		logger.info("***************   TC_AddCustomerTest_003 statred  *********** ");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();

		logger.info("***************  Providing customer details  *********** ");

		
		String email=randomestring()+"@gmail.com";
		
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("varinder");
		addcust.setLastName("Kaur");
		addcust.setGender("Female");
		addcust.setDob("11/29/1991"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setCustomerRoles("Guests");
		addcust.setManagerOfVendor("Vendor 2");
		Thread.sleep(3000);
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();

		// validation
		if (addcust.verifyConfirmationMsg()) {
			logger.info("***************  Customer added succesfully *********** ");
			Assert.assertTrue(true);

		} else {
			logger.error("*************** Customer Not added succesfully *********** ");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

		logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
		
	}
}
