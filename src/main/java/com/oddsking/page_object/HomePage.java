package com.oddsking.page_object;

import com.oddsking.browserfactory.DriverHelpers;
import com.oddsking.taskhelpers.TaskHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverHelpers {




    public void homepageNavigate(String url){
        navigateToUrl(url);
        String currentUrlis= driver.getCurrentUrl();
        System.out.println(currentUrlis);
   }


}
