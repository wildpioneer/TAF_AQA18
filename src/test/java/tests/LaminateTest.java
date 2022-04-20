package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BrowsersService;

public class LaminateTest {

    @Test
    public void test() throws InterruptedException {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");
        driver.findElement(By.cssSelector(".calc-btn-div .calc-btn")).click();

        Thread.sleep(2000);

        String value1 = driver.findElement(By.cssSelector(".calc-result div:first-child span")).getText();
        String value2 = driver.findElement(By.cssSelector(".calc-result div:nth-child(2) span")).getText();
        Assert.assertEquals(value1, "57");
        Assert.assertEquals(value2, "8");

        driver.quit();
    }
}
