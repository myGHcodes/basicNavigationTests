package com.homework.testBase;

import com.herokuapp.utils.BrowserFactoryHA;
import com.homework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract  class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    private String urlHA = "";

    @BeforeMethod (alwaysRun = true)
    public void setUp(Method method) {
        driver = DriverFactory.getDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(method.getAnnotation(Test.class).description());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        DriverFactory.closeDriver();
    }

}
