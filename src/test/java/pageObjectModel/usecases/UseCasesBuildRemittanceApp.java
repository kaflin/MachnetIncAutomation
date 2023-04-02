package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class UseCasesBuildRemittanceApp {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCasesBuildRemittanceApp.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//div[text()='Build Remittance App']")
    WebElement buildRemittanceApp;

    @FindBy(xpath = "//*[@id=\"sandbox-button\"]")
    WebElement useCasesRequestDemoButton;

    @FindBy(xpath = "//*[@id=\"get-api-docs-button\"]")
    WebElement useCasesGetApiDocs;



    public UseCasesBuildRemittanceApp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBuildRemittanceApp() throws InterruptedException {
        log.info("Clicking on UseCases's BuildRemittanceApp");
        buildRemittanceApp.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Build Remittance App | Machnet California");
        Thread.sleep(5000);
    }
    public void clickOnUseCasesRequestDemo() throws InterruptedException {
        log.info("Clicking on UseCases's  RequestDemo Button");
        useCasesRequestDemoButton.click();
        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Remove the handle of the current window from the set of handles
        windowHandles.remove(currentWindowHandle);

        // Switch to the new window
        driver.switchTo().window(windowHandles.iterator().next());
        Thread.sleep(10000);

        //Close the switched window
        driver.close();


        //Switch to previous window
        driver.switchTo().window(currentWindowHandle);
        Thread.sleep(10000);

    }

    public void clickOnUseCasesGetApiDocs() throws InterruptedException {
        log.info("Clicking on UseCases's  API Docs Button");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,950)");
        useCasesGetApiDocs.click();
        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Remove the handle of the current window from the set of handles
        windowHandles.remove(currentWindowHandle);

        // Switch to the new window
        driver.switchTo().window(windowHandles.iterator().next());
        Thread.sleep(10000);

        //Close the switched window
        driver.close();


        //Switch to previous window
        driver.switchTo().window(currentWindowHandle);

        jse.executeScript("window.scrollTo(0, 0)");//Scroll to Top of original window
        Thread.sleep(10000);
    }
}

