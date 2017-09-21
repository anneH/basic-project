/**
 * File Name: WSTest.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 6, 2017
 */
package com.sqa.ah.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * AdactinTest //ADDD (description of class)
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTest extends BasicTest {

	/**
	 * @param baseurl
	 */
	public AdactinTest(String baseurl) {
		super("http://adactin.com/HotelApp");
		// TODO Auto-generated constructor stub
	}

	@Test
	public void invalidLoginTest() {
		// this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.id("username")).sendKeys("invalidusername");
		this.driver.findElement(By.id("password")).sendKeys("invalidpassword");
		this.driver.findElement(By.id("login")).click();
		String invalidText = this.driver.findElement(By.cssSelector(".auth_error>b")).getText();
		AssertJUnit.assertEquals("Invalid Login Details", invalidText);
	}

	@Test
	public void selectLocation() {
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("username")).sendKeys("annetest");
		this.driver.findElement(By.id("password")).sendKeys("annepw");
		this.driver.findElement(By.id("login")).click();
		WebElement location = this.driver.findElement(By.id("location"));
		Select selector = new Select(location);
		selector.selectByVisibleText("Sydney");
	}

	@Test
	public void validLoginTest() {
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("username")).sendKeys("annetest");
		this.driver.findElement(By.id("password")).sendKeys("annepw");
		this.driver.findElement(By.id("login")).click();
		String pageTitle = this.driver.getTitle();
		AssertJUnit.assertEquals(pageTitle, "AdactIn.com - Search Hotel");
	}
	// @Test
	// public void validLoginTest() {
	// this.driver.findElement(By.id("username")).clear();
	// this.driver.findElement(By.id("password")).clear();
	// this.driver.findElement(By.id("username")).sendKeys("annetest");
	// this.driver.findElement(By.id("password")).sendKeys("annepw");
	// this.driver.findElement(By.id("login")).click();
	// String pageTitle = this.driver.getTitle();
	// AssertJUnit.assertEquals(pageTitle, "AdactIn.com - Search Hotel");
	// }
}
