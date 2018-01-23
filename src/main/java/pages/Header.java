package pages;

import models.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Header extends BasePage {
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



}
