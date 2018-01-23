package steps;

import models.User;
import pages.Home;

import java.util.Arrays;
import java.util.HashSet;

public class HomePageSteps {

    Home homePage;

    public HomePageSteps(Home homePage){
        this.homePage=homePage;
    }

    public void open() {
        homePage.open();
    }

    public void printUserCredentials(User user) {
        User testUser=new User("test","password", new HashSet<String>(Arrays.asList("testSkill")));
        User secondTestUser=new User();
        secondTestUser=testUser;
        user.setSkills(testUser.getSkills());
        user.addSkill("Java+Junit+Cucumber");
        System.out.println(user.getLogin()+ " - "+user.getPassword()+" - "+user.getSkills());
    }
}
