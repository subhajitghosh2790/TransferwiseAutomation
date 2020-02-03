package com.transferwise.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.transferwise.qa.base.BaseClass;

public class TestUtils extends BaseClass {

	public TestUtils() {
		super();
	}

	public void openURL(String url) {
		log.info("Opening link ---> " + url);
		driver.get(url);
	}

	public boolean getPageTitle(String title) {
		return driver.getTitle().contains(title);
	}

	public boolean verifyElementDisplay(String locator) {
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}

	public void clickElement(String locator) {
		driver.findElement(By.xpath(locator)).click();
		log.info("Element is clicked");
	}

	public void inputText(String locator, Object text) {
		log.info("Input text --->" + text);
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(String.valueOf(text));
	}

	public void waitForElement(int timeInSeconds, String locatorOfElement) {
		new WebDriverWait(driver, timeInSeconds)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorOfElement)));

	}

	public void selectElementWithActionsClass(String locatorOfSearchBox, String valueToSearch) {
		new Actions(driver).sendKeys(driver.findElement(By.xpath(locatorOfSearchBox)), Keys.chord(valueToSearch))
				.sendKeys(Keys.ENTER).build().perform();
	}

	public String getValue(String locator) {
		return driver.findElement(By.xpath(locator)).getAttribute("value");
	}

	public String getText(String locator) {
		return driver.findElement(By.xpath(locator)).getText();
	}
}
