package SystemMavenProject;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AnotherSystem {
		//** FOR FIREFOX BROWSER **//
		//driver = new firefoxDriver();
		//********************************** //	 
		Settings testSettings = new Settings();
		
		@BeforeClass
		public void setupDriver() {
			System.setProperty("webdriver.chrome.driver","src\\chromedriver.exe");
		}
	
	   public  WebDriver driver;
	   public  WebDriverWait wait;
	   public static String username = "iannis@iscale-solutions.com";
	   public static String password = "@Access18!";
	   public static String cardNumber = "546048******6444";
	   public static String notifEmail = "lea@iscalesolutions.com";
	   public static String notifPass = "Testing123!!";
	   
	   DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");	
	   Date date = new Date();


@Test (priority = Settings.LoginTest, alwaysRun = true)
	public void LoginTest() {
	 if(testSettings.skipTest("LoginTest")){
		 System.out.println("Now on Login Test");
		   WebDriver driver = new ChromeDriver();
	   
		   wait = new WebDriverWait(driver, 20);
		   	   
		   driver.manage().window().maximize();
		   driver.get("https://dev.system.an-other.co.uk/");
		   WebElement Username = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
		   Username.sendKeys(username);
		   WebElement Password = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
		   Password.sendKeys(password);
		   WebElement SysIn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		   SysIn.click();
		   WebElement dashboard = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p0\"]")));
		   Assert.assertTrue(dashboard.isDisplayed());
		   driver.quit();
	 }else{
		 throw new SkipException("Skipping LoginTest case. ");
	}
				
  }
@Test (priority = Settings.FinanceTest, alwaysRun = true)
public void FinanceTest() {
	
	if(testSettings.skipTest("FinanceTest")){ 
		WebDriver driver = new ChromeDriver();
		String clearingReference = "7-9-3038481";
		System.out.println("Now on Finance Test");
		   log_in_system_user(driver, username, password);
		//BALANCES	
			WebElement Finance = driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
			Finance.click();
			
			WebElement Balances = driver.findElement(By.xpath("//a[contains(text(),'Ledger Balances')]"));
			Balances.click();
			// Check Pagination//
			
			//Export//
			Actions  action = new Actions(driver);
			
			try {
				WebElement ClearExportButton = driver.findElement(By.xpath("//button[@id='w1']"));
				action.moveToElement(ClearExportButton).click().perform();

				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement ClearExportButton = driver.findElement(By.xpath("//button[@id='w1']"));
				action.moveToElement(ClearExportButton).click().perform();
				}	    
			
			try {
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}
				
				
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			WebElement saveCSVButton =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
			action.moveToElement(saveCSVButton).click().perform();
			
			
			//PDF 	
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			driver.navigate().refresh();
			
		    try {
		    	WebElement ExportButton = driver.findElement(By.id("w1"));
		    	action.moveToElement(ExportButton).click().perform();

		    	}
		    catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
		    	WebElement ExportButton = driver.findElement(By.id("w1"));
		    	action.moveToElement(ExportButton).click().perform();
				}	

			try {
				WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
				action.moveToElement(saveCSV).click().perform();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement saveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
				action.moveToElement(saveCSV).click().perform();
			}

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			WebElement csvButton =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
			action.moveToElement(csvButton).click().perform();
			
			//Showing All Data
			driver.navigate().refresh();
			
			try {
				WebElement ShowData = driver.findElement(By.xpath("//a[@id='legder-balance-togdata-page']"));
				ShowData.click();
			}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement ShowData = driver.findElement(By.xpath("//a[@id='legder-balance-togdata-page']"));
				ShowData.click();
			}
			
			try {
				WebElement pagination = driver.findElement(By.xpath("//div[@class='kv-panel-pager']"));
				Assert.assertTrue(pagination.isDisplayed());
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement pagination = driver.findElement(By.xpath("//div[@class='kv-panel-pager']"));
				Assert.assertTrue(pagination.isDisplayed());
			}
			
			//PAGINATION
			driver.navigate().refresh();
			
			//CLEARING
			WebElement Finance1 = driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
			Finance1.click();
			
			WebElement Clearing = driver.findElement(By.xpath("//a[contains(text(),'Prefund Clearing')]"));
			Clearing.click();
			
			WebElement ClearDate = driver.findElement(By.xpath("//div[@id='ledgersearch-date_created-container']"));
			ClearDate.click();
			
			WebElement ClearDate30days = driver.findElement(By.xpath("//li[contains(text(),'Last 30 Days')]"));
			ClearDate30days.click();
			
			//EXPORT
			try {
			    WebElement ClearExportButton = driver.findElement(By.xpath("//button[@id='w1']"));
			    action.moveToElement(ClearExportButton).click().perform();

			    }
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
			    WebElement ClearExportButton = driver.findElement(By.xpath("//button[@id='w1']"));
			    action.moveToElement(ClearExportButton).click().perform();
				}	    
			    
			try {
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-csv']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}
				
				
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			WebElement pdfbutton1 =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
			action.moveToElement(pdfbutton1).click().perform();
				
				
				
			//PDF 	
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			driver.navigate().refresh();
				
			try {
			    WebElement ClearExportButton1 = driver.findElement(By.id("w1"));
			    action.moveToElement(ClearExportButton1).click().perform();

			    }
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
			    WebElement ClearExportButton1 = driver.findElement(By.id("w1"));
			    action.moveToElement(ClearExportButton1).click().perform();
				}	

			try {
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement ClearsaveCSV = driver.findElement(By.xpath("//a[@class='export-pdf']"));
				action.moveToElement(ClearsaveCSV).click().perform();
				}

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			WebElement pdfButton1 =  driver.findElement(By.xpath("//button[contains(text(),' Ok')]"));
			action.moveToElement(pdfButton1).click().perform();
			
			//Show All Data
			driver.navigate().refresh();
				
			try {
				WebElement ShowData = driver.findElement(By.xpath("//a[@id='clearing-table-togdata-page']"));
				ShowData.click();
				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement ShowData = driver.findElement(By.xpath("//a[@id='clearing-table-togdata-page']"));
				ShowData.click();
				}
				
			try {
				WebElement pagination = driver.findElement(By.xpath("//div[@class='kv-panel-pager']"));
				Assert.assertTrue(pagination.isDisplayed());
				}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				WebElement pagination = driver.findElement(By.xpath("//div[@class='kv-panel-pager']"));
				Assert.assertTrue(pagination.isDisplayed());
				}
				//PAGINATION
				driver.navigate().refresh();
				
				driver.get("https://dev.system.an-other.co.uk/ledger?LedgerSearch%5Bdate_created%5D=2018-05-08+-+2018-06-30&LedgerSearch%5Bcardholder_name%5D=Edited&LedgerSearch%5Bprogram_name%5D=Global+Sourcing+Solutions&LedgerSearch%5Bcard_number%5D="+cardNumber+"&LedgerSearch%5Btype%5D=SecureTrading&LedgerSearch%5Bdr%5D=88.00&LedgerSearch%5Bcr%5D=&LedgerSearch%5Bcurrency%5D=GBP&LedgerSearch%5Breference%5D="+clearingReference+"&LedgerSearch%5Bcleared%5D=&LedgerSearch%5Bfee%5D=9.40&LedgerSearch%5Bcharges%5D=");
					
				//if (wait.until(ExpectedConditions.urlContains("PaymentRequestSearch[payment_request_id]=&&PaymentRequestSearch%5Bcard_number%5D="+cardNumber+"&PaymentRequestSearch%5Btype%5D=cashflows_payment"))) {
					WebElement baseTable = driver.findElement(By.cssSelector("#clearing-table-container > table"));
					WebElement ParseReference = baseTable.findElement(By.cssSelector("#clearing-table-container > table > tbody > tr > td:nth-child(9)"));
										
					System.out.println(ParseReference.getText());
					Assert.assertTrue(ParseReference.getText().contains(clearingReference));		
					
				//}

		//ADJUSTMENT
			WebElement Finance2 = driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
			Finance2.click();
				
			WebElement Adjustment = driver.findElement(By.xpath("//a[contains(text(),'Ledger Adjustments')]"));
			Adjustment.click();
			driver.quit();
	}else{
		 throw new SkipException("Skipping FinanceTest case. ");
	}
  }

