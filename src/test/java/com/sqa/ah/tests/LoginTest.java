/**
 * File Name: LoginTest.java Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.tests;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.ah.core.*;
import com.sqa.ah.pageObjects.*;

/**
 * This class tests the Adactin Hotel app login function with valid and invalid
 * credentials.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class LoginTest extends BasicTest {

	/**
	 * @param baseurl
	 */
	public LoginTest(String baseurl) {
		super("http://adactin.com/HotelApp/index.php");
	}

	@Test
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(this.driver);
		loginPage.inValidLogin("annetest", " ");
	}

	@Test
	public void testValidLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(this.driver);
		loginPage.validLogin("annetest", "annepw");
		Thread.sleep(10000);
		String pageTitle = this.driver.getTitle();
		AssertJUnit.assertEquals(pageTitle, "AdactIn.com - Search Hotel");
	}
}
