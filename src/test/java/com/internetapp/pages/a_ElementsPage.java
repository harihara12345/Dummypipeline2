package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

public class a_ElementsPage extends WebActions {
	private final By elementHead = By.xpath("(//div[@class='card-up'])[1]");
	private final By elementText = By.xpath("(//div[@class='col-12 mt-4 col-md-6'])[1]");
	private final By submitText = By.xpath("//button[@id='submit']");
	private final By FirstName = By.xpath("//input[@placeholder='Full Name']");
	private final By email = By.xpath("//input[@type='email']");
	private final By address = By.xpath("//textarea[@placeholder='Current Address']");
	private final By cAddress = By.xpath("//textarea[@id='permanentAddress']");
	private final By testBox = By.xpath("//span[contains(text(),'Text Box')]");
	private final By  chkBox = By.xpath("//span[contains(text(),'Check Box')]");
	private final By homeChk  = By.xpath("//span[@class='rct-checkbox']");
	private final By chkText = By.xpath("//div[@id='result']");
	private final By radiobtn = By.xpath("//span[contains(text(),'Radio Button')]");
	private final By radiobtnPoint= By.xpath("//input[@type='radio']//following::label[contains(text(),'Impressive')]");
	private final By webTable = By.xpath("//span[contains(text(),'Web Tables')]");
	private final By alden = By.xpath("(//div[contains(text(),'Insurance')]//following::span[@class='mr-2'])[2]");
	private final By agew = By.xpath("//input[@placeholder='Age']");
	private final By table = By.xpath("//div[@class='web-tables-wrapper']");
	private final By addB = By.xpath("//button[@id='addNewRecordButton']");
	private final By ddbutton = By.xpath("//span[contains(text(),'Buttons')]");
	private final By doublebtn = By.xpath("//button[@id='doubleClickBtn']");
	private final By rightbtn = By.xpath("//button[@id='rightClickBtn']");
	private final By clickbtn  = By.xpath("(//button[@type='button'])[4]");
	private final By links  = By.xpath("//span[contains(text(),'Links')]");
	private final By homeLink = By.xpath("//a[contains(text(),'Home') and @id='simpleLink']");

