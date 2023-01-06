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

public class FormatDataHighlightText {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);	
		
		List<String> metroList=new ArrayList<String>();
		
		metroList.add("Chennai");
		metroList.add("Delhi");
		metroList.add("Kolkatta");
		metroList.add("Mumbai");
										
		extentReports.createTest("City List - List")
		.info(MarkupHelper.createOrderedList(metroList))
		.info(MarkupHelper.createUnorderedList(metroList));
		
		extentReports.createTest("Highlight the text")
		.info(MarkupHelper.createLabel("This is to confirm the messege Highlight", ExtentColor.ORANGE));		
		extentReports.flush();
		
		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
}
