package com.homework.tests;

import com.browserUtilities.BrowserUtilities;
import com.homework.pages.*;
import com.homework.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestCases extends TestBase {

    GoogleWebToolKit gwtk = new GoogleWebToolKit();
    PracticeCybertekDropdown pcd = new PracticeCybertekDropdown();
    BrowserUtilities bu = new BrowserUtilities();
    Amazon amazon = new Amazon();
    W3schools w3schools = new W3schools();
    SeleniumDev seleniumDev = new SeleniumDev();
    Random random = new Random();



    @Test(priority = 1, description = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox")
    void tc1() {
        int numFridaysChecked = 0;
        while (numFridaysChecked != 3) {
            WebElement temp = gwtk.showCaseCheckBox.get(random.nextInt(5));
            temp.click();
            System.out.println(temp.getText());
            temp.click();
            if (temp.getText().equalsIgnoreCase("Friday"))
                numFridaysChecked++;
        }
    }





    @Test(priority = 2, description = "http://practice.cybertekschool.com/dropdown")
    void tc2() {
        String actual = new Select(pcd.year).getFirstSelectedOption().getText() + "/" +
                new Select(pcd.month).getFirstSelectedOption().getText()
                + "/" + new Select(pcd.date).getFirstSelectedOption().getText();
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MMMM/dd"));
        assertEquals(actual, expectedDate);
    }


    @Test(priority = 3, description = "http://practice.cybertekschool.com/dropdown")
    void tc3() {
        int year = random.nextInt(new Select(pcd.year).getOptions().size());
        new Select(pcd.year).selectByIndex(year);

        List<Integer> numOfDaysInMonth = new ArrayList<>(Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        if (bu.leapYear(year))
            numOfDaysInMonth.set(1, 29);

        for (int i = 0; i < new Select(pcd.month).getOptions().size(); i++) {
            new Select(pcd.month).selectByIndex(i);
            assertEquals(new Integer(new Select(pcd.date).getOptions().size()), numOfDaysInMonth.get(i));
        }
    }

    @Test(priority = 4, description = "https://www.amazon.com")
    void tc4() {
        assertTrue(amazon.navigationSearchLabel.isDisplayed());
        assertEquals(amazon.navigationSearchLabel.getText(), "All");
        List<WebElement> listWebElements = new Select(amazon.departmentsDropdown).getOptions();
        List<String> list = new ArrayList<>();
        bu.listElementsToString(listWebElements, list);
        List<String> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        assertEquals(list.equals(list2), false);
        //with method
        //assertEquals(bu.alphabeticallySortedAmazonByFirstLetter(new Select(amazon.departmentsDropdown)), false);
    }


    @Test(priority = 5, description = "https://www.amazon.com/gp/site-directory")
    void tc5() {
        SoftAssert softAssertion = new SoftAssert();
        List<String> listDropdown = Arrays.asList(amazon.departmentsDropdown.getText().split("\n"));

        List<String> listMainDepts = new ArrayList<>();
        bu.listElementsToString(amazon.mainDepts, listMainDepts);
        try {
            for (String each : listMainDepts) {
                softAssertion.assertTrue(listDropdown.contains(each), "dropdown doesn't contain --- " + each);
            }
            softAssertion.assertAll();
        } catch (AssertionError ae) {
            ae.printStackTrace();
        }
    }


    @Test(priority = 6, description = "https://www.w3schools.com/")
    void tc6() {
        for (WebElement each : w3schools.listOfTagNames) {
            if (each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }

    @Test(priority = 7, description = "https://www.selenium.dev/documentation/en/")
    void tc7() {
        for (int i = 0; i < seleniumDev.listOfTagA.size() ; i++) {
            String url = seleniumDev.listOfTagA.get(i).getAttribute("href");
            bu.verifyLinkValid(url);
        }

    }

    @Test(priority = 8, description = "https://amazon.com")
    void tc8() {
        amazon.search.sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> itemTitlesVisible = new ArrayList<>();
        itemTitlesVisible.addAll(amazon.itemTitles);
        itemTitlesVisible.removeIf(n -> n.isDisplayed() == false);
        int indexValue = random.nextInt(itemTitlesVisible.size());
        String price = amazon.prices.get(amazon.itemTitles.indexOf(itemTitlesVisible.get(indexValue))).getText().replace("\n",  ".");
        String name = itemTitlesVisible.get(indexValue).getText();
        itemTitlesVisible.get(indexValue).click();
        System.out.println(name + " --- " + price);
        bu.wait(3);
        String quantity = amazon.quantity.getText();
        assertEquals(quantity, "1");
        assertEquals(name, amazon.titleOfClickedElement.getText());
        bu.wait(3);
        assertEquals(price, amazon.priceOfClickedElement.getText());
        assertTrue(amazon.addToCartButton.isDisplayed());
    }


    @Test(priority = 9, description = "https://amazon.com")
    void tc9() {
        amazon.search.sendKeys("wooden spoon", Keys.ENTER);
        amazon.getFirstTitleOfItem();
        amazon.primeCheckbox.click();
        String name1 = amazon.getFirstTitleOfItemOnPrime();
        assertEquals(amazon.getFirstTitleOfItem(),amazon.getFirstTitleOfItemOnPrime());
        bu.wait(4);
        amazon.clickToLastBrand();
        bu.wait(5);
        assertNotEquals(name1, amazon.getFirstTitleOfBrand());
        bu.wait(3);
    }

    @Test(priority = 10, description = "https://amazon.com")
    void tc10() {
        amazon.search.sendKeys("wooden spoon", Keys.ENTER);
        amazon.getFirstTitleOfItem();
        amazon.primeCheckbox.click();
        String name1 = amazon.getFirstTitleOfItemOnPrime();
        assertEquals(amazon.getFirstTitleOfItem(),amazon.getFirstTitleOfItemOnPrime());
        bu.wait(4);
        amazon.clickToLastBrand();
        bu.wait(5);
        System.out.println("name1 = " + name1);
        System.out.println("amazon.getFirstTitleOfBrand() = " + amazon.getFirstTitleOfBrand());
        assertNotEquals(name1, amazon.getFirstTitleOfBrand());
        bu.wait(3);
    }


    @Test(priority = 11, description = "https://amazon.com")
    void tc11() {
        amazon.search.sendKeys("wooden spoon", Keys.ENTER);
        amazon.getListOfBrands();
        bu.wait(6);
        amazon.primeCheckbox.click();
        bu.wait(6);
        amazon.getListOfBrands();
        assertEquals(amazon.getListOfBrands(), amazon.getListOfBrands());
    }

    @Test(priority = 12, description = "https://amazon.com")
    void tc12() {
        amazon.search.sendKeys("wooden spoon", Keys.ENTER);
        bu.wait(4);
        amazon.test.click();
        bu.wait(4);
        for (String each : amazon.getPricesOfUnder25()) {
            int priceConverted = Integer.parseInt(each);
            assertTrue(priceConverted < 25);
        }



    }






}



