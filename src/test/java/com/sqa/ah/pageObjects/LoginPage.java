/**
 * File Name: LoginPage.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;

/**
 * This class contains the methods and elements for the Adactin Hotel app login
 * page.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class LoginPage {

	private WebElement username;

	private WebElement password;

	private WebElement login;

	@FindBy(css = ".auth_error>b")
	private WebElement invalidLoginText;

	private WebDriver driver;

	/**
	 * @param baseurl
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login.getAttribute("value");
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password.getAttribute("value");
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username.getAttribute("value");
	}

	public void inValidLogin(String userN, String passW) {
		this.username.clear();
		this.password.clear();
		this.username.sendKeys(userN);
		this.password.sendKeys(passW);
		this.login.click();
		AssertJUnit.assertEquals("Invalid Login Details", this.invalidLoginText.getText());
	}

	public void validLogin(String userN, String passW) {
		this.username.clear();
		this.password.clear();
		this.username.sendKeys(userN);
		this.password.sendKeys(passW);
		this.login.click();
	}
}
