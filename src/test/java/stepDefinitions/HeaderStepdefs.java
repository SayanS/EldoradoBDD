package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import steps.HeaderSteps;
import steps.HomePageSteps;
import steps.SelectCityPopUpSteps;

public class HeaderStepdefs {

    private HeaderSteps headerSteps;
    private HomePageSteps homePageSteps;
    private SelectCityPopUpSteps selectCityPopUpSteps;

    public HeaderStepdefs(HeaderSteps headerSteps, HomePageSteps homePageSteps, SelectCityPopUpSteps selectCityPopUpSteps){
        this.headerSteps=headerSteps;
        this.homePageSteps=homePageSteps;
        this.selectCityPopUpSteps=selectCityPopUpSteps;
    }

    @Then("^Enter \"([^\"]*)\" into Global Search field$")
    public void enterIntoGlobalSearchField(String searchText) throws Throwable {

    }

    @Then("Selected city \"([^\"]*)\" should be displayed in Header menu$")
    public void selectedCityShouldBeDisplayedInHeaderMenu(String cityName){
      headerSteps.isCityDisplayedInHeaderMenu(cityName);
    }

    @Then("^Notification message \"([^\"]*)\" should be displayed$")
    public void notificationMessageShouldBeDisplayed(String message){
        headerSteps.isNotificationDisplayed(message);
    }

    @Then("^First item of the Autosuggest list of the Header Search should be$")
    public void firstItemOfTheAutosuggestListOfTheHeaderSearchShouldBe(DataTable autosuggestLine){
        headerSteps.isFirstItemOfAutosuggestListEqualTo(autosuggestLine);
    }
}
