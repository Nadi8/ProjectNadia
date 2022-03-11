package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	
			static Properties property;

			
			static {

				try {
					
					String filePath = "src\\test\\resources\\testData\\configuration.properties";
					FileInputStream input = new FileInputStream(filePath);
					
					property = new Properties();

					property.load(input);

					input.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			} 
			
			public static String getProperty(String keyName) {
				return property.getProperty(keyName);
				
				
			}

		} 
