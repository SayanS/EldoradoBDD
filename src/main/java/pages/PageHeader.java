package pages;

import org.openqa.selenium.WebDriver;

public class PageHeader extends BasePage {
    private WebDriver webDriver;

    public PageHeader(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

    public final String SEARCH_FIELD=".//div[@class='header-content desktop-header']//input";
}
