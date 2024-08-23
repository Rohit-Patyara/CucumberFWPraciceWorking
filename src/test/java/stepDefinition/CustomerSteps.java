package stepDefinition;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CustomerSteps {

	WebDriver driver;

	@Given("user launches browser")
	public void launchBrowser() throws Throwable {
		driver = FunctionLibrary.startBrowser();
	}

	@When("user enter url as {string} in a browser")
	public void openUrl(String url) {
		FunctionLibrary.openUrl(url);
	}

	@When("user waits for username with locator {string} and its value {string}")
	public void waitForUsername(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user enters username as {string} with locator {string} and its value {string}")
	public void enterUsername(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters password as {string} with locator {string} and its value {string}")
	public void enterPassword(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user click login button with locator {string} and its value {string}")
	public void clickLoginButton(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user waits for customer link with locator {string} and its value {string}")
	public void waitForCustomerLink(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user click customer link with locator {string} and its value {string}")
	public void clickCustomerLink(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user waits for Add icon with locator {string} and its value {string}")
	public void waitForAddIcon(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user clicks Add icon button with locator {string} and its value {string}")
	public void clickAddIcon(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user waits for Customer Number with locator {string} and its value {string}")
	public void waitForCustomerNumber(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user captures Customer Number with locator {string} and its value {string}")
	public void captureCustomerNumber(String locatorName, String locatorValue) throws Throwable {
		FunctionLibrary.captureCustomer(locatorName, locatorValue);
	}

	@When("user enters Customer Name as {string} with locator {string} and its value {string}")
	public void enterCustomerName(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Address as {string} with locator {string} and its value {string}")
	public void enterAddress(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters City as {string} with locator {string} and its value {string}")
	public void enterCity(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Country as {string} with locator {string} and its value {string}")
	public void enterCountry(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Contact Person as {string} with locator {string} and its value {string}")
	public void enterContactPerson(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Phone Number as {string} with locator {string} and its value {string}")
	public void enterPhoneNumber(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Email as {string} with locator {string} and its value {string}")
	public void enterEmail(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Mobile Number as {string} with locator {string} and its value {string}")
	public void enterMobileNumber(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user enters Notes as {string} with locator {string} and its value {string}")
	public void enterNotes(String testData, String locatorName, String locatorValue) {
		FunctionLibrary.typeAction(locatorName, locatorValue, testData);
	}

	@When("user clicks Add button with locator {string} and its value {string}")
	public void clickAddButton(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user waits for Confirm Ok button with locator {string} and its value {string}")
	public void waitForConfirmOkButton(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user clicks Confirm Ok button with locator {string} and its value {string}")
	public void clickConfirmOkButton(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user waits for Alert Ok button with locator {string} and its value {string}")
	public void waitForAlertOkButton(String locatorName, String locatorValue) {
		FunctionLibrary.waitForElement(locatorName, locatorValue, "10");
	}

	@When("user clicks Alert Ok button with locator {string} and its value {string}")
	public void cllickAlertOkButton(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user validates Customer Table")
	public void validateCustomerTable() throws Throwable {
		FunctionLibrary.customerTable();
	}

	@When("user clicks Logout Link with locator {string} and its value {string}")
	public void clickLogout(String locatorName, String locatorValue) {
		FunctionLibrary.clickAction(locatorName, locatorValue);
	}

	@When("user close browser")
	public void closeBrowser() {
		FunctionLibrary.closeBrowser();
	}
}
