package PageClasses;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormAuthenticationPage extends BasePage {

    private final String URL = "https://the-internet.herokuapp.com/login";
    private final String SECURE_AREA_URL = "https://the-internet.herokuapp.com/secure";

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    protected FormAuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public BasePage openPage() {
        driver.get(URL);
        waitUntilPageIsLoaded(loginButton);
        return this;
    }

    public FormAuthenticationPage fillUsernameInput(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public FormAuthenticationPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean didLoginSucceed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.urlToBe(SECURE_AREA_URL));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}