package functional.pages;

import org.openqa.selenium.WebDriver;

public class ProductDetails extends BasePage {

	public ProductDetails(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "DanMurphy's Online page";
	}
}
