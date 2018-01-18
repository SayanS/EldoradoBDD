package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageHeader {
    private String URL = "https://eldorado.ua/";
    private Browser browser;
    private WebDriver webDriver;

    public HomePage(Browser browser) {
        super(browser);
        this.browser=browser;
        webDriver = browser.webDriver;
    }

    public HomePage open() {
        webDriver.navigate().to(URL);
        return new HomePage(browser);
    }

}