	//Alerts,Frames and Windows
	private final By AlertFrameWindow = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
	private final By AlertFrameWindowbutton = By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]");
	//BrowserWindows
		private final By BrowserWindows = By.xpath("//span[contains(text(),'Browser Windows')]");
		private final By NewTab = By.xpath("//button[@id='tabButton']");
		private final By NewWindow = By.xpath("//button[@id='windowButton']");
		private final By NewWindowMessage = By.xpath("//button[@id='messageWindowButton']");
	//Alerts
		private final By Alerts = By.xpath("//span[contains(text(),'Alerts')]");
		private final By AlertsHeader = By.xpath("//div[@class='main-header']");
		private final By AlertClickAlert = By.xpath("//button[@id='alertButton']");
		private final By AlertClickTimerAlert = By.xpath("//button[@id='timerAlertButton']");
		private final By AlertClickConfirmAlert = By.xpath("//button[@id='confirmButton']");
		private final By AlertClickPromptAlert = By.xpath("//button[@id='promtButton']");
		private final By Result1 = By.xpath("//span[@id='confirmResult']");
		private final By Result2 = By.xpath("//span[@id='promptResult']");
		
	//Frames	
		private final By Frames = By.xpath("//span[contains(text(),'Frames')]");
		private final By FramesHeader = By.xpath("//div[@class='main-header']");
		private final By Frame1 = By.xpath("//iframe[@id='frame1']");
		private final By Frame2 = By.xpath("//iframe[@id='frame2']");

	//ModalDialogs
	private final By ModalDialogs = By.xpath("//span[contains(text(),'Modal Dialogs')]");
	private final By ModalDialogsHeader = By.xpath("//div[@class='main-header']");
	private final By ModalDialogsSmall = By.xpath("//button[@id='showSmallModal']");
	private final By ModalDialogsSmallHeader = By.xpath("//div[@id='example-modal-sizes-title-sm']");
	private final By ModalDialogsSmallBody = By.xpath("//div[@class='modal-body']");
	private final By ModalDialogsSmallClose = By.xpath("//button[@id='closeSmallModal']");
	private final By ModalDialogsLarge = By.xpath("//button[@id='showLargeModal']");
	private final By ModalDialogsLargeHeader = By.xpath("//div[@id='example-modal-sizes-title-lg']");
	private final By ModalDialogsLargeBody = By.xpath("//div[@class='modal-body']");
	private final By ModalDialogsLargeClose= By.xpath("//button[@id='closeLargeModal']");
	private final By ModalContent = By.xpath("//div[@class='modal-content']");

	//Widgets

	private final By Widgets = By.xpath("//div[contains(text(),'Widgets')]");
	private final By Accordian = By.xpath("//span[contains(text(),'Accordian')]");
	private final By AccordianHeader = By.xpath("//div[@class='main-header']");
	private final By Accordian1 = By.xpath("//div[@id='section1Heading']");
	private final By Accordian1Content = By.xpath("//div[@id='section1Content']");
	private final By Accordian2 = By.xpath("//div[@id='section2Heading']");
	private final By Accordian2Content = By.xpath("//div[@id='section2Content']");
	private final By Accordian3 = By.xpath("//div[@id='section3Heading']");
	private final By Accordian3Container = By.xpath("//div[@id='section3Content']");

	//AutoComplete
	private final By AutoComplete = By.xpath("//span[contains(text(),'Auto Complete')]");
	private final By AutoCompleteTextBox1 = By.xpath("//div[@id='autoCompleteMultipleContainer']//div[@class='auto-complete__control css-yk16xz-control']");
	private final By AutoCompleteUpdate1 = By.xpath("(//div[@class='css-12jo7m5 auto-complete__multi-value__label'])[1]");
	private final By AutoCompleteUpdate2 = By.xpath("(//div[@class='css-12jo7m5 auto-complete__multi-value__label'])[2]");
	private final By AutoCompleteUpdate3 = By.xpath("(//div[@class='css-12jo7m5 auto-complete__multi-value__label'])[3]");
	private final By AutoCompleteTextBox2 = By.xpath("//div[@id='autoCompleteSingleContainer']");
	private final By AutoCompleteUpdate4 = By.xpath("//div[@class='auto-complete__single-value css-1uccc91-singleValue']");


	//DatePicker
	private final By Datepicker = By.xpath("//span[contains(text(),'Date Picker')]");
	private final By DatepickerHeader= By.xpath("//div[@class='main-header']");
	private final By DatepickerSelectDate = By.xpath("//input[@id='datePickerMonthYearInput']");
	private final By DatepickerSelectDateAndTime = By.xpath("//input[@id='dateAndTimePickerInput']");

	//Slider
	private final By Slider = By.xpath("//span[contains(text(),'Slider')]");
	private final By SliderView = By.xpath("//input[@class='range-slider range-slider--primary']");
	private final By SliderValue = By.xpath("//input[@id='sliderValue']");

	//ProgressBar
	private final By ProgressBar = By.xpath("//span[contains(text(),'Progress Bar')]");
	private final By ProgressBarHeader = By.xpath("//div[@class='main-header']");
	private final By ProgressBarStart = By.xpath("//button[@id='startStopButton']");
	private final By ProgressBarView = By.xpath("//div[@id='progressBar']");
	private final By ProgressBarViewInfo =By.xpath("//div[@class='progress-bar bg-info']");

	//Tabs
	private final By Tabs = By.xpath("//span[contains(text(),'Tabs')]");
	private final By TabsHeader = By.xpath("//div[@class='main-header']");
	private final By Tab1 = By.xpath("//a[@id='demo-tab-what']");
	private final By Tab1Content = By.xpath("//div[@id='demo-tabpane-what']");
	private final By Tab2 = By.xpath("//a[@id='demo-tab-origin']");
	private final By Tab2Content = By.xpath("//div[@id='demo-tabpane-origin']");
	private final By Tab3 = By.xpath("//a[@id='demo-tab-use']");
	private final By Tab3Content = By.xpath("//div[@id='demo-tabpane-use']");
	private final By AllTabs = By.xpath("//a[@role='tab']");
	

	//ToolTips
	private final By ToolTips = By.xpath("//span[contains(text(),'Tool Tips')]");
	private final By ToolTipsHeader = By.xpath("//div[@class='main-header']");
	private final By ToolTip1 = By.xpath("//button[@id='toolTipButton']");
	private final By ToolTip2 = By.xpath("//input[@id='toolTipTextField']");

	//Menu
	private final By Menu = By.xpath("//li[@id='item-7']//span[@class='text'][contains(text(),'Menu')]");
	private final By MenuHeader = By.xpath("//div[@class='main-header']");
	private final By Menu1 = By.xpath("//a[contains(text(),'Main Item 1')]");
	private final By Menu2 = By.xpath("//a[contains(text(),'Main Item 2')]");
	private final By Menu3 = By.xpath("//a[contains(text(),'Main Item 3')]");


	//SelectMenu
	private final By SelectMenu = By.xpath("//span[contains(text(),'Select Menu')]");
	private final By SelectMenuHeader = By.xpath("//div[@class='main-header']");
	private final By oldstyleSelectMenu = By.xpath("//select[@id='oldSelectMenu']");
	
	

    WebDriverWait wait;
    WebDriver driver;

    public a_ElementsPage() {
        driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
    }

    public a_ElementsPage navigate(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();

        logScreenshot("login");
        ;
        log("sample log");

        return this;

    }	

    public a_ElementsPage testBox(String Fname,String mail,String add,String cAdd) throws InterruptedException {
    	driver.findElement(elementHead).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	driver.findElement(testBox).click();
    	Thread.sleep(2000);
    	driver.findElement(FirstName).sendKeys(Fname);
    	driver.findElement(email).sendKeys(mail);
    	driver.findElement(address).sendKeys(add);
    	driver.findElement(cAddress).sendKeys(cAdd);
    	logScreenshot("Texted successful");
    	scrollDown();
    	driver.findElement(submitText).click();
        logScreenshot("TextBox successful");
        Thread.sleep(2000);
        return this;
    }
  
    public a_ElementsPage checkBox() throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(chkBox));
    	driver.findElement(chkBox).click();Thread.sleep(1000);
    	driver.findElement(homeChk).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(chkText)).isDisplayed();
    	
        logScreenshot("CheckBox successful");
        return this;
    }

    public a_ElementsPage radioButton(String option) throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(radiobtn));
    	driver.findElement(radiobtn).click(); Thread.sleep(1000);
    	driver.findElement(radiobtnPoint).click();
        logScreenshot("RadioButton successful");
        return this;
    }

    public a_ElementsPage webTables(String ageGiven) throws InterruptedException {
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(webTable));
    	driver.findElement(webTable).click(); 
    	logScreenshot("webTables successful");
