package stepDefinitions;

import cucumber.api.Scenario;
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
    public void setUp(Scenario scenario){
        browser.webDriver=new ChromeDriver();
        System.out.println("_____________________________________________");
        System.out.println(scenario.getName());
      //  browser.webDriver.manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario){
        browser.webDriver.quit();
    }


}
