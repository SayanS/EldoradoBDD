package stepDefinitions;

import cucumber.api.java.en.Then;
import steps.HeaderSteps;
import steps.HomePageSteps;
import steps.SearchResultsSteps;
import steps.SelectCityPopUpSteps;

public class SearchResultsStepDefs {
    private HeaderSteps headerSteps;
    private HomePageSteps homePageSteps;
    private SelectCityPopUpSteps selectCityPopUpSteps;
    private SearchResultsSteps searchResultsSteps;

    public SearchResultsStepDefs(HeaderSteps headerSteps, HomePageSteps homePageSteps, SelectCityPopUpSteps selectCityPopUpSteps, SearchResultsSteps searchResultsSteps){
        this.headerSteps=headerSteps;
        this.homePageSteps=homePageSteps;
        this.selectCityPopUpSteps=selectCityPopUpSteps;
        this.searchResultsSteps=searchResultsSteps;
    }

    @Then("^All descriptions of the products in Search results should contain \"([^\"]*)\"$")
    public void allDescriptionsOfTheProductsInSearchResultsShouldContain(String text) throws InterruptedException {
        searchResultsSteps.isEachProductDescriptionContain(text);
    }
}
