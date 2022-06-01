package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.RadioButton;
import wrappers.Table;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.successLogin(
                                ReadProperties.username(),
                                ReadProperties.password()
                        )
                        .isPageOpened()
        );
    }

    @Test
    public void radioButtonTest() throws Exception {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        driver.get("https://aqa1803.testrail.io/index.php?/admin/projects/add");

        RadioButton suiteMode = new RadioButton(driver, By.name("suite_mode"));
        suiteMode.select("3");

        Thread.sleep(4000);
    }

    @Test
    public void tableTest() throws Exception {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        driver.get("https://aqa1803.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        System.out.println(table.getColumnIndex("Project"));
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin("sdsd", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin(ReadProperties.username(), "123").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
