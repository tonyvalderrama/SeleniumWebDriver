package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.MultipleWindowsPage;
import com.epam.tat.module7.PageObjects.NewWindowPage;
import com.epam.tat.module7.config.ConfigURLs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {

    @Test(description = "Opening multiple windows/tabs test",
        groups = {"smoke","regression","all"})
    public void changingBetweenWindowsTest() {
        MultipleWindowsPage multipleWindowsPage = mainPage.clickMultipleWindows();
        NewWindowPage newWindowPage = multipleWindowsPage.openNewWindow();

        Assert.assertTrue(multipleWindowsPage.numberOfHandles() > 1,
                "Expecting more than 1 window");
        Assert.assertEquals(newWindowPage.getWindowText(),
                "New Window",
                "New window has the text 'New Window'");

        multipleWindowsPage.switchBackToOriginalWindow();
        Assert.assertEquals(driver.getCurrentUrl(),
                ConfigURLs.MULTIPLEWINDOWS_URL,
                "Expect to be back on multiple windows page");
    }
}
