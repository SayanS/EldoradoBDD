package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageHeader {
    private String URL = "https://eldorado.ua/";
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public HomePage open() {
        webDriver.navigate().to(URL);
        return new HomePage(webDriver);
    }

}
