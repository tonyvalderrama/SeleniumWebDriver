package com.epam.tat.module7.test;

import com.epam.tat.module7.PageObjects.AddRemoveElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest{

    @Test(description = "Test: adding and removing elements",
            groups = {"regression","all"})
    public void testAddRemoveElements() {
        AddRemoveElementsPage addRemoveElementsPage =
                mainPage.clickAddRemoveElementsPage();

        // Click button 2 times and assert number of Delete buttons that appear
        addRemoveElementsPage
                .clickAddElementButton()
                .clickAddElementButton();
        Assert.assertEquals(addRemoveElementsPage.numberOfDeleteButtons(),
                2,
                "Expected 2 delete buttons");

        // Click first delete button and assert that only one is left
        addRemoveElementsPage
                .clickFirstDeleteButton();
        Assert.assertEquals(addRemoveElementsPage.numberOfDeleteButtons(),
                1,
                "Expected 1 delete button");

        // Click last deletebutton and see that there are none
        addRemoveElementsPage
                .clickFirstDeleteButton();
        Assert.assertEquals(addRemoveElementsPage.numberOfDeleteButtons(),
                0,
                "No delete button expected");

    }
}
