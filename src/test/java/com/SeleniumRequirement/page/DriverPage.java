package com.SeleniumRequirement.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {

public static void Browser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\SELINIUM TESTING\\Softwares  for Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);

}
}
