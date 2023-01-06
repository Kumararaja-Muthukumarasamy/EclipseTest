package com.reports.FormatData;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FormatDataCollectionsData {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);	
		
		List<String> metroList=new ArrayList<String>();
		
		metroList.add("Chennai");
		metroList.add("Delhi");
		metroList.add("Kolkatta");
		metroList.add("Mumbai");
		
		Set<String> airwaysSet= new HashSet<String>();
		airwaysSet.add("Indigo");
		airwaysSet.add("Air India");
		airwaysSet.add("Air Asia");
		airwaysSet.add("Tiger");
		
		Map<Integer,String> populationMap=new HashMap<Integer,String>();
		populationMap.put(101, "UP");
		populationMap.put(102, "MP");
		populationMap.put(103, "Maharashtra");
		populationMap.put(104, "Tamil Nadu");
							
		extentReports.createTest("City List - List")
		.info(MarkupHelper.createOrderedList(metroList))
		.info(MarkupHelper.createUnorderedList(metroList));
		
		extentReports.createTest("Airways List - Set")
		.info(MarkupHelper.createOrderedList(airwaysSet))
		.info(MarkupHelper.createUnorderedList(airwaysSet));
		
		extentReports.createTest("Population List - Map")
		.info(MarkupHelper.createOrderedList(populationMap))
		.info(MarkupHelper.createUnorderedList(populationMap));
		
		extentReports.flush();
		
		//To open the file by default from the java		
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}
}
