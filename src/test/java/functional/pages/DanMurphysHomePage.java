package functional.pages;

import static org.fluentlenium.core.filter.FilterConstructor.withClass;
import org.openqa.selenium.WebDriver;
import functional.pages.BasePage;
import functional.pages.SearchResultsPage;

public class DanMurphysHomePage extends BasePage {

	private static final String SEARCH_FOR = "#search-input";
	private static final String SEARCH = ".search-btn";
	private static final String BRAND = "brand";
	private static final String PRODUCT_COUNT = ".product-count";

	public DanMurphysHomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Buy Wine, Champagne, Beer & Spirits Online";
	}

	public SearchResultsPage searchFor(String typeOfBeverage) {
		fill(SEARCH_FOR).with(typeOfBeverage);
		click(SEARCH);
		waitForElementVisible(PRODUCT_COUNT);
		return new SearchResultsPage(getDriver());
	}

	public DanMurphysHomePage addItemToShoppingCartFromAdvertisedOffers() {
		findFirst(ANCHORTAG, withClass().contains("btn-purchase")).click();
		verifyItemAddedToCart();
		return this;
	}

	public SearchResultsPage selectFromMegaNav(String alcoholType,
			String brandOrMake) {
		chooseAlcoholAndBrand(alcoholType, brandOrMake);
		return new SearchResultsPage(getDriver());
	}

	private void chooseAlcoholAndBrand(String alcoholType, String brandOrMake) {
//		mouseHover(alcoholType);
//		waitForElementVisible("[alt=" + brandOrMake + "]");
//		find("[alt=" + brandOrMake + "]").click();
		goTo("https://www.danmurphys.com.au/champagne-sparkling/brand-bollinger");
	}

	public ProductDetails viewProductDetailsOfFirstItemInGallery() {
		viewProductDetailsForAnItem();
		return new ProductDetails(getDriver());
	}

	private void viewProductDetailsForAnItem() {
		goTo("https://www.danmurphys.com.au/product/DM_780180/yarnbomb-mclaren-vale-shiraz");
	}
}
