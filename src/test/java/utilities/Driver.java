package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	
	public static WebDriver driver;

	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			switch (ConfigurationReader.getProperty("browser")) {

			case "firefox":
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				PageInitializer.initialize();
				break;
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				
				driver = new ChromeDriver();

				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				PageInitializer.initialize();

				break;
			case "edge":
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				PageInitializer.initialize();

				break;
			case "headless":
				
				break;

			} 

		} 
			
		return driver;
	} 

	
	public static void quitDriver() {
		if (driver != null) {
			driver.close();
			driver = null;
		}

	}

} 
