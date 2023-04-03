package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class UseCasesWalletForBussinessCustomer {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCasesWalletForBussinessCustomer.class.getName());
    SoftAssert softAssert = new SoftAssert();


    @FindBy(xpath = "//div[text()='Wallet for Business Customers']")
    WebElement walletForBussinessCustomer;

    public UseCasesWalletForBussinessCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;

    public void clickOnWalletForBussinessCustomer() throws InterruptedException {
        log.info("Clicking on UseCases's Wallet For BussinessCustomer");
        useCasesBuildRemittanceApp=new UseCasesBuildRemittanceApp(driver);
        walletForBussinessCustomer.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Wallet for Business Customers | Machnet California");
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();
        Thread.sleep(5000);
    }
}
