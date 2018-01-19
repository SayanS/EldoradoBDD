package stepDefinitions;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.User;
import steps.HeaderSteps;
import steps.HomePageSteps;
import utils.GenerateUniqueEmail;

import java.util.List;

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

    @Given("^User credentials$")
    public void userCredentialsAnd(List<User> user) {
       homePageSteps.printUserCredentials(user.get(0));
    }

    @Then("^Change user \"([^\"]*)\" to unique value$")
    public void changeUserToUniqueValue(@Transform(GenerateUniqueEmail.class) String email) {
        System.out.println(email);
    }
}
