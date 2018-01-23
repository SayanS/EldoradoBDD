package pages;


import com.google.common.base.Function;
import models.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private WebDriver webDriver;
    private Browser browser;

    public BasePage(Browser browser) {
        this.browser=browser;
        webDriver = browser.webDriver;
        // PageFactory.initElements(this.webDriver, this);
    }

    protected WebElement findBy(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    protected WebElement find(By byXpath) {
        return webDriver.findElement(byXpath);
    }

    protected List<WebElement> findAllBy(String xpath){
        return webDriver.findElements(By.xpath(xpath));
    }

    protected List<String> getTextValuesFrom(List<WebElement> webElements){
        List<String> textValues=new ArrayList<>();
        webElements.forEach(webElement->textValues.add(webElement.getText()));
        return textValues;
    }

    public List<String> getTextValuesOf(String xpath){
        List<String> textValues=new ArrayList<>();
        findAllBy(xpath).forEach(webElement->textValues.add(webElement.getText()));
        return textValues;
    }

    public String getTextOf(String xpath){
        return findBy(xpath).getText();
    }

    public String getTextOf(String xpath, String keyWord){
        return getTextOf(xpath.replace("$KeyWord", keyWord));
    }

    public void clickOnByXpathJS(String xpath) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", findBy(xpath));
    }

    public void scrollIntoView(String xpath, int offset_y) {
        int y = webDriver.findElement(By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, " + y + ")");
    }

    public void scrollIntoView(String xpath) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0)");
    }

    protected WebElement moveTo(String xpath){
        Actions actions=new Actions(webDriver);
        actions.moveToElement(findBy(xpath)).perform();
        return  findBy(xpath);
    }

    public void clickOnByXpath(String xpath) {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS,3);
        scrollIntoView(xpath, -100);
        moveTo(xpath);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), TimeUnit.SECONDS,3);
        findBy(xpath).click();
    }

    public void clickOnByXpath(String xpath, String keyWord) {
        clickOnByXpath(xpath.replace("$KeyWord",keyWord));
    }

    protected <V> V waitFor(Function<? super WebDriver,V> condition, TimeUnit timeUnit, int timeout){
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

    public Boolean waitForTextToBePresentIn(String xpath, String text, Integer seconds) {
        return waitFor(ExpectedConditions.textToBePresentInElement(By.xpath(xpath),text), TimeUnit.SECONDS, seconds);
    }

    public Boolean waitForVisibilityOfElementLocatedByXpath(String xpath, Integer seconds) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, seconds);
        if(waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, seconds)!=null){
            return true;
        }
        return false;
    }

    public void enterValueIntoField(String xpath, String value){
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS,5);
        scrollIntoView(xpath);
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS,5);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), TimeUnit.SECONDS,3);
        findBy(xpath).sendKeys(value);
    }




}
