package tests;

import PageClasses.MultipleWindowsPage;
import PageClasses.NewWindowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {

    @Test(description = "Opening multiple windows/tabs test")
    public void changingBetweenWindowsTest() {
        final String PAGE_URL = "https://the-internet.herokuapp.com/windows";

        MultipleWindowsPage multipleWindowsPage = mainPage.clickMultipleWindows();
        NewWindowPage newWindowPage = multipleWindowsPage.openNewWindow();

        Assert.assertTrue(multipleWindowsPage.numberOfHandles() > 1,
                "Expecting more than 1 window");
        Assert.assertEquals(newWindowPage.getWindowText(),
                "New Window",
                "New window has the text 'New Window'");

        multipleWindowsPage.switchBackToOriginalWindow();
        Assert.assertEquals(driver.getCurrentUrl(),
                PAGE_URL,
                "Expect to be back on multiple windows page");
    }
}
