package com.duckduckvideo.pages;

import com.duckduckgo.pages.VideoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.WebEndpoint;

public class VideoClick {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (name = "q")
    private WebElement searchField;

    @FindBy (partialLinkText = "Vidéos")
    private WebElement videoLink;

    public void goTo(){
        this.driver.get("https://duckduckgo.com/?q=java&t=hx&va=g&ia=web");
        this.wait.until(ExpectedConditions.visibilityOf(this.searchField));
    }

    public VideoClick(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void clickonVideoBtn(){
        this.videoLink.click();
    }
}