@Test (priority = Settings.LoadFeesTest, alwaysRun = true)
public void LoadFeesTest() {
	if(testSettings.skipTest("LoadFeesTest")){ 
		WebDriver driver = new ChromeDriver();
		log_in_system_user(driver, username, password);
		String minAmount = "1";
		String maxAmount = "10";
		String loadFee = "2";
		String loadPercent = "2";
		System.out.println("Now on LoadFeesTest");
		
		WebElement ProgramLoadFees = driver.findElement(By.xpath("//*[@id=\"w4\"]/li[3]/a"));
		ProgramLoadFees.click();
		
		
		WebElement EditLoadFees = driver.findElement(By.xpath("//*[@id=\"w6\"]/li[2]/a"));
		EditLoadFees.click();
		
		// program in the list
		WebElement EditFeeTable = driver.findElement(By.xpath("//*[@id=\"w0\"]/table/tbody/tr[1]/td[2]/a"));
		EditFeeTable.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		List<WebElement> minimumLoadAmount = driver.findElements(By.cssSelector("tbody tr>td:nth-child(2)"));
		
		WebElement addPreset = driver.findElement(By.cssSelector("a.btn.btn-success"));
		addPreset.click();
		
		WebElement MinAmount = driver.findElement(By.xpath("//input[@id='fee-min_load_value']"));
		MinAmount.sendKeys(minAmount);
				
		WebElement MaxAmount = driver.findElement(By.xpath("//input[@id='fee-max_load_value']"));
		MaxAmount.sendKeys(maxAmount);
		
		WebElement LoadFee = driver.findElement(By.xpath("//input[@id='fee-amount']"));
		LoadFee.sendKeys(loadFee);
		
		WebElement LoadPercentage = driver.findElement(By.xpath("//input[@id='fee-load_fee_percentage']"));
		LoadPercentage.sendKeys(loadPercent);
		
		//WebElement Create = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		//Create.click();		
		
	/*	driver.navigate().back();
		
		WebElement View = driver.findElement(By.xpath("//a[@title='View']"));
		View.click();
		
		WebElement ViewTable = driver.findElement(By.xpath("//table[@id='w0']"));
		Assert.assertTrue(ViewTable.isDisplayed());
		
		driver.navigate().back();
		
		WebElement Update = driver.findElement(By.xpath("//a[@title='Update']"));
		Update.click();
		
		WebElement MinAmountUpdate = driver.findElement(By.xpath("//input[@id='fee-min_load_value']"));
		MinAmountUpdate.sendKeys("2");
		
		WebElement MaxAmountUpdate = driver.findElement(By.xpath("//input[@id='fee-max_load_value']"));
		MaxAmountUpdate.sendKeys("26");
		
		WebElement LoadFeeUpdate = driver.findElement(By.xpath("//input[@id='fee-amount']"));
		LoadFeeUpdate.sendKeys("2");
		
		WebElement LoadPercentageUpdate = driver.findElement(By.xpath("//input[@id='fee-load_fee_percentage']"));
		LoadPercentageUpdate.sendKeys("2");
		
		WebElement UpdateButton = driver.findElement(By.xpath("//button[contains(text(),'Update']"));
		UpdateButton.click();
		*/
		//Validations
		driver.quit();
	}else{
		 throw new SkipException("Skipping LoadFeesTest case. ");
	}
	
	
}

@Test (priority = Settings.ProgramsTest, alwaysRun = true)
public void ProgramsTest() {
	if(testSettings.skipTest("ProgramsTest")){ 
		WebDriver driver = new ChromeDriver();
		log_in_system_user(driver, username, password);
		String pname = "QATestProgram";
		String cname = "iScale Solutions";
		String add1 = " 7th flr. salaustino Bldg";
		String add2 = "Perea st. corner paseo st.";
		String city = "Makati City";
		String state = "Manila";
		String zip = "1630";
		String id = "100002";
		String program = "Global Sourcing Solutions";
		System.out.println("Now on Program Test");
				
	//EDIT PROGRAMS	
		
		WebElement aProgram = driver.findElement(By.xpath("//*[@id=\"w4\"]/li[3]/a"));
		aProgram.click();
		
		WebElement EditProgram = driver.findElement(By.xpath("//*[@id=\"w6\"]/li[1]/a"));
		EditProgram.click();

		WebElement pTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));
		Assert.assertTrue(pTable.isDisplayed());
		
		
		WebElement CreateProgram = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		CreateProgram.click();
		
		WebElement ProgramName = driver.findElement(By.xpath("//input[@id='program-program_name']"));
		ProgramName.sendKeys(pname);
		
		WebElement CompanyName = driver.findElement(By.xpath("//input[@id='program-company_name']"));
		CompanyName.sendKeys(cname);
		
		WebElement Address1 = driver.findElement(By.xpath("//input[@id='program-address1']"));
		Address1.sendKeys(add1);
		
		WebElement Address2 = driver.findElement(By.xpath("//input[@id='program-address2']"));
		Address2.sendKeys(add2);
		
		WebElement City = driver.findElement(By.xpath("//input[@id='program-city']"));
		City.sendKeys(city);
		
		WebElement State = driver.findElement(By.xpath("//input[@id='program-state']"));
		State.sendKeys(state);
		
		WebElement Zip = driver.findElement(By.xpath("//input[@id='program-zip']"));
		Zip.sendKeys(zip);
		
		Select selectCountry = new Select(driver.findElement(By.id("program-country_code")));
		selectCountry.selectByVisibleText("United Kingdom");
		
		Select selectStatus =  new Select(driver.findElement(By.id("program-status")));
		selectStatus.selectByVisibleText("Active");
		
		Select selectCurrency =  new Select(driver.findElement(By.id("program-cardcurrency")));
		selectCurrency.selectByVisibleText("GBP");
		
		Select selectProduct =  new Select(driver.findElement(By.id("program-product_id")));
		selectProduct.selectByIndex(1);
		
		Select selectTariff =  new Select(driver.findElement(By.id("program-tariff")));
		selectTariff.selectByIndex(2);
		
		WebElement EnableRegistration = driver.findElement(By.xpath("//input[@id='program-enable_registration']"));
		EnableRegistration.click();
		
		/*WebElement Create = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		Create.click();
		
		WebElement Update = driver.findElement(By.xpath("//a[contains(text(),'Update')]"));
		Update.click();*/
		
		driver.navigate().back();
		
		WebElement ID = driver.findElement(By.xpath("//input[@name='ProgramSearch[id]']"));
		ID.sendKeys(id);
		ID.sendKeys(Keys.ENTER);
		
		ID.clear();
		ID.sendKeys(Keys.ENTER);
			
		WebElement progProgramName = driver.findElement(By.xpath("//input[@name='ProgramSearch[program_name]']"));
		progProgramName.sendKeys(program);
		progProgramName.sendKeys(Keys.ENTER);	
		progProgramName.clear();
		progProgramName.sendKeys(Keys.ENTER);
		
		Select ProductSelect = new Select(driver.findElement(By.name("ProgramSearch[product_id]")));
		ProductSelect.selectByIndex(1);
			
		Select StatusSelect = new Select(driver.findElement(By.name("ProgramSearch[status]")));
		StatusSelect.selectByIndex(1);
		
		WebElement View = driver.findElement(By.xpath("//a[@title='View']"));
		View.click();
		
		WebElement programsTable = driver.findElement(By.cssSelector(".table.table-striped.table-bordered"));
		Assert.assertTrue(programsTable.isDisplayed());
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramsTest case. ");
	}
	
	
}

