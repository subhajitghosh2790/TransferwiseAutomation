package com.transferwise.qa.pages;

import org.testng.Assert;

import com.transferwise.qa.base.BaseClass;
import com.transferwise.qa.utils.TestUtils;

public class HomePage extends BaseClass {

	TestUtils utils;

	String xpath_PageHeader = "//h1";
	String xpath_FromCurrency_Dropdown = "(//button[@class ='btn dropdown-toggle btn-input'])[1]";
	String xpath_Search_FromCurrency_List = "(//input[@placeholder = 'Search...'])[1]";
	String xpath_ToCurrency_Dropdown = "(//button[@class ='btn dropdown-toggle btn-input'])[2]";
	String xpath_Search_ToCurrency_List = "(//input[@placeholder = 'Search...'])[2]";
	String xpath_Enter_Amount = "//input[@id= 'cc-amount']";
	String xpath_ConvertButton = "//button[text()= 'Convert']";

	public HomePage() {
		super();
		utils = new TestUtils();
	}

	public void verifyPageTitle(String title) {
		Assert.assertTrue(utils.getPageTitle(title), "The page title doesn't match.");
	}

	public void checkPageHeader() {
		Assert.assertTrue(utils.verifyElementDisplay(xpath_PageHeader));
		log.info("The page header is --> " + utils.getText(xpath_PageHeader));
	}

	public void select_FromCurrency(String currency) {
		utils.clickElement(xpath_FromCurrency_Dropdown);
		utils.inputText(xpath_Search_FromCurrency_List, currency);
		utils.clickElement(
				"((//input[@placeholder = 'Search...'])[1]/following::li//*[text() = '" + currency + "'])[1]");
	}

	public void select_ToCurrency(String currency) {
		utils.clickElement(xpath_ToCurrency_Dropdown);
		utils.inputText(xpath_Search_ToCurrency_List, currency);
		utils.clickElement(
				"((//input[@placeholder = 'Search...'])[2]/following::li//*[text() = '" + currency + "'])[1]");
	}

	public void enterAmount_forConversion(Object amount) {
		utils.inputText(xpath_Enter_Amount, amount);
	}

	public CurrencyConverterPage clickConvert() {
		utils.clickElement(xpath_ConvertButton);
		return new CurrencyConverterPage();
	}
}
