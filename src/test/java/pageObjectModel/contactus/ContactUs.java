package pageObjectModel.contactus;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(ContactUs.class.getName());
    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"contact-button\"]")
    WebElement contactUs;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"emailaddress\"]")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id=\"phoneno\"]")
    WebElement phoneNo;

    @FindBy(xpath = "//*[@id=\"companyname\"]")
    WebElement companyName;


    @FindBy(xpath = "//*[@id=\"companyurl\"]")
    WebElement companyUrl;

    @FindBy(xpath = "//*[@id=\"companysize\"]")
    WebElement companySize;

    @FindBy(xpath = "//*[@id=\"selectedcountry\"]")
    WebElement selectedCountry;

    @FindBy(xpath = "//*[@id=\"licensed\"]")
    WebElement licensed;

    @FindBy(xpath = "//*[@id=\"intended-use\"]")
    WebElement intendedApi;


    @FindBy(xpath = "//*[@id=\"businessexplanation\"]")
    WebElement businessRequiremnets;

    @FindBy(xpath = "//*[@id=\"submit-button-contacts\"]")
    WebElement contactSalesButton;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContactUs() throws InterruptedException {
        log.info("Clicking on Contact Us page");
        contactUs.click();
        Thread.sleep(5000);

    }
    public void fillingContactUsForm() throws InterruptedException {
        log.info("Entering Details On Contact Us Form");
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        emailAddress.sendKeys(faker.name().username()+"@gmail.com");
        phoneNo.sendKeys(faker.phoneNumber().phoneNumber());
        companyName.sendKeys(faker.name().name());
        companyUrl.sendKeys(faker.name().name()+".com");
        Select selectSize=new Select(companySize);
        selectSize.selectByIndex(1);

        Select selectCountry=new Select(selectedCountry);
        selectCountry.selectByIndex(1);

        Select selectLicensed = new Select(licensed);
        selectLicensed.selectByIndex(1);


        Select selectIntended =new Select(intendedApi);
        selectIntended.selectByIndex(1);

        businessRequiremnets.sendKeys("Her name is Natalie Gamble. She lives in East Tammyborough. Her favorite color is Magenta. She works as a Metallurgist Her name is Natalie Gamble. She lives in East Tammyborough. Her favorite color is Magenta. She works as a Metallurgist");
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(40000);
        contactSalesButton.click();
        Thread.sleep(5000);


    }
}
