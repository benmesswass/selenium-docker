package com.duckduckgo.tests;

import com.duckduckgo.pages.SearchPage;
import com.duckduckgo.pages.VideoPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuckduckGoTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchPage(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.typeSearch(keyword);
    }

    @Test (dependsOnMethods = "searchPage")
    public void videoPage() {
        VideoPage videoPage = new VideoPage(driver);
        videoPage.clickVideos();
        int size = videoPage.getVideosNumber();

        Assert.assertTrue(size > 0);
    }

}
