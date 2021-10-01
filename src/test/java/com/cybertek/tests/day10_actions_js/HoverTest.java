package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }

    @Test
    public void oneImage() {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        Actions action = new Actions(driver);
        action.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(text1.isDisplayed(), "verify text1 is displayed");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        for (int i = 1; i <= 3; i++) {

            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user" + i + "']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(), "verify user " + i + " is displayed");

        }


    }

    @Test
    public void test3() {

        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> elements = driver.findElements(By.tagName("img"));
        for (WebElement element : elements) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            List<WebElement> TEXT = driver.findElements(By.tagName("h5"));
            for (WebElement txt : TEXT) {
                Assert.assertTrue(element.isDisplayed());
            }
        }


    }



}