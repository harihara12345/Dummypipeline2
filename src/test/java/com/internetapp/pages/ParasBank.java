package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Popup;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ParasBank extends WebActions {
	
private static final CharSequence Username = null;
private static final CharSequence PassWord = null;
private static final CharSequence username = null;
private static final CharSequence password = null;
//Register    
	private final By Register = By.xpath("//a[contains(text(),'Register')]");
	private final By Title = By.xpath("//h1[@class='title']");
	private final By FirstName = By.xpath("//input[@id='customer.firstName']");
	private final By LastName = By.xpath("//input[@id='customer.lastName']");
	private final By Address = By.xpath("//input[@id='customer.address.street']");
	private final By City = By.xpath("//input[@id='customer.address.city']");
	private final By State = By.xpath("//input[@id='customer.address.state']");
	private final By Zipcode = By.xpath("//input[@id='customer.address.zipCode']");
	private final By Input = By.xpath("//input[@id='customer.phoneNumber']");
	private final By SSN = By.xpath("//input[@id='customer.ssn']");
	private final By UserName = By.xpath("//input[@id='customer.username']");
	private final By Password = By.xpath("//input[@id='customer.password']");
	private final By ConfirmPassword = By.xpath("//input[@id='repeatedPassword']");
	private final By RegisterButton = By.xpath("//table[@class='form2']//input[@class='button']");
	private final By WelcomeTitle = By.xpath("//h1[@class='title']");
	private final By OpenNewAccount = By.xpath("//a[contains(text(),'Open New Account')]");
	private final By TransferFunds = By.xpath("//a[contains(text(),'Transfer Funds')]");
	private final By usname = By.xpath("//input[@name='username']");
	private final By psword = By.xpath("//input[@name='password']");
	private final By login = By.xpath("//input[@class='button']");
	private final By homepagetitle = By.xpath("//img[@class='logo']");
	
//Open New Account 	
	private final By OpenNewAccountTitle = By.xpath("//h1[@class='title']");
	private final By dropdown1 = By.xpath("//select[@id='type']");
	private final By dropdown2 = By.xpath("//select[@id='fromAccountId']");
	private final By OpenNewAccountClick = By.xpath("//input[@class='button']");
	private final By AccountOpenedTitle = By.xpath("//h1[@class='title']");
	private final By NewAccountNumber = By.xpath("//a[@id='newAccountId']");

//Account Overview
	private final By AccountsOverview = By.xpath("//a[contains(text(),'Accounts Overview')]");
	private final By AccountsOverviewTitle = By.xpath("//h1[@class='title']");
	private final By SecondAccount = By.xpath("(//a[@class='ng-binding'])[2]");
	private final By AccountDetailsHeader = By.xpath("//h1[contains(text(),'Account Details')]");
	
	
//Transfer Funds
	private final By TransferTitileScreen = By.xpath("//h1[@class='title']");
	private final By TransferAmount = By.xpath("//input[@id='amount']");
	private final By FromAccount = By.xpath("//select[@id='fromAccountId']");
	private final By ToAccount = By.xpath("//select[@id='toAccountId']");
	private final By TransferButton = By.xpath("//input[@class='button']");
	private final By TransferComplete = By.xpath("//h1[@class='title']");
	private final By LogOut = By.xpath("//a[contains(text(),'Log Out')]");
//	private final By elementHead = By.xpath("");
	
	
	 WebDriverWait wait;
	    WebDriver driver;

	    public ParasBank()  {
	        driver = Driver.getWebDriver();
	        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());

	    }

	    public ParasBank navigate(String url) {
	        driver.navigate().to(url);
	        driver.manage().window().maximize();

	        logScreenshot("login");
	        ;
	        log("sample log");

	        return this;

	    }	
	    	//src//main//resources//testData//Parasbank.xlsx
	    	//C:\\Users\\HARIHARAVIGNESHM\\Desktop\\Eclipse source folders\\Parasbank.xlsx
	    
	    
	    public ParasBank Register(String option1) throws IOException, Exception, NullPointerException  {
	    	
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 
	    	 String text = driver.findElement(homepagetitle).getAttribute("title");
             Assert.assertEquals(text, "ParaBank");
             System.out.println("Assertion passed for Paras Bank URL launch - "+text);  
	    	 File file = new File("src//main//resources//testData//Parasbank.xlsx");
	//    	 String  lastname,address,city,state,zipcode,input,ssn,username,password,confirmpassword;
	    	 
	         InputStream is = new FileInputStream(file);
	         XSSFWorkbook wb = new XSSFWorkbook(is);
	         XSSFSheet sheet1 = wb.getSheet("Sheet1");
	         
	         Thread.sleep(10);
	         driver.findElement(Register).click();
	         int RowCount=sheet1.getLastRowNum();
	         for (int i = 1; i <= (RowCount-1); i++)
	         {
	        	 try {
	        	 
	        	 String firstname= sheet1.getRow(i).getCell(0).getStringCellValue();
	        	 String lastname= sheet1.getRow(i).getCell(1).getStringCellValue();
	        	 String address= sheet1.getRow(i).getCell(2).getStringCellValue();
	        	 String city = sheet1.getRow(i).getCell(3).getStringCellValue();
	        	 String state = sheet1.getRow(i).getCell(4).getStringCellValue();
	        	 String zipcode = sheet1.getRow(i).getCell(5).getStringCellValue();
	        	 String input = sheet1.getRow(i).getCell(6).getStringCellValue();
	        	 String ssn = sheet1.getRow(i).getCell(7).getStringCellValue();
	        	 String username = sheet1.getRow(i).getCell(8).getStringCellValue();
	        	 String password = sheet1.getRow(i).getCell(9).getStringCellValue();
	        	 String confirmpassword = sheet1.getRow(i).getCell(10).getStringCellValue();
	        	 driver.findElement(FirstName).sendKeys(firstname);
				 driver.findElement(LastName).sendKeys(lastname);
				 driver.findElement(Address).sendKeys(address);
				 driver.findElement(City).sendKeys(city);
				 driver.findElement(State).sendKeys(state);
				 driver.findElement(Zipcode).sendKeys(zipcode);
				 driver.findElement(Input).sendKeys(input);
				 driver.findElement(SSN).sendKeys(ssn);
				 scrollDown();
				 
				 driver.findElement(UserName).sendKeys(username);
				 driver.findElement(Password).sendKeys(password);
				 driver.findElement(ConfirmPassword).sendKeys(confirmpassword);
				 logScreenshot("Details input for user Register");
				 driver.findElement(RegisterButton).click();
	             String text1 = driver.findElement(WelcomeTitle).getText();
                 Assert.assertEquals(text1, "Welcome " + username);
                 System.out.println("Assertion passed on Registration for user name " + username);                
                 String  Username=username;
                 String  PassWord=password;
                 System.out.println("Username created - "+Username);
                 System.out.println("Password created - "+PassWord);
 //                driver.findElement(LogOut).click();
                 Thread.sleep(1000);
 //                driver.findElement(Register).click();
                 
	        	 
	         } catch (NullPointerException e) {
	                e.printStackTrace();
	            }
	        	 
	         }
/*	         String curusername = sheet1.getRow(1).getCell(8).getStringCellValue();
        	 String curpassword = sheet1.getRow(1).getCell(9).getStringCellValue();
	    	 driver.findElement(By.xpath("//input[@name='username']")).sendKeys(curusername);
	    	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(curpassword);
	    	 driver.findElement(login).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountsOverviewTitle)).isDisplayed();
	    	 String text3= driver.findElement(AccountsOverviewTitle).getText();
	    	 Assert.assertEquals(text3, "Accounts Overview");
             System.out.println("Assertion passed for Navigating to page with Title - " + text3);
	*/    	 
	    	 driver.findElement(OpenNewAccount).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(OpenNewAccountTitle)).isDisplayed();
	    	 String text4= driver.findElement(OpenNewAccountTitle).getText();
	    	 Assert.assertNotEquals(text4, "Accounts Overview");
             System.out.println("Assertion passed for Navigating to page with Title - " + text4);
	    	 
	    	 WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='type']"));
	    	 Select select = new Select(dropdown1);
	    	   	select.selectByVisibleText(option1);
	        	Thread.sleep(1000);
	        	logScreenshot("Details inputted for New Account opening");
	        	Thread.sleep(2000);
	        	driver.findElement(OpenNewAccountClick).click();
	        	wait.until(ExpectedConditions.presenceOfElementLocated(AccountOpenedTitle)).isDisplayed();
	        	logScreenshot("New Account opened");
	        	String AccountNumber = driver.findElement(NewAccountNumber).getText();
	        	System.out.println("New Account number created is - "+AccountNumber);
	    	 return this;
	    }
	  
	    public ParasBank FundTransfer(String Amount, int option1) throws IOException, InterruptedException  {
	    	
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(TransferFunds).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(TransferTitileScreen)).isDisplayed();
	    	 Thread.sleep(2000);
	    	 driver.findElement(TransferAmount).sendKeys(Amount);
	    	 
	    	 
	    	 WebElement dropdown1 = driver.findElement(FromAccount);
	    	 WebElement dropdown2 = driver.findElement(ToAccount);
	    	 Select select = new Select(dropdown1);
	    	   	select.selectByIndex(option1);
	    	   	String AccountnumberFrom = dropdown1.getText();
	    	   	String AccountnumberTo = dropdown2.getText();
	        	Thread.sleep(1000);
	        	logScreenshot("Details inputted for Fund transfer from one account to another account");
	        	driver.findElement(TransferButton).click();
	        	wait.until(ExpectedConditions.presenceOfElementLocated(TransferComplete)).isDisplayed();
	        	logScreenshot("Fund transfer Completed");
	        	WebElement text = driver.findElement(By.xpath("//span[@id='amount']"));
	        	String text2="$"+Amount;
	        	System.out.println("Amount inputted - "+text2);
	        	String AmountTransferred = 	text.getText();
	        	System.out.println("Amount Transfeered - "+AmountTransferred);
	        	Assert.assertEquals(text2, AmountTransferred);
	        	
	        	Thread.sleep(1000);
	        	
	        	
	    	 return this;
	    }
	    
	    public ParasBank AccounActivity() throws IOException, InterruptedException  {
	    	
	    	WebElement Account =  driver.findElement(By.xpath("//span[@id='fromAccountId']"));	
	    	String text = Account.getText();
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(AccountsOverview).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountsOverviewTitle)).isDisplayed();
	    	 driver.findElement(SecondAccount).click();
	    	 Thread.sleep(1000);
	    	 WebElement Account1 =  driver.findElement(By.xpath("//td[@id='accountId']"));	
	    	 String text1 = Account1.getText();
	    	 Thread.sleep(2000);
	    	 Assert.assertEquals(text, text1);
	    	 System.out.println("Assertion passed for Account selected - "+text);
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountDetailsHeader)).isDisplayed();
	    	 logScreenshot("Navigated to Account details Screen");
	    	 //To get number of rows in the table
	    	 WebElement TogetRows = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody"));
	    	 List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
	    	 int RowCount = TotalRowsList.size();
	    	 //To Get no of Columns in the table
	    	 WebElement ToGetColumns = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody/tr[1]"));
	    	 List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
	    	 int Columncount = TotalColsList.size();
	    	 scrollDown();
	    	     	 
	 		//src//main//resources//testData//Parasbank.xlsx
	    	 
	    	 //C:\\Users\\HARIHARAVIGNESHM\\Desktop\\Eclipse source folders\\Excel.xlsx
	 		for(int i=1;i<=RowCount;i++)
	 		{
	 			File file = new File("src//main//resources//testData//Excel.xlsx");
	 			FileInputStream fis = new FileInputStream(file);
			 	 
			 	XSSFWorkbook wb = new XSSFWorkbook(fis);
			 	XSSFSheet sheet = wb.getSheet("Sheet1"); 			
	 			Row row = sheet.createRow(i);
	 			for(int j=0;j<Columncount;j++)
	 			{
	 				if(i==1)
	 				{
	 				List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[1]//td"));
	 				String text2 = A.get(j).getText();
	 				Cell firstCell = row.createCell(j);
	 				firstCell.setCellValue(text2);
	 				Thread.sleep(1000);
	 				}
	 				if(i==2)
	 				{
	 				List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[2]//td"));
	 				String text2 = A.get(j).getText();
	 				Cell firstCell = row.createCell(j);
	 				firstCell.setCellValue(text2);
	 				Thread.sleep(1000);
	 				}
	 		    }
	 			fis.close();
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
			
	 		}	
	 		
	 		
			System.out.println("Excel write Successfully done");
			driver.findElement(LogOut).click();
			System.out.println("Successfully logged out ");
			logScreenshot("Successfully logged out");
			
			
	    	 return this;
	    
	  }
}