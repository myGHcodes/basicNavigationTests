package com.herokuapp.tests;

import com.herokuapp.pages.*;
import com.herokuapp.testBase.TestBaseHA;
import com.herokuapp.utils.UtilsHA;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TestCasesHA extends TestBaseHA {

    UtilsHA utilsHA = new UtilsHA();
    HomePageFakeMail hpfakeMail = new HomePageFakeMail();
    RegistrationFormHA pRgstForm = new RegistrationFormHA();
    SignUpMailListHA pSignUpMailLst = new SignUpMailListHA();
    FileUploadHA pFileUpload = new FileUploadHA();
    AutocompleteHA pAutocomplete = new AutocompleteHA();
    StatusCodesHA pStatusCodes = new StatusCodesHA();



    @Test(testName = "Test case #1", priority = 0, description = "https://practice-cybertekschool.herokuapp.com/")
    void wrongDOB() {
        pRgstForm.registrationLink.click();
        pRgstForm.birthday.sendKeys("wrong_dob");
        assertTrue(pRgstForm.dobWrnMsg.isDisplayed());
        pRgstForm.birthday.sendKeys("May");
    }

    @Test(testName = "Test case #2", priority = 1, description = "https://practice-cybertekschool.herokuapp.com/")
    void programmingLangs() {
        pRgstForm.registrationLink.click();
        for (WebElement each : pRgstForm.lstProgrLang) {
            each.isDisplayed();
        }
    }

    @Test(testName = "Test case #3", priority = 3, description = "https://practice-cybertekschool.herokuapp.com/")
    void onlyAlphabeticalChars() {
        pRgstForm.registrationLink.click();
        pRgstForm.firstName.sendKeys("t");
        assertTrue(pRgstForm.firstNameWrnMsg.isDisplayed());
    }

    @Test(testName = "Test case #4", priority = 4, description = "https://practice-cybertekschool.herokuapp.com/")
    void onlyAlphabeticalChars2() {
        pRgstForm.registrationLink.click();
        pRgstForm.lastName.sendKeys("t");
        assertTrue(pRgstForm.lastNameWrnMsg.isDisplayed());
    }

    @Test(testName = "Test case #5", priority = 5, description = "https://practice-cybertekschool.herokuapp.com/")
    void fullRegisterForm() {
        pRgstForm.registrationLink.click();
        pRgstForm.firstName.sendKeys("Tomas");
        pRgstForm.lastName.sendKeys("Shelby");
        pRgstForm.username.sendKeys("tomShelby");
        pRgstForm.email.sendKeys("tom@gmail.com");
        pRgstForm.password.sendKeys("tom3162020");
        pRgstForm.phone.sendKeys("571-000-0000");
        pRgstForm.genderMale.click();
        pRgstForm.birthday.sendKeys("01/01/1990");
        new Select(pRgstForm.selectDepts).selectByVisibleText("Mayor's Office");
        new Select(pRgstForm.selectJobTitle).selectByVisibleText("Product Owner");
        pRgstForm.javaLang.click();
        pRgstForm.signUpBtn.click();
        assertTrue(pRgstForm.successSignUpMsg.isDisplayed());
    }

    @Test(testName = "Test case #6", priority = 6, description = "https://www.fakemail.net/")
    void mailList() {
        String email = hpfakeMail.email.getText();
        utilsHA.goTo("https://practice-cybertekschool.herokuapp.com/");
        pSignUpMailLst.signUpMailList.click();
        pSignUpMailLst.fullName.sendKeys("Elizabeth");
        pSignUpMailLst.email.sendKeys(email);
        pSignUpMailLst.signUpBtn.click();
        assertTrue(pSignUpMailLst.signUpMsg.isDisplayed());
        utilsHA.goTo("https://www.fakemail.net/");
        utilsHA.wait(5);
        assertTrue(hpfakeMail.inboxEmailFrom.isDisplayed());
        hpfakeMail.inboxEmail.click();
        utilsHA.wait(5);
        String expectedTxt = "do-not-reply@practice.cybertekschool.com";
        assertEquals(expectedTxt, hpfakeMail.emailFrom.getText(), "Text doesn't match expectedTxt");
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        assertEquals(expectedSubject, hpfakeMail.subject.getText(), "Text doesn't match expectedSubject");

    }

    @Test(testName = "Test case #7", priority = 7, description = "https://practice-cybertekschool.herokuapp.com/")
    void fileUpload() {
        pFileUpload.fileUploadLink.click();
        pFileUpload.chooseFileBtn.sendKeys("C:\\Users\\Ika\\Desktop\\softSkill.txt");
        utilsHA.wait(3);
        pFileUpload.uploadBtn.click();
        assertTrue(pFileUpload.fileUploaded.isDisplayed());
        assertTrue(pFileUpload.nameOfUpldFile.isDisplayed());
    }

    @Test(testName = "Test case #8", priority = 8, description = "https://practice-cybertekschool.herokuapp.com/")
    void autocomplete() {
        pAutocomplete.autocompleteLink.click();
        pAutocomplete.country.sendKeys("United States of America");
        pAutocomplete.submitBtn.click();
        assertEquals(pAutocomplete.result.getText().trim(), "You selected: United States of America");
    }



    @Test(testName = "Test case #9-12", description = "https://practice-cybertekschool.herokuapp.com/", dataProvider = "test9-12", priority = 9, dataProviderClass = UtilsHA.class)
    public void statusCodes(String statusCode, String message) {
        pStatusCodes.statusCodesLink.click();
        driver.findElement(By.linkText(statusCode)).click();
        assertTrue(pStatusCodes.tagName.getText().contains(message));
        System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/p")).getText());

    }


}
