package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationFormHA {

    public RegistrationFormHA() {
        PageFactory.initElements(BrowserFactoryHA.getDriver(), this);
    }


    @FindBy(name="birthday")
    public WebElement birthday;

    @FindBy(linkText = "Registration Form")
    public WebElement registrationLink;

    @FindBy(xpath = "//*[@data-bv-result='INVALID']")
    public WebElement dobWrnMsg;

    @FindBy(xpath = "//*[@class='form-check-label']")
    public List<WebElement> lstProgrLang;

    @FindBy(name ="firstname")
    public WebElement firstName;

    @FindBy(xpath = "//small[text()='first name must be more than 2 and less than 64 characters long']")
    public WebElement firstNameWrnMsg;

    @FindBy(name ="lastname")
    public WebElement lastName;

    @FindBy(xpath = "//small[text()='The last name must be more than 2 and less than 64 characters long']")
    public WebElement lastNameWrnMsg;

    @FindBy(name ="username")
    public WebElement username;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "phone")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='gender'][@value='male']")
    public WebElement genderMale;

    @FindBy(name ="department")
    public WebElement selectDepts;

    @FindBy(name = "job_title")
    public WebElement selectJobTitle;

    @FindBy(id="inlineCheckbox2")
    public WebElement javaLang;

    @FindBy(id="wooden_spoon")
    public WebElement signUpBtn;

    @FindBy(id="content")
    public WebElement successSignUpMsg;











}
