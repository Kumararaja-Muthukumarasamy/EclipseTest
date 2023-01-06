package com.reports.Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("On Test Success");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("On Test Failure");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("On Test Skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult tr) {
		System.out.println("On Test Failed with timeout");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		System.out.println("On Test Fail but within success percentage");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");;
	}

}
