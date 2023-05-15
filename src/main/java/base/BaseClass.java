package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseClass.class.getName());
    public Actions action;
    public SoftAssert softAssert = new SoftAssert();
    public String baseDirectory = System.getProperty("user.dir");

    private void setDriver(String browserType, String baseURL) {
      switch (browserType) {
        case "chrome":
            driver = initChromeDriver(baseURL);
            break;
        case "ie":
            driver = initIEDriver(baseURL);
            break;
        default:
            driver = initFirefoxDriver(baseURL);
         }
    }
    private WebDriver initChromeDriver(String baseURL) {
        logger.info("Launching google chrome browser..");
        logger.info("Opening Machnetinc.com");
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1814, 974));
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriver(String baseURL) {
        logger.info("Launching Firefox browser..");
        logger.info("Opening Machnetinc.com");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initIEDriver(String baseURL) {
        logger.info("Launching Internet Explorer browser..");
        logger.info("Opening Machnetinc.com");
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }
    @Parameters({ "browser", "baseURL" })
    @BeforeClass(alwaysRun = true)
    public void initializeBaseTest(String browser, String baseURL) {
        try {
            logger.info("Initiate browser..");
            setDriver(browser, baseURL);
            String log4jConfPath = baseDirectory + "/src/main/resources/config/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
        } catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        logger.info("Clean up activity: Closed all browser instances..");
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}
