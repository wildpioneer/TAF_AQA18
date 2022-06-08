package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1960x1080";
        //Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.driverManagerEnabled = false;
        //Configuration.fastSetValue = true;
        //Configuration.headless = true;
        Configuration.reportsFolder = "target/screens";
        Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();
        Configuration.timeout = Duration.ofSeconds(20).toMillis();
        ;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
/*
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
*/
    }

    @Test
    public void simpleSelenideTest() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

    @Test
    public void selenideTest1() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
        $$("div.project")
                .filter(visible)
                .shouldHave(size(26))
                .find(text("erg"))
                .click();
        $$("div.project")
                .first();
        $$("div.project")
                .get(2);

        sleep(1000);
        refresh();
        title();
        executeJavaScript("");
    }

    @Test
    public void selenideTest2() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        System.out.println($(byText("asdasdasdfaszc")).innerText());
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        System.out.println($(byText("asdasdasdfaszc")).getValue());
        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr");
        $(byText("asdasdasdfaszc")).ancestor("div");
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent();

        $(byText("asdasdasdfaszc")).uploadFile(new File(""));
        //$(byText("asdasdasdfaszc")).download();
    }

    @Test
    public void selenideTest3() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));

        $("#announcement")
                .should(exist)
                .should(hidden).should(disappear).shouldNotBe(visible)
                .shouldBe(readonly)
                .shouldHave(name("fname"))
                .shouldHave(value("John"))
                .shouldHave(type("checkbox"))
                .shouldBe(empty)
                .shouldBe(focused);

        WebElement webElement = $("#announcement").toWebElement();

        Condition clickable = and("can be clicked", visible, enabled);
        $$("#announcement")
                .findBy(clickable).click();

        $("#announcement").shouldBe(clickable);

        $("#announcement")
                .shouldHave(text("Expected Text")) // contains
                .shouldHave(matchText("Expected Text")) // regex
                .shouldHave(exactText("Exact Text"))  //equalsIgnoreCase
                .shouldHave(textCaseSensitive("Expected Result Text"))
                .shouldHave(exactTextCaseSensitive("Expected Result Text")); //equals
    }
}
