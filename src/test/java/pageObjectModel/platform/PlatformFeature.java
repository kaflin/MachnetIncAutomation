package pageObjectModel.platform;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformFeature {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(PlatformFeature.class.getName());

    @FindBy(xpath = "//div[text()='Features']")
    WebElement features;

    @FindBy(xpath = "//div/a[text()='Collect']")
    WebElement featuresCollect;

    @FindBy(xpath = "//div/a[text()='Hold']")
    WebElement featuresHold;

    @FindBy(xpath = "//div/a[text()='Disburse']")
    WebElement featuresDisburse;

    @FindBy(xpath = "//div/a[text()='Compliance']")
    WebElement featuresCompliance;

    @FindBy(xpath = "//div/a[text()='Risk']")
    WebElement featuresRisk;

    @FindBy(xpath = "//*[@id=\"subscription-form\"]")
    WebElement subscribe;

    @FindBy(xpath="//input[@class=\"footer-submit w-button\"]")
    WebElement subscribeSubmitButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement recaptchaBox;


    @FindBy(xpath="//*[@id=\"subscribe-success\"]")
    WebElement subscribeSuccessMessage;


    public PlatformFeature(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnFeatures() throws InterruptedException {
        log.info("Clicking on Platform's Features");
        features.click();
        Thread.sleep(5000);
    }

    public void clickOnFeaturesCollect() throws InterruptedException {
        log.info("Clicking on featuresCollect");
        featuresCollect.click();
        Thread.sleep(5000);
    }
    public void clickOnFeaturesHold() throws InterruptedException {
        log.info("Clicking on featuresHold");
        featuresHold.click();
        Thread.sleep(5000);
    }
    public void clickOnFeaturesDisburse() throws InterruptedException {
        log.info("Clicking on featuresCompliance");
        featuresDisburse.click();
        Thread.sleep(5000);
    }
    public void clickOnFeaturesCompliance() throws InterruptedException {
        log.info("Clicking on featuresCompliance");
        featuresCompliance.click();
        Thread.sleep(5000);
    }
    public void clickOnFeaturesRisk() throws InterruptedException {
        log.info("Clicking on featuresRisk");
        featuresRisk.click();

//        JavascriptExecutor jse=(JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(200,300)");
        Thread.sleep(5000);
    }

    public void subscribeToGetLatestUpdate() throws InterruptedException {
        log.info("Providing email to get latest update");
        subscribe.sendKeys("suraj@gmail.com");
//        recaptchaBox.click();
        Thread.sleep(40000);
        subscribeSubmitButton.click();
        Thread.sleep(2000);
        if(subscribeSuccessMessage.getText().equalsIgnoreCase("Thank you! Your submission has been received!")){
            log.info("You have correctly subscribed");
        }else{
            log.info("You haven't subscribed yet");
        }
        log.info("*********************************************");
    }

}
