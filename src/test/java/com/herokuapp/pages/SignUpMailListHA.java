package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpMailListHA {

    public SignUpMailListHA(){
        PageFactory.initElements(BrowserFactoryHA.getDriver(), this);
    }

    @FindBy(linkText = "Sign Up For Mailing List")
    public WebElement signUpMailList;

    @FindBy(name="full_name")
    public WebElement fullName;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "wooden_spoon")
    public WebElement signUpBtn;

    @FindBy(name = "signup_message")
    public WebElement signUpMsg;


}
