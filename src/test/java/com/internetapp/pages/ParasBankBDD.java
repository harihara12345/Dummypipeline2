package com.internetapp.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;

public class ParasBankBDD extends WebActions implements En{
	
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
		private final static By AccountsOverview = By.xpath("//a[contains(text(),'Accounts Overview')]");
		private final By AccountsOverviewTitle = By.xpath("//h1[@class='title']");
		private final By SecondAccount = By.xpath("(//a[@class='ng-binding'])[2]");
		private final By AccountDetailsHeader = By.xpath("//h1[contains(text(),'Account Details')]");
		
		
	//Transfer Funds
		private final By TransferTitileScreen = By.xpath("//h1[@class='title']");
		private final static By TransferAmount = By.xpath("//input[@id='amount']");
		private final static By FromAccount = By.xpath("//select[@id='fromAccountId']");
		private final static By ToAccount = By.xpath("//select[@id='toAccountId']");
		private final static By TransferButton = By.xpath("//input[@class='button']");
		private final By TransferComplete = By.xpath("//h1[@class='title']");
		private final By LogOut = By.xpath("//a[contains(text(),'Log Out')]");
		
		WebDriverWait wait;
	    

	WebDriver driver;
	public static int inputamount;
	
	ParasBank Locator = new ParasBank();
	SeleniumDriver seleniumdriver = new SeleniumDriver();
	

	
	@Given("^I Launch the parasBank Site$")
	public void I_Launch_the_parasBank_Site() throws InterruptedException
	{
		driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
        driver.navigate().to("https://parabank.parasoft.com/parabank/register.htm");
        driver.manage().window().maximize();
/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARIHARAVIGNESHM\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");   */	
     	logScreenshot("Sucessfully Launched parasbank Site");
       

	}
/*
	And("^Register a User by inputting valid details$", ()-> 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 
   	 String text = driver.findElement(homepagetitle).getAttribute("title");
        Assert.assertEquals(text, "ParaBank");
        System.out.println("Assertion passed for Paras Bank URL launch - "+text);  
   	 File file = new File("src//main//resources//testData//Parasbank.xlsx");
//    	 String  lastname,address,city,state,zipcode,input,ssn,username,password,confirmpassword;
   	 
        InputStream is = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet1 = wb.getSheet("Sheet1");
        
        
        driver.findElement(Register).click();
        int RowCount=sheet1.getLastRowNum();
        for (int i = 1; i < RowCount; i++)
        {
       	 try
       	 {
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
            driver.findElement(LogOut).click();
            Thread.sleep(1000);
            driver.findElement(Register).click();
       	 }catch (NullPointerException e) {
             e.printStackTrace();
         }
       	catch (InterruptedException e) {
            e.printStackTrace();
        }
       	
        }
	});
	
	*/
	@And("^Input the User Name and password and click login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Input_the_User_Name_and_password_and_click_login(String arg1, String arg2)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(arg1);
      	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg2);
      	 driver.findElement(login).click();
      	 logScreenshot("Logged in Successfully");
	}
	
	@And("^Navigate to Open New Account section$")
	public void Navigate_to_Open_New_Account_section()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
