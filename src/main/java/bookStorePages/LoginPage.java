package bookStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement errorEmptyField;
    private WebElement  errorMessage;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getUserNameField() {
        userNameField = getDriver().findElement(By.id("userName"));
        return userNameField;
    }

    public WebElement getPasswordField() {
        passwordField = getDriver().findElement(By.id("password"));
        return passwordField;
    }
    public WebElement getLoginButton() {
       loginButton = getDriver().findElement(By.id("login"));
        return loginButton;
    }
    public WebElement getErrorMessage() {
        errorMessage = getDriver().findElement(By.id("name"));
        return errorMessage;
    }
    public WebElement getErrorEmptyField(){
        errorEmptyField=getDriver().findElement(By.xpath("//*[@class='mr-sm-2 is-invalid form-control']"));
        return  errorEmptyField;
    }

    public LoginPage enterUserNameField(String userName) {
        getUserNameField().sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }
    public  LoginPage clickLoginButton(){
        getLoginButton().click();
        return this;
}
    public LoginPage open() {
        getDriver().get("https://demoqa.com/login");
        return this;
    }

}
