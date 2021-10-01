package com.cybertek.reviews.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day9_homeworks {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void TC1() throws InterruptedException {
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob");
        WebElement message=driver.findElement(By.xpath("//small[contains(.,'not valid')]"));
        Assert.assertTrue(message.isDisplayed());


    }

    @Test
    public void TC2(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        WebElement c=driver.findElement(By.xpath("//*[.='C++']"));
        Assert.assertTrue(c.isDisplayed());

        WebElement java=driver.findElement(By.xpath("//*[.='Java']"));
        Assert.assertTrue(java.isDisplayed());

        WebElement Js= driver.findElement(By.xpath("//*[.='JavaScript']"));
        Assert.assertTrue(Js.isDisplayed());
    }

    @Test
    public void TC3(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        WebElement inputFirstname=driver.findElement(By.cssSelector("[placeholder='first name']"));
        inputFirstname.sendKeys("k");

        WebElement actualMessage=driver.findElement(By.xpath("//small[contains(.,'first name must be ')]"));

        Assert.assertTrue(actualMessage.isDisplayed());


    }

    @Test
    public void TC4(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        WebElement inputFirstname=driver.findElement(By.cssSelector("[placeholder='last name']"));
        inputFirstname.sendKeys("k");

        WebElement actualMessage=driver.findElement(By.xpath("//small[contains(.,'last name must be ')]"));

        Assert.assertTrue(actualMessage.isDisplayed());

    }
    @Test
    public void TC5() throws InterruptedException {
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.cssSelector("[placeholder='first name']")).sendKeys("kubra");
        driver.findElement(By.cssSelector("[placeholder='last name']")).sendKeys("kurukamci");
        driver.findElement(By.cssSelector("[placeholder='username']")).sendKeys("kbrkmc");
        driver.findElement(By.cssSelector("[placeholder='email@email.com']")).sendKeys("kubrakrkmc@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("571-987-1234");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("12/19/1990");
        WebElement department=driver.findElement(By.cssSelector("[name='department']"));
        Select selectDep=new Select(department);
        selectDep.selectByIndex(1);

        WebElement jobTitle=driver.findElement(By.cssSelector("[name='job_title']"));
        Select selectJobTitle=new Select(jobTitle);
        selectJobTitle.selectByVisibleText("QA");

        driver.findElement(By.cssSelector("[value='java']")).click();

        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement message=driver.findElement(By.xpath("//p[contains(.,'successfully ')]"));
        Assert.assertTrue(message.isDisplayed());





    }

    //@Test
   // public void TC7(){
       // driver.get( "https://practice-cybertekschool.herokuapp.com");
       // driver.findElement(By.xpath("//a[.='File Upload']")).click();




   // }
    @Test
    public void TC8(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        WebElement message=driver.findElement(By.id("result"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void TC9(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();
        driver.findElement(By.xpath("//a[.='200']")).click();
        WebElement message=driver.findElement(By.cssSelector(".example>p"));
        Assert.assertTrue(message.isDisplayed());


    }

    @Test
    public void TC10(){
        driver.get( "https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();
        driver.findElement(By.xpath("//a[.='301']")).click();
        WebElement message=driver.findElement(By.cssSelector(".example>p"));
        Assert.assertTrue(message.isDisplayed());

    }
}
