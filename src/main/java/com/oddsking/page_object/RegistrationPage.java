package com.oddsking.page_object;

import com.oddsking.browserfactory.DriverHelpers;
import com.oddsking.taskhelpers.TaskHelpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends DriverHelpers {
    int number = TaskHelpers.generateRandomNumber();
    public String randomStringIs = TaskHelpers.getRandomString(3);
    public String emailId="bhavin.m.mehta" + randomStringIs + number + "@gmail.com";
    public String userName="bhavinmehta" + randomStringIs + number;
    public String password="Admin" + randomStringIs + number;
    public String nameAndLastName = "Bhavin" + randomStringIs + randomStringIs;

    @FindBy(css="button[class='_1b70e9te']")
    WebElement cookiesContinue;
    @FindBy(xpath="//a[@href='/registration']")
    WebElement joinButton;
    @FindBy(css="input[id*='email']")
    WebElement emailField;
    @FindBy(xpath="//input[@name='username']")
    WebElement userNameField;
    @FindBy(css="input[type='password']")
    WebElement passwordField;
    @FindBy(css="div._1736bqa")
    WebElement checkBox;
    @FindBy(css="button[tabindex$='5']")
    WebElement accountContinueButton ;
    @FindBy(css="button[name='Mrs']")
    WebElement title;
    @FindBy(css="input[name='firstName']")
    WebElement firstName;
    @FindBy(css="input[name='lastName']")
    WebElement lastName;
    @FindBy(css="input[placeholder='DD']")
    WebElement dateOfBirth;
    @FindBy(css="input[placeholder='MM']")
    WebElement monthOfBirth;
    @FindBy(css="input[placeholder='YYYY']")
    WebElement yearOfBirth;
    @FindBy(css="button._nljctal")
    WebElement personalContinueButton;
    @FindBy(xpath="//input[@id='RegistrationPage.TelephoneNumberInput.telephone.desktop-telephone']")
    WebElement telePhoneNumber;
    @FindBy(css="select[name^='desktop-securityQuestion']")
    WebElement securityQuestion;
    @FindBy(css="input[name*='desktop-securityAnswer']")
    WebElement securityAnswer;
    @FindBy(css="div[class='_lhb3i8'] button[class='_nljctal']")
    WebElement contactContinueButton;
    @FindBy(css="#search")
    WebElement addressSearch;
    @FindBy(css="span[class='pcadescription']")
    WebElement addresses;
    @FindBy(css="button[tabindex='4']")
    WebElement addressContinueButton;
    @FindBy(xpath="//div[@class='_19fmlyg7']/label[@for='firstParty-Receive No Marketing-checkbox']")
    WebElement firstPartyNoMarketing;
    @FindBy(css="label[for='thirdParty-Receive No Marketing-checkbox'] div[class='_1736bqa']")
    WebElement thirdPartyNoMarketing;
    @FindBy(css="button[class='_nljctal']")
    WebElement registrationButton;
    @FindBy(css="h5[data-actionable='RegistrationPage.RegistrationSuccess.desktop.thanks_header']")
    WebElement message;
    @FindBy(css="button[data-actionable='RegistrationPage.RegisterHeader.desktop.close']")
    WebElement crossButton;
    @FindBy(css="span[aria-label='Account']")
    WebElement poundButton;
    @FindBy(xpath="//span[normalize-space()='Log Out']")
    WebElement logoutButton;

    public RegistrationPage(){
        PageFactory.initElements(driver,this);
    }
    public void registration(){
        cookiesContinue.click();
        joinButton.click();
        emailField.sendKeys(emailId);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        checkBox.click();
        TaskHelpers.customWait(3000);
        accountContinueButton.click();
        title.click();
        firstName.sendKeys(nameAndLastName);
        lastName.sendKeys(nameAndLastName);
        dateOfBirth.sendKeys("20");
        monthOfBirth.sendKeys("01");
        yearOfBirth.sendKeys("2000");
        personalContinueButton.click();
        telePhoneNumber.click();
        telePhoneNumber.sendKeys("01234567890");
        new Select(securityQuestion).selectByValue("Your mother's maiden name?");
        securityAnswer.sendKeys(randomStringIs);
        TaskHelpers.customWait(2000);
        contactContinueButton.click();
        addressSearch.click();
        addressSearch.sendKeys("wd25 9bh");
        TaskHelpers.customWait(2000);
        addresses.click();
        addressContinueButton.click();
        firstPartyNoMarketing.click();
        thirdPartyNoMarketing.click();
        TaskHelpers.scrollByJavaScriptExecutor(0,1000);
        registrationButton.click();
    }
    public String conformationRegistration(){
        String joiningMessages = message.getText();
        System.out.println(joiningMessages);
        return joiningMessages;
    }
    public void clickRossButton(){
        crossButton.click();
    }

}
