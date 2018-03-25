package com.qa.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver driverCall(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			return new ChromeDriver();

		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
	}
}
