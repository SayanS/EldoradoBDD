package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SelectCityPopUp extends BasePage {
    private Browser browser;
    private WebDriver webDriver;

    public SelectCityPopUp(Browser browser) {
        super(browser);
        this.browser=browser;
        this.webDriver = this.browser.webDriver;
    }

    public String BUTTON_XPATH = ".//div[@class='select-city-li']//*[contains(@class,'button') and .='$Name']";
    public String INPUT_CITY = ".//div[@class='city-select']//input[@class='react-autosuggest__input']";
    public String CONTEXT_CITIES = ".//ul[@class='city-select-content row']/li/div";

    public void clickOnButton(String name) {
        moveTo(BUTTON_XPATH.replace("$Name", name)).click();
    }

    public List<String> getContextCities() {
      return getTextValuesOf(CONTEXT_CITIES);
    }
}
