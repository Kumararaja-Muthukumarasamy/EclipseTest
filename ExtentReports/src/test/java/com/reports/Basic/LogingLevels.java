package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogingLevels {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);
		
		// Log Level is lNFO >> PASS >> WARNING >> SKIP >> FAIL is the top in order
					
		extentReports.createTest("Test 1")
		.log(Status.INFO, "Verify Level Of Info")
		.log(Status.FAIL, "Verify Level Of Fail")
		.log(Status.PASS, "Verify Level Of Pass")
		.log(Status.SKIP, "Verify Level Of Skip")
		.log(Status.WARNING, "Verify Level Of Warning");
	
		
		extentReports.flush();
		
		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
}
