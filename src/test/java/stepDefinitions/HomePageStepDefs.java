package stepDefinitions;

import cucumber.api.java.en.Given;
import steps.HeaderSteps;
import steps.HomePageSteps;

public class HomePageStepDefs {

    private HeaderSteps headerSteps;
    private HomePageSteps homePageSteps;

    public HomePageStepDefs(HeaderSteps headerSteps, HomePageSteps homePageSteps) {
        this.headerSteps=headerSteps;
        this.homePageSteps=homePageSteps;
    }

    @Given("^Home page is opened$")
    public void homePageIsOpened() throws Throwable {
        homePageSteps.open();
    }

}
