package com.cbt.utilities;

import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class test {

    static WebDriver driver;
    public static void main(String[] args) {

        driver = BrowserFactory.getDriver("chrome");

       /* String titleCompare = driver.getTitle().toLowerCase();
        System.out.println("titleCompare = " + titleCompare);
        String test = titleCompare.substring(0, titleCompare.indexOf(".com")+4);
        System.out.println("test = " + test );
        String urlCompare = driver.getCurrentUrl().replace("https://www.","").toLowerCase();
        System.out.println("urlCompare = " + urlCompare);
        String cutted = urlCompare.substring(0, urlCompare.length()-1);
          System.out.println("cutted = " + cutted);
          if (test.contains(cutted)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!");
        }*/
       driver.get("https://www.luluandgeorgia.com");
        String titleCompare = driver.getTitle().toLowerCase();
        String[] splitted = titleCompare.split("");
        System.out.println("titleCompare = " + splitted);
        String test = titleCompare.substring(0, titleCompare.indexOf(".com")+4);
        System.out.println("test = " + test );
        String urlCompare = driver.getCurrentUrl().replace("https://www.","").toLowerCase();
        System.out.println("urlCompare = " + urlCompare);
        String cutted = urlCompare.substring(0, urlCompare.length()-1);
          System.out.println("cutted = " + cutted);
          if (test.contains(cutted)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!");
        }


        driver.quit();
    }
}
