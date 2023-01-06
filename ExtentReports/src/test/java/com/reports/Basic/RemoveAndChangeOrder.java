package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class RemoveAndChangeOrder {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter_All= new ExtentSparkReporter("Report_All.html");
		ExtentSparkReporter sparkReporter_Fail= new ExtentSparkReporter("Report_Fail.html");
		ExtentSparkReporter sparkReporter_Warning= new ExtentSparkReporter("Report_Warning.html");
		sparkReporter_Fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_Warning.filter().statusFilter().as(new Status[] {Status.FAIL,Status.WARNING}).apply();
		extentReports.attachReporter(sparkReporter_All,sparkReporter_Fail,sparkReporter_Warning);
		
		extentReports.createTest("Test 1", "Test Case for All the status")
		.assignAuthor("Kumararaja","Dinesh")
		.assignCategory("Smoke","Sanity")
		.assignDevice("Windows 10","Linux")
		.pass("Test Cass Pass");
		
		extentReports.createTest("Test 2", "Test Case for Failed ")
		.assignAuthor("Ramya")
		.assignCategory("Regression")
		.assignDevice("Linux")
		.fail("Test Cass Fail");
		
		extentReports.createTest("Test 3", "Test Case for Warning")
		.assignAuthor("Ramya")
		.assignCategory("Regression")
		.assignDevice("Linux")
		.warning("Test Cass Warning");
		
		extentReports.flush();

		Desktop.getDesktop().browse(new File("Report_All.html").toURI());
		Desktop.getDesktop().browse(new File("Report_Fail.html").toURI());
		Desktop.getDesktop().browse(new File("Report_Warning.html").toURI());

	}

}
