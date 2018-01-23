package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public class Home extends Header {
    private String URL = "https://eldorado.ua/";
    private Browser browser;
    private WebDriver webDriver;

    public Home(Browser browser) {
        super(browser);
        this.browser=browser;
        webDriver = browser.webDriver;
    }

    public void open() {
        webDriver.navigate().to(URL);
    }

}
