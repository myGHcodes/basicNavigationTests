package com.homework.utils;

public class Utilities {

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println("wait exception not handled");
        }
    }



}
