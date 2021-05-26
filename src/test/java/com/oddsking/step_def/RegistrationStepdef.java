package com.oddsking.step_def;

import com.oddsking.page_object.HomePage;
import com.oddsking.page_object.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationStepdef {
    HomePage homepage=new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();



    @Given("User is on homepage {string}")
    public void user_is_on_homepage(String url) {
        homepage.homepageNavigate(url);
    }

    @When("User enter details for registration")
    public void user_enter_details_for_registration() {

        registrationPage.registration();
    }

    @Then("User can see thanks for joining message")
    public void user_can_see_thanks_for_joining_message() {
        String joinMessage=registrationPage.conformationRegistration();
        Assert.assertTrue(joinMessage.contains("thanks for joining "));
        Assert.assertTrue(joinMessage.contains(registrationPage.nameAndLastName));
        registrationPage.clickRossButton();
    }
}
