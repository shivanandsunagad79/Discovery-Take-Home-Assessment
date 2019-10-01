package com.globalLogic.discovery.stepdefs.steps;

import com.globalLogic.discovery.PropertyFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert; 

public class AllShowsSteps extends BaseSteps {
	String appURL=PropertyFileReader.getProperty("app.url");
	@SuppressWarnings("deprecation")
	@Given("^I want to navigate to discovery app to see all shows$")
	public void i_want_to_navigate_to_discovery_app_to_see_all_shows() throws Throwable {
		launchBrowser(appURL);
		homePage=getHomePage();
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals("Discovery - Official Site", homePageTitle);
		String homePageURL=homePage.verifyHomePageURL();
		Assert.assertEquals(appURL,homePageURL);
		homePage.scrollDown();
		homePage.clickShowsLink();
		homePage.clickSeeAllShowsLink();
		allShowsPage=getAllShowsPage();
		allShowsPage.clickSeacrchIcon();
	}
	@When("^I select shows title contain \"([^\"]*)\" shows in show tab$")
	public void i_select_shows_title_contain_shows_in_show_tab(String showsTitle) throws Throwable {
		allShowsPage.enterTextToSearchShow(showsTitle );
	}
	@When("^I verify the selected \"([^\"]*)\" shows favorites status and set unfavorite to favorite and vice versa$")
	public void i_verify_the_selected_shows_favorites_status_and_set_unfavorite_to_favorite_and_vice_versa(String showsTitle) throws Throwable {
		allShowsPage.clickOnSearchedShows(showsTitle);
	}
	@Then("^validate the favorite or unfavorite shows under “FAVORITE SHOWS” in My Videos collection$")
	public void validate_the_favorite_or_unfavorite_shows_under_FAVORITE_SHOWS_in_My_Videos_collection() throws Throwable {
		allShowsPage.verifyMyVideosFavoriteShows();
		closeBrowser();
	}
}
