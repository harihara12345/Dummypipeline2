package com.internetapp.pages;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
	private static SeleniumDriver seleniumDriver;
	 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

   public static void  SeleniumDriver(String url) {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARIHARAVIGNESHM\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
        driver.get(url);
       
    }

    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
