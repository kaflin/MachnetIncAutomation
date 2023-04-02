package pageObjectModel.platform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Platform {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(Platform.class.getName());

    @FindBy(xpath = "//*[text()='Platform']")
    WebElement platform;


    public Platform(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void hoverOnPlatform() throws InterruptedException {
        log.info("Hovering on Platform");
        Actions actions=new Actions(driver);
        actions.moveToElement(platform).perform();
        Thread.sleep(5000);
    }
}
