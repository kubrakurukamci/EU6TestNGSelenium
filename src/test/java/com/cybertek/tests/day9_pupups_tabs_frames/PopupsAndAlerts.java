package com.cybertek.tests.day9_pupups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
       // driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the Confirm button
        driver.findElement(By.xpath("//button/span[text()='Confirm']")).click();


        //Click NO button
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click for JS Alert Button
        driver.findElement(By.xpath("//Button[1]")).click();

        //switch to JS Alert Pup up
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //click for 'JS Confirm Button' on the page
        driver.findElement(By.xpath("//Button[2]")).click();
        alert.dismiss();

        //click for JS Prompt
        driver.findElement(By.xpath("//Button[3]")).click();
        //sendkeys to JS Prompt
        alert.sendKeys("Mike Smith");
        //click OK
        alert.accept();


    }

    }
