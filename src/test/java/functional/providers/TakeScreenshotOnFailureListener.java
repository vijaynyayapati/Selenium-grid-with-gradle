package functional.providers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshotOnFailureListener extends TestWatcher {
	protected WebDriver _driver;
	private static final String pathToScreenshotDirForWindows = "\\build\\";
	private static final String pathToScreenshotDirForMacAndLinux = "//build//";
	
	protected String screenshotDirectory = System.getProperty("user.dir")
			+ getScreenShotDirectory().get(OS.getOsName());
	
	
	public Map<String, String> getScreenShotDirectory(){
		Map<String, String> pathToScreenshotDir = new HashMap<String, String>();
		pathToScreenshotDir.put("Windows XP", pathToScreenshotDirForWindows);
		pathToScreenshotDir.put("Mac OS X", pathToScreenshotDirForMacAndLinux);
		pathToScreenshotDir.put("Linux", pathToScreenshotDirForMacAndLinux);
		return pathToScreenshotDir;
	}
	
	@Override
	protected void failed(Throwable e, Description description) {
		super.failed(e, description);
		try {
			silentlySaveScreenshotWith(description);
		} catch (Exception ex) {
			System.err.println("Can't save screenshot to "
					+ screenshotDirectory + ", " + ex);
		}
	}

	private void silentlySaveScreenshotWith(Description description) {
		try {
			FileUtils.copyFile(grabScreenshot(), new File(screenshotDirectory
					+ getTestName(description)));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private File grabScreenshot() {
		File screenshot = ((TakesScreenshot) _driver)
				.getScreenshotAs(OutputType.FILE);
		return screenshot;
	}

	private String getTestName(Description description) {
		String name = description.getMethodName();
		name = name + ".png";
		return name;
	}

	@Override
	protected void finished(Description description) {
		_driver.manage().deleteAllCookies();
	}
}