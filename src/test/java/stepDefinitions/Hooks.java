package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Browser;

public class Hooks {
    private Browser browser;

    public Hooks(Browser browser){
        this.browser=browser;
    }

    @Before
    public void setUp(){
        browser.webDriver=new ChromeDriver();
      //  browser.webDriver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        browser.webDriver.quit();
    }


}