@Test (priority = Settings.ProgramProductsTest, alwaysRun = true)
public void ProgramProductsTest() {
	if(testSettings.skipTest("ProgramProductsTest")){ 
		WebDriver driver = new ChromeDriver();
		String ProductCode = "QAPROD-001";
		String ProductName = "QA Automated Product "; 
		System.out.println("Now on ProgramProductsTest Test");
		log_in_system_user(driver, username, password);
		
		WebElement ParseProgramMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(3) > a")));		
		ParseProgramMenu.click();
		
		WebElement editProducts = driver.findElement(By.linkText("Edit Products"));
		editProducts.click();
		
		//create Record
		WebElement CreateProduct = driver.findElement(By.cssSelector("a.btn.btn-success"));
		CreateProduct.click();
		
		
		wait = new WebDriverWait(driver, 10);
		WebElement ParseProductPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseProductPage.getText().contains("Add Product"));
		
		WebElement ParseProductCode = driver.findElement(By.name("Product[product_id]"));
		WebElement ParseProductName = driver.findElement(By.name("Product[name]"));
		Select CardType = new Select(driver.findElement(By.name("Product[card_type]")));
		
		List<WebElement>  all_elements_text =new ArrayList<>();
		all_elements_text.add(ParseProductCode);
		all_elements_text.add(ParseProductName);
		    
		WebElement  ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		
		 CRUDTestCase CrudTest = new CRUDTestCase();
		 CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		 ParseProductName.sendKeys(ProductName);
		 ParseProductCode.sendKeys(ProductCode);
		 CardType.selectByValue("1");
		// ParseCreate.click();
		 		
		driver.navigate().back();
		
		
		//Search Record		
		driver.get("https://dev.system.an-other.co.uk/product/index?ProductSearch[product_id]="+ProductCode+"&ProductSearch[name]="+ProductName+"&ProductSearch[card_type]=1&sort=product_id");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ProductValueCode = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		WebElement ProductValueName = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));
		WebElement ProductValueCardType = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4)"));		
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(5) > a:nth-child(1) > span"));
		
		Assert.assertTrue(ProductValueCode.getText().contains(ProductCode));
		//Assert.assertTrue(ProductValueName.getText().contains(ProductName));
		Assert.assertTrue(ProductValueCardType.getText().contains("Virtual Cards Only"));
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(ParseViewPage.getText() == "Product Id") {
			Assert.assertTrue(ParseViewValue.getText().contains(ProductCode));			
		}
		
		driver.get("https://dev.system.an-other.co.uk/product/index?ProductSearch[product_id]="+ProductCode+"&ProductSearch[name]="+ProductName+"&ProductSearch[card_type]=1&sort=product_id");
		WebElement baseTableEdit =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(5) > a:nth-child(2) > span"));
		
		
		//Edit Record
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Product: "+ProductCode));
		
		WebElement ParseProductCodeEdit = driver.findElement(By.name("Product[product_id]"));
		WebElement ParseProductNameEdit = driver.findElement(By.name("Product[name]"));
		
		
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		
		List<WebElement>  all_elements_edits =new ArrayList<>();
		all_elements_edits.add(ParseProductCodeEdit);
		all_elements_edits.add(ParseProductNameEdit);
		
		CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
		CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
	    
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		ParseProductCodeEdit.clear();
		ParseProductCodeEdit.sendKeys(ProductCode+"-E");
		
		ParseProductNameEdit.clear();
		ParseProductNameEdit.sendKeys(ProductName+"-Edited");
		
		ParseUpdate.click();
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramProductsTest case. ");
	}
		
}



@Test (priority = Settings.ProgramProductRefTest, alwaysRun = true)
public void ProgramProductRefTest() {
	
	if(testSettings.skipTest("ProgramProductRefTest")){ 
		WebDriver driver = new ChromeDriver();
		String ProductRef = "QAPRODREF "+ dateFormat.format(date);
		String ProductRefDesc = "QA Automated Product Ref " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date); 
		System.out.println("Now on ProgramProductRefTest Test");
		log_in_system_user(driver, username, password);
		WebElement ParseProgramMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(3) > a")));		
		ParseProgramMenu.click();
		
		WebElement ProgramProductRef = driver.findElement(By.cssSelector("#w6 > li:nth-child(5) > a"));
		ProgramProductRef.click();
		
		//create Record
		WebElement CreateProductRef = driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > p > a"));
		CreateProductRef.click();
		
		
		wait = new WebDriverWait(driver, 10);
		WebElement ParseProductRefPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseProductRefPage.getText().contains("Add Product Ref"));
		
		WebElement ParseProductRef = driver.findElement(By.name("ProductRef[product_ref]"));
		WebElement ParseProductRefDesc = driver.findElement(By.name("ProductRef[description]"));

		List<WebElement>  all_elements_text =new ArrayList<>();
		all_elements_text.add(ParseProductRef);
		all_elements_text.add(ParseProductRefDesc);
		    
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
				
		
		CRUDTestCase CrudTest = new CRUDTestCase();
		CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		ParseProductRef.sendKeys(ProductRef);
		ParseProductRefDesc.sendKeys(ProductRefDesc);
		 
		ParseCreate.click();		
		
		driver.navigate().back();
		//Search Record		
		driver.get("https://dev.system.an-other.co.uk/product-ref/index?ProductRefSearch[product_ref]="+ProductRef+"&ProductRefSearch[description]="+ProductRefDesc+"&sort=product_ref");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ProductRefValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		WebElement ProductRefValueDesc = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));	
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(1) > span"));
		
		Assert.assertTrue(ProductRefValue.getText().contains(ProductRef));
		//Assert.assertTrue(ProductValueName.getText().contains(ProductName));
		Assert.assertTrue(ProductRefValueDesc.getText().contains(ProductRefDesc));
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(ParseViewPage.getText() == "Product Ref") {
			Assert.assertTrue(ParseViewValue.getText().contains(ProductRef));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/product-ref/index?ProductRefSearch[product_ref]="+ProductRef+"&ProductRefSearch[description]="+ProductRefDesc+"&sort=product_ref");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(2) > span"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Product Ref: "+ProductRef));
		
		WebElement ParseProductRefEdit = driver.findElement(By.name("ProductRef[product_ref]"));
		WebElement ParseProductRefDescEdit = driver.findElement(By.name("ProductRef[description]"));
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
				
		List<WebElement>  all_elements_edits =new ArrayList<>();
		all_elements_edits.add(ParseProductRefEdit);
		all_elements_edits.add(ParseProductRefDescEdit);
				
		CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
		CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
	    		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		ParseProductRefEdit.clear();
		ParseProductRefEdit.sendKeys(ProductRef+" -E");
		
		ParseProductRefDescEdit.clear();
		ParseProductRefDescEdit.sendKeys(ProductRefDesc+" -Edited");
				
		ParseUpdate.click();
		
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/product-ref/index?ProductRefSearch[product_ref]="+ProductRef+" -E&ProductRefSearch[description]="+ProductRefDesc+" -Edited&sort=product_ref");
		
		wait = new WebDriverWait(driver, 10);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(3) > span"));
		ParseDelete.click();
		driver.switchTo().alert().accept();
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramProductRefTest case. ");
	}
}

