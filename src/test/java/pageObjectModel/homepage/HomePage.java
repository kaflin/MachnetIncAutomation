package pageObjectModel.homepage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomePage.class.getName());

    @FindBy(xpath="//div/a/img[@class=\'flowbase-logo\']")
    WebElement logo;

    @FindBy(xpath = "//*[@id=\"contact-button-top\"]")
    WebElement contactSales;

    @FindBy(xpath = "//*[@id=\"explore-more-button\"]")
    WebElement exploreMore;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogo() throws InterruptedException {
        log.info("Clicking on Machnet logo");
        logo.click();
        Thread.sleep(2000);
    }
    public void clickContactSales() throws InterruptedException {
        log.info("Clicking on Homepage Contact Sales button");
        contactSales.click();

        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

        // Switch to the new window
        driver.switchTo().window(currentWindowHandle);

        logo.click();//Click on logo to switch to homepage
        Thread.sleep(5000);
    }
    public void clickExploreMore() throws InterruptedException {
        log.info("Clicking on Homepage Explore More button");
        contactSales.click();

        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

        // Switch to the new window
        driver.switchTo().window(currentWindowHandle);

        logo.click();//Click on logo to switch to homepage
        Thread.sleep(5000);
    }
}
