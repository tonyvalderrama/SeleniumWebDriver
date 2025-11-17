package tests;

import PageClasses.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxTest() {
        CheckboxesPage checkboxesPage = mainPage.clickCheckboxes();

        Assert.assertFalse(checkboxesPage.isCheckbox1Checked(),
                "CheckBox1 must not be checked");
        checkboxesPage.clickCheckbox1();
        Assert.assertTrue(checkboxesPage.isCheckbox1Checked(),
                "After clicking, checkbox1 should be checked");

        Assert.assertTrue(checkboxesPage.isCheckbox2Checked(),
                "Checkbox2 should be checked");
        checkboxesPage.clickCheckbox2();
        Assert.assertFalse(checkboxesPage.isCheckbox2Checked(),
                "After clicking, checkbox2 should be unchecked");
    }
}
