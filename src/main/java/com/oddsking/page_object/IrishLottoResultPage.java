package com.oddsking.page_object;

import com.oddsking.browserfactory.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class IrishLottoResultPage extends DriverHelpers {
    static int currentDay;
    static int targetDay;
    static int currentMonth;
    List<Integer>actualList;

    @FindBy(css = "a[class='_ornm4v']")
    WebElement resultButton;
    @FindBy(css = "div[class='_sbhwlz9'] div[class='_1pgebc1']")
    WebElement fromDateBox;
    @FindBy(css = "button[class='_wwwszdf']")
    WebElement fromDoneButton;
    @FindBy(css = "button[class='_yavddls']")
    WebElement viewFilterResult;

    public IrishLottoResultPage() {
        PageFactory.initElements(driver, this);
    }

    public  List<Integer> lottoresutSelection() {
        resultButton.click();
        fromDateBox.click();
        getCurrentDateMonthAndYear();
        targetDay = currentDay - 07;
        System.out.println(currentDay);
        System.out.println(targetDay);
        String daySelect = Integer.toString(targetDay);
        List<WebElement> selectDates = driver.findElements(By.xpath("//div[@class='react-calendar__month-view__days']/button"));
        for (WebElement selectDate : selectDates) {
            if (selectDate.getText().contains(daySelect)) {
                selectDate.click();
                break;
            }
        }
        fromDoneButton.click();
        viewFilterResult.click();
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
        List<WebElement> mainDrawDates=driver.findElements(By.xpath("//div[@class='_1sjkz1w']/div/div[@class='_5ubxge']"));
        List<String> collectedDates=new ArrayList<String>();
        for (int i = 0; i <mainDrawDates.size() ; i++) {
            System.out.println(mainDrawDates.get(i).getText());
            collectedDates.add(mainDrawDates.get(i).getText().toString().substring(0,2));
        }
        System.out.println(collectedDates);
        actualList=new ArrayList<Integer>();
        for (int i = 0; i <collectedDates.size() ; i++) {
            actualList.add(Integer.parseInt(collectedDates.get(i)));
        }
        System.out.println(actualList);
        return actualList;
    }
    public void assertionOfResult(){
        for (int i = 0; i <actualList.size() ; i++) {
            int dateInt=actualList.get(i);
            assertTrue(dateInt>=targetDay);
            assertTrue(dateInt<=currentDay);
        }
    }


    public static void getCurrentDateMonthAndYear(){
        Calendar calendar = Calendar.getInstance();
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH) + 1;
    }
}