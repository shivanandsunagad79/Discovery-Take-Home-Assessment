package com.globalLogic.discovery.stepdefs.steps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.globalLogic.discovery.PropertyFileReader;
import com.globalLogic.discovery.TimeManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PopularShowsSteps extends BaseSteps{
	String appURL=PropertyFileReader.getProperty("app.url");
	@SuppressWarnings("deprecation")
	@Given("^I want to navigate to discovery app to see popular shows$")
	public void i_want_to_navigate_to_discovery_app_to_see_popular_shows() throws Throwable {
		launchBrowser(appURL);
		homePage=getHomePage();
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals("Discovery - Official Site", homePageTitle);
		String homePageURL=homePage.verifyHomePageURL();
		Assert.assertEquals(appURL,homePageURL);
		popularShowsPage=getPopularShowsPage();
		popularShowsPage.scrollIntoPopularShows();
		Assert.assertEquals("POPULAR SHOWS", popularShowsPage.getText());
	}
	@When("^I go to last video to explore it$")
	public void i_go_to_last_video_to_explore_it() throws Throwable {
		popularShowsPage.clickRightIconArrow();
		popularShowsPage.clickOnExploreTheShow();
	}
	@When("^I verify the more shows available and few are added$")
	public void i_verify_the_more_shows_available_and_few_are_added() throws Throwable {
		//popularShowsPage.scrollIntoViewMoreShows();
		popularShowsPage.scrollDown();
		TimeManager.waitInSeconds(10);
		popularShowsPage.clickOnViewMoreShows();
		TimeManager.waitInSeconds(10);
		popularShowsPage.scrollDown();
		popularShowsPage.clickOnViewMoreShows();
	}
	@Then("^create a new text file and write all show title and its duration$")
	public void create_a_new_text_file_and_write_all_show_title_and_its_duration() throws Throwable {
		//get current project path
		String filePath = System.getProperty("user.dir");
		//create a new file
		File file = new File(filePath + "\\" + "PopularShowsList.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File is created");
			} else {
				System.out.println("File already exist");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}	    	   
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(popularShowsPage.getAllShowTitles());
		bw.newLine();
		bw.write(popularShowsPage.getAllShowDuration());
		bw.close();  	
		//Close the browser
		closeBrowser();
	}
}
