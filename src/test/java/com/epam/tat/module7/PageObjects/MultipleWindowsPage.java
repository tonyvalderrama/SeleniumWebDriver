package com.epam.tat.module7.PageObjects;

import com.epam.tat.module7.config.ConfigURLs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MultipleWindowsPage extends BasePage {
    private String originalHandle;

    @FindBy(linkText = "Click Here")
    private WebElement linkClickHere;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected BasePage openPage() {
        driver.get(ConfigURLs.MULTIPLEWINDOWS_URL);
        waitUntilPageIsLoaded(linkClickHere);
        return this;
    }

    public NewWindowPage openNewWindow() {
        linkClickHere.click();
        originalHandle = switchToNewWindow();
        return new NewWindowPage(driver);
    }

    public String switchToNewWindow() {
        String originalHandle = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = driver.getWindowHandles();
        String newHandle = windowHandles.stream()
                .filter(handle->!handle.equals(originalHandle))
                .findFirst()
                .orElseThrow(()->new RuntimeException("New handle not found"));

        driver.switchTo().window(newHandle);
        return originalHandle;
    }

    public void switchBackToOriginalWindow() {
        switchToWindow(originalHandle);
    }

    private void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public int numberOfHandles() {
        return driver.getWindowHandles().size();
    }
}
