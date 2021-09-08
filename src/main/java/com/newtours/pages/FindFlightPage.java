package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (name = "reserveFlights")
    private WebElement reserveFlightsbtn;

    @FindBy(name = "buyFlights")
    private WebElement billingAdressbtn;

    public FindFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void PressContinueReserve (){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsbtn));
        this.reserveFlightsbtn.click();
    }

    public void PressContinueBilling (){
        this.wait.until(ExpectedConditions.visibilityOf(this.billingAdressbtn));
        this.billingAdressbtn.click();
    }
}