/*		File file = new File("src//main//resources//testData//Parasbank.xlsx");  	 
       InputStream is = new FileInputStream(file);
       XSSFWorkbook wb = new XSSFWorkbook(is);
       XSSFSheet sheet1 = wb.getSheet("Sheet1");

		String curusername = sheet1.getRow(1).getCell(8).getStringCellValue();
   	 String curpassword = sheet1.getRow(1).getCell(9).getStringCellValue();
   	 driver.findElement(By.xpath("//input[@name='username']")).sendKeys(curusername);
   	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(curpassword);
   	 driver.findElement(login).click();
   	 */
		driver.findElement(OpenNewAccount).click();
		String text4= driver.findElement(OpenNewAccountTitle).getText();
		System.out.println(text4);
		Assert.assertEquals(text4, "Open New Account");
        System.out.println("Assertion passed for Navigating to page with Title - " + text4);
        logScreenshot("Navigated to Account opening section");
		
	}
	
	@When("^I Select the Account Type \"([^\"]*)\" and Click Open new accountButton$")
	public void I_Select_the_Account_Type (String arg1) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='type']"));
   	 Select select = new Select(dropdown1);
   	   	select.selectByVisibleText(arg1);
       	Thread.sleep(1000);
       	
       	logScreenshot("Details inputted for New Account opening");
       	Thread.sleep(2000);
       	driver.findElement(OpenNewAccountClick).click();
       	
  //     	String AccountNumber = driver.findElement(NewAccountNumber).getText();
  //     	System.out.println("New Account number created is - "+AccountNumber);
	}
	
	@Then("^A New account is opened$")
	public void A_New_account_is_opened()
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logScreenshot("New Account opened");
       	String AccountNumber = driver.findElement(NewAccountNumber).getText();
       	System.out.println("New Account number created is - "+AccountNumber);
	}
	
	@When("I Click the Transfer Funds option")
	public void I_Click_the_Transfer_Funds_option() throws InterruptedException
	{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	  driver.findElement(TransferFunds).click();
   	  Thread.sleep(2000);
   	logScreenshot("Navigated to Fund transfer page");	
		
	}
	
	@And("^Input the Amount (\\d+) to be transferred$")
	public void Input_the_Amount(int amo1) throws Throwable
		{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		int inputamount = amo1;
	   driver.findElement(TransferAmount).sendKeys(inputamount+"");
	   logScreenshot("Fund transfer Amount inputted");
	   	 
		
	}
	
	@And("^Select the Account from which transfer to happen$")
	public void Select_the_Account_from_which_transfer_to_happen() throws InterruptedException
		{
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement dropdown1 = driver.findElement(FromAccount);
	   	 WebElement dropdown2 = driver.findElement(ToAccount);
	   	 Select select = new Select(dropdown1);
	   	   	select.selectByIndex(1);
	   	   	
	       	Thread.sleep(1000);
	       
	       	logScreenshot("Fund transfer account selected");  

		
	}
	
	@And("Click TransferButton")
	public void Click_TransferButton()
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(TransferButton).click();
	       
       	
       	
		
	}
	
	@Then("^Fund transfer is complete$")
	public void Fund_transfer_is_complete() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement text = driver.findElement(By.xpath("//span[@id='amount']"));
       	 
		String text2="$"+inputamount;
//       	System.out.println("Amount inputted - "+text2);
       	String AmountTransferred = 	text.getText();
       	System.out.println("Amount Transfeered - "+AmountTransferred);
//       	Assert.assertEquals(text2, AmountTransferred);
       	logScreenshot("Fund transfer complete");
       	Thread.sleep(1000);
		
	}
	
	@When("^I Click the Accounts Overview Option$")
	public void I_Click_the_Accounts_Overview_Option() throws InterruptedException
	
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Account =  driver.findElement(By.xpath("//span[@id='fromAccountId']"));	
    	String text = Account.getText();
    	
    	 driver.findElement(AccountsOverview).click();
    	 Thread.sleep(2000);
    	 logScreenshot("Navigated to Account Overvew section");

		
	}
	
	@And("Select the Account from the table")
	public void Select_the_Account_from_the_table() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(SecondAccount).click();
   	 Thread.sleep(2000);
   	logScreenshot("Particular account selected");

		
	}
	@Then("^Details of the Account Displayed$")
	public void Details_of_the_Account_Displayed() throws InterruptedException
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 WebElement Account1 =  driver.findElement(By.xpath("//td[@id='accountId']"));	
	   	 String text1 = Account1.getText();
	   	 Thread.sleep(2000);
//	   	 Assert.assertEquals(text, text1);
	  	 System.out.println("Account number Selected  - "+text1);
	   	 
	   	 logScreenshot("Navigated to Account details Screen");
	   	 
	   	 	}
	
	@And("^Account activity details displayed is exported to excel$") 
	public void Account_activity_details_displayed_is_exported_to_excel() throws InterruptedException, IOException
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		scrollDown();
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
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					if(i==2)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[2]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
					Thread.sleep(1000);
					}
					
					if(i==3)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[3]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
					
					}
					if(i==4)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[4]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
					Thread.sleep(1000);
					}
					if(i==5)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[5]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
					
					}
					if(i==6)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[6]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
					Thread.sleep(1000);
					}
					if(i==7)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[7]//td"));
					String text2 = A.get(j).getText();
					Cell firstCell = row.createCell(j);
					firstCell.setCellValue(text2);
									}
					if(i==8)
					{
					List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[8]//td"));
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
			Thread.sleep(1000);
			scrollDown();
			logScreenshot("Account summary of the account selected");

		
	}
	
	@When("I Click Logout option")
	public void I_Click_Logout_option() throws InterruptedException
		{
		
		driver.findElement(LogOut).click();
		Thread.sleep(1000);
		logScreenshot("Successfully logged out");
		
	}
	
	@Then("Successfully logged out from parasbank Site")
	public void Successfully_logged_out_from_parasbank_Site()
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 String text = driver.findElement(homepagetitle).getAttribute("title");
	        Assert.assertEquals(text, "ParaBank");
	        System.out.println("Successfully logged out ");
			
	        driver.quit();
	}




	private void seleniumdriver(String url, String Browser) throws InterruptedException {
		if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARIHARAVIGNESHM\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
		}
		if(Browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HARIHARAVIGNESHM\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get(url);
			}
		
	
	


	}
}
