package bookStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement captchaCheckBox;
    private WebElement registerButton;
    private WebElement errorMessage;
    private WebElement errorEmptyField;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFirstNameField() {
        firstNameField = getDriver().findElement(By.id("firstname"));
        return firstNameField;
    }

    public WebElement getLastNameField() {
        lastNameField = getDriver().findElement(By.id("lastname"));
        return lastNameField;
    }

    public WebElement getUserNameField() {
        userNameField = getDriver().findElement(By.id("userName"));
        return userNameField;
    }

    public WebElement getPasswordField() {
        passwordField = getDriver().findElement(By.id("password"));
        return passwordField;
    }

    public WebElement getCaptchaCheckBox() {
        captchaCheckBox = getDriver().findElement(By.xpath("//*[@class='recaptcha-checkbox-border']"));
        return captchaCheckBox;
    }

    public WebElement getRegisterButton() {
        registerButton = getDriver().findElement(By.id("register"));
        return registerButton;
    }

    public WebElement getErrorMessage() {
        errorMessage = getDriver().findElement(By.id("name"));
        return errorMessage;
    }
    public WebElement getErrorEmptyField(){
        errorEmptyField=getDriver().findElement(By.xpath("//*[@class='mr-sm-2 is-invalid form-control']"));
        return  errorEmptyField;
    }

    public RegisterPage enterFirstNameField(String firstName) {
        getFirstNameField().sendKeys(firstName);
        return this;
    }

    public RegisterPage enterLastNameField(String lastName) {
        getLastNameField().sendKeys(lastName);
        return this;
    }

    public RegisterPage enterUserNameField(String userName) {
        getUserNameField().sendKeys(userName);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public RegisterPage clickCaptchaCheckBox() {
        getCaptchaCheckBox().click();
        return this;
    }

    public RegisterPage clickRegisterButton() {
        getRegisterButton().click();
        return this;
    }

    public RegisterPage open() {
        getDriver().get("https://demoqa.com/register");
        return this;
    }
}
