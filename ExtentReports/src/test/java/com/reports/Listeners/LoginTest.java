package com.reports.Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void gmailLogin() {
		System.out.println("Gmail Login");
		Assert.assertEquals("Kumar", "Kumar");
	}
	@Test
	public void yahooLogin() {
		System.out.println("Yahoo Login");
		Assert.assertEquals("Kumar", "Ramya");
	}

}
