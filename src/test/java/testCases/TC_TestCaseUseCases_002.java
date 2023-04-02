package testCases;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pageObjectModel.platform.PlatformRoadMap;
import pageObjectModel.usecases.*;

public class TC_TestCaseUseCases_002 extends BaseClass {

    UseCases useCases;
    UseCasesBuildRemittanceApp useCasesBuildRemittanceApp;
    UseCasesP2pDigitalWallet useCasesP2pDigitalWallet;
    UseCasesBuildPayrollPlatform useCasesBuildPayrollPlatform;
    UseCasesWalletForBussinessCustomer useCasesWalletForBussinessCustomer;
    UseCasesCollectAndTransferPayments useCasesCollectAndTransferPayments;

    @Test(priority = 1)
    public void platformNavBarUseCases() throws InterruptedException {
        useCases=new UseCases(driver);
        useCases.hoverOnUseCases();
    }

    @Test(priority = 2)
    public void useCasesNavBarBuildRemittanceApp() throws InterruptedException {
        useCasesBuildRemittanceApp =new UseCasesBuildRemittanceApp(driver);
        useCasesBuildRemittanceApp.clickOnBuildRemittanceApp();
        useCasesBuildRemittanceApp.clickOnUseCasesRequestDemo();
        useCasesBuildRemittanceApp.clickOnUseCasesGetApiDocs();

    }
    @Test(priority = 3)
    public void useCasesNavBarP2pDigitalWallet() throws InterruptedException {
        useCasesP2pDigitalWallet=new UseCasesP2pDigitalWallet(driver);
        useCasesP2pDigitalWallet.clickOnP2pDigitalWallet();
    }
    @Test(priority = 4)
    public void useCasesNavBarBuildPayrollPlatform() throws InterruptedException {
        useCasesBuildPayrollPlatform=new UseCasesBuildPayrollPlatform(driver);
        useCasesBuildPayrollPlatform.clickOnBuildPayrollPlatform();
    }
    @Test(priority = 5)
    public void useCasesNavBarWalletForBussinessCustomer() throws InterruptedException {
        useCasesWalletForBussinessCustomer =new UseCasesWalletForBussinessCustomer(driver);
        useCasesWalletForBussinessCustomer.clickOnWalletForBussinessCustomer();
    }
    @Test(priority = 6)
    public void useCasesNavBarCollectAndTransferPayments() throws InterruptedException {
        useCasesCollectAndTransferPayments =new UseCasesCollectAndTransferPayments(driver);
        useCasesCollectAndTransferPayments.clickOnCollectAndTransferPayments();
    }


}

