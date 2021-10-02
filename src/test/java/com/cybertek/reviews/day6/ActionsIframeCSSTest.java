package com.cybertek.reviews.day6;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsIframeCSSTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){

       // driver.quit();
    }

    @Test
    public void test1() {
    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    driver.findElement(By.id("accept-choices")).click();
    driver.switchTo().frame("iframeResult");

    WebElement click= driver.findElement(By.cssSelector("[ondblclick='myFunction()']"));

    //double click action create an action obj
    Actions actions=new Actions(driver);
    actions.doubleClick(click).perform();

    String expectedStyle="red";
    String actualStyle=click.getAttribute("style");
    Assert.assertTrue(actualStyle.contains(expectedStyle));




    }
}
