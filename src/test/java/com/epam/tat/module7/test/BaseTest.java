package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass (alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod (alwaysRun = true)
    public void openMainPage() {
        mainPage = new MainPage(driver);
        mainPage.openPage();
    }
}
