package com.qa.Swaag.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver openApplication(WebDriver driver, String browserName, String appUrl){
		
		if (browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");		
			driver = new ChromeDriver();
		}
		else if (browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");		
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("Edge")){
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");		
			driver = new EdgeDriver();
		}
		else {
			System.out.println("This browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		return driver; 
	}
		
	public static void quitBrowser(WebDriver driver){
		driver.quit();		
	}
}
