package steps;

import org.junit.Assert;
import pages.SelectCityPopUp;

public class SelectCityPopUpSteps {
    SelectCityPopUp selectCityPopUp;

    public SelectCityPopUpSteps(SelectCityPopUp selectCityPopUp){
        this.selectCityPopUp=selectCityPopUp;
    }

    public void clickOnButton(String buttonName) {
        selectCityPopUp.clickOnButton(buttonName);
    }

    public void enterCityName(String text) {
        selectCityPopUp.enterValueIntoField(selectCityPopUp.INPUT_CITY,text);
    }

    public void isEachContextCityStartsWith(String text) {
        selectCityPopUp.getContextCities().forEach(cityName->Assert.assertTrue(cityName.startsWith(text)));
    }
}
