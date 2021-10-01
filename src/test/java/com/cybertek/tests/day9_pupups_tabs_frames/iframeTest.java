package com.cybertek.tests.day9_pupups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {


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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1.Switch using by name or ID atrribute of frame
        driver.switchTo().frame("mce_0_ifr");

        //clear something before sendkeys

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");

        //goes back to first frame (main html)
        //goes back to first frame , when we have switched multiple frames
        driver.switchTo().defaultContent(); //her yerden ana frame doner

        //2.Switching with index

        driver.switchTo().frame(0);//tekrar degistirdik baby html ye ikinci yontemle, ve ayni islemleri yaptik
                                        //bir tane iframe old icin index 0 olur

        //clear something before sendkeys

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with INDEX");

        //Second way to switching back to Parent
        driver.switchTo().parentFrame(); //move only one level up

        //3.Using WEBELEMENT

        WebElement iframeWebElement=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeWebElement);


        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with WEB ELEMENT");


    }

    //html
    //top
    //left
    //middle
    //firstFrame
    //smallFrame
    //right
    //bottom
        /*
        We can switch one at a time, cannot switch to grandchild directly.
·       We cannot switch to siblings.
·       We can only switch from parent to child, or from child to parent.
         */

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");

        //top has 3 frame under left, middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //goes back to top frame
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());




    }





}
