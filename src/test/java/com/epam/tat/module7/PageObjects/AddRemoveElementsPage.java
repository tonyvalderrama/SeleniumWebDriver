package com.epam.tat.module7.PageObjects;

import com.epam.tat.module7.config.ConfigURLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage extends BasePage{

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;
    By byDeleteButtons = By.xpath("//button[@class='added-manually']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public BasePage openPage() {
        driver.get(ConfigURLs.ADDREMOVE_PAGE);
        waitUntilPageIsLoaded(addElementButton);
        return null;
    }

    public AddRemoveElementsPage clickAddElementButton() {
        addElementButton.click();
        return this;
    }

    public int numberOfDeleteButtons() {
        return driver.findElements(byDeleteButtons).size();
    }

    public AddRemoveElementsPage clickFirstDeleteButton() {
        List<WebElement> deleteButtonsList = driver.findElements(byDeleteButtons);
        if (!deleteButtonsList.isEmpty()) {
            deleteButtonsList.get(0).click();
        }
        return this;
    }
}
