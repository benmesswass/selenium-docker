package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        //BROWSER => chrome / firefox
        //HUB_HOST => localhost / :10.0.1.3 / hostname
        String host = "localhost";
        DesiredCapabilities dc;

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("firefox")){
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://"+ host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver (new URL(completeURL), dc);
    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}
