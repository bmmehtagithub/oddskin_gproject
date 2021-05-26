package com.oddsking.hooks;

import com.oddsking.browserfactory.DriverHelpers;
import com.oddsking.taskhelpers.TaskHelpers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {


    private DriverHelpers driverHelpers = new DriverHelpers();

    @Before
    public void setUp() {
        driverHelpers.openBrowser();
        driverHelpers.deletecoockies();
        driverHelpers.maximiseBrowser();
        driverHelpers.applyImpWaits();
    }
    @After
    public void tearDown(Scenario scenario) {
        TaskHelpers.customWait(4000);
        driverHelpers.closeBrowser();
        }

}


