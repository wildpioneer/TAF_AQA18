package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure example")
@Feature("TestNG support")
public class EpicTest {

    @Test
    @Story("Base support function 1")
    public void testName3() {
        Assert.assertTrue(true);
    }
}
