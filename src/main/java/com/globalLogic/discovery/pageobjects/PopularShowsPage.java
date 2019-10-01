package com.globalLogic.discovery.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globalLogic.discovery.PageObject;
import com.globalLogic.discovery.TimeEntity;

public class PopularShowsPage extends PageObject {
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	final By lblPopularShows=By.xpath("//h2[@class='popularShowsCarousel__header']");
	final By icnArrow=By.xpath("//div[@class='carousel__arrowWrapper popularShowsCarousel__controlsProp']//i[@class='icon-arrow-right']");
	final By lblExploreTheShow=By.xpath("//div[contains(text(),'Deadliest Catch')]");
	final By lblViewMoreShows=By.xpath("//button[@class='episodeList__showMoreButton']");
	final By lblAllShowTitles=By.xpath("//p[@class='episodeTitle']");
	final By lblAllShowDuration=By.xpath("//p[@class='minutes']");
	@Override
	protected void load() {
		logger.debug("PopularShowsPage {} load() \", this.getClass().getName()");		
	}

	@Override
	protected void isLoaded() throws Error {
		logger.debug("PopularShowsPage {} isLoaded() ", this.getClass().getName());
		this.init();

	}
	public void scrollIntoPopularShows() {
		jsScroll(lblPopularShows);
	}
	public String getText() {
		return findElement(lblPopularShows).getText();
	}
	public void clickRightIconArrow() {
		WebElement ele=findElement(icnArrow);

		while(true) {
			click(ele);
			if(findElementThatIsVisibale(icnArrow, TimeEntity.SEC_30.getSeconds()) == null) {
				break;
			}
		}	

	}
	public void clickOnExploreTheShow() throws InterruptedException {

		try {
			WebElement ele=findElement(lblExploreTheShow);
			click(ele);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void scrollIntoViewMoreShows() {
		jsScroll(lblViewMoreShows);
	}
	public void clickOnViewMoreShows() {
		try {
			WebElement ele=findElement(lblViewMoreShows);
			click(ele);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void scrollDown() {
		jsScroll(0, 1000);
	}
	public String getAllShowTitles() {
		String returnString="";
		int num=1;
		List<WebElement> AllShowTitles=findElements(lblAllShowTitles);
		for(WebElement showTitle:AllShowTitles) {
			String showTitleText=showTitle.getText().toString();
			returnString=returnString+"  "+ num+")"+ showTitleText;
			num++;
		}
		return returnString;
	}
	public String getAllShowDuration() {
		String returnString="";
		int num=1;
		List<WebElement> AllShowDuration=findElements(lblAllShowDuration);
		for(WebElement showDuration:AllShowDuration) {
			String showDurationText=showDuration.getText().toString();
			returnString=returnString+"  "+ num+")show duration"+":"+ showDurationText;
			num++;
		}
		return returnString;
	}
}

