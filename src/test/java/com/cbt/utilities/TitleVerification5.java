package com.cbt.utilities;

import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification5 {

    static WebDriver driver;
    public static void main(String[] args) {

        driver = BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList( "https://wayfair.com",
                "https://walmart.com", "https://westelm.com", "https://www.luluandgeorgia.com/");
        for (int i = 0; i < urls.size() ; i++) {
            driver.get(urls.get(i));

            if(driver.getTitle().contains(".com")) {
                String currentURL = driver.getCurrentUrl();
                String titleOfWaifairAndWalmart = driver.getTitle().substring(0, driver.getTitle().indexOf("com") + 3).toLowerCase();   // wayfair.com and walmart.com
                Verify.verify(currentURL.contains(titleOfWaifairAndWalmart), "doesn't contain");
            } else {
                String titleReplaced = driver.getTitle().toLowerCase().replaceAll("[^a-zA-z]", "");
                System.out.println(titleReplaced);
                String str = driver.getCurrentUrl().substring(driver.getCurrentUrl().indexOf(".") + 1, driver.getCurrentUrl().lastIndexOf("."));
                Verify.verify(titleReplaced.contains(str), "doesn't contain");
            }
        }
        driver.quit();
    }
}
/* https://www.walmart.com/ //<-- url
 Walmart.com | Save Money. Live Better.  // title*/
