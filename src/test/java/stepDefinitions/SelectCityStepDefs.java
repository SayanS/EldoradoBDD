package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.SelectCityPopUpSteps;

public class SelectCityStepDefs {
    private SelectCityPopUpSteps selectCityPopUpSteps;

    public SelectCityStepDefs(SelectCityPopUpSteps selectCityPopUpSteps){
        this.selectCityPopUpSteps=selectCityPopUpSteps;
    }

    @When("^Click on \"([^\"]*)\" button of Select city pop-up$")
    public void clickOnButtonOfSelectCityPopUp(String buttonName){
        selectCityPopUpSteps.clickOnButton(buttonName);
    }

    @When("^Enter \"([^\"]*)\" into City name field on Select city pop-up$")
    public void enterIntoCityNameFieldOnSelectCityPopUp(String text){
      selectCityPopUpSteps.enterCityName(text);
    }

    @Then("^Each context city on Select city pop-up should start with \"([^\"]*)\"$")
    public void eachContextCityOnSelectCityPopUpShouldStartWith(String text)  {
       selectCityPopUpSteps.isEachContextCityStartsWith(text);
    }
}
