package com.herokuapp.pages;

import com.herokuapp.utils.BrowserFactoryHA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadHA {

    public FileUploadHA(){
        PageFactory.initElements(BrowserFactoryHA.getDriver(), this);
    }

    @FindBy(linkText="File Upload")
    public WebElement fileUploadLink;

    @FindBy(id= "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(id="file-submit")
    public WebElement uploadBtn;

    @FindBy(tagName = "h3")
    public WebElement fileUploaded;

    @FindBy(id="uploaded-files")
    public WebElement nameOfUpldFile;
}
