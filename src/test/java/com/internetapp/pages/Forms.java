package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

import junit.framework.Assert;

public class Forms extends WebActions {

	//Login and Profile
	private final By BookStore = By.xpath("//h5[contains(text(),'Book Store Application')]");
	private final By BookStoreHeader = By.xpath("//div[@class='main-header']");
	private final By Login = By.xpath("//button[@id='login']");  
	private final By LoginHeader = By.xpath("//div[@class='main-header']");
	private final By UserName = By.xpath("//input[@id='userName']");
	private final By Password= By.xpath("//input[@id='password']");
	private final By UserNameValidation = By.xpath("//label[@id='userName-value']");
	private final By SearchBoxText = By.xpath("//input[@id='searchBox']");
	private final By SearchBoxFind = By.xpath("//span[@id='basic-addon2']//span//*[local-name()='svg']");
	private final By SearchList = By.xpath("//div[@class='rt-tr-group']");
	private final By GoToStore = By.xpath("//button[@id='gotoStore']");
	private final By BackToBookStore = By.xpath("//button[contains(text(),'Back To Book Store')]");

	private final By SearchListTitle = By.cssSelector(".mr-2");
	private final By Title = By.id("userName-value");
	private final By AddToCollection = By.xpath("//button[contains(text(),'Add To Your Collection')]");

	private final By Profile = By.xpath("//span[contains(text(),'Profile')]");
	private final By ProfileHeader = By.xpath("//div[@class='main-header']");
	private final By Logout = By.xpath("//button[contains(text(),'Log out')]"); 
	
	//Previousones
	private final By Forms = By.xpath("//h5[contains(text(),'Forms')]");
	private final By FormsHeader = By.xpath("//div[@class='main-header']");
	private final By PractiseForm = By.xpath("//span[contains(text(),'Practice Form')]");
	private final By PractiseFormHeader = By.xpath("//div[@class='main-header']");
	private final By elementHead = By.xpath("(//div[@class='card-up'])[1]");
	private final By elementText = By.xpath("(//div[@class='col-12 mt-4 col-md-6'])[1]");
	private final By submitText = By.xpath("//button[@id='submit']");
	private final By FirstName = By.xpath("//input[@placeholder='Full Name']");
	private final By FirstName1 = By.xpath("//input[@id='firstName']");
	private final By LastName = By.xpath("//input[@id='lastName']");
	private final By email = By.xpath("//input[@id='userEmail']");
	private final By address = By.xpath("//textarea[@id='currentAddress']");
	private final By subject = By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']");
	private final By mobilenumber = By.xpath("//input[@id='userNumber']");
	private final By testBox = By.xpath("//span[contains(text(),'Text Box')]");
	private final By  chkBox = By.xpath("//span[contains(text(),'Check Box')]");
	private final By checkboxoption  = By.xpath("//label[contains(text(),'Sports')]");
	private final By checkboxoption1  = By.xpath("//label[contains(text(),'Reading')]");
	private final By checkboxoption2  = By.xpath("//label[contains(text(),'Music')]");
	
	private final By chkText = By.xpath("//div[@id='result']");
	private final By radiobtn = By.xpath("//span[contains(text(),'Radio Button')]");
	private final By radioMale= By.xpath("//input[@type='radio']//following::label[contains(text(),'Male')]");
	private final By radioFemale= By.xpath("//input[@type='radio']//following::label[contains(text(),'Female')]");
	private final By radioOther= By.xpath("//input[@type='radio']//following::label[contains(text(),'Other')]");
	private final By autocompletecheck= By.xpath("//input[@id='subjectsInput']");
	private final By webTable = By.xpath("//span[contains(text(),'Web Tables')]");
	private final By dob = By.xpath("//input[@id='dateOfBirthInput']");
	private final By state = By.xpath("//input[@id='react-select-3-input']");
	private final By city = By.xpath("//input[@id='react-select-4-input']");
	private final By submit = By.xpath("//button[@id='submit']");
	private final By close = By.xpath("//button[@id='closeLargeModal']");
	private final By choosefile = By.xpath("//label[@class='form-file-label']");

	
	//Alerts,Frames and Windows
	private final By AlertFrameWindow = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
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

	    public Forms() {
	        driver = Driver.getWebDriver();
	        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
	    }

