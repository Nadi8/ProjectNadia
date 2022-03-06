package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	//configurationReader = default value is null 
			static Properties property;

			//"try catch" opens and loads data 
			static {

				try {
					//this is declaring/telling the path of the properties file 
					String filePath = "src\\test\\resources\\testData\\configuration.properties";
					FileInputStream input = new FileInputStream(filePath);
					
					property = new Properties();

					property.load(input);

					input.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			} // closing static bracket 
			
			public static String getProperty(String keyName) {
				return property.getProperty(keyName);
				
				
			}

		} // class level 
