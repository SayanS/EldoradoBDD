package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public class PageHeader extends BasePage {
    private Browser browser;
    private WebDriver webDriver;

    public PageHeader(Browser browser){
        super(browser);
        this.browser=browser;
        this.webDriver=this.browser.webDriver;
    }

    public final String SEARCH_FIELD=".//div[@class='header-content desktop-header']//input";
}
