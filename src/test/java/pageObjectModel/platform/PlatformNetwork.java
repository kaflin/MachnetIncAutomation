package pageObjectModel.platform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PlatformNetwork {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(PlatformNetwork.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//div[text()='Network']")
    WebElement network;

    public PlatformNetwork(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnNetwork() throws InterruptedException {
        Thread.sleep(5000);
        Platform platform=new Platform(driver);
        platform.hoverOnPlatform();
        log.info("Clicking on Platform's Network");
        network.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Network | Machnet California");
        Thread.sleep(5000);
    }
}
