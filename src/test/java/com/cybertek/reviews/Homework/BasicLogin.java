package com.cybertek.reviews.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BasicLogin {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        String expectedTitle="Web Orders Login";
        String actualTitle=driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/th"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        //get all cells in one row
        WebElement row1 = driver.findElement(By.xpath("//tbody/tr[2]"));
        System.out.println(row1.getText());

        //get all rows
        List<WebElement> elements1 = driver.findElements(By.xpath("//tbody/tr"));
        for (int i = 2; i < elements1.size(); i++) {
            WebElement allRows=driver.findElement(By.xpath("//tbody/tr["+i+"]"));
            System.out.println(allRows.getText());

        }






    }



}
