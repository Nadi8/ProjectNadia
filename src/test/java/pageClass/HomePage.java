package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {

	public HomePage(){
		
		PageFactory.initElements(Driver.getDriver(), this);
			
	}
	
	@FindBy(name="q")
	public WebElement searchInput;
	
	
	
	
	
}
