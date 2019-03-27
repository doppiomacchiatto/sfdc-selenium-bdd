package sfdc.selenium.bdd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ApplicationUtil {
	public HashMap<String, String> loadProps() {
		HashMap<String, String> propsMap = new HashMap<String, String>();

		Properties prop = new Properties();
		InputStream input = null;

		try {
			String filename = "application.properties";
			input = ApplicationUtil.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				throw new IOException("Unable to load File");
			}
			// load a properties file
			prop.load(input);

			// get the property value
			propsMap.put("username", prop.getProperty("username"));
			propsMap.put("password", prop.getProperty("password"));
			propsMap.put("url", prop.getProperty("url"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propsMap;

	}

}
