package com.oddsking.taskhelpers;

import com.oddsking.browserfactory.DriverHelpers;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


public class TaskHelpers extends DriverHelpers {
    public static Actions actions;
    public static JavascriptExecutor js;


    public static void applyActions() {
        actions = new Actions(driver);
    }

    public static WebDriverWait explicitWait(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait;
    }

    public static void customWait(long miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollByJavaScriptExecutor(int y, int x) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + y + "," + x + ")");
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 10000 + 1);
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

}

