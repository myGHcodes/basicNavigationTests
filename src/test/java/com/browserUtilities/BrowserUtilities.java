package com.browserUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.*;
import java.util.List;

public class BrowserUtilities {

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println("wait exception not handled");
        }
    }

    public boolean leapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean alphabeticallySorted(List<WebElement> list) {
        int temp = 0, temp2 = 0;
        boolean b = true;
        for (int i = 0; i < list.size() - 1; i++) {
            temp = (int) list.get(i).getText().charAt(0);
            temp2 = (int) list.get(i + 1).getText().charAt(0);
            if (temp > temp2) {
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }

    public boolean alphabeticallySortedAmazonByFirstLetter(Select s) {
        int temp = 0, temp2 = 0;
        boolean b = true;
        for (int i = 0; i < s.getOptions().size() - 1; i++) {
            if (Character.isLetter(s.getOptions().get(i).getText().charAt(0))) {
                temp = (int) s.getOptions().get(i).getText().charAt(0);
            } else {
                temp = (int) s.getOptions().get(i).getText().charAt(3);
            }

            if (Character.isLetter(s.getOptions().get(i + 1).getText().charAt(0))) {
                temp2 = (int) s.getOptions().get(i + 1).getText().charAt(0);
            } else {
                temp2 = (int) s.getOptions().get(i + 1).getText().charAt(3);
            }

            if (temp > temp2) {
                b = false;
                break;
            } else {
                b = true;
            }
            System.out.println("l - " + (char) temp + " --- l2 - " + (char) temp2);
            //System.out.println(s.getOptions().get(i).getText());
        }
        return b;
    }

    public void listElementsToString(List<WebElement> list, List<String> list2) {
        for (WebElement each : list) {
            list2.add(each.getText().trim());
        }
    }

    public void verifyLinkValid(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
            }

        } catch (Exception e) {

        }
    }

    public void removeUnvisible(List<WebElement> list) {
        for (WebElement each: list) {
            if(!each.isDisplayed()) {
                list.remove(list.indexOf(each));
            }
        }
    }

}
