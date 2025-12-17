package com.epam.tat.module7.PageObjects;

import com.epam.tat.module7.config.ConfigURLs;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormAuthenticationPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    private WebDriverWait wait;

    protected FormAuthenticationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        PageFactory.initElements(driver,this);
        waitUntilPageIsLoaded(loginButton);
    }

    @Override
    public BasePage openPage() {
        driver.get(ConfigURLs.LOGIN_URL);
        return this;
    }

    public FormAuthenticationPage fillUsernameInput(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        return this;
    }

    public FormAuthenticationPage fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public boolean didLoginSucceed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.urlToBe(ConfigURLs.SECURE_AREA_URL));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}