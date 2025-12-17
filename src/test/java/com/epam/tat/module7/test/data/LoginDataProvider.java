package com.epam.tat.module7.test.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "correctLoginData")
    public Object[][] getCorrectLoginData() {
        return new Object[][] {
            {"tomsmith", "SuperSecretPassword!"}
        };
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] getIncorrectLoginData() {
        return new Object[][] {
            {"johndoe", "SomeOtherPassword"}
        };
    }
}
