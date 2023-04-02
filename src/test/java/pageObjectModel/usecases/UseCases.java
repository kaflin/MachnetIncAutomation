package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class UseCases {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCases.class.getName());

    @FindBy(xpath = "//*[text()='Use Cases']")
    WebElement useCases;



    public UseCases(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOnUseCases() throws InterruptedException {
        log.info("Hovering on UseCases");
        Actions actions=new Actions(driver);
        actions.moveToElement(useCases).perform();
        Thread.sleep(5000);
    }



}
