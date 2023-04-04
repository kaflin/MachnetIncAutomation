package pageObjectModel.homepage;

import io.netty.handler.codec.string.LineSeparator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class HomepageFooter {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomepageFooter.class.getName());


    @FindBy(xpath = "//div/div/a[@class='footer-brand w-inline-block w--current'] ")
    WebElement footerBrand;

    @FindBy(xpath = "//div/div[@class='footer-block-two']")
    WebElement footerIndiviualModule;

    public HomepageFooter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void scrollToFooter() throws InterruptedException {
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(10000);
    }
    public void clickToFooterLogo() throws InterruptedException {
        log.info("Clicking on Homepage's Footer Logo");
        scrollToFooter();
        footerBrand.click();
        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();
        // Switch to the new window
        driver.switchTo().window(currentWindowHandle);
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,5500)");
        Thread.sleep(5000);
    }
//    public void clickToFooterPlatFormModule() throws InterruptedException {
//        log.info("Clicking on Homepage's Footer PlatForm Module");
//        scrollToFooter();
//        List<WebElement> footerList= (List<WebElement>) footerIndiviualModule;
//        for(int i=0;i<footerList.size();i++){
//            driver.findElement(By.xpath("//div/div[@class='footer-block-two'][i]"));
//        }
//        // Get the handle of the current window
//        String currentWindowHandle = driver.getWindowHandle();
//        // Switch to the new window
//        driver.switchTo().window(currentWindowHandle);
//        JavascriptExecutor jse =(JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,5500)");
//        Thread.sleep(5000);
//    }
}
