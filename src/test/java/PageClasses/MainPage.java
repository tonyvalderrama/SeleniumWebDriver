package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private final String URL = "https://the-internet.herokuapp.com/";

    @FindBy(linkText = "Form Authentication")
    private WebElement linkFormAuthentication;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement linkAddRemoveElements;

    @FindBy(linkText = "Multiple Windows")
    private WebElement linkMultipleWindows;

    @FindBy(linkText = "Checkboxes")
    private WebElement linkCheckboxes;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public BasePage openPage() {
        driver.get(URL);
        waitUntilPageIsLoaded(linkFormAuthentication);
        return this;
    }

    public FormAuthenticationPage clickFormAuthentication() {
        linkFormAuthentication.click();
        return new FormAuthenticationPage(driver);
    }

    public AddRemoveElementsPage clickAddRemoveElementsPage() {
        linkAddRemoveElements.click();
        return new AddRemoveElementsPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        linkMultipleWindows.click();
        return new MultipleWindowsPage(driver);
    }

    public CheckboxesPage clickCheckboxes() {
        linkCheckboxes.click();
        return new CheckboxesPage(driver);
    }
}
