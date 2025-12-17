package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.CandyWrapperPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void tearDown() {
        // Remove implicit wait (make time = 0)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.quit();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void openPageImplicitTimeoutTest() {
        CandyWrapperPage candyWrapperPage = new CandyWrapperPage(driver);
        String titleText = candyWrapperPage
            .openPage()
            .getTitleText();
        Assert.assertEquals(titleText,"CandyMapper!");
    }

}
