package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.FormAuthenticationPage;
import com.epam.tat.module7.test.data.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "First test: Successful login",
            groups = {"smoke","regression"},
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "correctLoginData")
    public void testSuccessfulLogin(String user,String password) {
        FormAuthenticationPage formAuthenticationPage = mainPage.clickFormAuthentication();
        formAuthenticationPage
                .fillUsernameInput(user)
                .fillPassword(password)
                .clickLoginButton();
        Assert.assertTrue(formAuthenticationPage.didLoginSucceed(), "Login successful");
    }

    @Test(description = "Second test: Unsuccessful login",
            groups = {"smoke","regression","all"},
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "incorrectLoginData")
    public void unsuccessfulLogin(String user,String password) {
        FormAuthenticationPage formAuthenticationPage = mainPage.clickFormAuthentication();
        formAuthenticationPage
                .fillUsernameInput(user)
                .fillPassword(password)
                .clickLoginButton();

        Assert.assertFalse(formAuthenticationPage.didLoginSucceed(),"Login unsuccessful");
    }
}
