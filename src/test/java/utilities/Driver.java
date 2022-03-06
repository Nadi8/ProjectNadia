package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	// declaring WebDriver but its value is null
	public static WebDriver driver;

	// initializing WebDriver
	public static WebDriver getDriver() {
		// if else statement allows not to repeat
		if (driver == null) {
			// switch statement calling browser from configuration properties file
			switch (ConfigurationReader.getProperty("browser")) {

			case "firefox":
				// code
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				// initializes the pages by calling them
				PageInitializer.initialize();
				break;
			case "chrome":
				// code to setup Boni Garcia
				WebDriverManager.chromedriver().setup();
				// we declare
				driver = new ChromeDriver();

				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				// initializes the pages by calling them
				PageInitializer.initialize();

				break;
			case "edge":
				// code
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				// initializes the pages by calling them
				PageInitializer.initialize();

				break;
			case "headless":
				// code
				break;

			} // switch

		} // end of 'if else'
			// return driver
		return driver;
	} // end of getDriver method

	//
	public static void quitDriver() {
		if (driver != null) {
			driver.close();
			driver = null;
		}

	}

} // end of class
