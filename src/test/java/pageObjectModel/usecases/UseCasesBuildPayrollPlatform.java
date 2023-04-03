package pageObjectModel.usecases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UseCasesBuildPayrollPlatform{
    WebDriver driver;
    public static final Logger log = Logger.getLogger(UseCasesBuildPayrollPlatform.class.getName());
    SoftAssert softAssert = new SoftAssert();


    @FindBy(xpath = "//div[text()='Build Payroll Platform']")
    WebElement buildPayRollPlatform;

    public UseCasesBuildPayrollPlatform(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;

    public void clickOnBuildPayrollPlatform() throws InterruptedException {
        log.info("Clicking on UseCases's Build Payroll Platform");
        useCasesBuildRemittanceApp=new UseCasesBuildRemittanceApp(driver);
        buildPayRollPlatform.click();
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle, "Build Payroll Platform | Machnet California");
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();
        Thread.sleep(5000);
    }
}
