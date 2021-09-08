package com.duckduckvideo.tests;

import com.duckduckvideo.pages.VideoClick;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuckDuckVideoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\benme\\docker-udemy\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void videoClick (){
        VideoClick videoClick = new VideoClick(driver);
        videoClick.goTo();
        videoClick.clickonVideoBtn();
    }

    //@AfterTest
    //public void quitBrowser(){
     //   this.driver.quit();
    //}

}
