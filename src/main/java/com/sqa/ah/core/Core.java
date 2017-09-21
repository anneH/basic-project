/**
 * File Name: Core.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 6, 2017
 */
package com.sqa.ah.core;

import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.ah.helpers.*;

/**
 * Core class for setting the baseurl and Webdriver.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class Core {

	private String baseurl;

	protected WebDriver driver;

	private BasicTest curTest;

	private Logger log;

	public Core(BasicTest test) {
		this.curTest = test;
		this.baseurl = test.getBaseurl();
		this.driver = test.getDriver();
	}

	/**
	 * @param baseurl
	 * @param driver
	 */
	public Core(String baseurl) {
		this.baseurl = baseurl;
	}

	public Core(String baseurl, WebDriver driver) {
		super();
		this.baseurl = baseurl;
		this.driver = driver;
	}

	/**
	 * @return the baseurl
	 */
	public String getBaseurl() {
		return this.baseurl;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	public String getProp(String propName) {
		return AutoBasics.getProp(propName, "src/main/resources/", "config.properties", getLog());
	}

	public boolean isElementPresent(By locator) {
		return false;
	}

	/**
	 * @param baseurl
	 *            the baseurl to set
	 */
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return
	 */
	private Logger getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}
