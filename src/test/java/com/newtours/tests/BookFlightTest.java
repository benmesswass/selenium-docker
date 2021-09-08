package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String nbOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"nbOfPassengers", "expectedPrice"})
    public void setupParameters(String nbOfPassengers, String expectedPrice){
        this.nbOfPassengers = nbOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserElements("selenium","docker");
        registrationPage.enterUserCredentials("selenium","docker");
        registrationPage.submit();
    }

    @Test (dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test (dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(nbOfPassengers);
        flightDetailsPage.PressContinue();
    }

    @Test (dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.PressContinueReserve();
        findFlightPage.PressContinueBilling();
    }

    @Test (dependsOnMethods = "findFlightPage")
    public void flightConfirmation() {
        FlightConfirmation flightConfirmation = new FlightConfirmation(driver);
        String actualPrice = flightConfirmation.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
