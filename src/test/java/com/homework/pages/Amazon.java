package com.homework.pages;

import com.browserUtilities.BrowserUtilities;
import com.homework.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class Amazon {

    public Amazon(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id="searchDropdownBox")
    public WebElement departmentsDropdown;

    @FindBy(xpath = "//span[@class = \"nav-search-label\"]")
    public WebElement navigationSearchLabel;

    @FindBy(tagName = "h2")
    public List<WebElement> mainDepts;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement search;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']//span[2]")
    public WebElement quantity;

    @FindBy(xpath = "//span[@class = \"a-price\"]")  //span[@class='a-price']/span[@class='a-offscreen']
    public List<WebElement> prices;                  //span[@class = "a-price"]

    @FindBy(xpath = "//span[@class = \"a-size-base-plus a-color-base a-text-normal\"]")
    public List<WebElement> itemTitles;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement titleOfClickedElement;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    public WebElement priceOfClickedElement;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[2]")
    private WebElement firstTitleWoodenSpoon;

    @FindBy(xpath = "(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[2]")
    private WebElement firstTitleWoodenSpoonOnPrime;

    @FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[17]")
    private WebElement scanwoodBrand;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    private WebElement titleOfFirstItemFromBrand;

    public String getFirstTitleOfBrand(){ return titleOfFirstItemFromBrand.getText(); }

    public String getFirstTitleOfItem(){
        return firstTitleWoodenSpoon.getText();
    }

    public String getFirstTitleOfItemOnPrime(){
        return firstTitleWoodenSpoonOnPrime.getText();
    }

    public void clickToLastBrand(){
        scanwoodBrand.click();
    }

    @FindBy(xpath = "//i[@class='a-icon a-icon-prime a-icon-medium']")
    public List<WebElement> primeLabels;


    @FindBy(xpath = "//i[@class='a-icon a-icon-prime a-icon-medium']/../div/label/i")
    public WebElement primeCheckbox;

    @FindBy(css = "span[class='a-price']>[class='a-offscreen']")
    public List <WebElement> prices1;

    @FindBy(xpath = "(//ul[@aria-labelledby='p_89-title'])[1]//li")
    public List<WebElement> brands;



    public List<String> getListOfBrands() {
        List<String> textValues = new ArrayList<>();
        for (WebElement each : brands) {
            if (!each.getText().isEmpty()) {
                textValues.add(each.getText());
            }
        }
        return textValues;
    }

    @FindBy(linkText = "Under $25")
    public WebElement test;


    @FindBy(css = "[id ='p_36/1253523011']")
    public WebElement under251;

   @FindBy(className = "a-price-whole")
    public List<WebElement> pricesUnder25;

   //span[@class ='a-price-whole']

    public List<String> getPricesOfUnder25() {
        List<String> textValues = new ArrayList<>();
        for (WebElement each : pricesUnder25) {
            if (!each.getText().isEmpty()) {
                textValues.add(each.getText());
            }
        }
        return textValues;
    }


























}
