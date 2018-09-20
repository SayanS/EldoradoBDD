package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import models.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Hooks {
    private WebDriver webDriver;

    public Hooks(Browser browser) {
        this.webDriver = browser.getWebDriver();
    }

//    @Before
//    public void setUp(Scenario scenario) {
//      browser=new Browser();
//    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            makeScreenshot();
        }
        webDriver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return (((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
    }

//    @Attachment
//    public String performedActions(ActionSequence actionSequence) {
//        return actionSequence.toString();
//    }

}
