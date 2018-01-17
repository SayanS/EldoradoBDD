package pages;


import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        // PageFactory.initElements(this.webDriver, this);
    }

    public WebElement findBy(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    public void clickOnJS(String xpath) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", findBy(xpath));
    }

    public void scrollIntoView(String xpath, int offset_y) {
        int y = webDriver.findElement(By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, " + y + ")");
    }

    public void scrollIntoView(String xpath) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0)");
    }

    public WebElement moveTo(String xpath){
        Actions actions=new Actions(webDriver);
        actions.moveToElement(findBy(xpath)).perform();
        return  findBy(xpath);
    }

    public void clickOn(String xpath) {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS,3);
        findBy(xpath);
    }

    public <V> V waitFor(Function<? super WebDriver,V> condition, TimeUnit timeUnit, int timeout){
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(timeout, timeUnit)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class).
                            pollingEvery(500, TimeUnit.MILLISECONDS);
            return wait.until(condition);
        } catch (TimeoutException e) {
            System.out.println("Element hasn't been found:TIMEOUT EXCEPTION");
            return null;
        }
    }


}