@Test (priority = Settings.ProgramCarrierTypeTest, alwaysRun = true)
public void MnuProgramCarrierType() {
	if(testSettings.skipTest("ProgramCarrierTypeTest")){ 
		WebDriver driver = new ChromeDriver();
		String CarrierType = "QACT - "+ dateFormat.format(date);
		String CarrierDesc = "QA Automated Carrier Type " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date); 
		System.out.println("Now on ProgramCarrierTypeTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 20);
		
		WebElement ParseProgramMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(3) > a")));		
		ParseProgramMenu.click();
		WebElement ProgramCarrierType = driver.findElement(By.cssSelector("#w6 > li:nth-child(6) > a"));
		ProgramCarrierType.click();
		//create Record
		WebElement CreateCarrierType = driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > p > a"));
		CreateCarrierType.click();
		
		
		wait = new WebDriverWait(driver, 10);
		WebElement ParseCarrierTypePage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseCarrierTypePage.getText().contains("Add Carrier Type"));
		
		WebElement ParseCarrierType = driver.findElement(By.name("CarrierType[carrier_type]"));				
		WebElement ParseCarrierDesc = driver.findElement(By.name("CarrierType[description]"));
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));		

		List<WebElement>  all_elements_text =new ArrayList<>();
		all_elements_text.add(ParseCarrierType);
		all_elements_text.add(ParseCarrierDesc);				
		
		CRUDTestCase CrudTest = new CRUDTestCase();
		CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		ParseCarrierType.sendKeys(CarrierType);
		ParseCarrierDesc.sendKeys(CarrierDesc);
		ParseCreate.click();		
		
		driver.navigate().back();
		
		//Search Record	
		
		driver.get("https://dev.system.an-other.co.uk/carrier-type/index?CarrierTypeSearch[carrier_type]="+CarrierType+"&CarrierTypeSearch[description]="+CarrierDesc+"&sort=carrier_type");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement CarrierTypeValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		WebElement CarrierTypeValueDesc = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));	
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(1) > span"));
		
		Assert.assertTrue(CarrierTypeValue.getText().contains(CarrierType));
		Assert.assertTrue(CarrierTypeValueDesc.getText().contains(CarrierDesc));
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(ParseViewPage.getText() == "Carrier Type") {
			Assert.assertTrue(ParseViewValue.getText().contains(CarrierType));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/carrier-type/index?CarrierTypeSearch[carrier_type]="+CarrierType+"&CarrierTypeSearch[description]="+CarrierDesc+"&sort=carrier_type");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(2) > span"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Carrier Type: "+CarrierType));
		
		WebElement ParseCarrierTypeEdit = driver.findElement(By.name("CarrierType[carrier_type]"));
		WebElement ParseCarrierTypeDescEdit = driver.findElement(By.name("CarrierType[description]"));
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		
		List<WebElement>  all_elements_edits =new ArrayList<>();
		all_elements_edits.add(ParseCarrierTypeEdit);
		all_elements_edits.add(ParseCarrierTypeDescEdit);
		
		
		CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
		CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
		    
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		ParseCarrierTypeEdit.clear();
		ParseCarrierTypeEdit.sendKeys(CarrierType+" -E");
			
		ParseCarrierTypeDescEdit.clear();
		ParseCarrierTypeDescEdit.sendKeys(CarrierDesc+" -Edited");
			
		ParseUpdate.click();
		
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/carrier-type/index?CarrierTypeSearch[carrier_type]="+CarrierType+"&CarrierTypeSearch[description]="+CarrierDesc+"&sort=carrier_type");
		
		wait = new WebDriverWait(driver, 10);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(3) > span"));
		ParseDelete.click();
		driver.switchTo().alert().accept();
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramCarrierTypeTest case. ");
	}
}

