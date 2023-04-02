package pageObjectModel.platform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PlatformRoadMap {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(PlatformRoadMap.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//div[text()='Roadmap']")
    WebElement roadMap;

    @FindBy(xpath = "//h1[@class='work-heading']")
    WebElement roadMapPage;

    @FindBy(xpath = "//*[@id=\"w-tabs-0-data-w-tab-1\"]")
    WebElement roadMapButton;

    @FindBy(xpath = "//*[@id=\"w-tabs-0-data-w-tab-0\"]")
    WebElement announcementsButton;

    public PlatformRoadMap(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnRoadMap() throws InterruptedException {
        Thread.sleep(5000);
        Platform platform=new Platform(driver);
        platform.hoverOnPlatform();
        log.info("Clicking on Platform's RoadMap");
        roadMap.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Roadmap | Machnet California");
        Thread.sleep(5000);
    }
    public void clickOnRoadMapButton() throws InterruptedException {
        log.info("Clicking on RoadMap Button");
        roadMapButton.click();
        Thread.sleep(5000);
    }
    public void clickOnAnnouncementsButton() throws InterruptedException {
        log.info("Clicking on Announcements Button");
        announcementsButton.click();
        Thread.sleep(5000);
    }



}
