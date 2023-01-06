package com.reports.ScreenShots;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);
		// Selenium Code to open the google
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);


// To create extent report test cases
		extentReports.createTest("Test 1")
		.log(Status.INFO, "Verify the text in normal foramt");

		extentReports.flush();

		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
	
	// To capture the screen shot
	public static void captureScreenShot(String Name) {
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/"+Name+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screen Shot Saved Successfully");
	}

}
