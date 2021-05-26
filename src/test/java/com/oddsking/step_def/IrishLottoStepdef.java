package com.oddsking.step_def;

import com.oddsking.page_object.HomePage;
import com.oddsking.page_object.IrishLottoResultPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class IrishLottoStepdef {
    IrishLottoResultPage irishLottoResultPage=new IrishLottoResultPage();


    @When("User click on result and select date and click filter button")
    public void user_click_on_result_and_select_date_and_click_filter_button() {

        irishLottoResultPage.lottoresutSelection();
    }

    @Then("User can see result between selected date")
    public void user_can_see_result_between_selected_date() {
     irishLottoResultPage.assertionOfResult();
    }
}
