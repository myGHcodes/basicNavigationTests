package com.homework.pages;

import com.homework.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeCybertekDropdown {

    public PracticeCybertekDropdown(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "day")
    public WebElement date;

}
