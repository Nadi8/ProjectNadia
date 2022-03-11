package interviewSpiral;

import org.openqa.selenium.Keys;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonMethods;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SearchGoogle extends CommonMethods {

	@Before
	public void openBrowser() {

		Driver.getDriver();
		hp.searchInput.clear();

	}

	
	@Test
	public void searchDucks() {
		String expectedURL = "https://www.google.com/";
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.equals(expectedURL));
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);

		String resultURL = driver.getCurrentUrl();	
		Assert.assertTrue(resultURL.contains("Ducks"));
		

	}


	@Test
	public void searchDucks2() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);
		String expectedTitle = "Ducks - Google Search";
		String title = driver.getTitle();
		Assert.assertEquals(expectedTitle, title);
		Assert.assertTrue(title.contains("Ducks"));
		

	}

	
	@Test
	public void searchDucks3() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);
		CommonMethods.getWaitObject();
		CommonMethods.waitForVisibility(rp.resultStatsMsg);
		Assert.assertTrue(rp.resultStatsMsg.isDisplayed());
		
	}

	
	@Test
	public void searchDucks4() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItemExtraSpace"), Keys.ENTER);
		CommonMethods.getWaitObject();
		CommonMethods.waitForVisibility(rp.didYouMeanMsg);
		Assert.assertTrue(rp.didYouMeanMsg.getText().contains("Ducks"));
		
	}

	
	@Test
	public void searchDucks5() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItemSpellingError"), Keys.ENTER);
		CommonMethods.getWaitObject();
		CommonMethods.waitForVisibility(rp.searchInsteadMsg);
		Assert.assertTrue(rp.searchInsteadMsg.isDisplayed());
		
	}

	@Test
	public void searchDucks6() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);
		String resultURL = driver.getCurrentUrl();
		int size = rp.searchLinks.size();
		for (int i = 0; i < rp.searchLinks.size(); i++) {
			String linkText = rp.searchLinks.get(i).getText();
			if (linkText.contains("Ducks")) {
				rp.searchLinks.get(i).click();

			}
		}

//		String newURL = driver.getCurrentUrl();
//		Assert.assertTrue(!newURL.equals(resultURL));
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Driver.getDriver().navigate().back();
		

	}

//	@After
//	public void closeBrowser() {
//		Driver.quitDriver();
//	}
}