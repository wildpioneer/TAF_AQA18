package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void validate_Dashboard_Menu_Test() {
/*
        DashboardPage dashboardPage = loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        TopMenuPage topMenuPage = dashboardPage.topMenuPage;

        Assert.assertTrue(topMenuPage.isPageOpened());
*/
    }

    @Test
    public void validate_Projects_SideMenu_Test() {
/*
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(navigationStep.navigateToProjectsPage().sideMenuPage.isPageOpened());
*/
    }
}
