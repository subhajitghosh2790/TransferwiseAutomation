package com.transferwise.qa.Listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\Advanced-reports\\Extent-Report.html");
		htmlReporter.config().setDocumentTitle("Transferwise Test Automation Report");
		htmlReporter.config().setReportName("Acceptance Criteria Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		try {
			extent.setSystemInfo("Hostname", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		extent.setSystemInfo("Testname", System.getProperty("user.name"));
		return extent;
	}
}
