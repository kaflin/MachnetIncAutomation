package pageObjectModel.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomepageWhyMachnet {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepageWhyMachnet.class.getName());

    public HomepageWhyMachnet(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void moveToWhyMachnet() throws InterruptedException {
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(5000);
    }

}
