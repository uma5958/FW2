/**
 * @author UmaMaheswararao
 */

package com.Core;

import static com.Core.GC.extent;
import static com.Core.GC.testDataFilePath;
import static com.Core.GC.tldriver;
import static com.Util.ActionUtil.getCurrentDateAndTime;
import static com.Util.ActionUtil.loadTheUrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.Util.ExcelUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.Listeners.TestListeners.class)
public class Base {

	public static Properties prop;
	public static ExcelUtility reader;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		initialize_properties();
		initilizeExtentReport();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		launchBrowser();
		loadTheUrl(prop.getProperty("url"));
		reader = new ExcelUtility(testDataFilePath);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		getDriver().quit();
	}

	@AfterSuite
	public static void afterSuite() throws Exception {
	}

	public static Properties initialize_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static void initilizeExtentReport() throws Exception {
		String timeStamp = getCurrentDateAndTime();
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\ExtentReports\\Reports\\Automation_Report-" + timeStamp + ".html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\ExtentReports\\ConfigFile\\html-config.xml");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", prop.getProperty("os"));
		extent.setSystemInfo("Environment", prop.getProperty("envirionment"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
	}

	public static void launchBrowser() throws Exception {
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			WebDriver driver = new ChromeDriver(options);
			setDriver(driver);
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
			setDriver(new FirefoxDriver());
		} 
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("headlessChrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();  
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
			setDriver(new ChromeDriver(options));
		}
		
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void setDriver(WebDriver driver) {
		tldriver.set(driver);
	}




}
