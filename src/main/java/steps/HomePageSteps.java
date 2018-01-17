package steps;

import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps(HomePage homePage){
        this.homePage=homePage;
    }

    public void open() {
        homePage.open();
    }

}
