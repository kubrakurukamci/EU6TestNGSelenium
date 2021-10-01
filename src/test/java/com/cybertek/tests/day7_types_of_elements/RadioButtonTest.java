package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioButton= driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton=driver.findElement(By.id("red"));

        //how to check radio button is selected ?
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioButton.isSelected());


        //verify blue is selected red is not selected
        //blue --> true
        Assert.assertTrue(blueRadioButton.isSelected(),"Verify that blue is selected");
        //red--> false
        Assert.assertFalse(redRadioButton.isSelected(),"Verify that red is NOT selected");

        //how to click radio button ?
        //clicking red radio button
        redRadioButton.click();

        //blue --> false
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue is NOT selected");
        //red-->true
        Assert.assertTrue(redRadioButton.isSelected(),"verify that red is selected");


        Thread.sleep(2000);
        driver.quit();

    }



}
