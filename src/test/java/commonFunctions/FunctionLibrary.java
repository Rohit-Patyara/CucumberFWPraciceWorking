package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FunctionLibrary {

	public static WebDriver driver;
	public static Actions act;

	// method for launching browser
	public static WebDriver startBrowser() throws Throwable {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	// Method for launching URL
	public static void openUrl(String url) {
		driver.get(url);
	}

	// Method for webelement to wait
	public static void waitForElement(String locatorName, String locatorValue, String testData) {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(testData)));
		if (locatorName.equalsIgnoreCase("xpath")) {
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
		if (locatorName.equalsIgnoreCase("id")) {
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}
		if (locatorName.equalsIgnoreCase("name")) {
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		}
	}

	// Method for type action
	public static void typeAction(String locatorName, String locatorValue, String testData) {
		if (locatorName.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).clear();
			driver.findElement(By.xpath(locatorValue)).sendKeys(testData);
		}
		if (locatorName.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(testData);
		}
		if (locatorName.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(testData);
		}
	}

	// Method for click action
	public static void clickAction(String locatorName, String locatorValue) {
		if (locatorName.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		}
		if (locatorName.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(Keys.ENTER);
		}
		if (locatorName.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		}
	}

	// Method for page title validation
	public static void verifyTitle(String expected_Title) {
		String actualTitle = driver.getTitle();
		try {
			Assert.assertEquals(actualTitle, expected_Title, "Title is not matching");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(), true);
		}
	}

	// Method for closing browser
	public static void closeBrowser() {
		driver.quit();
	}

	// Method for date generation
	public static String generateDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY_MM_DD hh_mm_ss");
		return df.format(date);
	}

	// Method for mouse hover
	public static void mouseHoverAction(String locatorName, String locatorValue) {
		act = new Actions(driver);
		if (locatorName.equalsIgnoreCase("xpath")) {
			act.moveToElement(driver.findElement(By.xpath(locatorValue))).perform();
		}
		if (locatorName.equalsIgnoreCase("id")) {
			act.moveToElement(driver.findElement(By.id(locatorValue))).perform();
		}
		if (locatorName.equalsIgnoreCase("name")) {
			act.moveToElement(driver.findElement(By.name(locatorValue))).perform();
		}
	}

	// Method for category table
	public static void categoryTable(String Exp_Data) throws Throwable {
		// if search textbox is not displayed click search panel
		if (!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			// click search panel button
			driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_Data);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		Thread.sleep(3000);
		String Act_Data = driver
				.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[4]/div/span/span")).getText();
		Reporter.log(Act_Data + "  " + Exp_Data, true);
		try {
			Assert.assertEquals(Act_Data, Exp_Data, "Category Name is Not Matching");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(), true);
		}
	}

	// Method for listboxes
	public static void dropDownAction(String locatorName, String locatorValue, String testData) {
		int value = Integer.parseInt(testData);
		if (locatorName.equalsIgnoreCase("xpath")) {
			Select element = new Select(driver.findElement(By.xpath(locatorValue)));
			element.selectByIndex(value);
		}
		if (locatorName.equalsIgnoreCase("id")) {
			Select element = new Select(driver.findElement(By.id(locatorValue)));
			element.selectByIndex(value);
		}
		if (locatorName.equalsIgnoreCase("name")) {
			Select element = new Select(driver.findElement(By.name(locatorValue)));
			element.selectByIndex(value);
		}
	}

	// Method to capture stock number into notepad
	public static void captureStock(String locatorName, String locatorValue) throws Throwable {
		String stockNumber = "";
		if (locatorName.equalsIgnoreCase("xpath")) {
			stockNumber = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("id")) {
			stockNumber = driver.findElement(By.id(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("name")) {
			stockNumber = driver.findElement(By.name(locatorValue)).getAttribute("value");
		}
		// create note pad and write stock number
		FileWriter fw = new FileWriter("./CaptureData/stocknumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(stockNumber);
		bw.flush();
		bw.close();
	}

	// Method for stock table
	public static void stockTable() throws Throwable {
		// read stock number from note pad
		FileReader fr = new FileReader("./CaptureData/stocknumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		// if search textbox is not displayed click search panel
		if (!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			// click search panel button
			driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_Data);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		String Act_Data = driver
				.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
		Reporter.log(Act_Data + "   " + Exp_Data, true);
		try {
			Assert.assertEquals(Act_Data, Exp_Data, "Stock Number is Not Matching");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(), true);
		}
		br.close();
	}

	// Method to capture supplier number into notepad
	public static void captureSupplier(String locatorName, String locatorValue) throws Throwable {
		String supplierNumber = "";
		if (locatorName.equalsIgnoreCase("xpath")) {
			supplierNumber = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("id")) {
			supplierNumber = driver.findElement(By.id(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("name")) {
			supplierNumber = driver.findElement(By.name(locatorValue)).getAttribute("value");
		}
		// create note pad and write supplier number
		FileWriter fw = new FileWriter("./CaptureData/suppliernumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(supplierNumber);
		bw.flush();
		bw.close();
	}

	// Method for supplier table
	public static void supplierTable() throws Throwable {
		// read supplier number from note pad
		FileReader fr = new FileReader("./CaptureData/suppliernumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		// if search textbox is not displayed click search panel
		if (!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			// click search panel button
			driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_Data);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		String Act_Data = driver
				.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
		Reporter.log(Act_Data + "   " + Exp_Data, true);
		try {
			Assert.assertEquals(Act_Data, Exp_Data, "Supplier Number is Not Matching");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(), true);
		}
		br.close();
	}

	// Method to capture customer number into notepad
	public static void captureCustomer(String locatorName, String locatorValue) throws Throwable {
		String customerNumber = "";
		if (locatorName.equalsIgnoreCase("xpath")) {
			customerNumber = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("id")) {
			customerNumber = driver.findElement(By.id(locatorValue)).getAttribute("value");
		}
		if (locatorName.equalsIgnoreCase("name")) {
			customerNumber = driver.findElement(By.name(locatorValue)).getAttribute("value");
		}
		// create note pad and write customer number
		FileWriter fw = new FileWriter("./CaptureData/customernumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(customerNumber);
		bw.flush();
		bw.close();
	}

	// Method for customer table
	public static void customerTable() throws Throwable {
		// read customer number from note pad
		FileReader fr = new FileReader("./CaptureData/customernumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		// if search textbox is not displayed click search panel
		if (!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			// click search panel button
			driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_Data);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		String Act_Data = driver
				.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
		Reporter.log(Act_Data + "   " + Exp_Data, true);
		try {
			Assert.assertEquals(Act_Data, Exp_Data, "Customer Number is Not Matching");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(), true);
		}
		br.close();
	}
}