	    public Forms navigate(String url) {
	        driver.navigate().to(url);
	        driver.manage().window().maximize();

	        logScreenshot("login");
	        ;
	        log("sample log");

	        return this;

	    }	
	    
	    public Forms testBox(String Fname,String lname,String mail,String mobile,String add) throws InterruptedException {
	    	scrollDown();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(Forms)).isDisplayed();
	    	driver.findElement(Forms).click();
	    	Thread.sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(FormsHeader));
	    	driver.findElement(PractiseForm).click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(PractiseFormHeader));
	    	driver.findElement(FirstName1).isDisplayed();
	    	driver.findElement(FirstName1).sendKeys(Fname);
	    	driver.findElement(LastName).isEnabled();
	    	driver.findElement(LastName).sendKeys(lname);
	    	driver.findElement(email).sendKeys(mail);
	    	driver.findElement(mobilenumber).sendKeys(mobile);
	    	driver.findElement(address).sendKeys(add);
	    	System.out.println("TextBox fields inputted");
	    	Thread.sleep(2000);
	        return this;
	    }
	    
	    public Forms radioButton(String gender) throws InterruptedException {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(radioMale)).isEnabled();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(radioFemale)).isEnabled();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(radioOther)).isEnabled();
	    	if(gender=="Male")
	    	{
	    		driver.findElement(radioMale).click();
	    	}
	    	else if(gender=="Female")
	    	{
	    		driver.findElement(radioFemale).click();
	    	}
	    	else if(gender=="Other")
	    	{
	    		driver.findElement(radioOther).click();
	    	}
	    	
	    	System.out.println("Radio button selected");
	    	Thread.sleep(1000);
	        return this;
	        
	        //gender are Male, Female & Other
	    }
	    
	    public Forms checkBox(String option1, String option2) throws InterruptedException {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(checkboxoption));
	    	
	    	
	    	if(option1=="Sports" && option2=="Reading")
	    	{
	    		driver.findElement(checkboxoption).click();
	    		driver.findElement(checkboxoption1).click();
	    	}
	    	else if(option1=="Sports" && option2=="Music")
	    	{
	    		driver.findElement(checkboxoption).click();
	    		driver.findElement(checkboxoption2).click();
	    	}
	    	else if(option1=="Reading" && option2=="Music")

	    	{
	    		driver.findElement(checkboxoption1).click();
	    		driver.findElement(checkboxoption2).click();
	    	}
	    	else if(option1=="Reading" && option2=="Sports")

	    	{
	    		driver.findElement(checkboxoption1).click();
	    		driver.findElement(checkboxoption).click();
	    	}
	    	else if(option1=="Music" && option2=="Sports")

	    	{
	    		driver.findElement(checkboxoption2).click();
	    		driver.findElement(checkboxoption).click();
	    	}
	    	else if(option1=="Music" && option2=="Reading")

	    	{
	    		driver.findElement(checkboxoption2).click();
	    		driver.findElement(checkboxoption1).click();
	    	}
	    	System.out.println("Check box options selected");
	    	Thread.sleep(1000);
	        return this;
	        
	        //options are Sports, Reading & Music
	    }
	    
	    private void If() {
			// TODO Auto-generated method stub
			
		}

		public Forms DatePicker(String option1) throws InterruptedException {
        	
        	wait.until(ExpectedConditions.presenceOfElementLocated(dob)).isDisplayed();
        	driver.findElement(dob).click();
        	Thread.sleep(1000);
        	driver.findElement(dob).sendKeys(Keys.CONTROL,"a");
        	Thread.sleep(1000);
        	driver.findElement(dob).sendKeys(Keys.SPACE);
        	driver.findElement(dob).sendKeys(option1);
        	driver.findElement(dob).sendKeys(Keys.ENTER);
        	Thread.sleep(2000);
        	System.out.println("Datepicker field inputted");
        	Thread.sleep(2000);
        	
        	return this;
        }
		
		public Forms Upload() throws InterruptedException {
        	
        	wait.until(ExpectedConditions.presenceOfElementLocated(choosefile)).isDisplayed();
        	System.out.println("File upload entered");
        	driver.findElement(choosefile).click();
        	System.out.println("File upload Clicked");
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Users\\HARIHARAVIGNESHM\\Desktop\\Eclipse source folders\\Background.png");
        	
        	Thread.sleep(1000);
        	
        	return this;
        }
	    
	    public Forms AutoComplete(String option1,String option2, String option3, String option4 ) throws InterruptedException {
        	
        	
        	
        	wait.until(ExpectedConditions.presenceOfElementLocated(subject)).isDisplayed();
        	driver.findElement(autocompletecheck).click();
//        	System.out.println("autocomplete clicked");
        	driver.findElement(autocompletecheck).sendKeys(option1);
        	Thread.sleep(2000);
        	driver.findElement(autocompletecheck).sendKeys(Keys.ENTER);
        	Thread.sleep(1000);
        	driver.findElement(autocompletecheck).sendKeys(option2);
        	driver.findElement(autocompletecheck).sendKeys(Keys.ENTER);
        	driver.findElement(state).sendKeys(option3);
        	driver.findElement(state).sendKeys(Keys.ENTER);
        	Thread.sleep(2000);
        	wait.until(ExpectedConditions.presenceOfElementLocated(city));
        	driver.findElement(city).sendKeys(option4);
        	driver.findElement(city).sendKeys(Keys.ENTER);
        	
        	System.out.println("Auto complete Dialog boxes inputted");  
        	Thread.sleep(3000);
        	logScreenshot("All the details in the Form inputted");
        	//options are ma, ch, har, kar
        	Thread.sleep(1000);
        	driver.findElement(submit).click();
            Thread.sleep(1000);
            logScreenshot("All the details in the Form updated");
            Thread.sleep(1000);
            driver.findElement(close).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(FormsHeader)).isDisplayed();
            System.out.println("successfully update the detils in form");
        	return this;
    
        }
	    

