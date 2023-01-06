package com.reports.Basic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ThemeConfigToReport {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		/*
		 * sparkReporter.config().setTheme(Theme.DARK);
		 * sparkReporter.config().setReportName("Report Name");
		 * sparkReporter.config().setDocumentTitle("Document Title");
		 * sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		 * sparkReporter.config().setCss(".badge-primary{background-color:#fecd2f)}");
		 * // To disable the logo from the report sparkReporter.config().setJs(
		 * "document.getElementsByClassName('logo')[0].style.display='none';");
		 */
		
		// Use config variable instead of writing the above lengthy code
		ExtentSparkReporterConfig config=sparkReporter.config();
		config.setTheme(Theme.DARK);
		config.setReportName("Report Name");
		config.setDocumentTitle("Document Title");
		config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		config.setCss(".badge-primary{background-color:#fecd2f)}");
		// To disable the logo from the report
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
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
