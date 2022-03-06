package pageClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ResultsPage {

	public ResultsPage() {

		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(xpath = "//*[@id='search']/div/div/div[1]")
	public WebElement firstResult;

	@FindBy(xpath = "//*[@ebates-serp-link='title']")
	public List<WebElement> searchResults;

	@FindBy(id = "rso")
	public List<WebElement> searchLinks;

	

	
}
