package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFakeMail {


    public HomePageFakeMail(){
        PageFactory.initElements(BrowserFactoryHA.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id = \"email\"]")
    public WebElement email;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement inboxEmail;

    @FindBy(id="odesilatel")
    public WebElement emailFrom;

    @FindBy(id="predmet")
    public WebElement subject;

    @FindBy(xpath="//tbody[@id='schranka']/tr/td[1][contains(text(), 'do-not-reply@practice.cybertekschool.com')]")
    public WebElement inboxEmailFrom;
}
