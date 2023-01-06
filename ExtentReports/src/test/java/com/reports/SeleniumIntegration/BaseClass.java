package com.reports.SeleniumIntegration;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
public static WebDriver driver;
public static String subFolderName;
@Parameters("browserName")
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void captureScreenShot(String Name) {
		if(subFolderName==null) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyy_HHmmss");
	    subFolderName= myDateObj.format(myFormatObj);
		}		
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/"+subFolderName +"/"+Name+".png");
				try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
					e.printStackTrace();
		}
				System.out.println("Screen Shot Saved Successfully");
	}
}