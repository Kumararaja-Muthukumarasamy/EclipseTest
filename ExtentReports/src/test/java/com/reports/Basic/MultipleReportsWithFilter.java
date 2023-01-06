package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class MultipleReportsWithFilter {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]
				{ViewName.AUTHOR,ViewName.DASHBOARD,ViewName.EXCEPTION}).apply();
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Test 1", "Add Author,Category and Divice to the test case")
		.assignAuthor("Kumararaja","Dinesh")
		.assignCategory("Smoke","Sanity")
		.assignDevice("Windows 10","Linux")
		.pass("Test Cass Pass");

		Throwable t= new RuntimeException("This is a custom exception");
		extentReports.createTest("Exception 2").fail(t);
		
		extentReports.flush();

			
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
