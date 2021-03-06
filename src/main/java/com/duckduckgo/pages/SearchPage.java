package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (name = "q")
    private WebElement searchtxt;

    @FindBy (id = "search_button_homepage")
    private WebElement searchBtn;

    public SearchPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void goTo (){
        this.driver.get("https://duckduckgo.com/");
    }

    public void typeSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchtxt));
        this.searchtxt.sendKeys(keyword);
        this.searchBtn.click();
    }

}