@Test (priority = Settings.ProgramDeliveryFeeTest, alwaysRun = true)
public void MnuProgramDeliveryFee() {
	if(testSettings.skipTest("ProgramDeliveryFeeTest")){ 
		WebDriver driver = new ChromeDriver();
		String ProgramName = "Qa Test Plastic/Virtual Switching 001";
		String DF_UKFee = "2";
		String DF_EURFee = "2";
		String DF_OTFee = "3";
		System.out.println("Now on ProgramDeliveryFeeTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 5);
		
		WebElement ParseProgramMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(3) > a")));		
		ParseProgramMenu.click();
		
		
		WebElement ProgramDeliveryFee = driver.findElement(By.cssSelector("#w6 > li:nth-child(7) > a"));
		ProgramDeliveryFee.click();
		
		//Search Record	
		driver.get("https://dev.system.an-other.co.uk/delivery-fee/index?DeliveryFeeSearch[program_name]="+ProgramName+"&sort=uk_fee");
			
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ProgramNameValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		
		
			
		if(!ProgramNameValue.getText().contentEquals(ProgramName)) {
			//create Record
			WebElement CreateDeliveryFee = driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > p > a"));
			CreateDeliveryFee.click();
			
			
			wait = new WebDriverWait(driver, 10);
			WebElement ParseDeliverFeePage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
			
			Assert.assertTrue(ParseDeliverFeePage.getText().contains("Add Delivery Fee"));
			
			Select Program = new Select(driver.findElement(By.name("DeliveryFee[program_id]")));
			Program.selectByValue("100015");
			
			WebElement ProgramValue = Program.getFirstSelectedOption();
			ProgramName = ProgramValue.getText();
			
			WebElement ParseDF_UK = driver.findElement(By.name("DeliveryFee[uk_fee]"));
			WebElement ParseDF_EUR = driver.findElement(By.name("DeliveryFee[europe_fee]"));
			WebElement ParseDF_OT = driver.findElement(By.name("DeliveryFee[other_country_fee]"));
			
			
			WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
			
			
			List<WebElement>  all_elements_text =new ArrayList<>();
		    all_elements_text.add(ParseDF_UK);
		    all_elements_text.add(ParseDF_EUR);
		    all_elements_text.add(ParseDF_OT);
		
		    CRUDTestCase CrudTest = new CRUDTestCase();
		    CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		 
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		    ParseDF_UK.sendKeys(DF_UKFee);
		    ParseDF_EUR.sendKeys(DF_EURFee);
		    ParseDF_OT.sendKeys(DF_OTFee);
			
			ParseCreate.click();	
			driver.navigate().back();
		}else {
			driver.get("https://dev.system.an-other.co.uk/delivery-fee/index");
			//View Record
			driver.get("https://dev.system.an-other.co.uk/delivery-fee/index?DeliveryFeeSearch[program_name]="+ProgramName+"&sort=uk_fee");
			
			WebElement baseTableView =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
			WebElement ProgramNameValueView = baseTableView.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
			WebElement ParseView = baseTableView.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(6) > a:nth-child(1) > span"));
			
			ParseView.click();		
			
			WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
			WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
			
			if(ParseViewPage.getText() == "Program Name") {
				Assert.assertTrue(ParseViewValue.getText().contains(ProgramName));			
			}
			driver.navigate().back();
			
			//Edit Record
			driver.get("https://dev.system.an-other.co.uk/delivery-fee/index?DeliveryFeeSearch[program_name]="+ProgramName+"&sort=uk_fee");
			WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
			WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(6) > a:nth-child(2) > span"));
			
			ParseEdit.click();
			WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
			
			Assert.assertTrue(ParsePage.getText().contains("Update Delivery Fee: "+ProgramName));
		
			WebElement ParseDF_UKEdit = driver.findElement(By.name("DeliveryFee[uk_fee]"));
			if(ParseDF_UKEdit.getText() == DF_UKFee) {
				DF_UKFee = DF_UKFee+1;
				DF_EURFee = DF_EURFee+1;
				DF_OTFee = DF_OTFee+1;
			}
			ParseDF_UKEdit.clear();
			ParseDF_UKEdit.sendKeys(DF_UKFee);
			
			WebElement ParseDF_EUREdit = driver.findElement(By.name("DeliveryFee[europe_fee]"));		
			WebElement ParseDF_OTEdit = driver.findElement(By.name("DeliveryFee[other_country_fee]"));			
			WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			
			 List<WebElement>  all_elements_edits =new ArrayList<>();
				all_elements_edits.add(ParseDF_EUREdit);
				all_elements_edits.add(ParseDF_OTEdit);				
				
				CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
				CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
			    
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
				ParseDF_EUREdit.clear();
				ParseDF_EUREdit.sendKeys(DF_EURFee);
				
				ParseDF_OTEdit.clear();
				ParseDF_OTEdit.sendKeys(DF_OTFee);
				
			ParseUpdate.click();
		}
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramDeliveryFeeTest case. ");
	}
}


@Test (priority = Settings.ProgramTariffTest, alwaysRun = true)
public void MnuProgramTariff() {
	if(testSettings.skipTest("ProgramTariffTest")){ 
		WebDriver driver = new ChromeDriver();
		String TariffCode = "QATARIFF - "+ dateFormat.format(date);
		String TariffName = "QA Automated Tariff " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date); 
		System.out.println("Now on ProgramTariffTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 20); 
		
		WebElement ParseProgramMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(3) > a")));		
		ParseProgramMenu.click();
		
		
		WebElement ProgramTariff = driver.findElement(By.cssSelector("#w6 > li:nth-child(8) > a"));
		ProgramTariff.click();
		
		//create Record
		WebElement CreateTariff = driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > p > a"));
		CreateTariff.click();
		
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseCreateTariffPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseCreateTariffPage.getText().contains("Create Tariff"));
		
		WebElement ParseTariffCode = driver.findElement(By.name("Tariff[code]"));		
		WebElement ParseTariffName = driver.findElement(By.name("Tariff[name]"));
		
		
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		
		List<WebElement>  all_elements_text =new ArrayList<>();
	    all_elements_text.add(ParseTariffCode);
	    all_elements_text.add(ParseTariffName);
	    
	    CRUDTestCase CrudTest = new CRUDTestCase();
	    CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
	 
	 
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	    ParseTariffCode.sendKeys(TariffCode);
	    ParseTariffName.sendKeys(TariffName);
	 	 
		ParseCreate.click();		
		
		driver.navigate().back();
		
		//Search Record	
		
		driver.get("https://dev.system.an-other.co.uk/tariff/index?TariffSearch[code]="+TariffCode+"&TariffSearch[name]="+TariffName+"&sort=code");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement TariffCodeValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		WebElement TariffNameValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));	
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(1) > span"));
		
		Assert.assertTrue(TariffCodeValue.getText().contains(TariffCode));
		Assert.assertTrue(TariffNameValue.getText().contains(TariffName));
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(ParseViewPage.getText() == "Code") {
			Assert.assertTrue(ParseViewValue.getText().contains(TariffCode));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/tariff/index?TariffSearch[code]="+TariffCode+"&TariffSearch[name]="+TariffName+"&sort=code");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(2) > span"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Tariff: "+TariffCode));
		
		WebElement ParseTariffCodeEdit = driver.findElement(By.name("Tariff[code]"));
		WebElement ParseTariffNameEdit = driver.findElement(By.name("Tariff[name]"));
		
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		
		List<WebElement>  all_elements_edits =new ArrayList<>();
		all_elements_edits.add(ParseTariffCodeEdit);
		all_elements_edits.add(ParseTariffNameEdit);
		
		CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
		CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
	    
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		ParseTariffCodeEdit.clear();
		ParseTariffCodeEdit.sendKeys(TariffCode+" -E");
		
		ParseTariffNameEdit.clear();
		ParseTariffNameEdit.sendKeys(TariffName+" -Edited");
		
		ParseUpdate.click();
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/tariff/index?TariffSearch[code]="+TariffCode+"&TariffSearch[name]="+TariffName+"&sort=code");
		
		wait = new WebDriverWait(driver, 10);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(3) > span"));
		ParseDelete.click();
		driver.switchTo().alert().accept();
		driver.quit();
	}else{
		 throw new SkipException("Skipping ProgramTariffTest case. ");
	}
}

