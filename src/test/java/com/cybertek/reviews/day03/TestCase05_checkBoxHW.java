package com.cybertek.reviews.day03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase05_checkBoxHW {

    /*
    SeleniumEasy Checkbox Verification – Section 1 and 2
1.Open Chrome browser
2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify “Success – Check box is checked” message is NOT displayed.
4.Click to checkbox under “Single Checkbox Demo” section
5.Verify “Success – Check box is checked” message is displayed.
     */

    WebDriver driver;  // we need to make it global variable

    @BeforeClass
    public void setUp() {
        // Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void test1() {


        //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html


        // locator of our single check box
        WebElement singleCheckBox = driver.findElement(By.cssSelector("input#isAgeSelected"));

        // Success message Text locator
        WebElement successMessage = driver.findElement(By.cssSelector("div#txtAge"));


        //3. Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertFalse(successMessage.isDisplayed(), "Message verification failed"); // checks if it returning false

        //4. Click to checkbox under “Single Checkbox Demo” section
        singleCheckBox.click();

        // Verify “Success – Check box is checked” message is displayed.

        Assert.assertTrue(successMessage.isDisplayed(), "Message is not displayed");
    }


    @Test
    public void test2() {
        // Verify “Check All” button text is “Check All”

        WebElement checkAllButton = driver.findElement(By.cssSelector("#check1"));
        String expectedText = "Check All";
        String actualText = checkAllButton.getAttribute("value");

        Assert.assertEquals(actualText, expectedText, "Verification of ButtonText failed");

        // Click to “Check All” button
        checkAllButton.click();
        // Verify all check boxes are checked (you did not learn findElements)

        // with findElement method
/*
        String locatorCB1 = "(//input[@class='cb1-element'])[1]";
        WebElement checkbox1 = driver.findElement(By.xpath(locatorCB1));
        Assert.assertTrue(checkbox1.isSelected());
        String locatorCB2 = "(//input[@class='cb1-element'])[2]";
        WebElement checkbox2 = driver.findElement(By.xpath(locatorCB2));
        String locatorCB3 = "(//input[@class='cb1-element'])[3]";
        WebElement checkbox3 = driver.findElement(By.xpath(locatorCB3));
        String locatorCB4 = "(//input[@class='cb1-element'])[4]";
        WebElement checkbox4 = driver.findElement(By.xpath(locatorCB4));
    */
        for (int i = 1; i <= 4; i++) {
            String locatorForCheckBox = "(//input[@class='cb1-element'])[" + i + "]";
            WebElement checkbox = driver.findElement(By.xpath(locatorForCheckBox));
            Assert.assertTrue(checkbox.isSelected());
        }

        // with findElements method

        // Verify button text changed to “Uncheck All”
        String expectedTextAfterClick = "Uncheck All";
        String actualTextAfterClick = checkAllButton.getAttribute("value");
        Assert.assertEquals(actualTextAfterClick, expectedTextAfterClick, "some message");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}