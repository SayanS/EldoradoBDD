package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public abstract class Header extends BasePage {
    private Browser browser;
    private WebDriver webDriver;

    public Header(Browser browser){
        super(browser);
        this.browser=browser;
        this.webDriver=this.browser.webDriver;
    }

    public final String SEARCH_FIELD=".//div[@class='header-content desktop-header']//input";
    public final String SELECTED_CITY=".//ul[@class='header-navigation']/li/div/span";
    public final String NOTIFICATION_SELECTED_CITY=".//div[contains(@class,'notification-visible')]/div";
    public final String BUTTON=".//ul[@class='react-autosuggest__suggestions-list']//*[.='$KeyWord']";
    public final String SHOW_ALL_SEARCH_RESULTS_BUTTON=".//div[@class='search-auto-item show-all']/span";

    public void clickOnShowAllButton() throws InterruptedException {
        Thread.sleep(2000);
        findBy(SHOW_ALL_SEARCH_RESULTS_BUTTON).click();
    }
}
