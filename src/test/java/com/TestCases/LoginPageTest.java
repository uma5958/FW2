/**
 * @author UmaMaheswararao
 */

package com.TestCases;

import static com.Pages.LoginPage.verify_Login_functionality;
import static com.Pages.LoginPage.verify_Loout_functionality;
import static com.Util.ActionUtil.createNode;

import org.testng.annotations.Test;

import com.Core.Base;

public class LoginPageTest extends Base {

	@Test(enabled=true)
	public void verify_Login_and_logout_functionality_Test() throws Exception {
		verify_Login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		verify_Loout_functionality();
	}
	

	@Test(enabled=true)
	public void verify_Login_and_logout_functionality_Test1() throws Exception {
		verify_Login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		verify_Loout_functionality();
	}
	

	@Test(enabled=false)
	public void readData() throws Exception {
		createNode("Test Data reading: ");
		System.out.println("Data: "+reader.getCellData("TestData", 0, 15));
	}
	
	
	
	
	
	
	
	
}
