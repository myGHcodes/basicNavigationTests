package com.cbt.utilities;

import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerification {

    static WebDriver driver;
    static StringUtility strUtil = new StringUtility();

    public static void main(String[] args) throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        for (int i = 0; i < urls.size() ; i++) {
            driver.get(urls.get(i));
            String expectedTitle = "Practice";
            Assert.assertEquals(expectedTitle, driver.getTitle());
            Thread.sleep(1000);
            String expectedUrl = "http://practice.cybertekschool.com";
            Thread.sleep(1000);
            Verify.verify(driver.getCurrentUrl().startsWith(expectedUrl), "URL doesn't startWith expectedURL");
        }
        driver.quit();
    }
}