@Test (priority = Settings.UsersSystemUserTest, alwaysRun = true)
public void UsersSystemUserTest() {
	if(testSettings.skipTest("UsersSystemUserTest")){ 
		WebDriver driver = new ChromeDriver();
		String SysUsername = "qa_auto_user";		
		System.out.println("Now on UsersSystemUser");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 5); 
		
		WebElement ParseUsersMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(4) > a")));		
		ParseUsersMenu.click();
		
		
		WebElement UserSystem = driver.findElement(By.cssSelector("#w7 > li:nth-child(2) > a"));
		UserSystem.click();
		
		//create Record
		WebElement addSystemUserbutton = driver.findElement(By.cssSelector("a.btn.btn-success"));
		addSystemUserbutton.click();
		
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseCreateSystemUserPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseCreateSystemUserPage.getText().contains("Create System User"));
		
		WebElement ParseUsername = driver.findElement(By.name("UserAdmin[username]"));
		ParseUsername.sendKeys(SysUsername);
		
		WebElement ParseEmail = driver.findElement(By.name("UserAdmin[email]"));
		ParseEmail.sendKeys(notifEmail);
		
		WebElement ParsePassword = driver.findElement(By.name("UserAdmin[password]"));
		ParsePassword.sendKeys(notifPass);
		
		Select ParseUserType = new Select(driver.findElement(By.name("user_role")));
		ParseUserType.selectByValue("system-admin");
		
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		ParseCreate.click();		
		
		driver.navigate().back();
		
		//Search Record	
		
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=system-admin&type=system");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement SysUsernameValue = baseTable.findElement(By.cssSelector("tbody > tr td:nth-child(3)"));
		WebElement SysEmailValue = baseTable.findElement(By.cssSelector("tbody > tr td:nth-child(4)"));
		WebElement SysAccessValue = baseTable.findElement(By.cssSelector("tbody > tr td:nth-child(6)"));	
		
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("tbody > tr td:nth-child(7) span"));
		
		Assert.assertTrue(SysUsernameValue.getText().contains(SysUsername));
		Assert.assertTrue(SysEmailValue.getText().contains(notifEmail));
		Assert.assertTrue(SysEmailValue.getText().contains(notifEmail));
		
		
		//View Record
		ParseView.click();		
		WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement usernameValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(usernameField.getText() == "Username") {
			Assert.assertTrue(usernameValue.getText().contains(SysUsername));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=system-admin&type=system");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("span.glyphicon.glyphicon-pencil"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update System User: "+SysUsername));
		
		WebElement ParseSysUsernameEdit = driver.findElement(By.name("User[username]"));
		ParseSysUsernameEdit.clear();
		ParseSysUsernameEdit.sendKeys(SysUsername+"_edited");		
		
		WebElement ParseUpdate = driver.findElement(By.cssSelector("button.btn.btn-primary:nth-child(1)"));
		ParseUpdate.click();
		
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=system-admin&type=system");
		
		wait = new WebDriverWait(driver, 20);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector("span.glyphicon.glyphicon-trash"));
		ParseDelete.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement okDeleteButton = driver.findElement(By.cssSelector("button.btn.btn-warning"));
		okDeleteButton.click();
		String userPageTitle = driver.getTitle();
		assertTrue(userPageTitle.contains("Users"));
		driver.quit();
	}else{
		 throw new SkipException("Skipping UsersSystemUser case. ");
	}
}

@Test (priority = Settings.UsersProgramUserTest, alwaysRun = true)
public void UsersProgramUserTest() {
	if(testSettings.skipTest("UsersProgramUserTest")){ 
		WebDriver driver = new ChromeDriver();
		String SysUsername = "qa_auto_user";		
		System.out.println("Now on UsersProgramUserTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 10); 
		
		WebElement ParseUsersMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(4) > a")));		
		ParseUsersMenu.click();
		
		WebElement UserSystem = driver.findElement(By.cssSelector("#w7 > li:nth-child(1) > a"));
		UserSystem.click();
		
		//create Record
		WebElement CreateProgramUser = driver.findElement(By.cssSelector("a.btn.btn-success"));
		CreateProgramUser.click();
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseCreateProgramUserPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h1")));
		
		Assert.assertTrue(ParseCreateProgramUserPage.getText().contains("Create Program User"));
		
		WebElement ParseUsername = driver.findElement(By.name("User[username]"));
		ParseUsername.sendKeys(SysUsername);
		
		WebElement ParseEmail = driver.findElement(By.name("User[email]"));
		ParseEmail.sendKeys(notifEmail);
		
		WebElement ParsePassword = driver.findElement(By.name("User[password]"));
		ParsePassword.sendKeys(notifPass);
		
		Select ParseProgram = new Select(driver.findElement(By.cssSelector("#form-user > div.form-group.field-user-user_program.required > div.col-sm-6 > select")));
		ParseProgram.selectByValue("100002");
		
		
		Select ParseUserType = new Select(driver.findElement(By.name("user_role")));
		ParseUserType.selectByValue("program-admin");
		
		
		
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		ParseCreate.click();		
		
		driver.navigate().back();
		
		//Search Record	
		
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=program-admin&type=program");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement SysUsernameValue = baseTable.findElement(By.cssSelector("tbody tr td:nth-child(3)"));
		WebElement SysEmailValue = baseTable.findElement(By.cssSelector("tbody tr td:nth-child(4)"));
		WebElement SysAccessValue = baseTable.findElement(By.cssSelector("tbody tr td:nth-child(6)"));	
		
		
		WebElement ParseView = baseTable.findElement(By.cssSelector(".glyphicon.glyphicon-eye-open"));
		
		Assert.assertTrue(SysUsernameValue.getText().contains(SysUsername));
		Assert.assertTrue(SysEmailValue.getText().contains(notifEmail));
		Assert.assertTrue(SysEmailValue.getText().contains(notifEmail));
		
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody tr:nth-child(2) th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody tr:nth-child(2) td")));
		
		if(ParseViewPage.getText() == "Username") {
			Assert.assertTrue(ParseViewValue.getText().contains(SysUsername));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=program-admin&type=program");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector(".glyphicon.glyphicon-pencil"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Program User: "+SysUsername));
		
		WebElement ParseSysUsernameEdit = driver.findElement(By.name("User[username]"));
		ParseSysUsernameEdit.clear();
		ParseSysUsernameEdit.sendKeys(SysUsername+"_edited");		
		
		WebElement ParseUpdate = driver.findElement(By.cssSelector("button.btn.btn-primary:nth-child(1)"));
		ParseUpdate.click();
		
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/users?UserSearch[username]="+SysUsername+"&UserSearch[email]="+notifEmail+"&UserSearch[program_name]=&UserSearch[user_role]=program-admin&type=program");
		
		wait = new WebDriverWait(driver, 20);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector(".glyphicon.glyphicon-trash"));
		ParseDelete.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement okDeleteButton = driver.findElement(By.cssSelector(".btn.btn-warning"));
		okDeleteButton.click();
		String userPageTitle = driver.getTitle();
		assertTrue(userPageTitle.contains("Users"));
		driver.quit();
	}else{
		 throw new SkipException("Skipping UsersSystemUser case. ");
	}
}

