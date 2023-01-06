package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemInformationExtentReports {

	public static void main(String[] args) throws IOException {		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		ExtentReports extentReport=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");

		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("Browser Name", capabilities.getBrowserName());
		extentReport.setSystemInfo("Browser Version", capabilities.getVersion());
		extentReport.attachReporter(sparkReporter);
						
		extentReport.createTest("Test Case 1", "Test Description")
		.assignCategory("System Test");

		extentReport.flush();
		
		driver.quit();
		
		Desktop.getDesktop().browse(new File("Report.html").toURI());
	}

}
