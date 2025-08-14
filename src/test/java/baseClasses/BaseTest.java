package baseClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass
    @Parameters("browser")
    protected void beforeClass(String browserName) {
        logger = LogManager.getLogger(this.getClass());

        driver = initBrowser(browserName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/upload/");
    }

    @AfterClass
    protected void afterClass() {
        driver.quit();
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10000);
    }

    private WebDriver initBrowser(String browserName) {
        switch (browserName) {
            case "firefox":
                return driver = new FirefoxDriver();
            case "chrome":
                return driver = new ChromeDriver();
            case "edge":
                return driver = new EdgeDriver();
            default:
                throw new RuntimeException("Invalid browser: " + browserName);
        }
    }

}
