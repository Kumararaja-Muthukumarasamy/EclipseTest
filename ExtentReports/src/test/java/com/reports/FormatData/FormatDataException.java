package com.reports.FormatData;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FormatDataException {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);	
					
		try {
		int i=9/0;
		}catch(Exception e) {
			extentReports.createTest("Exception 1").info(e);
		}
		
		Throwable t= new RuntimeException("This is a custom exception");
		extentReports.createTest("Exception 2").fail(t);
				
		extentReports.flush();
		
		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
}
