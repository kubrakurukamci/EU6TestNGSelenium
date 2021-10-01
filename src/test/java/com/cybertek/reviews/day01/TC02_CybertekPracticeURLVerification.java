package com.cybertek.reviews.day01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC02_CybertekPracticeURLVerification {
    public static void main(String[] args) {
/*
TC #2: Cybertekpractice toolverifications
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com
3.Verify URL contains
Expected: cybertekschool
4.Verify title:
Expected: Practice
 */
        // in order to use getDriver method create an object from WebDriverFactory class

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // to maximize web page
        driver.manage().window().maximize();

        // go to website
        driver.get("http://practice.cybertekschool.com");


        String expectedInUrl = "cybertekschool";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!");
        }

        driver.quit();


    }
}
