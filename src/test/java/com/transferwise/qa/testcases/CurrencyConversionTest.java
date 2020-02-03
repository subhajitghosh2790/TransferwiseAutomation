package com.transferwise.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.transferwise.qa.base.BaseClass;
import com.transferwise.qa.pages.CurrencyConverterPage;
import com.transferwise.qa.pages.HomePage;
import com.transferwise.qa.utils.Dataproviders;
import com.transferwise.qa.utils.TestUtils;

public class CurrencyConversionTest extends BaseClass {

	CurrencyConverterPage ccPage;
	HomePage homePage;
	TestUtils utils;

	@Parameters({ "browser" })
	@BeforeMethod(description = "Initialization of browser and ")
	public void setUp(String browser) {
		log.info("\n**************************************************************\n"
				+ "*                        Testcase started                    *\n"
				+ "**************************************************************\n");
		homePage = new HomePage();
		utils = new TestUtils();
		initialization(browser);
		utils.openURL("https://transferwise.com/ie/currency-converter/");
		homePage.verifyPageTitle("TransferWise");
		homePage.checkPageHeader();
	}

	@Test(dataProvider = "currencies", dataProviderClass = Dataproviders.class)
	public void checkCurrencyConversion(String fromCurrency, String toCurrency) {
		homePage.select_FromCurrency(fromCurrency);
		homePage.select_ToCurrency(toCurrency);
		homePage.enterAmount_forConversion(1000);
		ccPage = homePage.clickConvert();
		ccPage.verifyPageTitle(fromCurrency, toCurrency);
		ccPage.checkPageHeader();
		ccPage.display_FromCurrency_Amount(fromCurrency);
		ccPage.display_ToCurrency_Amount(toCurrency);

	}

	@AfterMethod
	public void tearDown() {
		utils.closeBrowser();
	}
}
