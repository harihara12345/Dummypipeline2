package com.maveric.core.utils.web;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.maveric.core.driver.Driver;
import com.maveric.core.testng.listeners.ReportListener;
import com.maveric.core.utils.reporter.Report;

public class WebActions {
    private final static AtomicInteger counter = new AtomicInteger();
    private final static Logger logger = LogManager.getLogger();
    public WebDriver driver;

    public void logScreenshot(String name) {
        String path = captureScreenshot();
        String html = "<a target=_blank href=" + "screenshots" + path.replaceAll(" ", "%20") + ">" + name + "  </a>";
        Report.log(html);
    }

    public WebActions() {
        if (!Driver.isWebDriverEmpty()) {
            driver = Driver.getWebDriver();
        } else if (!Driver.isAppiumDriverEmpty()) {
            driver = Driver.getAppiumDriver();
        }
    }

    private String captureScreenshot() {
        String screenshotName = null;
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            screenshotName = "/screenshot" + "_" + getId() + ".png";
            String screenshotPath = ReportListener.screenshotFolder + screenshotName;
            FileUtils.copyFile(file, new File(screenshotPath));

        } catch (Exception e) {
            logger.error("unable to capture screenshot" + e);
        }
        return screenshotName;
    }

    private int getId() {
        return counter.incrementAndGet();
    }
    
    public void scrollDown()
    {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(200,450)", "");
    }
    public void scrollUp()
    {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,-350)", "");
    }
    public void doubleClickAction(WebElement value) {
    	Actions actions = new Actions(driver);
    	WebElement elementLocator = value;
    	actions.doubleClick(elementLocator).perform();
    }
    
    public void rightClickAction(WebElement value) {
    	Actions action = new Actions(driver);
    	WebElement link = value;
    	action.contextClick(link).perform();
    }
    
    public void highLighterMethod(WebDriver driver, WebElement element){
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    	 }
    
    
    
    
    
    
    
    
    
    
    

}
