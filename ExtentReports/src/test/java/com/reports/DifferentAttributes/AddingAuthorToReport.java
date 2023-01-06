package com.reports.DifferentAttributes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddingAuthorToReport {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Test 1", "Add Author,Category and Divice to the test case")
		.assignAuthor("Kumararaja","Dinesh")
		.assignCategory("Smoke","Sanity")
		.assignDevice("Windows 10","Linux")
		.pass("Test Cass Pass");

		extentReports.flush();

			
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
