package com.reports.SeleniumIntegration;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{

	@Test (testName="GOOGLE", groups="Smoke")
	public void testGoogle() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Google";
		Assert.assertEquals(ActualTitle, ExpectedTitle ,"Title is mismatched");
	}
	
	@Test (testName="ORANGE", groups={"Smoke","Regression"})
	public void testOrange() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin1237");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean status=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		Assert.assertTrue(status,"Login not success");

	}
}
