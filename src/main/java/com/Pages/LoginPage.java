/**
 * @author UmaMaheswararao
 */

package com.Pages;

import static com.Util.ActionUtil.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class LoginPage {

	// Object Repository:
	static By signInButton = By.xpath("//a[@class='login']");
	static By emailField = By.id("email");
	static By passwordField = By.id("passwd");
	static By loginBtn = By.cssSelector("#SubmitLogin");
	static By myAccHeaderText = By.xpath("//h1[@class='page-heading'][text()='My account']");
	static By signOutBtn = By.cssSelector(".logout");
	
	
	
	
	
	
	
	// Page Action methods:
	public static void verify_Login_functionality(String un, String pw) throws Exception {
		createNode("Login to application");
		waitForElementToBeDisplayed("signInButton", signInButton, 20);
		click("signInButton", signInButton);
		sendKeys("emailField", emailField, un);	
		sendKeys("passwordField", passwordField, pw);
		click("loginBtn", loginBtn);
		waitForElementToBeDisplayed("myAccHeaderText", myAccHeaderText, 20);
		assertTrue(verifyElementPresent("myAccHeaderText", myAccHeaderText), "'My Account Header Text' is not displaying");
		Reporter.log("Login successful", true);
	}

	public static void verify_Loout_functionality() throws Exception {
		createNode("Logout from application");
		waitForElementToBeDisplayed("logOutBtn", signOutBtn, 20);
		click("signOutBtn", signOutBtn);
		assertTrue(verifyElementPresent("emailField", emailField), "Logout unsuccessful");
		Reporter.log("Logout successful", true);
	}

	
	
	
	
	
	
	
	
	
	

}