@Test (priority = Settings.IPWhitelistTest, alwaysRun = true)
public void IPWhitelistTest() {
	if(testSettings.skipTest("IPWhitelistTest")){ 
		WebDriver driver = new ChromeDriver();
		String IPWhitelistIP = "000.0.0.1";
		String WhitelistDesc = "QA Automated Whitelisting "; 
		System.out.println("Now on IPWhitelistTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 5);
		
		WebElement ParseWhitelistMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(5) > a")));		
		ParseWhitelistMenu.click();
		
		
		WebElement Whitelist = driver.findElement(By.cssSelector("#w8 > li > a"));
		Whitelist.click();
		
		//Search Record	
		driver.get("https://dev.system.an-other.co.uk/ip-whitelist/index?IpWhitelistSearch[ip_address]="+IPWhitelistIP+"&IpWhitelistSearch[comments]="+WhitelistDesc+"&sort=ip_address");
					
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		try{
			WebElement IpAddressValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
			//Search Record	
			//driver.get("https://dev.system.an-other.co.uk/product/index");
			
			//driver.get("https://dev.system.an-other.co.uk/ip-whitelist/index?IpWhitelistSearch[ip_address]="+IPWhitelistIP+"&IpWhitelistSearch[comments]="+WhitelistDesc+"&sort=ip_address");
			
			WebElement baseTableView =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
			WebElement IpAddressView = baseTableView.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
			WebElement IpAddressDescView = baseTableView.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));
			
			WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(1) > span"));			
			
			//View Record
			ParseView.click();		
			WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(1) > th")));
			WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(1) > td")));
			
			if(ParseViewPage.getText() == "IP Address") {
				Assert.assertTrue(ParseViewValue.getText().contains(IPWhitelistIP));			
			}
			
			driver.get("https://dev.system.an-other.co.uk/ip-whitelist/index?IpWhitelistSearch[ip_address]="+IPWhitelistIP+"&IpWhitelistSearch[comments]="+WhitelistDesc+"&sort=ip_address");
			WebElement baseTableEdit =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
			WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(4) > a:nth-child(2) > span"));
			
			
			//Edit Record
			ParseEdit.click();
			WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
			
			Assert.assertTrue(ParsePage.getText().contains("Update IP Whitelist: "+IPWhitelistIP));

			WebElement ParseWhitelistIpEdit = driver.findElement(By.name("IpWhitelist[ip_address]"));
			WebElement ParseWhitelistDescEdit = driver.findElement(By.name("IpWhitelist[comments]"));
			
			/*System.out.println(ParseWhitelistIpEdit.getText());
			if(ParseWhitelistIpEdit.getText() == IPWhitelistIP) {
				IPWhitelistIP = "000.0.0.0";
				WhitelistDesc = WhitelistDesc + " -Edited001";
			}*/
			
			 List<WebElement>  all_elements_edits =new ArrayList<>();
			 all_elements_edits.add(ParseWhitelistIpEdit);
			 all_elements_edits.add(ParseWhitelistDescEdit);
				
			 WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
				
			 CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
			 CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
			 
			 
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			 ParseWhitelistIpEdit.clear();
			 ParseWhitelistIpEdit.sendKeys(IPWhitelistIP);
			 ParseWhitelistDescEdit.clear();
			 ParseWhitelistDescEdit.sendKeys(WhitelistDesc + " - Edited");
			 
			 ParseUpdate.click();
			driver.navigate().back();
		}catch(Exception e){
			 
			//create Record
			WebElement CreateWhitelist = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/p/a"));
			CreateWhitelist.click();
			
			
			wait = new WebDriverWait(driver, 10);
			WebElement ParseWhitelistPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
			
			Assert.assertTrue(ParseWhitelistPage.getText().contains("Add IP Whitelist"));
			
			WebElement ParseWhitelist = driver.findElement(By.name("IpWhitelist[ip_address]"));
			WebElement ParseWhitelistDesc = driver.findElement(By.name("IpWhitelist[comments]"));
			
			
			
			WebElement ParseCreate = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[3]/button"));
			ParseCreate.click();		
			
			List<WebElement>  all_elements_text =new ArrayList<>();
		    all_elements_text.add(ParseWhitelist);
		    all_elements_text.add(ParseWhitelistDesc);
		    
		    CRUDTestCase CrudTest = new CRUDTestCase();
		    CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		 
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			 ParseWhitelist.sendKeys(IPWhitelistIP);
			 ParseWhitelistDesc.sendKeys(WhitelistDesc);
			 ParseCreate.click();
			 driver.quit();
	 		}		
		
	}else{
		 throw new SkipException("Skipping IPWhitelistTest case. ");
	}			
}


@Test (priority = Settings.CardholderDetailsTest, alwaysRun = true)
public void CardholderDetailsTest() {
	if(testSettings.skipTest("CardholderDetailsTest")){ 
		WebDriver driver = new ChromeDriver();
		String CardholderEmail = "G00799@100002.com";
		String WhitelistDesc = "QA Automated Whitelisting "; 
		System.out.println("Now on CardholderDetailsTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 5);
		
		WebElement ParseSuportMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(6) > a")));		
		ParseSuportMenu.click();
		
		
		WebElement CardholderDetails = driver.findElement(By.cssSelector("#w9 > li > a"));
		CardholderDetails.click();
		
				
		WebElement ParseCardholder =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#support-form > p")));
		Assert.assertTrue(ParseCardholder.getText().contains("Search Cardholder"));	
		
		
		WebElement ParseCardholderResults = driver.findElement(By.name("Cardholder[email]"));
		ParseCardholderResults.sendKeys(CardholderEmail);
		WebElement ParseSearchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		ParseSearchBtn.click();				
			
		wait = new WebDriverWait(driver, 10);
		WebElement ParseCardholderDetails =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div.site-system > div > div.col-md-offset-1.col-md-8.col-sm-12.col-xs-12 > h1")));
	
		Assert.assertTrue(ParseCardholderDetails.getText().contains("Cardholder Details"));	
		
		
		WebElement ParseEditBtn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/h1/a/div"));
		ParseEditBtn.click();
		
		Select dropdownCountry = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name("Cardholder[deli_country]"))));
		WebElement CountryValue = dropdownCountry.getFirstSelectedOption();
		
		if(CountryValue.getText() == "GB") {
			dropdownCountry.selectByValue("FR");
		}else {
			dropdownCountry.selectByValue("GB");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement ParseUpdateBtn = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		ParseUpdateBtn.click();
		
		
		WebElement ParseMessageAlert = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div")));
		Assert.assertTrue(ParseMessageAlert.getText().contains("has been saved successfully"));	
		driver.quit();
	}else{
		 throw new SkipException("Skipping CardholderDetailsTest case. ");
	}			
}