//    	driver.findElement(addB).click();
    	driver.findElement(alden).click();Thread.sleep(5000);
//    	driver.findElement(agew).sendKeys(ageGiven);
//    	driver.findElement(submitText).click();
    	logScreenshot("webTables amned successful");Thread.sleep(2000);
        return this;
    }
  
    public a_ElementsPage Dbutton() throws InterruptedException {
    	driver.findElement(elementHead).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(ddbutton));logScreenshot("visible");
    	driver.findElement(ddbutton).click(); 
    	logScreenshot("webTables successful");
    	doubleClickAction(driver.findElement(doublebtn));
    	rightClickAction(driver.findElement(rightbtn));
    	driver.findElement(clickbtn).click();
    	Thread.sleep(3000);
    	logScreenshot("clicking successful");
        return this;
    }
    
    

    public a_ElementsPage LinksOps() throws InterruptedException {
    	driver.findElement(elementHead).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(links));
    	highLighterMethod(driver, (WebElement) links);
    	logScreenshot("visible");
    	driver.findElement(links).click();
    	logScreenshot("clicking successful");
    	wait.until(ExpectedConditions.presenceOfElementLocated(homeLink));
    	highLighterMethod(driver, (WebElement) homeLink);Thread.sleep(2000);logScreenshot("visible");
