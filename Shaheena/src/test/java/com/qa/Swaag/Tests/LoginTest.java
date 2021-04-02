package com.qa.Swaag.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.Swaag.Base.BaseClass;
import com.qa.Swaag.Pages.LoginPage;


public class LoginTest extends BaseClass{
		
	@Test
	public void loginApp(){		
	logger =  report.createTest("Login to Swaag Test"); 
	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
	logger.info("Starting the browser"); 	
	loginPage.loginToSwaag(excel.getDataFromExcel(0, 0, 0), excel.getDataFromExcel(0, 0, 1));
	logger.pass("Test passed; login successful"); 
	}
}
