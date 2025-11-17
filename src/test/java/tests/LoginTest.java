package tests;

import PageClasses.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "First test: Successful login")
    public void testSuccessfulLogin() {
        FormAuthenticationPage formAuthenticationPage = mainPage.clickFormAuthentication();
        formAuthenticationPage
                .fillUsernameInput("tomsmith")
                .fillPassword("SuperSecretPassword!")
                .clickLoginButton();

        Assert.assertTrue(formAuthenticationPage.didLoginSucceed(), "Login successful");
    }

    @Test(description = "Second test: Unsuccessful login")
    public void unsuccessfulLogin() {
        FormAuthenticationPage formAuthenticationPage = mainPage.clickFormAuthentication();
        formAuthenticationPage
                .fillUsernameInput("johndoe")
                .fillPassword("SomeOtherPassword")
                .clickLoginButton();

        Assert.assertFalse(formAuthenticationPage.didLoginSucceed(),"Login unsuccessful");
    }
}
