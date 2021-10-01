package com.cybertek.tests.day5_XPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");
        WebElement searchButton=driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();


        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String resultText= result.getText();

        System.out.println("resultText= " + resultText);

        String expectedResult= "1-48 of 211 results for ";
        if(expectedResult.equals(resultText)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.close();


    }



}
