package com.duckduckgo.pages;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VideoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (partialLinkText = "Videos")
    private WebElement videosLink;

    @FindBy (className = "tile--vid")
    private List<WebElement>  videos;

    public VideoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getVideosNumber(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return this.videos.size();
    }

}
