package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UseCasesCollectAndTransferPayments {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCasesCollectAndTransferPayments.class.getName());
    SoftAssert softAssert = new SoftAssert();


    @FindBy(xpath = "//div[text()='Collect and Transfer Payments']")
    WebElement collectAndTransferPayments ;

    public UseCasesCollectAndTransferPayments(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;
    UseCases useCases;

    public void clickOnCollectAndTransferPayments() throws InterruptedException {
        log.info("Clicking on UseCases's Collect And Transfer Payments");
        useCasesBuildRemittanceApp=new UseCasesBuildRemittanceApp(driver);
        useCases =new UseCases(driver);
        useCases.hoverOnUseCases();
        collectAndTransferPayments.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Collect and Transfer Payments | Machnet California");
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();
        Thread.sleep(5000);
    }
}
