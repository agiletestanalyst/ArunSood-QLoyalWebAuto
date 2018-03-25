package com.qa.testScripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.driverFactory.DriverFactory;

public class ArunQloyalCodeFlightBookTest {

	WebDriver driver;

	String browser = "Chrome";
	String webURL = "https://phptravels.com/demo/";

	String email = "user@phptravels.com";
	String password = "demouser";

	@Test
	public void testCode() throws InterruptedException {
		System.out.println("Testing area");
		driver.manage().window().maximize();
		driver.get(webURL);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.findElement(By.cssSelector("a[href='//www.phptravels.net']")).click();
		

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);

		driver.findElement(By.xpath("(//a[contains(text(),'My Account')])[2]")).click();
		

		driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		driver.findElement(By.name("username")).click();
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(email);

		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		TimeUnit.SECONDS.sleep(15);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='loader'][href='https://www.phptravels.net/flightst'][title='Travelstart']")));
		
		driver.findElement(By.cssSelector("a[class='loader'][href='https://www.phptravels.net/flightst'][title='Travelstart']")).click();
		
		WebElement blogEle = driver.findElement(By.cssSelector("a[class='loader'][href='https://www.phptravels.net/blog']"));
		
		blogEle.sendKeys("");
		blogEle.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Dubai");
		
		

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.driverCall(browser);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		TimeUnit.SECONDS.sleep(10);
		driver.quit();

	}

}
