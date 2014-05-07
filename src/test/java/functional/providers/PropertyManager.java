package functional.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {

	private Properties properties = new Properties();
	private PropertyManager props;

	@SuppressWarnings("serial")
	private static final Map<String, String> TYPE_TO_FACTORY_MAP = new HashMap<String, String>() {
		{
			put("Windows", "/windows.properties");
			put("Linux", "/linux.properties");
			put("Mac OS X", "/osx.properties"); 
		}
	};
	
	public Properties loadProperties() throws IOException {
		FileInputStream fis = null;
			try {
				fis = new FileInputStream(getWorkingDirectory()
						+ TYPE_TO_FACTORY_MAP.get(OS.getOsName()));
				properties.load(fis);
			} catch (FileNotFoundException ex) {
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
		return properties;
	}

	public String getAbsolutePathForProperty(String key) throws IOException {
		return getWorkingDirectory() + getPropertyValue(key);
	}

	public String getPropertyValue(String key) throws IOException {
		props = new PropertyManager();
		return props.loadProperties().getProperty(key);
	}

	private static String getWorkingDirectory() {
		return System.getProperty("user.dir");
	}
}
