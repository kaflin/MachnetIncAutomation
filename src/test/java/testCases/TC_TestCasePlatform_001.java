package testCases;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectModel.platform.Platform;
import pageObjectModel.platform.PlatformFeature;
import pageObjectModel.platform.PlatformNetwork;
import pageObjectModel.platform.PlatformRoadMap;

public class TC_TestCasePlatform_001 extends BaseClass {
    SoftAssert softAssert = new SoftAssert();

    Platform platform;
    PlatformFeature  platformFeature;
    PlatformRoadMap platformRoadMap;
    PlatformNetwork platformNetwork;



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
    public void platformNavBarFeature() throws InterruptedException {
        platform=new Platform(driver);
        platformFeature =new PlatformFeature(driver);
        platform.hoverOnPlatform();
        platformFeature.clickOnFeatures();
        platformFeature.clickOnFeaturesCollect();
        platformFeature.clickOnFeaturesHold();
        platformFeature.clickOnFeaturesDisburse();
        platformFeature.clickOnFeaturesCompliance();
        platformFeature.clickOnFeaturesRisk();
//        platformFeature.subscribeToGetLatestUpdate();
    }
    @Test(priority = 3)
    public void platformNavBarRoadMap() throws InterruptedException {

        platformRoadMap=new PlatformRoadMap(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, 0)"); // To scroll at Top of page
        platformRoadMap.clickOnRoadMap();
        platformRoadMap.clickOnRoadMapButton();
        jse.executeScript("window.scrollBy(0, 800)"); //To scroll down of page
        Thread.sleep(5000);
        jse.executeScript("window.scrollTo(0, 0)"); // To scroll at Top of page
        platformRoadMap.clickOnAnnouncementsButton();
        jse.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(5000);
        jse.executeScript("window.scrollTo(0, 0)");
    }
    @Test(priority = 4)
    public void platformNavBarNetwork() throws InterruptedException {
        platformNetwork =new PlatformNetwork(driver);
        platformNetwork.clickOnNetwork();

    }

}
