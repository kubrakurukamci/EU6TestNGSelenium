package com.cybertek.reviews.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyGaming {

    @Test
    public void moneyGaming(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(" https://moneygaming.qa.gameaccount.com/sign-up.shtml");

        WebElement name= driver.findElement(By.cssSelector("#forename"));
        name.sendKeys("kubra");

        WebElement surname=driver.findElement(By.cssSelector("[name='map(lastName)']"));
        surname.sendKeys("kurukamci");

        WebElement checkBoxText= driver.findElement(By.cssSelector("[class='validation']"));
        String actualText=checkBoxText.getText();
        String expectedText="I accept the Terms and Conditions and certify that I am over the age of 18.";

        Assert.assertEquals(actualText,expectedText);

        WebElement joinNowButton=driver.findElement(By.cssSelector("#form"));
        joinNowButton.click();

        WebElement checkBox= driver.findElement(By.cssSelector(".required.checkbox.terms"));
        Assert.assertFalse(checkBox.isSelected());

        WebElement validationMessage=driver.findElement(By.cssSelector("[for='dob']"));
        String actualMessage=validationMessage.getText();
        String expectedMessage="Dieses Feld ist erforderlich";

        Assert.assertEquals(actualMessage,expectedMessage);

        driver.quit();



    }
}
