package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusCodesHA {

    public StatusCodesHA(){
        PageFactory.initElements(BrowserFactoryHA.getDriver(),this);
    }

    @FindBy(linkText = "Status Codes")
    public WebElement statusCodesLink;

    @FindBy(tagName = "p")
    public WebElement tagName;


}
