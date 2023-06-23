
package bookStoreTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {


    @Test
    public void verifyRegisterPageUrl() {
        getRegisterPage().open();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/register"));
    }

    @Test
    public void verifyLoginRequiresCaptcha() {
        String firstname = "TestFirstName";
        String lastName = "TestLastName";
        String userName = "TestUserName";
        String password = "Test_1234!";

        getRegisterPage().open()
                .enterFirstNameField(firstname)
                .enterLastNameField(lastName)
                .enterUserNameField(userName)
                .enterPassword(password)
                .clickRegisterButton();
        assertVisibilityOfElement(getRegisterPage().getErrorMessage());
        Assert.assertEquals(getRegisterPage().getErrorMessage().getText(),
                "Please verify reCaptcha to register!" );
    }

    @Test
    public void verifyThatUserCanNotRegisterWithEmptyInputs() {
        getRegisterPage().open()
                .clickRegisterButton();
        assertVisibilityOfElement(getRegisterPage().getErrorEmptyField());

    }

}
