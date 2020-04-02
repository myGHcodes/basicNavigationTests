package com.homework.pages;

import com.homework.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class GoogleWebToolKit {

    public GoogleWebToolKit(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='gwt-CheckBox']")
    public List<WebElement> showCaseCheckBox;



}
