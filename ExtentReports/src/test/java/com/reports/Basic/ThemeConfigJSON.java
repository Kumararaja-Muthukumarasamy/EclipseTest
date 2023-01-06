package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ThemeConfigJSON {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		//sparkReporter.loadJSONConfig(new File ("./src/test/resources/extent-reports-config.json"));
		sparkReporter.loadXMLConfig(new File ("./src/test/resources/extent-reports-config.xml"));
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Test 1", "Add Author,Category and Divice to the test case")
		.assignAuthor("Kumararaja")
		.assignCategory("Smoke")
		.assignDevice("Windows 10")
		.fail("Test Cass Pass");

		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
