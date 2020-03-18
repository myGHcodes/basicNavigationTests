package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactoryCBT {

    private static WebDriver driver;
    private static String browser = "chrome";


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().version("79.0").setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
            }
        }
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        if(browser.equalsIgnoreCase("chrome") && driver == null) {
            WebDriverManager.chromedriver().version("79.0").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        }
        return driver;
    }


    }




