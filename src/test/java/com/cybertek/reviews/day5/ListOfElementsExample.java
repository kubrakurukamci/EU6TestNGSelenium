package com.cybertek.reviews.day5;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOfElementsExample {

    WebDriver driver;
    Faker faker=new Faker();

    /**
     * Test case #2
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }

    @Test
    public void task2() throws InterruptedException {

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(By.cssSelector(".form-check-label"));// Alt+enter

        List<String> actualElementsStrings = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            actualElementsStrings.add(elements.get(i).getText());

        }

        // we did assertion one by one
        Assert.assertEquals(elements.get(0).getText(),"C++");
        Assert.assertEquals(elements.get(1).getText(),"Java");
        Assert.assertEquals(elements.get(2).getText(),"JavaScript");

        List<String> expectedCodeNames = Arrays.asList("C++","Java","JavaScript"); // Java lazy way of creating a list


        // We did assertion as a List
        Assert.assertEquals(actualElementsStrings,expectedCodeNames); // you can not compare list of string to list of webelement


    }
    @Test
    public void test3(){
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("username")).sendKeys(faker.name().username());
        driver.findElement(By.name("email")).sendKeys(faker.name().username() + "@gmail.com");
    }
}
