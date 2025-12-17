package com.epam.tat.module7.PageObjects;

import com.epam.tat.module7.config.ConfigURLs;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CandyWrapperPage {
    private WebDriver driver;

    By byTitleText = By.xpath("//h1[text()='CandyMapper!']");
    By byClosePopupX = By.id("popup-widget5689-close-icon");
    By byIFrame = By.tagName("iframe");

    public CandyWrapperPage(WebDriver driver) {
        this.driver = driver;
    }

    public CandyWrapperPage openPage() {
        driver.get(ConfigURLs.CANDYWRAPPER_URL);
        return this;
    }

    public CandyWrapperPage closePopup() {
        driver.findElement(byClosePopupX).click();
        return this;
    }

    public String getTitleText() {
        return driver.findElement(byTitleText).getText();
    }

    public String getTitleTextWithFluentWait() {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(40))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
        WebElement iFrame = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(byIFrame)
        );

        driver.switchTo().frame(iFrame);

        String titleText = fluentWait.until(
                ExpectedConditions.visibilityOfElementLocated(byTitleText)).getText();

        driver.switchTo().defaultContent();
        return titleText;
    }
}
