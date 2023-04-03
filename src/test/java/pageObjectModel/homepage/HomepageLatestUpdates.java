package pageObjectModel.homepage;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageLatestUpdates {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepageLatestUpdates.class.getName());
    Faker faker=new Faker();

    @FindBy(xpath = "//*[@id=\"subscription-form\"]")
    WebElement subscribe;

    @FindBy(xpath="//input[@class=\"footer-submit w-button\"]")
    WebElement subscribeSubmitButton;

    public HomepageLatestUpdates(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void subscribeToGetLatestUpdate() throws InterruptedException {
        log.info("Providing email to get latest update");
        subscribe.sendKeys(faker.name().firstName()+"@gmail.com");
        Thread.sleep(40000);
        subscribeSubmitButton.click();
        Thread.sleep(2000);
    }
}