@Test (priority = Settings.SettingsPrefundTest, alwaysRun = true)
public void SettingsPrefundTest() {
	if(testSettings.skipTest("SettingsPrefundTest")){ 
		WebDriver driver = new ChromeDriver();
		String PrefundLabel = "QA-Prefund";
		String PrefundDetails = "IBAN	\r GB29 NWBK 6016 1331 9268 19 ISO Country Code	\r GB (United Kingdom) IBAN Check Digits	29 BBAN	\n NWBK 6016 1331 9268 19 Bank Identifier	\n NWBK Branch Identifier	\n 601613 Account Number	31926819 -E"; 
		System.out.println("Now on SettingsPrefundTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 5); 
		
		WebElement ParseSettingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(7) > a")));		
		ParseSettingsMenu.click();
		
		
		WebElement SettingsPrefund = driver.findElement(By.cssSelector("#w10 > li:nth-child(1) > a"));
		SettingsPrefund.click();
		
		//update Prefund		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseUpdatePrefundPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseUpdatePrefundPage.getText().contains("Update Prefund Account Details"));
		
		WebElement ParsePrefundLabel = driver.findElement(By.name("Settings[display_text]"));
		ParsePrefundLabel.clear();
		ParsePrefundLabel.sendKeys(PrefundLabel);
		
		WebElement ParsePrefundDetails = driver.findElement(By.name("Settings[var_text]"));
		System.out.println(PrefundDetails);
		ParsePrefundDetails.clear();
		ParsePrefundDetails.sendKeys(PrefundDetails);
		
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		ParseUpdate.click();	
		
		WebElement ParseAlertMessage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > div.card-list.col-xs-12 > div")));
		ParseAlertMessage.getText();
		Assert.assertTrue(ParseAlertMessage.getText().contains("Prefund accound details has been saved!"));
		driver.quit();
		}else{
		 throw new SkipException("Skipping SettingsPrefundTest case. ");
	}
}

@Test (priority = Settings.SettingsDeliveryMethodTest, alwaysRun = true)
public void SettingsDeliveryMethodTest() {
	if(testSettings.skipTest("SettingsDeliveryMethodTest")){ 
		WebDriver driver = new ChromeDriver();
		String DeliveryMethod = "QA-D01";
		String DeliveryName = "QA Automated Delivery Name " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date); 
		System.out.println("Now on SettingsDeliveryMethodTest");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 20); 
		
		WebElement ParseSettingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(7) > a")));		
		ParseSettingsMenu.click();
		
		
		WebElement SettingsDeliveryMethod = driver.findElement(By.cssSelector("#w10 > li:nth-child(3) > a"));
		SettingsDeliveryMethod.click();
		
		//create Record
		WebElement CreateDeliveryMethod = driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > p > a"));
		CreateDeliveryMethod.click();
		
		
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseCreateDeliveryPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseCreateDeliveryPage.getText().contains("Add Delivery Method"));
		
		WebElement ParseDeliveryMethod = driver.findElement(By.name("DeliveryMethod[delivery_method]"));	
		WebElement ParseDeliveryName = driver.findElement(By.name("DeliveryMethod[delivery_method_name]"));
		
		 List<WebElement>  all_elements_text =new ArrayList<>();
		    all_elements_text.add(ParseDeliveryMethod);
		    all_elements_text.add(ParseDeliveryMethod);
		    
		WebElement ParseCreate = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
				
		
		 CRUDTestCase CrudTest = new CRUDTestCase();
		 CrudTest.validateEmptyFields(all_elements_text,ParseCreate,"create");
		 
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		 ParseDeliveryMethod.sendKeys(DeliveryMethod);
		 ParseDeliveryName.sendKeys(DeliveryName);
		 ParseCreate.click();
		
		 driver.navigate().back();
		
		//Search Record	
		
		driver.get("https://dev.system.an-other.co.uk/delivery-method/index?DeliveryMethodSearch[delivery_method]=&DeliveryMethodSearch[delivery_method_name]="+DeliveryName+"&sort=-delivery_method");
		
		WebElement baseTable =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement TariffCodeValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(2)"));
		WebElement TariffNameValue = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(3)"));	
		
		WebElement ParseView = baseTable.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(5) > a:nth-child(1) > span"));
		
		Assert.assertTrue(TariffCodeValue.getText().contains(DeliveryMethod));
		Assert.assertTrue(TariffNameValue.getText().contains(DeliveryName));
		
		//View Record
		ParseView.click();		
		WebElement ParseViewPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > th")));
		WebElement ParseViewValue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w0 > tbody > tr:nth-child(2) > td")));
		
		if(ParseViewPage.getText() == "Value") {
			Assert.assertTrue(ParseViewValue.getText().contains(DeliveryMethod));			
		}
		
		
		//Edit Record
		driver.get("https://dev.system.an-other.co.uk/delivery-method/index?DeliveryMethodSearch[delivery_method]=&DeliveryMethodSearch[delivery_method_name]="+DeliveryName+"&sort=-delivery_method");
		WebElement baseTableEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseEdit = baseTableEdit.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(5) > a:nth-child(2) > span"));
		
		ParseEdit.click();
		WebElement ParsePage =  driver.findElement(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1"));
		
		Assert.assertTrue(ParsePage.getText().contains("Update Delivery Method: "+DeliveryName));
		
		WebElement ParseDeliveryMethodEdit = driver.findElement(By.name("DeliveryMethod[delivery_method]"));		
		WebElement ParseDeliveryNameEdit = driver.findElement(By.name("DeliveryMethod[delivery_method_name]"));
		
		
		List<WebElement>  all_elements_edits =new ArrayList<>();
		all_elements_edits.add(ParseDeliveryMethodEdit);
		all_elements_edits.add(ParseDeliveryNameEdit);
		
		WebElement ParseUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		
		CRUDTestCase CrudTestEdit = new CRUDTestCase(); //Re-instantiated because of stale error.
		CrudTestEdit.validateEmptyFields(all_elements_edits,ParseUpdate,"update");
	    
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		ParseDeliveryMethodEdit.clear();
		ParseDeliveryMethodEdit.sendKeys(DeliveryMethod +" -E");
		
		ParseDeliveryNameEdit.clear();
		ParseDeliveryNameEdit.sendKeys(DeliveryName+" -Edited");
		
		WebElement ParseUpdate2 = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		ParseUpdate2.click();
		
		
		//Delete Record
		driver.navigate().back();
		
		driver.get("https://dev.system.an-other.co.uk/delivery-method/index?DeliveryMethodSearch[delivery_method]=&DeliveryMethodSearch[delivery_method_name]="+DeliveryName+"&sort=-delivery_method");
		
		wait = new WebDriverWait(driver, 10);
		WebElement baseTableDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0\"]/table")));
		WebElement ParseDelete = baseTableDelete.findElement(By.cssSelector("#w0 > table > tbody > tr > td:nth-child(5) > a:nth-child(3) > span"));
		ParseDelete.click();
		driver.switchTo().alert().accept();
		driver.quit();
		
	}else{
		 throw new SkipException("Skipping SettingsDeliveryMethodTest case. ");
	}
}

@Test (priority = Settings.LogsCardholders, alwaysRun = true)
public void LogsCardholders() {
	if(testSettings.skipTest("LogsCardholders")){ 
		WebDriver driver = new ChromeDriver();
		String DeliveryMethod = "QA-D01";
		String DeliveryName = "QA Automated Delivery Name " + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date); 
		System.out.println("Now on LogsCardholders");
		log_in_system_user(driver, username, password);
		wait = new WebDriverWait(driver, 20); 
		
		WebElement ParseLogsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#w4 > li:nth-child(8) > a")));		
		ParseLogsMenu.click();
		
		
		WebElement LogsCardholders = driver.findElement(By.cssSelector("#w11 > li:nth-child(1) > a"));
		LogsCardholders.click();
		
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseCardholdersLogsPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.wrap > div.container-fluid > div > div > div > h1")));
		
		Assert.assertTrue(ParseCardholdersLogsPage.getText().contains("Cardholder Activity Logs"));
		
		WebElement ParseDateSearch = driver.findElement(By.xpath("//*[@id=\"userlogsearch-date_time-container\"]/div"));
		ParseDateSearch.click();
		
		wait = new WebDriverWait(driver, 10); 
		WebElement ParseDateRange = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/ul/li[4]")));
		ParseDateRange.click();
		
		wait = new WebDriverWait(driver, 10);
		WebElement baseTable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"w0-container\"]/table")));
		
		try {
			WebElement ParseRow = baseTable.findElement(By.cssSelector("#w0-container > table > tbody > tr:nth-child(1) > td:nth-child(1)"));
			Assert.assertNotNull(ParseRow.getText());

	    }
	    catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
	    	WebElement ParseRow = baseTable.findElement(By.xpath("//*[@id=\"w0-container\"]/table/tbody/tr/td/div"));
			Assert.assertEquals("No results found.", ParseRow.getText());	    	
		}	 
		driver.quit();
	}else{
		 throw new SkipException("Skipping LogsCardholders case. ");
	}
}


	 
public void log_in_system_user(WebDriver driver, String username, String password) {
	wait = new WebDriverWait(driver, 20);
	   
	   driver.manage().window().maximize();
	   driver.get("https://dev.system.an-other.co.uk/");
	   WebElement Username = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
	   Username.sendKeys(username);
	   WebElement Password = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
	   Password.sendKeys(password);
	   WebElement SysIn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
	   SysIn.click();
	   WebElement dashboard = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p0\"]")));
}

}
