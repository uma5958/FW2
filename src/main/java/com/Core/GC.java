/**
 * @author UmaMaheswararao
 */

package com.Core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class GC {
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> tlExtentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> tlExtentTestNode = new ThreadLocal<ExtentTest>();
	public static String userDirectory = System.getProperty("user.dir");
	public static String testDataFilePath = "./src/main/java/com/TestData/Test_Data.xlsx";
	
	public static final String calendarTimeFormat = "dd/MM/yyyy, EEE";

}
