package com.epam.tat.module7.PageObjects;

import com.epam.tat.module7.config.ConfigURLs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends BasePage {

    @FindBy(xpath = "//form[@id='checkboxes']/input[following-sibling::text()[contains(., 'checkbox 1')]]")
    private WebElement checkbox1;
    @FindBy(xpath = "//form[@id='checkboxes']/input[following-sibling::text()[contains(., 'checkbox 2')]]")
    private WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public BasePage openPage() {
        driver.get(ConfigURLs.CHECKBOX_PAGE);
        waitUntilPageIsLoaded(checkbox1);
        return this;
    }

    public CheckboxesPage clickCheckbox1() {
        checkbox1.click();
        return this;
    }

    public CheckboxesPage clickCheckbox2() {
        checkbox2.click();
        return this;
    }

    public boolean isCheckbox1Checked() {
        return isChecked(checkbox1);
    }

    public boolean isCheckbox2Checked() {
        return isChecked(checkbox2);
    }

    public boolean isChecked(WebElement checkbox) {
        return checkbox.isSelected();
    }

}
