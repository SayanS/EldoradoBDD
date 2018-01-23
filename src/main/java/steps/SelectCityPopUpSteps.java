package steps;

import org.junit.Assert;
import pages.SelectCityPopUp;

public class SelectCityPopUpSteps {
    SelectCityPopUp selectCityPopUp;

    public SelectCityPopUpSteps(SelectCityPopUp selectCityPopUp){
        this.selectCityPopUp=selectCityPopUp;
    }

    public void clickOnButton(String buttonName) {
        selectCityPopUp.clickOnByXpath(selectCityPopUp.YES_NO_CONFIRM_CITY_BUTTONS,buttonName);
    }

    public void enterCityName(String text) {
        selectCityPopUp.enterValueIntoField(selectCityPopUp.INPUT_CITY,text);
    }

    public void isEachContextCityStartsWith(String text) {
        selectCityPopUp.getListOfContextCities().forEach(cityName->Assert.assertTrue(cityName.startsWith(text)));
    }

    public void selectCity(String cityName) {
        selectCityPopUp.clickOnByXpath(selectCityPopUp.CITY_LINK,cityName);
    }


}
