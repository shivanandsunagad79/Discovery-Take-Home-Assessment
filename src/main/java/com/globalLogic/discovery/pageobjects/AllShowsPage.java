package com.globalLogic.discovery.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globalLogic.discovery.PageObject;
import com.globalLogic.discovery.TimeEntity;
import com.globalLogic.discovery.TimeManager;

public class AllShowsPage extends PageObject {
	private static final CharSequence Apollo = null;
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	final By hdrSeacrhIcon=By.className("headerSearch__searchIcon");
	final By txtSearch=By.xpath("//input[@placeholder='Search Discovery']");
	final By lnkTosearch=By.xpath("//ul[@class='searchTypeAhead__resultsList']");
	final By plusIcon=By.xpath("//div[@class='showHero__showBrand showHero__showLogoNoClips']//i[contains(@class,'flipIconCore__icon icon-plus')]");
	final By minusIcon=By.xpath("//div[@class='showHero__showBrand showHero__showLogoNoClips']//i[contains(@class,'flipIconCore__icon icon-minus')]");
	final By hdrMainIcon=By.xpath("//*[@class='dscHeaderMain__iconMenu']");
	final By myVideos=By.xpath("//span[contains(text(),'My Videos')]");
	final By cancelIcon=By.xpath("//i[@class='icon-x searchInput__iconCancel']");
	@Override
	protected void load() {
		logger.debug("AllShowsPage {} load() \", this.getClass().getName()");

	}

	@Override
	protected void isLoaded() throws Error {
		logger.debug("AllShowsPage {} isLoaded() ", this.getClass().getName());
		this.init();

	}

	public void clickSeacrchIcon() {
		isDisplayed(hdrSeacrhIcon);
		click(hdrSeacrhIcon, TimeEntity.SEC_10.getSeconds());

	}

	public void enterTextToSearchShow(String showsTitle) {
		findElementThatIsVisibale(txtSearch, TimeEntity.SEC_30.getSeconds());
		type(showsTitle, txtSearch);
		TimeEntity.SEC_30.getSeconds();
		findElement(txtSearch).sendKeys(Keys.SPACE);
		TimeManager.waitInSeconds(10);
	}

	public void clickOnSearchedShows(String showsTitle)  {

		WebElement searchArea=findElement(lnkTosearch);
		List<WebElement> allTitleShows=searchArea.findElements(By.tagName("a"));
		for(int i=1; i<allTitleShows.size();i++) {
			String link=allTitleShows.get(i).getAttribute("href");
			((JavascriptExecutor)driver).executeScript("window.open();");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(link);
			TimeManager.waitInSeconds(10);
			jsScroll(0, -1500);
			String title=driver.getTitle();
			if(!(title.matches(showsTitle))) {
				TimeManager.waitInSeconds(5);
				WebElement plusIconEle=findElement(plusIcon);
				click(plusIconEle);
			}
			else {
				TimeManager.waitInSeconds(5);
				WebElement minusIconEle=findElement(minusIcon);
				click(minusIconEle);
			}
			driver.close();
			driver.switchTo().window(tabs.get(0));

		}
	}
	public void verifyMyVideosFavoriteShows() {
		WebElement cancelIconEle=findElement(cancelIcon);
		click(cancelIconEle);
		WebElement hdrIconEle=findElement(hdrMainIcon);
		click(hdrIconEle);
		WebElement myVideosEle=findElement(myVideos);
		click(myVideosEle);
		jsScroll(0, 500);

	}

}







