package com.herokuapp.utils;
import org.testng.annotations.DataProvider;

public class UtilsHA {

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println("wait exception not handled");
        }
    }

    public void goTo(String url) {
        BrowserFactoryHA.getDriver().navigate().to(url);
    }

    @DataProvider(name = "test9-12")
    public static Object[][] createData() {
        return new Object[][]{
                {"200", "This page returned a 200 status code."},
                {"301", "This page returned a 301 status code."},
                {"404", "This page returned a 404 status code."},
                {"500", "This page returned a 500 status code."},
        };
    }

}
