package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

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

    @Test
    public void successLoginInvocationsTest() {
        Assert.assertTrue(
                new LoginPage(driver)
                        .successLogin("fds", "sdfs")
                        .openProject("djfhgsd")
                        .getTabByName("dsfdf").isDisplayed()
        );
    }
}
