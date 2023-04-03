package pageObjectModel.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageKeyClients {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepageKeyClients.class.getName());

    @FindBy(xpath = "//div[@class='w-slider-dot']")
    WebElement sliderDot;

    public HomepageKeyClients(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnkeyClientsSlider() throws InterruptedException {
        log.info("Clicking on Key Clients Slider");
        Thread.sleep(5000);//Wait before scrolling down
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)");
        sliderDot.click();
        Thread.sleep(5000);
    }
}
