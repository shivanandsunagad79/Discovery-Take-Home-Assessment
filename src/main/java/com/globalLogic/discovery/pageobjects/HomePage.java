package com.globalLogic.discovery.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globalLogic.discovery.PageObject;
import com.globalLogic.discovery.TimeEntity;


/**
 * @author shivanand sunagad
 *
 */
public class HomePage extends PageObject{
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	//Home Page elements
		final By lnkShows = By.xpath("//span[contains(text(),'Shows')]");
		final By drpDwnLnkAllShows=By.className("dscShowsDropContent__seeAllShows");
		

	@Override
	protected void load() {
		logger.debug("HomePage {} load() \", this.getClass().getName()");

	}

	@Override
	protected void isLoaded() throws Error {
		logger.debug("HomePage {} isLoaded() ", this.getClass().getName());
		this.init();
	}

		//Navigate to main header top links
	public void clickShowsLink() {
		click(lnkShows,TimeEntity.SEC_5.getSeconds());
		
	}

	//Navigate to main header drop down links
	public void clickSeeAllShowsLink() {
		click(drpDwnLnkAllShows, TimeEntity.SEC_5.getSeconds());
	}
	// Add common methods to verify UI level test cases
	public String verifyHomePageTitle() {
		String pageTitle = getPageTitle();
		return pageTitle;
	}

	public String verifyHomePageURL() {
		String homePageURL = getPageUrl();
		return homePageURL;
	}
	
	public void scrollDown() {
		jsScroll(0, 500);
	}
	
	
	
}
