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

	Actions action = new Actions(Driver.getDriver());

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
//		System.out.println(resultURL);
		Assert.assertTrue(resultURL.contains("Ducks"));
		System.out.println("End of Test 1");

	}

	@Test
	public void searchDucks2() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);
		CommonMethods.getWaitObject();
		CommonMethods.waitForVisibility(rp.firstResult);
		System.out.println(rp.firstResult.getText());

		Assert.assertTrue(rp.firstResult.getText().contains("Ducks"));
		System.out.println("End of Test 2");
	}

	@Test
	public void searchDucks3() {
		hp.searchInput.sendKeys(ConfigurationReader.getProperty("searchItem"), Keys.ENTER);
		
		String title=driver.getTitle();
		
		System.out.println("resultTitle"+title);

		for (int i = 0; i < rp.searchLinks.size(); i++) {
			String linkText = rp.searchLinks.get(i).getText();
			System.out.println(linkText);
			if (linkText.contains("Ducks")) {
				rp.searchLinks.get(i).click();

			}
		}

		String resultNewTitle=driver.getTitle();
		System.out.println("ResultNewURL"+resultNewTitle);
		Assert.assertTrue(resultNewTitle.equals(resultNewTitle));
		System.out.println("End of Test 3");
	}

//	@After
//	public void closeBrowser() {
//		Driver.quitDriver();
//	}
}