package com.transferwise.qa.utils;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	@DataProvider(name = "currencies")
	public Object[][] setCurrency() {

		return new Object[][] { { "GBP", "INR" }, { "GBP", "USD" }, { "USD", "AUD" }, { "EUR", "INR" },
				{ "GBP", "EUR" } };
	}

}
