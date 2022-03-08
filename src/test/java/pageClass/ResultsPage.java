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

	@FindBy(id = "result-stats")
	public WebElement resultStatsMsg;
	
	@FindBy(id = "oFNiHe")
	public WebElement didYouMeanMsg;

	@FindBy(xpath = "//*[contains(text(),'Search instead for')]")
	public WebElement searchInsteadMsg;

	@FindBy(xpath = "//*[@id='search']/div/div/div")
	public List<WebElement> searchLinks;

}
