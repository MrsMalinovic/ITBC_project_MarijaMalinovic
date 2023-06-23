package bookStoreTests;

import bookStorePages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;;
import bookStorePages.RegisterPage;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "F://Desktop//chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        registerPage = new RegisterPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        getDriver().manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void cleanUp() {
        getDriver().close();
    }

    public void assertVisibilityOfElement(WebElement element) {
        Assert.assertTrue(getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed());
    }
    public void waitForUrlContains(String text) {
        getWait().until(ExpectedConditions.urlContains(text));
    }
}
