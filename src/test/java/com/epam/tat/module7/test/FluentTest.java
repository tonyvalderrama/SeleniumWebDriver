package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.CandyWrapperPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openPageFluentTimeoutTest() {
        CandyWrapperPage candyWrapperPage = new CandyWrapperPage(driver);
        String titleText = candyWrapperPage
                .openPage()
                .getTitleTextWithFluentWait();
        Assert.assertEquals(titleText,"CandyMapper!");
    }

}
