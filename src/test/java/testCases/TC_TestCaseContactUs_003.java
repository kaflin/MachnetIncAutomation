package testCases;
import base.BaseClass;
import org.testng.annotations.Test;
import pageObjectModel.contactus.ContactUs;

public class TC_TestCaseContactUs_003 extends BaseClass {

    ContactUs contactUs;

    @Test(priority = 1)
    public void clickContactUs() throws InterruptedException {
        contactUs =new ContactUs(driver);
        contactUs.clickOnContactUs();
        contactUs.fillingContactUsForm();
    }

}
