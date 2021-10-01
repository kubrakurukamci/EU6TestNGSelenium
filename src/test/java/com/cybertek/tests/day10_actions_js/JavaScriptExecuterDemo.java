package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {

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
    public void clickWithJS(){

        //normal click methodu bazen calismayinca JS click kullanmaliyiz

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink= driver.findElement(By.linkText("Dropdown"));
       // dropdownLink.click(); bu selenium click normal olan

        //javascprit click icin
        JavascriptExecutor jse = (JavascriptExecutor) driver; //casting yapiyoruz

        jse.executeScript("arguments[0].click();" , dropdownLink); //script kismini ezbere ya da google yaparak bulabiliriz.


    }

    @Test
    public void typeWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        String text = "Hello Disabled Input";

        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);//text bizim sendKeys'imiz

        //disabled olan elementlere dahi yazi yazmamizi saglayan JS executer kismi
        //googledan bulduk


    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse =(JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
             jse.executeScript("window.scrollBy(0,250)");//for scroll down

        }
        for (int i = 0; i <10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");//for scroll up

        }

    }
    @Test
    public void scrollToElement() throws InterruptedException {

        //belirli bir elemente scroll yapmak

        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",eng);


    }

    }
