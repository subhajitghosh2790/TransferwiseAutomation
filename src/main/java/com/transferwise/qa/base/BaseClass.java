package com.transferwise.qa.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log;

	public BaseClass() {
		log = Logger.getLogger("Transferwise Test Automation");
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void initialization(String browser) {

		if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Resources\\Firefox\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\Resources\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.quit();
		log.info("Browser closed.");
	}

}
