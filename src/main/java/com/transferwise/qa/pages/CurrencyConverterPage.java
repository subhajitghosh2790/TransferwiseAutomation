package com.transferwise.qa.pages;

import org.testng.Assert;

import com.transferwise.qa.base.BaseClass;
import com.transferwise.qa.utils.TestUtils;

public class CurrencyConverterPage extends BaseClass {

	TestUtils utils;
	String xpath_PageHeader = "//h1";

	public CurrencyConverterPage() {
		super();
		utils = new TestUtils();
	}

	public void verifyPageTitle(String fromCurrency, String toCurrency) {
		Assert.assertTrue(utils.getPageTitle(fromCurrency + " to " + toCurrency), "The page title doesn't match.");
	}

	public void checkPageHeader() {
		Assert.assertTrue(utils.verifyElementDisplay(xpath_PageHeader));
		log.info("The page header is --> " + utils.getText(xpath_PageHeader));
	}

	public void display_FromCurrency_Amount(String fromCurrency) {
		String amount = utils.getValue("//div[text()= '" + fromCurrency + "']/preceding-sibling::input");
		log.info("When you convert currency '" + fromCurrency + "' of an amount : " + amount);
	}

	public void display_ToCurrency_Amount(String toCurrency) {
		String amount = utils.getValue("//div[text()= '" + toCurrency + "']/preceding-sibling::input");
		log.info("The amount you get in currency '" + toCurrency + "' is an amount of :" + amount);
	}
}
