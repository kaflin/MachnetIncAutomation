package testCases;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pageObjectModel.usecases.*;

public class TC_TestCaseUseCases_002 extends BaseClass {

    UseCases useCases;
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;
    UseCasesP2pDigitalWallet useCasesP2pDigitalWallet;
    UseCasesBuildPayrollPlatform useCasesBuildPayrollPlatform;
    UseCasesWalletForBussinessCustomer useCasesWalletForBussinessCustomer;
    UseCasesCollectAndTransferPayments useCasesCollectAndTransferPayments;


    public void platformNavBarUseCases() {
        useCases=new UseCases(driver);
        useCases.hoverOnUseCases();
    }

    @Test(priority = 1)
    public void useCasesNavBarBuildRemittanceApp() throws InterruptedException {
        useCasesBuildRemittanceApp =new UseCasesBuildRemittanceApp(driver);
        platformNavBarUseCases();
        useCasesBuildRemittanceApp.clickOnBuildRemittanceApp();
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();

    }
    @Test(priority = 2)
    public void useCasesNavBarP2pDigitalWallet() throws InterruptedException {
        useCasesP2pDigitalWallet=new UseCasesP2pDigitalWallet(driver);
        platformNavBarUseCases();
        useCasesP2pDigitalWallet.clickOnP2pDigitalWallet();
    }
    @Test(priority = 3)
    public void useCasesNavBarBuildPayrollPlatform() throws InterruptedException {
        useCasesBuildPayrollPlatform=new UseCasesBuildPayrollPlatform(driver);
        platformNavBarUseCases();
        useCasesBuildPayrollPlatform.clickOnBuildPayrollPlatform();
    }
    @Test(priority = 4)
    public void useCasesNavBarWalletForBussinessCustomer() throws InterruptedException {
        useCasesWalletForBussinessCustomer =new UseCasesWalletForBussinessCustomer(driver);
        platformNavBarUseCases();
        useCasesWalletForBussinessCustomer.clickOnWalletForBussinessCustomer();
    }
    @Test(priority = 5)
    public void useCasesNavBarCollectAndTransferPayments() throws InterruptedException {
        useCasesCollectAndTransferPayments =new UseCasesCollectAndTransferPayments(driver);
        platformNavBarUseCases();
        useCasesCollectAndTransferPayments.clickOnCollectAndTransferPayments();
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, 0)");//Scroll to Top of original window
    }
}

