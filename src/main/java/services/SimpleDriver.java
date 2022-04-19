package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandr/Documents/Work/TechMeSkills/CODE_AQA18/TAF_AQA18/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
