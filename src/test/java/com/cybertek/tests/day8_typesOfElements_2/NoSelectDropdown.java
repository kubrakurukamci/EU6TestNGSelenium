package com.cybertek.tests.day8_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){

         driver.quit();
    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click dropdown to see available options
       dropdownElement.click();

        //get the options with findElements method and finding common locator between them
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        //print size of options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5,"verify the size of options");

        //print them one by one
        for (WebElement option : dropdownOptions) {
            System.out.println( option.getText());
        }

        //click Yahoo
        dropdownOptions.get(2).click();

    }
    
}
