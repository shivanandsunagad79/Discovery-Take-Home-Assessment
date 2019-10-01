package com.globalLogic.discovery.stepdefs.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globalLogic.discovery.DriverInitializer;
import com.globalLogic.discovery.cukes.TestConstants;
import com.globalLogic.discovery.pageobjects.AllShowsPage;
import com.globalLogic.discovery.pageobjects.HomePage;
import com.globalLogic.discovery.pageobjects.PopularShowsPage;

/**
 * @author shivanand sunagad
 *
 */
public class BaseSteps {
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	DriverInitializer driverInitializer=DriverInitializer.getdriverInitializerInstatnce();
	public HomePage homePage;
	public AllShowsPage allShowsPage;
	public PopularShowsPage popularShowsPage;

	/**
	 * @return
	 */
	public HomePage getHomePage() {
		return (HomePage) new HomePage().get();
	}

	/**
	 * @return
	 */
	public AllShowsPage getAllShowsPage() {
		return (AllShowsPage) new AllShowsPage().get();
	}
	
	/**
	 * @return
	 */
	public PopularShowsPage getPopularShowsPage() {
		return (PopularShowsPage) new PopularShowsPage().get();
	}
	
	/**getdriverInitializerInstatnce
	 * @param URL
	 */
	public void launchBrowser(String URL) {
		if (TestConstants.BROWSER_TYPE == "bschrome") {
			try {
				logger.info("Launching App on browser type:: {}", TestConstants.BROWSER_TYPE);
				logger.info("URL::{}", URL);
				driverInitializer.getAppropriateBrowserstackDriver(TestConstants.BROWSER_TYPE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driverInitializer.triggerUrl(URL);
		} else {
			try {
				logger.info("Launching App on browser type:: {}", TestConstants.BROWSER_TYPE);
				logger.info("URL::{}", URL);
				driverInitializer.getAppropriateDriver(TestConstants.BROWSER_TYPE, TestConstants.DRIVER_LIB_DIR);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driverInitializer.triggerUrl(URL);
		}
	}

	public void closeBrowser() {
		try {
			logger.info("Closing App on browser type::{}", TestConstants.BROWSER_TYPE);
			driverInitializer.closeAllBrowsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Browser is closed successfully");

	}


}
