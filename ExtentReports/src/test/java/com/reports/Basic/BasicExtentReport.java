package com.reports.Basic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtentReport {

	public static void main(String[] args) {
	ExtentReports extentReport=new ExtentReports();
	ExtentSparkReporter sparkReporter= new ExtentSparkReporter("./Reports/Report.html");
	extentReport.attachReporter(sparkReporter);
	extentReport.flush();
	}

}
