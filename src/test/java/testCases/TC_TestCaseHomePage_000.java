package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import pageObjectModel.homepage.*;
import pageObjectModel.platform.Platform;
import pageObjectModel.platform.PlatformFeature;

public class TC_TestCaseHomePage_000 extends BaseClass {

    HomePage homePage;
    HomepageKeyClients homepageKeyClients;
    HomepageDesginedForDevelopers homepageDesginedForDevelopers;
    HomepagePlatformFeatures homepagePlatformFeatures;
    HomepageWhyMachnet homepageWhyMachnet;
    HomepageLatestUpdates homepageLatestUpdates;


    @Test(priority = 1)
    public void verifyTitle() {
        String expectedTitle = "Machnet | License, Banking and Payment Processing for Cross Border Payments";
        String actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            logger.info("Title matched");
            softAssert.assertEquals(actualTitle, expectedTitle);
        } else {
            logger.info("Title didn't matched");
        }
    }
    @Test(priority = 2)
    public void homePageLogo() throws InterruptedException {
        homePage =new HomePage(driver);
        homePage.clickOnLogo();
    }
    @Test(priority = 3)
    public void homePageContactSales() throws InterruptedException {
        homePage =new HomePage(driver);
        homePage.clickContactSales();
        homePage.clickExploreMore();
    }
    @Test(priority = 4)
    public void homePageKeyClientsSlider() throws InterruptedException {
        homepageKeyClients =new HomepageKeyClients(driver);
        homepageKeyClients.clickOnkeyClientsSlider();
    }
    @Test(priority = 5)
    public void homePagePlatformFeature() throws InterruptedException {
        homepagePlatformFeatures =new HomepagePlatformFeatures(driver);
       homepagePlatformFeatures.moveToHomepagePlatformFeature();
    }
    @Test(priority = 6)
    public void homePageWhyMachnet() throws InterruptedException {
        homepageWhyMachnet = new HomepageWhyMachnet(driver);
        homepageWhyMachnet.moveToWhyMachnet();
    }

    @Test(priority = 7)
    public void homePageGetApiDocs() throws InterruptedException {
        homepageDesginedForDevelopers =new HomepageDesginedForDevelopers(driver);
        homepageDesginedForDevelopers.clickOnGetApiDocs();
    }
    @Test(priority = 8)
    public void HomepageLatestUpdates() throws InterruptedException {
        homepageLatestUpdates =new HomepageLatestUpdates(driver);
        homepageLatestUpdates.subscribeToGetLatestUpdate();
    }
}
