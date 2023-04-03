package pageObjectModel.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomepagePlatformFeatures {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepagePlatformFeatures.class.getName());

    public HomepagePlatformFeatures(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void moveToHomepagePlatformFeature() throws InterruptedException {
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,700)");
        Thread.sleep(5000);
    }

}
