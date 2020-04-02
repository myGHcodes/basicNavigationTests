package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutocompleteHA {

    public AutocompleteHA(){
        PageFactory.initElements(BrowserFactoryHA.getDriver(), this);
    }


    @FindBy(linkText = "Autocomplete")
    public WebElement autocompleteLink;

    @FindBy(name = "myCountry")
    public WebElement country;

    @FindBy(xpath = "//input[@class ='btn btn-primary']")
    public WebElement submitBtn;

    @FindBy(id="result")
    public WebElement result;
}
