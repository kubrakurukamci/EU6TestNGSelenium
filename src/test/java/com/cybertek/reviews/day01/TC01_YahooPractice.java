package com.cybertek.reviews.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_YahooPractice {

    public static void main(String[] args) throws InterruptedException {
        //1.Open Chrome browser
//setup browser
        WebDriverManager.chromedriver().setup();
// initialize driver object
        WebDriver driver = new ChromeDriver();

        //2.Go to https://www.yahoo.com

        driver.get("https://www.yahoo.com");

// expected string
        String expectedTitle = "Yahoo";
// actual string
        String actualTitle = driver.getTitle();

        // verification
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title is as expected. Verification passed");
        }else{
            System.out.println("Title is NOT as expected. Verification did NOT pass");
        }

        Thread.sleep(2000);

        driver.close();




    }
}
