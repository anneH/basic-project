/**
 * File Name: HotelSearchTest.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.tests;

import org.testng.annotations.*;

import com.sqa.ah.core.*;
import com.sqa.ah.pageObjects.*;

/**
 * HotelSearchTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class HotelSearchTest extends BasicTest {

	/**
	 * @param baseurl
	 */
	public HotelSearchTest(String baseurl) {
		super("http://adactin.com/HotelApp/index.php");
	}

	@Test
	public void testHotelLocationSearch() {
		LoginPage loginPg = new LoginPage(this.driver);
		SearchHotelPage searchHotelPg = new SearchHotelPage(this.driver);
		loginPg.validLogin("annetest", "annepw");
		searchHotelPg.searchHotels("Sydney", "Hotel Creek", "Standard", "1-One", "9/17/2017", "9/18/2017", "1-One",
				"-Select Children per Room-");
	}
}
