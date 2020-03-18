package com.herokuapp.testBase;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class TestBaseHA {

    protected WebDriver driver;
    protected Actions actions;
    private String urlHA = "";

    @BeforeMethod (alwaysRun = true)
    public void setUp(Method method) {
        driver = BrowserFactoryHA.getDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(method.getAnnotation(Test.class).description());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        BrowserFactoryHA.closeDriver();
    }

}
