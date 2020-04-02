package com.homework.pages;

import com.homework.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class W3schools {

    public W3schools(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(tagName = "a")
    public List<WebElement> listOfTagNames ;
}
