package com.cybertek.reviews.Homework;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Adidas {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){

       // driver.quit();
    }

    @Test
    public  void test1() throws InterruptedException {

        driver.findElement(By.linkText("Laptops")).click();
        driver.findElement(By.linkText("Sony vaio i5")).click();
        driver.findElement(By.xpath("//a[@onclick='addToCart(8)']")).click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        alert.accept();

        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.linkText("Laptops")).click();
        driver.findElement(By.linkText("Dell i7 8gb")).click();
        driver.findElement(By.xpath("//a[@onclick='addToCart(12)']")).click();
        Thread.sleep(2000);

        alert.accept();

        driver.findElement(By.id("cartur")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).click();
        driver.findElement(By.xpath("//*[.='Place Order']")).click();

        Faker faker=new Faker();
        driver.findElement(By.cssSelector("#name")).sendKeys(faker.name().fullName());
        driver.findElement(By.cssSelector("#country")).sendKeys(faker.address().country());
        driver.findElement(By.cssSelector("#city")).sendKeys(faker.address().city());
        driver.findElement(By.cssSelector("#card")).sendKeys(faker.finance().bic());
        driver.findElement(By.cssSelector("#month")).sendKeys("December");
        driver.findElement(By.cssSelector("#year")).sendKeys("2021");

        driver.findElement(By.xpath("//*[.='Purchase']")).click();


        String expectedResult=driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        String actualResult=driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        Assert.assertEquals(expectedResult,actualResult);

    }


}
