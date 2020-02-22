/**
 * @author UmaMaheswararao
 */

package com.Util;

import java.util.Set;

import org.openqa.selenium.Cookie;
import static com.Core.Base.getDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class CookieLibrary.
 */
public class CookieLibrary {

	/**
	 * Gets the cookie by name.
	 *
	 * @param getDriver() -The getDriver()
	 * @param cookieName -The cookie name
	 * @return the cookie
	 */
	public static Cookie getCookieByName(String cookieName){
		return getDriver().manage().getCookieNamed(cookieName);
	}
	
	/**
	 * Delete cookie by name.
	 *
	 * @param getDriver() -The getDriver()
	 * @param cookieName -The cookie name
	 */
	public static void deleteCookieByName(String cookieName){
		getDriver().manage().deleteCookieNamed(cookieName);
	}
	
	/**
	 * Delete all cookies.
	 *
	 * @param getDriver() -The getDriver()
	 */
	public static void deleteAllCookies(){
		getDriver().manage().deleteAllCookies();
	}
	
	/**
	 * Gets the all cookies.
	 *
	 * @param getDriver() -The getDriver()
	 * @return all cookies as Set&lt;Cookie&gt;
	 */
	public static Set<Cookie> getAllCookies(){
		return getDriver().manage().getCookies();
	}
	
	
}