public Forms BookStoreLogin(String username, String password, String searchword) throws InterruptedException {
        	
        	
        	Thread.sleep(2000);
        	scrollDown();
        	scrollDown();
        	
        	wait.until(ExpectedConditions.presenceOfElementLocated(BookStore)).isDisplayed();
        	driver.findElement(BookStore).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(Login)).isDisplayed();
           	driver.findElement(Login).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(LoginHeader)).isDisplayed();
        	driver.findElement(UserName).sendKeys(username);;
        	driver.findElement(Password).sendKeys(password);;
        	Thread.sleep(1000);
        	driver.findElement(Login).click();
        	Thread.sleep(1000);
        	wait.until(ExpectedConditions.presenceOfElementLocated(BookStoreHeader)).isDisplayed();
        	
        	
        	Thread.sleep(1000);
        	driver.findElement(SearchBoxText).sendKeys(searchword);
        	driver.findElement(SearchBoxFind).click();
        	Thread.sleep(1000);
       	 	List<WebElement> allLinks = driver.findElements(SearchListTitle);
       	 	System.out.println("No of search results are - "+allLinks.size());
       	  for(int i=0;i<allLinks.size();i++)
       	  {
       		  String text1=allLinks.get(i).getAttribute("id");
       		  
       		 String text2=text1.replaceFirst("see-book-", "");
       		  System.out.println(text2);
       		  driver.findElement(SearchBoxText).clear();
       		  driver.findElement(SearchBoxText).sendKeys(text2);
       		  driver.findElement(SearchBoxFind).click();
       		   Thread.sleep(1000);
       		   driver.findElement(SearchListTitle).click();
       		wait.until(ExpectedConditions.presenceOfElementLocated(BookStoreHeader)).isDisplayed();
       		
       		scrollDown();
       		driver.findElement(AddToCollection).click();
       		Thread.sleep(1000);
       		
       		Alert alert = driver.switchTo().alert();
       		driver.switchTo().alert();
       		driver.switchTo().alert().accept();
       		driver.findElement(BackToBookStore).click();
       		
       		Thread.sleep(2000);
       		    }        	
        	Thread.sleep(2000);
        	scrollDown();
        	driver.findElement(Profile).click();
        	wait.until(ExpectedConditions.presenceOfElementLocated(ProfileHeader)).isDisplayed();
        	System.out.println("Selected Books reflecting in Profile section");
        	Thread.holdsLock(1000);
        	driver.findElement(Logout);
        	
        	
        	
        	return this;
    
        }

	  


}
