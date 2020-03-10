package com.cbt.utilities;

import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    static WebDriver driver;
    public static void main(String[] args) {

        driver = BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList( "https://wayfair.com",
                "https://walmart.com", "https://westelm.com", "https://www.luluandgeorgia.com/");
        for (int i = 0; i < urls.size() ; i++) {
            driver.get(urls.get(i));
            if(driver.getTitle().contains(".com")) {
                Verify.verify(driver.getCurrentUrl()
                                .contains(driver.getTitle().substring(0, driver.getTitle().indexOf("com") + 3).toLowerCase()),
                        "doesn't contain");
            } else {
                Verify.verify(driver.getTitle().toLowerCase().replaceAll("[^a-zA-z]", "").contains(driver.getCurrentUrl()
                        .substring(driver.getCurrentUrl().indexOf(".") + 1, driver.getCurrentUrl().lastIndexOf("."))), "doesn't contain");
            }
        }
        driver.quit();
    }
}
