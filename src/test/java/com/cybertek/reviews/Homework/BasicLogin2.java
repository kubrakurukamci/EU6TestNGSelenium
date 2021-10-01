package com.cybertek.reviews.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicLogin2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
    @AfterMethod
    public void afterMethod(){
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        int rows=getRows();
        int columns=getColumns();

        for (int i = 2; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                 String path="//tbody/tr["+i+"]/td["+j+"]";
                 WebElement cell=driver.findElement(By.xpath(path));
                System.out.println(cell.getText());

            }

        }

    }

    private int getColumns() {
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/th"));
        return elements.size();
    }

    private int getRows() {
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr"));
        return elements.size();
    }

    @Test
    public void test2(){
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();



    }
}
