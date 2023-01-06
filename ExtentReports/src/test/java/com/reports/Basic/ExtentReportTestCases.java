package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestCases {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);
		
		ExtentTest test1=extentReports.createTest("Test 1");
		test1.log(Status.PASS, "This test case for the status Pass");
		
		ExtentTest test2=extentReports.createTest("Test 2");
		test2.fail("This test case for the status Fail");		
		
		extentReports.createTest("Test 3").warning("This test case for warning");
		
		extentReports.flush();
		//To open the file by default from the java
		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