//    	driver.findElement(homeLink).click();Thread.sleep(2000);
    	
    	return this;
    }
    
    public a_ElementsPage browserwindows(String option1, String option2) throws InterruptedException {
    	
    	
    	scrollDown();
    	driver.findElement(AlertFrameWindow).click();	
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(BrowserWindows)).isDisplayed();
    	driver.findElement(BrowserWindows).click(); 
    	logScreenshot("Browser Window launched successful");
    	wait.until(ExpectedConditions.presenceOfElementLocated(NewTab)).isDisplayed();
    	driver.findElement(NewTab).click();
    	
    	Thread.sleep(3000);
    	
    	//Store the ID of the original window
    	String originalWindow = driver.getWindowHandle();
    	
    	//Loop through until we find a new window handle
    	for (String windowHandle : driver.getWindowHandles()) {
    	    if(!originalWindow.contentEquals(windowHandle)) {
    	        driver.switchTo().window(windowHandle);
    	        logScreenshot("Navigated to new Tab");
    	        break;
    	    }
    	}
    	driver.close();
    	driver.switchTo().window(originalWindow);
    	
    	logScreenshot("Navigated back to original Window");
    	wait.until(ExpectedConditions.presenceOfElementLocated(NewWindow));
    	driver.findElement(NewWindow).click();
    	Thread.sleep(3000);
    	
    	
    	for (String windowHandle : driver.getWindowHandles()) {
    	    if(!originalWindow.contentEquals(windowHandle)) {
    	        driver.switchTo().window(windowHandle);
    	        logScreenshot("Navigated to new Window");
    	        break;
    	    }
    	}
    	driver.close();
    	driver.switchTo().window(originalWindow);
    	logScreenshot("Navigated back to original Window");
    	wait.until(ExpectedConditions.presenceOfElementLocated(NewWindowMessage));
    	driver.findElement(NewWindowMessage).click();
    	Thread.sleep(3000);
    	String lastWindowHandle = "";
    	for (String windowHandle1 : driver.getWindowHandles()) {
    	    if(!originalWindow.contentEquals(windowHandle1)) {
    	    	lastWindowHandle = windowHandle1;
    	        driver.switchTo().window(lastWindowHandle);
 // 	        logScreenshot("Navigated to new Window with Message");
    	        break;
    	    }
    	}
    	driver.close();
    	driver.switchTo().window(originalWindow);
    	logScreenshot("Navigated back to original Window");
    	Thread.sleep(2000);
        return this;
    }
    
    
    public a_ElementsPage Alerts(String Text) throws InterruptedException {
    	
    	//Scenario - Successfully accessing the Alerts sub-option
    	//Given <Logged into Demoqa.com URL>
    	//And <I'm in the Alerts, Frame & Windows section>
    	//And <Selected Browser Alerts sub option>
    	//When <I click the First "Click Me" button>
    	//Then <A Simple Alert pops up And it is able to accept>
    	//When <I click the Second "Click Me" button>
    	//Then <A  Simple Alert pops up after 5 secs And it is able to accept>
    	//When <I click the Third "Click Me" button>
    	//Then <A  Confirmation Alert pops up And it is able to accept or Reject>
    	//When <I click the Forth "Click Me" button>
    	//Then <A  Prompt Alert pops up And it is able to input a text>
    	
    	scrollDown();
    	driver.findElement(Alerts).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(AlertsHeader)).isDisplayed();
    	logScreenshot("Navigated to simple Alert Section");
    	driver.findElement(AlertClickAlert).click();
    	driver.switchTo().alert();
  //  	logScreenshot("Navigated to simple alert pop up");
    	Alert alert = driver.switchTo().alert();
    	String alertMessage= driver.switchTo().alert().getText();
    	System.out.println("Message in the Simple Alert is - "+alertMessage);
 //   	logScreenshot("Navigated to simple Alert msg box");
    	driver.switchTo().alert().accept();
    	wait.until(ExpectedConditions.presenceOfElementLocated(AlertClickTimerAlert)).isDisplayed();
    	
    	driver.findElement(AlertClickTimerAlert).click();
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert();
    	
    	String alertMessage1= driver.switchTo().alert().getText();
    	driver.switchTo().alert().accept();
        System.out.println("Timer Alert is present and its contents is - "+alertMessage1);
        wait.until(ExpectedConditions.presenceOfElementLocated(AlertClickConfirmAlert));
        driver.findElement(AlertClickConfirmAlert).click();
        driver.switchTo().alert();
        String alertMessage2= driver.switchTo().alert().getText();
    	System.out.println("Message in the Simple Alert is - "+alertMessage2);
     	driver.switchTo().alert().accept();
     	logScreenshot("Prompt Message accepted");
     	String result1 = driver.findElement(Result1).getText();
     	System.out.println(result1);
     	wait.until(ExpectedConditions.presenceOfElementLocated(AlertClickPromptAlert));
     	driver.findElement(AlertClickPromptAlert).click();
     	driver.switchTo().alert().sendKeys(Text);
     	alert.accept();
     	logScreenshot("Confirmation Message accepted");
     	String result2 = driver.findElement(Result2).getText();
     	System.out.println(result2);
        return this;
 /*   	 try{ 
    	        Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
    	        if(a!=null){
    	        	String alertMessage1= driver.switchTo().alert().getText();
    	            System.out.println("Timer Alert is present and its contents is - "+alertMessage1);
    	            driver.switchTo().alert().accept();
    	            return this;
    	        }else{
    	            throw new Throwable();
    	        }
    	    } 
    	    catch (Throwable e) {
    	        System.err.println("Alert isn't present!!");
    	        return this; 
    	    }  */
    }
    
        public a_ElementsPage Frameselement() throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Frames sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Alerts, Frame & Windows section>
        	//And <Selected Browser Frames sub option>
        	//When <I switch to a Frame>
        	//Then <Able to access the frame>
        	
        	
        	scrollDown();
        	driver.findElement(Frames).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(FramesHeader));
        	logScreenshot("Navigated to frame screen");
        	int size = driver.findElements(By.tagName("iframe")).size();
        	System.out.println("No of Frames in the screen - "+size);
        	driver.switchTo().frame("frame1");
        	System.out.println("Switched to frame 1");
        	driver.switchTo().defaultContent();
        	driver.switchTo().frame("frame2");
        	System.out.println("Switched to frame 2");
        	driver.switchTo().defaultContent();
        	return this;
        	
        }
        
        public a_ElementsPage ModalDialogs() throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Modal Dialogs sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Alerts, Frame & Windows section>
        	//And <Selected Modal Dialogs sub option>
        	//When <I click the "Small Modal" button >
        	//Then <A Modal dialog box appears with message content>
        	//And <Able to close it>
        	
        	
        	scrollDown();
        	driver.findElement(ModalDialogs).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(ModalDialogsHeader));
        	logScreenshot("Navigated to Modal Dialogs Screen");
        	driver.findElement(ModalDialogsSmall).click();
        	WebElement  modal  = driver.findElement(ModalContent);
        	modal.click();
            logScreenshot("Navigated to Modal Dialog box");
        	WebElement     modalcontent = driver.findElement(ModalDialogsSmallBody);
        	String content = modalcontent.getText();
        	System.out.println("The content in the Modal Dialog box - "+content);
        	driver.findElement(ModalDialogsSmallClose).click();
        	Thread.sleep(1000);
        	scrollDown();
           	return this;
           	
        	
        }
    
        public a_ElementsPage Accordian() throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Accordian sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Accordian sub option>
        	//When <I click the Accordian tab >
        	//Then <Contents of the Accordian tab is displayed>
        	
        	
 //       	scrollDown();
        	wait.until(ExpectedConditions.presenceOfElementLocated(AlertFrameWindowbutton)).isDisplayed();
        	driver.findElement(AlertFrameWindowbutton).click();
  //      	scrollDown();
        	wait.until(ExpectedConditions.presenceOfElementLocated(Widgets)).isDisplayed();
        	Thread.sleep(1000);
        	driver.findElement(Widgets).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(Accordian));
        	Thread.sleep(2000);
        	driver.findElement(Accordian).click();
        	logScreenshot("Navigated to Accordian Screen");
        	 List<WebElement> allLinks = driver.findElements(By.cssSelector(".card-header"));
        	  System.out.println("No of Accordians in the screen - "+allLinks.size());
        	  for(WebElement w:allLinks)
        	  {
        		  String text1=w.getText();
        		  System.out.println("Text metioned in the Accordian selected - "+text1);
        		    new Actions(driver).click(w).build().perform();
        		    
        		        Thread.sleep(3000);
        		    } 
        	  
        	  
 /*       	  Iterator<WebElement> itr = allLinks.iterator();
        	  while(itr.hasNext())
        	  {
        		  String text1=itr.next().getText();
        		  System.out.println(text1);
        	      itr.next().click();
        	      Thread.sleep(3000);
        	      
        	      }*/
        	Thread.sleep(2000);
        	return this;
        	
        }
     
        public a_ElementsPage AutoComplete(String option1,String option2 ) throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Auto Complete sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Auto Complete sub option>
        	//When <I click the text box with Auto Complete feature  and input a characters>
        	//Then <Values matching the inputted characters is displayed and selected>
        	
        	
        	
  //      	driver.findElement(Widgets).click();
        	Thread.sleep(2000);
  //      	scrollDown();
  //      	scrollUp();
        	wait.until(ExpectedConditions.presenceOfElementLocated(AutoComplete));
        	driver.findElement(AutoComplete).click();
        	logScreenshot("Navigated to AutoComplete Screen");
       	driver.findElement(AutoCompleteTextBox1).click();
        	Thread.holdsLock(1000);
        	System.out.println("Text box clicked");
        	driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(option1);
        	driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(Keys.ENTER);
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(option2);
        	driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(Keys.ENTER);
        	Thread.sleep(1000);
        	
        	logScreenshot("Auto Complete textbox selected with values");
        	
  /*      	List<WebElement> autoSuggest = driver.findElements(By.xpath("//div[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']"));
            Thread.sleep(3000);
            for (WebElement a : autoSuggest)
            {
            	System.out.println("Values are = " + a.getText());
            	if (a.getText().equalsIgnoreCase("Red"));
            	a.click();
            	Thread.sleep(3000);
            	break;
            }*/
        	
     
        	return this;   
    
        }
        
        public a_ElementsPage DatePicker(String option1,String option2) throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Date Picker sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Date Picker sub option>
        	//When <I click the Date Picker box and input the Date and Time>
        	//Then <Date and Time inputted is updated/displayed>
        	
        	
        	scrollDown();
        	driver.findElement(Datepicker).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(DatepickerSelectDateAndTime));
        	driver.findElement(DatepickerSelectDateAndTime).click();
    //    	driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).clear();
        	Thread.sleep(2000);
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(Keys.CONTROL,"a");
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(Keys.DELETE);
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(option1);
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(Keys.SPACE);
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(option2);
        	driver.findElement(DatepickerSelectDateAndTime).sendKeys(Keys.ENTER);
        	Thread.sleep(2000);
        	logScreenshot("Date and Time inputted in Date Picker");
        	
        	
        	return this;
        }
        public a_ElementsPage Slider(int option1) throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Slider sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Slider sub option>
        	//When <I swipe the slider>
        	//Then <The Slider value gets displayed for the slider movement>
        	
        	scrollDown();
        	
        	driver.findElement(Slider).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(SliderView));
        	WebElement Slider = driver.findElement(SliderView);
        	Thread.sleep(2000);
        	
        	Actions moveSlider = new Actions(driver);
        	Action action = moveSlider.dragAndDropBy(Slider, option1, 0).build();

        	action.perform();
        	logScreenshot("Slider moved");
        	
        	
        	return this;
        }
        
        public a_ElementsPage ProgressBar() throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Progress Bar sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Progress Bar sub option>
        	//When <I click the "Start" button>
        	//Then <Progress bar stars progressing and displays the percentage of progress>
        	////When <I click the "Stop" button>
        	//Then <Progress bar stops progressing and displays the final percentage of progress>
        	
        	
        	scrollDown();
        	driver.findElement(ProgressBar).click();
        	Thread.sleep(1000);
        	wait.until(ExpectedConditions.presenceOfElementLocated(ProgressBarStart));
        	
        	WebElement Image = driver.findElement(ProgressBarViewInfo);
        	int ImageWidth = Image.getSize().getWidth();
        	System.out.println("Progress bar percentage before start - "+ImageWidth);
        	driver.findElement(ProgressBarStart).click();
        	System.out.println("Progress bar clicked");
        	
        	Thread.sleep(4000);
        	driver.findElement(ProgressBarStart).click();
        	Thread.sleep(3000);
        	WebElement Image1 = driver.findElement(ProgressBarViewInfo);
        	int ImageWidth1 = Image1.getSize().getWidth();
        	System.out.println("Progress bar percentage after Stop - "+ImageWidth1);
        	logScreenshot("Progress bar stopped");
        	Thread.sleep(2000);
        	       	
        	return this;
}
        public a_ElementsPage Tabs() throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Tabs sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Tabs sub option>
        	//When <I click tab>
        	//Then <Contents of the tag are displayed>
        	
        	
        	scrollDown();
        	scrollDown();
        	Thread.sleep(1000);
        	driver.findElement(Tabs).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(Tab1));
        	logScreenshot("Navigated to Tab Screen");
        	 List<WebElement> allLinks = driver.findElements(AllTabs);
 //       	  System.out.println(allLinks.size());
        	  for(WebElement w:allLinks)
        	  {
        		  String text1=w.getText();
        		  System.out.println("Header of the Tab selected - "+text1);
        		    new Actions(driver).click(w).build().perform();
        		    logScreenshot("Selected Tab Screenshot");
        		        Thread.sleep(3000);
        		    } 
        	  

        	Thread.sleep(2000);
        	return this;
        }
        
        public a_ElementsPage Menu(String menu1, String menu2) throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Menu sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Menu sub option>
        	//When <I click the Main Menu Option>
        	//Then <Sub menus under it are listed>
        	//When <I click the listed Sub Menu Option>
        	//Then <Sub menus under it are listed>
        	
        	
        	scrollDown();
        	scrollDown();
        	Thread.sleep(1000);
        	driver.findElement(Menu).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(MenuHeader));
        	logScreenshot("Navigated to Menu Screen");
        	 WebElement menu = driver.findElement(Menu2);
        	  System.out.println("Currently selected Menu - "+menu.getText());
        	  Actions builder = new Actions(driver);
        	  builder.moveToElement(menu).build().perform();
        	  Thread.sleep(1000);
        	  builder.moveToElement(driver.findElement(By.linkText(menu1))).build().perform();
        	  Thread.sleep(1000);
        	  builder.moveToElement(driver.findElement(By.linkText(menu2))).build().perform();
        	  Thread.sleep(1000);
        	  logScreenshot("Menu and Submenu");
        	  

        	Thread.sleep(2000);
        	return this;
        }
        public a_ElementsPage SelectMenu(String option1) throws InterruptedException {
        	
        	//Scenario - Successfully accessing the Select Menu sub-option
        	//Given <Logged into Demoqa.com URL>
        	//And <I'm in the Widgets section>
        	//And <Selected Select Menu sub option>
        	//When <I click the Select Drop down and select an option from this list >
        	//Then <option is selected>
        	
        	scrollDown();
        	scrollDown();
        	Thread.sleep(1000);
        	driver.findElement(SelectMenu).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(SelectMenuHeader));
        	WebElement Text = driver.findElement(oldstyleSelectMenu);
        	Select select = new Select(Text);
        	List <WebElement> optionCount = select.getOptions();
        	for(WebElement w:optionCount)
      	  {
      		  String gettext=w.getText();
      		  System.out.println("List of options in the select menu - "+gettext);
      		         		    
      		        Thread.sleep(1000);
      		    }
        	select.selectByVisibleText(option1);
        	logScreenshot("Navigated to Menu Screen");
        	 
        	 

        	Thread.sleep(2000);
        	return this;
        }
        }
        