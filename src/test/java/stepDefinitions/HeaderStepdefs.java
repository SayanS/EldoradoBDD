package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import steps.HeaderSteps;
import steps.HomePageSteps;

public class HeaderStepdefs {

    private HeaderSteps headerSteps;
    private HomePageSteps homePageSteps;

    public HeaderStepdefs(HeaderSteps headerSteps, HomePageSteps homePageSteps){
        this.headerSteps=headerSteps;
        this.homePageSteps=homePageSteps;
    }

    @Then("^Enter \"([^\"]*)\" into Global Search field$")
    public void enterIntoGlobalSearchField(String searchText) throws Throwable {
        throw new PendingException();
    }
}
