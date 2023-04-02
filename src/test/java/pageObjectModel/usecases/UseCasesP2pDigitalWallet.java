package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UseCasesP2pDigitalWallet {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCasesP2pDigitalWallet.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//div[text()='P2P Digital Wallet']")
    WebElement p2pDigitalWallet;

    public UseCasesP2pDigitalWallet(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;
    UseCases useCases;

    public void clickOnP2pDigitalWallet() throws InterruptedException {
        log.info("Clicking on UseCases's P2p Digital wallet");
        useCasesBuildRemittanceApp=new UseCasesBuildRemittanceApp(driver);
        useCases =new UseCases(driver);
        useCases.hoverOnUseCases();
        p2pDigitalWallet.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "P2P Digital Wallet | Machnet California");
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();
        Thread.sleep(5000);
    }

}
