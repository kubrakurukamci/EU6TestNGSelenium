package com.cybertek.reviews.day6;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
    }
    @AfterMethod
    public void afterMethod(){
        //driver.quit();
    }

    @Test
    public void testWithActionClass() throws InterruptedException {

        //Scroll down to "Powered by Cybertek School"
        Actions actions=new Actions(driver);
        WebElement cyber=driver.findElement(By.linkText("Cybertek School"));
        actions.moveToElement(cyber).perform();

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


    }
    @Test
    public void scrollWithJS() throws InterruptedException {
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
    }
}
