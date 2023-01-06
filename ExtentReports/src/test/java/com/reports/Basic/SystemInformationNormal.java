package com.reports.Basic;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemInformationNormal {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		// To get the browser details
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getVersion());
		// To get the System Information
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));
		// To get all the system properties
		System.getProperties().list(System.out);
	}

}
