/**
 * File Name: SearchHotelPage.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

/**
 * SearchHotelPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class SearchHotelPage {

	private WebElement location;

	private WebElement hotels;

	private WebElement room_type;

	private WebElement room_nos;

	private WebElement datepick_in;

	private WebElement datepick_out;

	private WebElement adult_room;

	private WebElement child_room;

	private WebElement Submit;

	private WebElement Reset;

	public SearchHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void searchHotels(String location, String hotel, String roomType, String numRooms, String checkInDate,
			String checkOutDate, String adultsPerRm, String childrenPerRm) {
		Select selectorLoc = new Select(this.location);
		selectorLoc.selectByVisibleText(location);
		Select selectorHotel = new Select(this.hotels);
		selectorHotel.selectByVisibleText(hotel);
		Select selectRmType = new Select(this.room_type);
		Select selectorNumRooms = new Select(this.room_nos);
		selectorNumRooms.selectByVisibleText(numRooms);
		this.datepick_in.sendKeys(checkInDate);
		this.datepick_out.sendKeys(checkOutDate);
		Select selectAdults = new Select(this.adult_room);
		selectAdults.selectByVisibleText(adultsPerRm);
		Select selectChildren = new Select(this.child_room);
		selectChildren.selectByVisibleText(childrenPerRm);
		this.Submit.click();
	}
}
