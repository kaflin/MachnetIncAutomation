package pageObjectModel.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomepageDesginedForDevelopers {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepageDesginedForDevelopers.class.getName());


    @FindBy(xpath="//*[@id=\"get-api-docs-button\"]")
    WebElement getApiDocs;



    public HomepageDesginedForDevelopers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnGetApiDocs() throws InterruptedException {
        log.info("Clicking on Get Api Docs");
        Thread.sleep(5000);//Wait before scrolling down
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,650)");
        getApiDocs.click();
        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Remove the handle of the current window from the set of handles
        windowHandles.remove(currentWindowHandle);

        // Switch to the new window
        driver.switchTo().window(windowHandles.iterator().next());
        Thread.sleep(5000);

        //Close the switched window
        driver.close();


        //Switch to previous window
        driver.switchTo().window(currentWindowHandle);
        jse.executeScript("window.scrollBy(0, 400)");//Scroll to down of original window
        Thread.sleep(5000);
    }
}

