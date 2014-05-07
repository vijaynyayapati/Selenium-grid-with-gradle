package functional.providers;

import functional.config.Configuration;

public class OS {
	public static String getOsName() {
		return System.getProperties().getProperty("os.name",
				Configuration.DEFAULT_OS);
	}

	public static boolean isWindows() {
		return getOsName().startsWith("Windows");
	}

	public static boolean isLinux() {
		return getOsName().startsWith("Linux");
	}
	
	public static boolean isOSX() {
		return getOsName().startsWith("Mac OS X");
	}
}
