package com.cybertek.reviews.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04XPathPractice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        WebElement result=driver.findElement(By.xpath("//p[@id='result']"));
        String actualText=result.getText();
        String expectedText="Clicked on button one!";
        if(actualText.equalsIgnoreCase(expectedText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.quit();


    }
}
