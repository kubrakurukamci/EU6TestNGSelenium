package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitelAndUrl {
    public static void main(String[] args) {

        //open chrome and navigate to http://practice.cybertekschool.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //shortcut for creating variable
        //Option or ALT +enter enter
        //getTitle()---> get you the titel of page
        String title = driver.getTitle();
        //System.out.println(driver.getTitle());//other way
        System.out.println("title = " + title); //soutv+enter to print variable name and value kisa yoldan buluruz :))

        //getCurrentUrl ---> get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPaceSourceC ---> gets the page source code of page from browser
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }

}
