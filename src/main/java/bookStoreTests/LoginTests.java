package bookStoreTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginPageUrl() {
        getLoginPage().open();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/login"));
    }

    @Test
    public void verifyThatUserCanNotLoginWithEmptyInputs() {
        getLoginPage().open()
                .clickLoginButton();
        assertVisibilityOfElement(getRegisterPage().getErrorEmptyField());
    }

    @Test
    public void verifyThatUserCanNotLoginWithInvalidInputs() {
        String userName = "TestUserName";
        String password = "1234";

        getLoginPage().open()
                .enterUserNameField(userName)
                .enterPassword(password)
                .clickLoginButton();
        assertVisibilityOfElement(getRegisterPage().getErrorMessage());
        Assert.assertEquals(getRegisterPage().getErrorMessage().getText(),
                "Invalid username or password!");
    }

    @Test
    public void verifyThatUserCanLoginWithValidInputs()  {
        String userName = "jdoe";
        String password = "Abc.1234!";

        getLoginPage().open()
                .enterUserNameField(userName)
                .enterPassword(password)
                .clickLoginButton();
        waitForUrlContains("profile");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("profile"));
    }
}