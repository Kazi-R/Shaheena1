package com.qa.Swaag.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Lib {
	
	public static String captureScreenshot(WebDriver driver, String methodName){
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Swaag_"+methodName+"_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured.");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot >>> "+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime(){
		DateFormat customFormat = new SimpleDateFormat("HH_mm_ss_MM_dd_yyyy"); 
		Date currentDate= new Date();
		return customFormat.format(currentDate);
	}
}
