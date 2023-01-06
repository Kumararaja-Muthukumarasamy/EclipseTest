package com.reports.FormatData;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FormatDataTextType {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);		
							
		extentReports.createTest("Test 1")
		.log(Status.INFO, "Verify the text in normal foramt")
		.log(Status.INFO, "<b> Verify the text in bold letters </b>")
		.log(Status.INFO, "<i> Verify the text in italic format </i>")
		.log(Status.INFO, "<b><i> Verify the text in italic format</b></i>");
		
		extentReports.flush();
		
		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
}
