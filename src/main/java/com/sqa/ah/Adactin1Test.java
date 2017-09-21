/**
 * File Name: Adactin1Test.java<br>
 * Hesemann, Anne<br>
 * Created: Aug 31, 2017
 */
package com.sqa.ah;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * This is a test of login for the Adactin Hotel Management web site.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
@Test
public class Adactin1Test {

	private WebDriver driver;

	private String baseUrl;

	@Test
	public void invalidLoginTest() {
		this.driver.get(this.baseUrl + "/");
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

	@BeforeClass
	public void setup() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://adactin.com/HotelApp/index.php";
	}

	@AfterClass
	public void teardown() throws Exception {
		this.driver.quit();
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